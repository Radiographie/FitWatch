package ca.uwo.csd.cs2212.team05;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;

public class GoalData extends Data implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String goalType;
	private int length;																	//can be choose from 1, 7, or set by user
	private int progress;
	private double goal;
	private Boolean done;
		
	public GoalData(String beginDateString, String goalType, int duration, double goalValue) throws ParseException{
		super(beginDateString);
		this.path = setPath();
		this.length = duration;
		this.goalType = goalType;
		this.progress = 0;
		this.goal = goalValue;
	}
	
	//start from the Date that not checked 
	public void check() throws JSONException, IOException, ParseException{
		
		Calendar cal = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = formatter.parse(this.simpleDataFormat); 
		cal.setTime(beginDate);
		cal.add(Calendar.DATE, progress);
		
		while(cal != Calendar.getInstance());{
			String date = formatter.format(cal.getTime());
			if (getGoalDate(date)<this.goal){
				setDone(false);
			}
			else{
				progress++;
			}
			cal.add(Calendar.DATE, +1);
		}
		
		if (getGoalDate()>=this.goal){
			progress++;
		}
		
		if (progress == length){
			setDone(true);
		}

		//if neither false or success, do nothing
	}
	
	public int timePass() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = formatter.parse(this.simpleDataFormat); 
		Date currDate = Calendar.getInstance().getTime();
			 
		int gap = (int) ((currDate.getTime() - beginDate.getTime())/86400000);
		return gap;
	}
	
	public double getGoalDate() throws JSONException, IOException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currDate = Calendar.getInstance().getTime();
		String today = formatter.format(currDate);
		DataParser parser = new DataParser(today);
		double value = 0;
		switch(this.goalType){
			case "calorie":{value = parser.getDailyCalorie();}break;
			case "distance":{value = parser.getDailyDistance();}break;
			case "steps":{value = parser.getDailySteps();}break;
			case "floors":{value = parser.getDailyFloor();}break;
		}
		parser.close();
		return value;
	}
	
	public double getGoalDate(String simpleDate) throws JSONException, IOException{
		DataParser parser = new DataParser(simpleDate);
		double value = 0;
		switch(this.goalType){
			case "calorie":{value = parser.getDailyCalorie();}break;
			case "distance":{value = parser.getDailyDistance();}break;
			case "steps":{value = parser.getDailySteps();}break;
			case "floors":{value = parser.getDailyFloor();}break;
		}
		parser.close();
		return value;
	}
	
	
	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

}
