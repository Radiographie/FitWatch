package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeaturePanel extends JPanel {

	private RightPanel parent;
	/**
	 * Create the panel.
	 */
	public FeaturePanel(RightPanel parent) {
		this.parent = parent;
		//setBackground(Color.GREEN);
		setLayout(null);
		initialize();
		
	}
	public void initialize(){
		this.setSize(610, 30);
		this.setLayout(null);
		
		//dailydata botton
		JButton dailyDataBtn = new JButton("Daily data");
		dailyDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent daily) {
				parent.initialize(0);
			}
		});
		dailyDataBtn.setBounds(0, 0, 118, 30);
		dailyDataBtn.setOpaque(false);
		dailyDataBtn.setContentAreaFilled(true);
		dailyDataBtn.setBorderPainted(false);
		add(dailyDataBtn);
		dailyDataBtn.setVisible(true);
		
		//calories botton
		JButton caloriesBtn = new JButton("Calories");
		caloriesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent cal) {
				parent.initialize(1);
			}
		});
		caloriesBtn.setBounds(118, 0, 118, 30);
		caloriesBtn.setOpaque(false);
		caloriesBtn.setContentAreaFilled(true);
		caloriesBtn.setBorderPainted(false);
		add(caloriesBtn);
		caloriesBtn.setVisible(true);	
		
		//goal botton
		JButton goalsBtn = new JButton("Goals");
		goalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent goal) {
				parent.initialize(2);
			}
		});
		goalsBtn.setBounds(118*2, 0, 118, 30);
		goalsBtn.setOpaque(false);
		goalsBtn.setContentAreaFilled(true);
		goalsBtn.setBorderPainted(false);
		add(goalsBtn);
		goalsBtn.setVisible(true);
		
		//achievements botton
		JButton achievementBtn = new JButton("Achievement");
		achievementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent achi) {
				parent.initialize(3);
			}
		});
		achievementBtn.setBounds(118*3, 0, 118, 30);
		achievementBtn.setOpaque(false);
		achievementBtn.setContentAreaFilled(true);
		achievementBtn.setBorderPainted(false);
		add(achievementBtn);
		achievementBtn.setVisible(true);
	}

}
