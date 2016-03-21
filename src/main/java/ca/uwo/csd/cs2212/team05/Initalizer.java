package ca.uwo.csd.cs2212.team05;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Initalizer {
	
	private Request req = new Request(); 
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String date;
	private final String APIPATH = "src/main/resources/apiActivity/";
	
	public Initalizer(){
		this.date = dateFormat.format(Calendar.getInstance().getTime());
		check();
		refresh();
	}

	public void check(){
		final String[] JARLIST = {"src/main/resources/AbsoluteLayout.jar",
				"src/main/resources/jcalendar-1.4.jar",
				"src/main/resources/jgoodies-common-1.2.0.jar",
				"src/main/resources/jgoodies-looks-2.4.1.jar",
				"src/main/resources/junit-4.6.jar","src/main/resources/WeatherLibrary.jar"};
		List<String> jarNotExist = new ArrayList<String>();
		for (int i=0; i<JARLIST.length; i++){
			String fileName = JARLIST[i];
			if (!(new File(fileName).exists())){
				jarNotExist.add(fileName);
			}
		}
		if (jarNotExist != null){
			System.out.println("Necessary jar file needed:");
			for (int j=0; j<jarNotExist.size(); j++){
				System.out.println(jarNotExist.get(j));
			}
			System.exit(-1);
		}
	}
	
	public void refresh(){
		dirRefresh();
		
		String DailyActivityPath = this.APIPATH + "activity"+ this.date +".json";
		File DailyActivity = new File(DailyActivityPath);
		
		//when the data is not up-to-date, refresh all, else check if LifeLong data missing and refresh
		if (!DailyActivity.exists()){
			req.storeDailyActivity(this.date);
			req.storeLifeLongActivities();
		}
		else{
			String LifeLongPath = this.APIPATH + "activity.json";
			File LifeLongActivity = new File(LifeLongPath);
			if (!LifeLongActivity.exists()){
				req.storeLifeLongActivities();
			}
		}
	}
	
	public void refresh(String selectDate){
		this.date = selectDate;
		dirRefresh();
		String SelectDateActivityPath = this.APIPATH + "activity"+ this.date +".json";
		File selectDateDailyActivity = new File(SelectDateActivityPath);
		if (!selectDateDailyActivity.exists()){
			req.storeDailyActivity(this.date);
		}
	}
	
	public void dirRefresh(){
		new File(this.APIPATH).mkdirs();
		new File("src/main/resources/CalorieData").mkdirs();
		new File("src/main/resources/DailyData").mkdirs();
		new File("src/main/resources/GoalData").mkdirs();
		new File("src/main/resources/HeartRateData").mkdirs();
		new File("src/main/resources/LifeLongData").mkdirs();
	}

	public Request getReq() {
		return req;
	}

	public void setReq(Request req) {
		this.req = req;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	


	/*
	public static void main(String[] args) throws IOException{
		File dir =new File("src/main/resources/LifeLongData");
		dir.mkdirs();
		File file = new File("src/main/resources/LifeLongData/check.dat");
		file.createNewFile();
		File dirs =new File("src/main/resources/LifeLongData");
		dirs.mkdirs();


		System.out.println(new File("src/main/resources/LifeLongData/check.dat").exists());
	}*/

}
