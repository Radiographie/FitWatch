package ca.uwo.csd.cs2212.team05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DailyData extends Data implements Serializable {

		private static final long serialVersionUID = 1L;
		private double calories, distance, floors, steps, active, sedentary;
		
		public DailyData(String simpleDataFormat){
			super(simpleDataFormat);
            this.path = setPath();
			this.calories = 0;
			this.distance = 0;
			this.floors = 0;
			this.steps = 0;
			this.active = 0;
			this.sedentary = 0;
		}
		
		public double getCalories(){
			return calories;
		}
		
		public double getDistance(){
			return distance;
		}
		
		public double getFloors(){
			return floors;
		}
		
		public double getSteps(){
			return steps;
		}
		
		public double getActive(){
			return active;
		}
		
		public double getSedentary(){
			return sedentary;
		}

		public void setCalories(double calories){
			this.calories = calories;
		}
		
		public void setDistance(double distance){
			this.distance = distance;
		}
		
		public void setFloors(double floors){
			this.floors = floors;
		}
		
		public void setSteps(double steps){
			this.steps = steps;
		}
		
		public void setActive(double active){
			this.active = active;
		}
		
		public void setSedentary(double sedentary){
			this.sedentary = sedentary;
		}
		
		/**
		 * Method getDaysData returns a DailyData object containing the data for a specific day that was retrieved locally.
		 * It restores the local storage of the data to a JSON Object and retrieves the needed data from this.
		 * 
		 * 
		 * @param y, integer representing the year
		 * @param m, integer representing the month
		 * @param d, integer representing the day
		 * @return data, a DailyData object containing date and several needed values
		 * @throws IOException
		 * @throws ClassNotFoundException
		 * @throws JSONException
		 */
		public void getDailyData(String simpleDataFormat) throws IOException, ClassNotFoundException, JSONException{
			
			DailyData dailyData = new DailyData(simpleDataFormat);
			dailyData = (DailyData) this.readDate();
			
			if (dailyData != null){
			  	this.setCalories (dailyData.getCalories());
			  	this.setDistance (dailyData.getDistance());
			  	this.setFloors (dailyData.getFloors());
			  	this.setSteps (dailyData.getSteps());
			  	this.setActive (dailyData.getActive());
			  	this.setSedentary (dailyData.getSedentary());
			}
			else{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/apiData/activities" + this.simpleDataFormat + ".json"));
				JSONTokener tokener = new JSONTokener((String)in.readObject());
				JSONObject temp = new JSONObject(tokener);
				
			  	String calor = temp.getJSONObject("summary").getString("caloriesOut");
			  	String dist = temp.getJSONObject("summary").getJSONArray("distances").getJSONObject(2).getString("distance");
			  	String floor = temp.getJSONObject("summary").getString("floors");
			  	String step = temp.getJSONObject("summary").getString("steps");
			  	String activeLight = temp.getJSONObject("summary").getString("lightlyActiveMinutes");
			  	String activeModerate = temp.getJSONObject("summary").getString("fairlyActiveMinutes");
			  	String activeHeavy = temp.getJSONObject("summary").getString("veryActiveMinutes");
			  	String sed = temp.getJSONObject("summary").getString("sedentaryMinutes");
				
			  	this.setCalories (Double.parseDouble(calor));
			  	this.setDistance (Double.parseDouble(dist));
			  	this.setFloors (Double.parseDouble(floor));
			  	this.setSteps (Double.parseDouble(step));
			  	this.setActive (Double.parseDouble(activeLight)  + Double.parseDouble(activeModerate) + Double.parseDouble(activeHeavy));
			  	this.setSedentary (Double.parseDouble(sed));
				
				in.close();
			}
		}
		
		/*
		public static void main(String[] args){
			DailyData d1 = new DailyData(1992,3,3);
			d1.setCalories(12.12);
			d1.setDay(23);
			System.out.println(d1.getClass().getName());
			d1.writeData();
			DailyData d2 = new DailyData(1992,3,3);
			d2 = (DailyData)d1.readDate();
			System.out.println(d2.getCalories());
			System.out.println(d2.getDay());
		}
		*/
	}
