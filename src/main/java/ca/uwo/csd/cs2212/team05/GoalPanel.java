package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;

public class GoalPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GoalPanel() {
		setBackground(Color.RED);
		setLayout(null);
		initialize();
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
	}

}
