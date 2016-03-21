package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;

public class ContentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ContentPanel() {
		setBackground(Color.GRAY);
		setLayout(null);
		initialize();
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
	}

}
