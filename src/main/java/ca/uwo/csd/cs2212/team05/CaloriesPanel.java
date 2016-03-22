package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaloriesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CaloriesPanel() {
		setBackground(Color.CYAN);
		setLayout(null);
		initialize();
				
		//place compare panel here
		JLabel placeComparePanelHere = new JLabel();
		placeComparePanelHere.setBounds(22, 22, 272, 193);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		placeComparePanelHere.setBorder(border);
		add(placeComparePanelHere);
		
		//calories inputs
		JLabel caloriesInputsLabel = new JLabel();
		caloriesInputsLabel.setBounds(22, 237, 272, 193);
		caloriesInputsLabel.setBorder(border);
		add(caloriesInputsLabel);
		
		//calories info display
		JLabel caloriesInfoDisplay = new JLabel();
		caloriesInfoDisplay.setBounds(316, 22, 272, 408);
		caloriesInfoDisplay.setBorder(border);
		add(caloriesInfoDisplay);
		
		//calories input
		JLabel caloriesInputLabel = new JLabel("Calories Input:");
		caloriesInputLabel.setBounds(40, 275, 71, 15);
		add(caloriesInputLabel);
		
		//calories total input
		JLabel caloriesTotalInputLabel = new JLabel("Calories Total input:");
		caloriesTotalInputLabel.setBounds(40, 345, 96, 15);
		add(caloriesTotalInputLabel);
		
		//calories input textfield
		JTextField caloriesInputTextfield = new JTextField();
		caloriesInputTextfield.setBounds(40, 300, 150, 30);
		add(caloriesInputTextfield);
		
		//calories total input displayer
		JLabel caloriesTotalInputDisplayer = new JLabel();
		caloriesTotalInputDisplayer.setText("");
		caloriesTotalInputDisplayer.setBorder(border);
		caloriesTotalInputDisplayer.setBounds(40, 370, 150, 30);
		add(caloriesTotalInputDisplayer);
		
		//ok botton
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				int data1 = Integer.parseInt(caloriesInputTextfield.getText());
				int data0 = Integer.parseInt(caloriesTotalInputDisplayer.getText());
				int tempData = data1 + data0;
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(tempData);
				String data2 = sb.toString();
				caloriesTotalInputDisplayer.setText(data2);
				caloriesInputTextfield.setText(null);
			}
		});
		okBtn.setBounds(220, 300, 60, 30);
		add(okBtn);
		
		//reset botton
		JButton resetBtn = new JButton("Reset");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				caloriesTotalInputDisplayer.setText("0");
			}
		});
		resetBtn.setBounds(220, 371, 60, 30);
		add(resetBtn);
	}
	
	public void initialize(){
		this.setSize(610, 452);
		this.setLayout(null);
		
	}
}