package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HeartRatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HeartRatePanel() {
		setBackground(Color.YELLOW);
		setLayout(null);
		
		//new feature label
		JLabel newFeatureLabel = new JLabel("new feature is coming up");
		newFeatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newFeatureLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newFeatureLabel.setBounds(0, 81, 610, 294);
		add(newFeatureLabel);
		initialize();
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
	}
}