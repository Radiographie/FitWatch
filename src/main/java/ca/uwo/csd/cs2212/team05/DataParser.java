package ca.uwo.csd.cs2212.team05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DataParser {

	private String sourcePath;
	private String simpleDataFormat;
	private JSONObject jsonObj;
	private ObjectInputStream in;
	
	public DataParser(String simpleDataFormat){
		this.simpleDataFormat = simpleDataFormat;
		if (this.simpleDataFormat == ""){
			this.sourcePath = "src/main/resources/apiData/activities.json"; 
		}
		else{
			this.sourcePath = "src/main/resources/apiData/activities" + this.simpleDataFormat + ".json";
		}
		try {
			readSource();
		} catch (ClassNotFoundException | IOException | JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void readSource()throws IOException, ClassNotFoundException, JSONException{
		in = new ObjectInputStream(new FileInputStream(this.sourcePath));
		JSONTokener token = new JSONTokener((String)in.readObject());
		this.setJsonObj(new JSONObject(token));
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public double getBestFloorsValue() throws JSONException{
		String value = this.jsonObj.getJSONObject("best").getJSONObject("total").getJSONObject("floors").getString("value");
		double floorsValue = Double.parseDouble(value);
		return floorsValue;
	}
	
	public String getBestFloorsDate() throws JSONException{
		String floorsDate = this.jsonObj.getJSONObject("best").getJSONObject("total").getJSONObject("floors").getString("date");
		return floorsDate;
	}
	
	public double getBestStepsValue() throws JSONException{
		String value = this.jsonObj.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getString("value");
		double floorsValue = Double.parseDouble(value);
		return floorsValue;
	}
	
	public String getBestStepsDate() throws JSONException{
		String floorsDate = this.jsonObj.getJSONObject("best").getJSONObject("total").getJSONObject("steps").getString("date");
		return floorsDate;
	}
	
	public double getLifeLongFloors() throws JSONException{
		String value = this.jsonObj.getJSONObject("lifetime").getJSONObject("total").getString("floors");
		double lifeLongFloors = Double.parseDouble(value);
		return lifeLongFloors;
	}
	
	public double getLifeLongDistance() throws JSONException{
		String value = this.jsonObj.getJSONObject("lifetime").getJSONObject("total").getString("distance");
		double lifeLongDistance = Double.parseDouble(value);
		return lifeLongDistance;
	}
	
	public double getLifeLongSteps() throws JSONException{
		String value = this.jsonObj.getJSONObject("lifetime").getJSONObject("total").getString("steps");
		double lifeLongSteps = Double.parseDouble(value);
		return lifeLongSteps;
	}
	
	public double getDailyCalorie() throws JSONException{
		String value = this.jsonObj.getJSONObject("summary").getString("caloriesOut");
		double dailyCalorie = Double.parseDouble(value);
		return dailyCalorie;
	}
	
	public double getDailyDistance() throws JSONException{
		String value = this.jsonObj.getJSONObject("summary").getJSONArray("distances").getJSONObject(2).getString("distance");
		double dailyDistance = Double.parseDouble(value);
		return dailyDistance;
	}
	
	public double getDailySteps() throws JSONException{
		String value = this.jsonObj.getJSONObject("summary").getString("steps");
		double dailySteps = Double.parseDouble(value);
		return dailySteps;
	}
	
	public double getDailyFloor() throws JSONException{
		String value = this.jsonObj.getJSONObject("summary").getString("floors");
		double dailyFloor = Double.parseDouble(value);
		return dailyFloor;
	}
	
	public double getDailyActive() throws JSONException{
		String lightlyActiveMinutes = this.jsonObj.getJSONObject("summary").getString("lightlyActiveMinutes");
		String fairlyActiveMinutes = this.jsonObj.getJSONObject("summary").getString("fairlyActiveMinutes");
		String veryActiveMinutes = this.jsonObj.getJSONObject("summary").getString("veryActiveMinutes");
		double dailyActive = Double.parseDouble(lightlyActiveMinutes)  + Double.parseDouble(fairlyActiveMinutes) + Double.parseDouble(veryActiveMinutes);
		return dailyActive;
	}
	
	public double getDailySedentary() throws JSONException{
		String value = this.jsonObj.getJSONObject("summary").getString("sedentaryMinutes");
		double dailySedentary = Double.parseDouble(value);
		return dailySedentary;
	}
	
	public void close() throws IOException{
		this.in.close();
	}
}
