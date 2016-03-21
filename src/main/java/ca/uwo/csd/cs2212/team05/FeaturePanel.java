package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FeaturePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public FeaturePanel() {
		setBackground(Color.GREEN);
		setLayout(null);
		initialize();
		
	}
	public void initialize(){
		this.setSize(794, 30);
		this.setLayout(null);
		
		//all feature label
		JLabel feature = new JLabel("Feature");
		feature.setHorizontalAlignment(SwingConstants.CENTER);
		feature.setBounds(0, 0, 182, 30);
		add(feature);
		
		//dailydata botton
		JButton dailyDataBtn = new JButton("Daily data");
		dailyDataBtn.setBounds(182, 0, 122, 30);
		dailyDataBtn.setOpaque(false);
		dailyDataBtn.setContentAreaFilled(true);
		dailyDataBtn.setBorderPainted(false);
		add(dailyDataBtn);
		dailyDataBtn.setVisible(true);
		
		//goal botton
		JButton goalsBtn = new JButton("Goals");
		goalsBtn.setBounds(182+122, 0, 122, 30);
		goalsBtn.setOpaque(false);
		goalsBtn.setContentAreaFilled(true);
		goalsBtn.setBorderPainted(false);
		add(goalsBtn);
		goalsBtn.setVisible(true);
		
		//heartrate botton
		JButton heartRateBtn = new JButton("Heart rate");
		heartRateBtn.setBounds(182+122*2, 0, 122, 30);
		heartRateBtn.setOpaque(false);
		heartRateBtn.setContentAreaFilled(true);
		heartRateBtn.setBorderPainted(false);
		add(heartRateBtn);
		heartRateBtn.setVisible(true);
		
		//calories botton
		JButton caloriesBtn = new JButton("Calories");
		caloriesBtn.setBounds(182+122*3, 0, 122, 30);
		caloriesBtn.setOpaque(false);
		caloriesBtn.setContentAreaFilled(true);
		caloriesBtn.setBorderPainted(false);
		add(caloriesBtn);
		caloriesBtn.setVisible(true);
		
		//achievements botton
		JButton achievementBtn = new JButton("Achievement");
		achievementBtn.setBounds(182+122*4, 0, 122, 30);
		achievementBtn.setOpaque(false);
		achievementBtn.setContentAreaFilled(true);
		achievementBtn.setBorderPainted(false);
		add(achievementBtn);
		achievementBtn.setVisible(true);
	}

}
