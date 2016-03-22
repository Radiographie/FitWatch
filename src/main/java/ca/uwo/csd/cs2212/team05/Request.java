/**
 * Request class allows for requesting data from the fitbit API. It stores data from requests locally and can fulfill
 * further requests from locally stored data.
 * 
 * @author Peter Valovcik, edited by Justin Grant
 * @version 1.1
 *
 */

package ca.uwo.csd.cs2212.team05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.github.scribejava.apis.FitbitApi20;
import com.github.scribejava.apis.service.FitbitOAuth20ServiceImpl;
import com.github.scribejava.core.builder.ServiceBuilder;
//Request Verb
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;


public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String requestURLSuffix;
	private String outputFileName;
	private final static String resourcePath = "src/main/resources/apiActivity/";						//set this to where you want the data saved (should be resources folder)
	private final static String CALL_BACK_URI="http://localhost:8080";
    private final static int CALL_BACK_PORT=8080;
	
    /**
     * Contructor makes Request and initializes the requestURLSuffix to a null string.
     */
    
	public Request(){
		requestURLSuffix = "";
	}
	
	/**
	 * Method storeDaysData takes a specific day as an input, and then makes an API request by calling AppRequestGet.
	 * This should result in storage of that day's activity data locally named based on the date. 
	 * 
	 * @param y, integer representing the year
	 * @param m, integer representing the month
	 * @param d, integer representing the day
	 */
	
	public void storeDailyActivity(String simpleDataFormat){
		requestURLSuffix = "activities/date/" + simpleDataFormat + ".json";
		outputFileName =  "activities" +simpleDataFormat+ ".json" ;//DataParser read daily date from here
		this.AppRequestGet(requestURLSuffix);
	}
	
	/**
	 * Method storeActivities pulls a large summary of data (including lifetime totals, and best days) from the Fitbit API
	 * by calling the AppRequestGet method. It stores this data locally.
	 */
	public void storeLifeLongActivities(){
		
		requestURLSuffix = "activities.json";
		outputFileName = "activities.json";
		this.AppRequestGet(requestURLSuffix);
		
	}

		/**
		 * Method AppRequestGet communicates with the fitbit API, Authorizes access to protected data, retrieves the
		 * data that is requested and stores the data locally. 
		 * 
		 * @param URLSuffix, part of a URL string that corresponds to which data will be requested from the API
		 */
	    
	    private void AppRequestGet(String URLSuffix)
	    {
	        //read credentials from a file
	        BufferedReader bufferedReader=null;
	        // This will reference one line at a time
	        String line = null;
	         
	        //Need to save service credentials for Fitbit
	        String apiKey = null;       
	        String apiSecret = null; 
	        String clientID = null;
	         
	        //holder for all the elements we will need to make an access token ( information about an authenticated session )
	        String accessTokenItself =  null;
	        String tokenType = null;
	        String refreshToken = null;
	        Long expiresIn = null;
	        String rawResponse = null;
	         
	        //This is the only scope you have access to currently
	        String scope = "activity%20heartrate%20nutrition";
	        try {
	            // File with service credentials.
	             
	            FileReader fileReader = 
	                    new FileReader(resourcePath + "Team5Credentials.txt");        
	            bufferedReader = new BufferedReader(fileReader);
	            clientID= bufferedReader.readLine();
	            apiKey= bufferedReader.readLine();
	            apiSecret = bufferedReader.readLine();
	            bufferedReader.close();
	            fileReader = new FileReader(resourcePath + "Team5Tokens.txt");
	            bufferedReader = new BufferedReader(fileReader);
	                     
	            accessTokenItself = bufferedReader.readLine();
	            tokenType = bufferedReader.readLine();
	            refreshToken = bufferedReader.readLine();
	            expiresIn = Long.parseLong(bufferedReader.readLine());
	            rawResponse = bufferedReader.readLine();
	     
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file\n"+ex.getMessage()); 
	            System.exit(1);
	        }
	        catch(IOException ex) {
	            System.out.println(
	                    "Error reading/write file\n"+ex.getMessage());   
	            System.exit(1);
	        }
	        finally{
	            try{
	                if (bufferedReader!=null)
	                    // Always close files.
	                    bufferedReader.close();  
	            }
	            catch(Exception e){
	                System.out.println(
	                        "Error closing file\n"+e.getMessage());  
	            }
	        }
	        //  Create the Fitbit service - you will ask this to ask for access/refresh pairs
	        //     and to add authorization information to the requests to the API
	        FitbitOAuth20ServiceImpl service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
	                .apiKey(clientID)       //fitbit uses the clientID here
	                .apiSecret(apiSecret)
	                .callback(CALL_BACK_URI)
	                .scope(scope)
	                .grantType("authorization_code")
	                .build(FitbitApi20.instance());
	         
	        //  The access token contains everything you will need to authenticate your requests
	        //  It can expire - at which point you will use the refresh token to refresh it
	        //  See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
	        //    I have authenticated and given you the contents of the response to use
	        OAuth2AccessToken accessToken = new OAuth2AccessToken(
	                accessTokenItself,
	                tokenType,
	                refreshToken,
	                expiresIn,
	                rawResponse);
	        // Now let's go and ask for a protected resource!
	        System.out.println("Now we're going to access a protected resource...");
	        System.out.println();
	        //Example request:
	        //    This is always the prefix (for my account)
	        String requestUrlPrefix = "https://api.fitbit.com/1/user/3WGW2P/";
	        String requestUrl;
	        //    The URL from this point is how you ask for different information
	        requestUrl = requestUrlPrefix + URLSuffix;
	        // This actually generates an HTTP request from the URL
	        //    -it has a header, body ect.
	        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);
	         
	        // This adds the information required by Fitbit to add the authorization information to the HTTP request
	        // You must do this before the request will work
	        // See: https://dev.fitbit.com/docs/oauth2/#making-requests
	        service.signRequest(accessToken, request);
	        //  If you are curious
	        System.out.println(request.toString());
	        System.out.println(request.getHeaders());
	        System.out.println(request.getBodyContents());
	         
	         
	        //  This actually sends the request:
	        Response response = request.send();
	         
	        //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating 
	        //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
	        System.out.println();
	        System.out.println("HTTP response code: "+response.getCode());
	        int statusCode = response.getCode();
	         
	        switch(statusCode){
	            case 200:
	                System.out.println("Success!");
	                System.out.println("HTTP response body:\n"+response.getBody());
	                break;
	            case 400:
	                System.out.println("Bad Request - may have to talk to Beth");
	                System.out.println("HTTP response body:\n"+response.getBody());
	                break;
	            case 401:
	                System.out.println("Likely Expired Token");
	                System.out.println("HTTP response body:\n"+response.getBody());  
	                System.out.println("Try to refresh");
	                 
	                // This uses the refresh token to get a completely new accessToken object
	                //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens            
	                // This accessToken is now the current one, and the old ones will not work 
	                //   again.  You should save the contents of accessToken.
	                accessToken = service.refreshOAuth2AccessToken(accessToken);
	                 
	                // Now we can try to access the service again
	                // Make sure you create a new OAuthRequest object each time!
	                request = new OAuthRequest(Verb.GET, requestUrl, service);
	                service.signRequest(accessToken, request);
	                response = request.send();
	                 
	                // Hopefully got a response this time:
	                System.out.println("HTTP response code: "+response.getCode());
	                System.out.println("HTTP response body:\n"+response.getBody()); 
	                break;
	            case 429:
	                System.out.println("Rate limit exceeded");
	                System.out.println("HTTP response body:\n"+response.getBody());
	                break;
	            default:
	                System.out.println("HTTP response code: "+response.getCode());
	                System.out.println("HTTP response body:\n"+response.getBody()); 
	        }
	         
	        BufferedWriter bufferedWriter=null;
	        //  Save the current accessToken information for next time
	         
	        // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
	        //   - contact Beth if this happens and she can reissue you a fresh set
	         
	        try {
	            FileWriter fileWriter;  
	            fileWriter =
	                    new FileWriter(resourcePath + "Team5Tokens.txt");
	            bufferedWriter = new BufferedWriter(fileWriter);
	            bufferedWriter.write(accessToken.getToken());
	            bufferedWriter.newLine();
	            bufferedWriter.write(accessToken.getTokenType());
	            bufferedWriter.newLine();
	            bufferedWriter.write(accessToken.getRefreshToken());
	            bufferedWriter.newLine();
	            bufferedWriter.write(accessToken.getExpiresIn().toString() );
	            bufferedWriter.newLine();
	            bufferedWriter.write(accessToken.getRawResponse());
	            bufferedWriter.newLine();
	            bufferedWriter.close();
	            
	    		FileOutputStream f_out = new FileOutputStream(resourcePath + outputFileName);

	    		// Write object with ObjectOutputStream
	    		ObjectOutputStream obj_out = new ObjectOutputStream (f_out);

	    		String obj = new String(response.getBody());
	    		// Write object out to disk
	            
	    		
	    		obj_out.writeObject(obj);
	    		
	    		f_out.close();
	    		obj_out.close();  
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file\n"+ex.getMessage());                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                    "Error reading/write file\n"+ex.getMessage());                  
	        }
	        finally{
	            try{ 
	                if (bufferedWriter!=null)
	                    bufferedWriter.close();  
	            }
	            catch(Exception e){
	                System.out.println(
	                        "Error closing file\n"+e.getMessage());  
	            }
	        }//end try
	    }//end method


	// comment this main out if you aren't testing

	public static void main( String[] args )
    {
		Request req = new Request();
		req.storeLifeLongActivities();
		req.storeDailyActivity("2016-2-27");
		
    }//end main 
}
