package ca.uwo.csd.cs2212.team05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CalorieData extends Data implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	private double calorisBurned;
	private double calorisTook;
	private double calorisBalance;
	
	public CalorieData(String simpleDataFormat){
		super(simpleDataFormat);
		this.path = setPath();
		this.calorisTook = 0;
		this.calorisBurned = 0;
		this.calorisBalance = this.calorisTook - this.calorisBurned;
	}

	public double getCalorisBalance() {
		return calorisBalance;
	}

	public void setCalorisBalance(double calorisBalance) {
		this.calorisBalance = calorisBalance;
	}

	public double getCalorisBurned() {
		return calorisBurned;
	}

	public void setCalorisBurned(double calorisBurned) {
		this.calorisBurned = calorisBurned;
	}

	public double getCalorisTook() {
		return calorisTook;
	}

	public void setCalorisTook(double calorisTook) {
		this.calorisTook = calorisTook;
	}
	
	
	public int[] convert(){
		
		int[] result = {0,0,0};
		int burnNum = (int)this.getCalorisBurned();
		final int MUFFIN_CAL = 450;
		final int BURGER_CAL = 295;
		final int PIZZA_CAL = 172;
		
		int num1 = burnNum/MUFFIN_CAL;
		result[0] = num1;
		int rest = burnNum%MUFFIN_CAL;
		int num2 = rest/BURGER_CAL;
		result[1] = num2;
		rest = rest%BURGER_CAL;
		int num3 = rest/PIZZA_CAL;
		result[2] = num3;
		
		return result;
	}
	
	
	public void getCalorieData(String simpleDataFormat) throws IOException, ClassNotFoundException, JSONException{
		
		CalorieData calorieData = new CalorieData(simpleDataFormat);
		calorieData = (CalorieData) this.readDate();
		
		if (calorieData != null){
			this.setCalorisTook(calorieData.getCalorisTook());
			this.setCalorisBurned(calorieData.getCalorisBurned());
			this.setCalorisBalance(calorieData.getCalorisBalance());
		}
		else{			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/apiData/activities" + simpleDataFormat + ".json"));
			JSONTokener tokener = new JSONTokener((String)in.readObject());
			JSONObject temp = new JSONObject(tokener);
			
			String calor = temp.getJSONObject("summary").getString("caloriesOut");
			this.setCalorisBurned (Double.parseDouble(calor));
			
			in.close();
		}

	}
	
	/*
	public static void main(String[] args){
		CalorieData d1 = new CalorieData(1992,3,3);
		d1.setCalorisBurned(12.12);
		System.out.println(d1.getClass().getName());
		d1.writeData();
		CalorieData d2 = new CalorieData(1992,3,3);
		d2 = (CalorieData)d1.readDate();
		System.out.println(d2.getCalorisBurned());
	}
	*/
}
