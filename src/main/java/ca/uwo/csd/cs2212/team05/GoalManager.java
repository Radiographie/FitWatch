package ca.uwo.csd.cs2212.team05;

import java.io.File;
import java.util.ArrayList;

public class GoalManager extends Data{
	
	private ArrayList<GoalData> goals = new ArrayList<GoalData>();
	private int onProgress;
	private int success;
	private int failed;
	
	public GoalManager(){
		super("");
		this.path = setPath();
	}
	
	public void addGoal(GoalData g){
		goals.add(g);
		onProgress++;
		g.writeData();
	}
	
	public void remove(GoalData g){
		File f = new File(g.path);
		
		
	}
	
	public void sort(){
		
	}
}
