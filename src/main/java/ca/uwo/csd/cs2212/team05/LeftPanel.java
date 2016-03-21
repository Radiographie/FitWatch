package ca.uwo.csd.cs2212.team05;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDayChooser;

public class LeftPanel extends JPanel {

	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public LeftPanel() {
		setBackground(new Color(245, 245, 245));
		initialize();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Last Update:");
		lblNewLabel.setBounds(0, 381, 182, 30);
		add(lblNewLabel);
	}
		
	
	public void initialize(){
		this.setSize(182, 452);
		this.setLayout(null);
		
		//dateChooser
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(0, 60, 182, 140);
		add(dayChooser);
		
		//switch user botton
		JButton caloriesBtn = new JButton("Refresh");
		caloriesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		caloriesBtn.setBounds(0, 422, 182, 30);
		caloriesBtn.setOpaque(false);
		caloriesBtn.setContentAreaFilled(true);
		caloriesBtn.setBorderPainted(false);
		add(caloriesBtn);
		caloriesBtn.setVisible(true);
	}
}
