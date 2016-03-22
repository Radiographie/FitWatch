package ca.uwo.csd.cs2212.team05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LifeLongData  extends Data implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double value;
	private final String SOURCE = "src/main/resources/apiData/activities.json";
	
	public LifeLongData(){
		super("");
		this.path = getPath();
		this.setValue(0);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	


	
	/**
	 * Method getBestSteps returns a Data object containing the value representing the largest number of steps taken
	 * in a day, and the date on which this best occurred.  It restores the local storage of the data to a JSON Object
	 * and retrieves the needed data from this.
	 * 
	 * @return stepsData, Data object containing date and value
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws JSONException
	 */
	
	public Data getBestSteps() throws IOException, ClassNotFoundException, JSONException{
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.SOURCE));
		JSONTokener tokener = new JSONTokener((String)in.readObject());
		JSONObject temp = new JSONObject(tokener);
	  	String stepsValue = temp.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getString("value");
	  	String stepsDate = temp.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getString("date");
	  	
	  	LifeLongData stepsData = new LifeLongData();
	  	stepsData.setValue (Double.parseDouble(stepsValue));
	  	stepsData.setSimpleDataFormat(stepsDate);
	  	
	  	in.close();

		return stepsData;
	}
	
	/**
	 * Method getLifetimeFloors returns a double representing the total lifetime floors climbed by the user.
	 *  It restores the local storage of the data to a JSON Object and retrieves the needed data from this.
	 * 
	 * @return floorsData, a double representing the total lifetime floors climbed
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws JSONException
	 */
	
	public double getLifetimeFloors() throws IOException, ClassNotFoundException, JSONException{
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.SOURCE));
		JSONTokener tokener = new JSONTokener((String)in.readObject());
		JSONObject temp = new JSONObject(tokener);
	  	String floorsValue = temp.getJSONObject("lifetime").getJSONObject("total").getString("floors");
	  	double floorsData = Double.parseDouble(floorsValue);
	  	
	  	in.close();
		
		return floorsData;
	}
	
	/**
	 * Method getLifetimeDistance returns a double representing the total lifetime distance traveled in km by the user.
	 *  It restores the local storage of the data to a JSON Object and retrieves the needed data from this.
	 * 
	 * @return distanceData, a double representing the total lifetime distance traveled in km
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws JSONException
	 */
	
	public double getLifetimeDistance() throws IOException, ClassNotFoundException, JSONException{
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.SOURCE));
		JSONTokener tokener = new JSONTokener((String)in.readObject());
		JSONObject temp = new JSONObject(tokener);
	  	String distanceValue = temp.getJSONObject("lifetime").getJSONObject("total").getString("distance");
	  	double distanceData = Double.parseDouble(distanceValue);
	  	
	  	in.close();
		
		return distanceData;
	}
	
	/**
	 * Method getLifetimeSteps returns a double representing the total lifetime steps taken by the user.
	 *  It restores the local storage of the data to a JSON Object and retrieves the needed data from this.
	 * 
	 * @return stepsData, a double representing the total lifetime steps taken
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws JSONException
	 */
	
	public double getLifetimeSteps() throws IOException, ClassNotFoundException, JSONException{
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.SOURCE));
		JSONTokener tokener = new JSONTokener((String)in.readObject());
		JSONObject temp = new JSONObject(tokener);
	  	String stepsValue = temp.getJSONObject("lifetime").getJSONObject("total").getString("steps");
	  	double stepsData = Double.parseDouble(stepsValue);
	  	
	  	in.close();
		
		return stepsData;
	}
	

}
