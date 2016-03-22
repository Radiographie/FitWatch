package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.SwingConstants;

public class CaloriesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CaloriesPanel() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		//calories in label
		JLabel caloriesIn = new JLabel("Calories In");
		caloriesIn.setHorizontalAlignment(SwingConstants.CENTER);
		caloriesIn.setBounds(40, 60, 57, 14);
		add(caloriesIn);
		
		//calories out label
		JLabel lblNewLabel = new JLabel("Calories Out");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 163, 67, 14);
		add(lblNewLabel);
				
		//calories in calories out
		JLabel caloriesInCaloriesOut = new JLabel();
		caloriesInCaloriesOut.setBounds(22, 22, 293, 193);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		caloriesInCaloriesOut.setBorder(border);
		add(caloriesInCaloriesOut);
		
		//calories input
		JLabel caloriesInput = new JLabel();
		caloriesInput.setBounds(22, 237, 293, 193);
		caloriesInput.setBorder(border);
		add(caloriesInput);
		
		//calories info display
		JLabel caloriesInfoDisplay = new JLabel();
		caloriesInfoDisplay.setBounds(337, 22, 251, 408);
		caloriesInfoDisplay.setBorder(border);
		add(caloriesInfoDisplay);
		
		initialize();
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
		
	}
	
	
}