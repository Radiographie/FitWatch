package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ComparePanel extends JPanel {
	private double redNum;
	private double blueNum;
	private double maxNum;
	/**
	 * Create the panel.
	 */
	public ComparePanel() {
		setLayout(null);
		initialize();
		
		//calories in label
		JLabel caloriesIn = new JLabel("Calories In");
		caloriesIn.setHorizontalAlignment(SwingConstants.CENTER);
		caloriesIn.setBounds(20, 33, 57, 20);
		add(caloriesIn);
				
		//calories out label
		JLabel lblNewLabel = new JLabel("Calories Out");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 139, 67, 20);
		add(lblNewLabel);
		
		
		//calories in line
		JLabel caloriesInLine = new JLabel();
		Border border1 = BorderFactory.createLineBorder(Color.BLUE, 5);
		caloriesInLine.setBorder(border1);
		caloriesInLine.setBounds(20, 88, (int)(blueNum/maxNum*232), 5);
		add(caloriesInLine);
		
		//calories out line
		JLabel caloriesOutLine = new JLabel();
		Border border2 = BorderFactory.createLineBorder(Color.RED, 5);
		caloriesOutLine.setBorder(border2);
		caloriesOutLine.setBounds(20, 100, (int)(redNum/maxNum*232), 5);
		add(caloriesOutLine);
	}
	
	public void initialize(){
		this.setSize(272, 193);
		this.setLayout(null);
	}

	public double getRedNum() {
		return redNum;
	}

	public void setRedNum(double redNum) {
		this.redNum = redNum;
	}

	public double getBlueNum() {
		return blueNum;
	}

	public void setBlueNum(double blueNum) {
		this.blueNum = blueNum;
	}

	public double getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(double maxNum) {
		this.maxNum = maxNum;
	}
	
	
}
