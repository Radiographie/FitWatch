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
	private int condition; 															// 0 for in progress; -1 for failed; 1 for success
	private double goal;
		
	public GoalData(String beginDateString, String goalType, int duration, double goal) throws ParseException{
		super(beginDateString);
		this.path = setPath();
		this.length = duration;
		this.goalType = goalType;
		this.condition = 0;
		this.setGoal(goal);
	}
	
//	public Boolean check(){
//		
//	}
	
	public int getProgress() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = formatter.parse(this.simpleDataFormat); 
		Date currDate = Calendar.getInstance().getTime();
			 
		int gap = (int) ((currDate.getTime() - beginDate.getTime())/86400000);
		return gap;
	}
		
	public void goalFinish(int finishCode){
		this.setCondition(finishCode);
		this.setLength(0);
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

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

}
