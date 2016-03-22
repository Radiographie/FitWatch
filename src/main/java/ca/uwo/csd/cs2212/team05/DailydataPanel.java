package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class DailydataPanel extends JPanel {
	/**
	 * 
	 */
	
	/**
	 * Create the panel.
	 */
	public DailydataPanel() {
		setBackground(Color.PINK);
		setLayout(null);
		initialize();
		
		
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
		
		//steps label
		JLabel stepsLabel = new JLabel("Steps");
		stepsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stepsLabel.setBackground(Color.ORANGE);
		stepsLabel.setOpaque(true);
		stepsLabel.setBounds(22, 22, 174, 193);
		add(stepsLabel);
		
		//calories burned
		JLabel caloriesBurnedLabel = new JLabel("Calories Burned");
		caloriesBurnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		caloriesBurnedLabel.setBackground(Color.RED);
		caloriesBurnedLabel.setOpaque(true);
		caloriesBurnedLabel.setBounds(22*2+174, 22, 174, 193);
		add(caloriesBurnedLabel);
		
		//floors climbed
		JLabel floorsClimbedLabel = new JLabel("Floors Climbed");
		floorsClimbedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		floorsClimbedLabel.setBackground(Color.WHITE);
		floorsClimbedLabel.setOpaque(true);
		floorsClimbedLabel.setBounds(22*3+174*2, 22, 174, 193);
		add(floorsClimbedLabel);
		
		//total distance walked
		JLabel totalDistanceWalkedLabel = new JLabel("Total Distance Walked");
		totalDistanceWalkedLabel.setBackground(Color.DARK_GRAY);
		totalDistanceWalkedLabel.setOpaque(true);
		totalDistanceWalkedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalDistanceWalkedLabel.setBounds(22, 237, 174, 193);
		add(totalDistanceWalkedLabel);
		
		//resting minutes
		JLabel restingMinutesLabel = new JLabel("Resting Minutes");
		restingMinutesLabel.setBackground(Color.BLUE);
		restingMinutesLabel.setOpaque(true);
		restingMinutesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restingMinutesLabel.setBounds(22*2+174, 22*2+193, 174, 193);
		add(restingMinutesLabel);
		
		//active minutes
		JLabel activeMinutesLabel = new JLabel("Active Minutes");
		activeMinutesLabel.setBackground(Color.CYAN);
		activeMinutesLabel.setOpaque(true);
		activeMinutesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		activeMinutesLabel.setBounds(22*3+174*2, 22*2+193, 174, 193);
		add(activeMinutesLabel);
	}
}
