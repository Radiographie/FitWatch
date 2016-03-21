package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BannerPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public BannerPanel() {
		setBackground(Color.YELLOW);
		initialize();
		setLayout(null);
	}
	
	public void initialize(){
		this.setSize(794, 90);
		this.setLayout(null);
		
		//avatar label
		JLabel avatarLabel = new JLabel("Avatar");
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarLabel.setBounds(0, 0, 90, 90);
		add(avatarLabel);
		
		//username label
		JLabel usernameLabel = new JLabel("Hello username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(90, 0, 120, 90);
		add(usernameLabel);
		
		//sex label
		JLabel sexLabel = new JLabel("Sex");
		sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexLabel.setBounds(270, 0, 90, 45);
		add(sexLabel);
		
		//age label
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setBounds(270, 45, 90, 45);
		add(ageLabel);
		
		//height label
		JLabel heightLabel = new JLabel("Height");
		heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightLabel.setBounds(370, 0, 90, 45);
		add(heightLabel);
		
		//weight label
		JLabel weightLabel = new JLabel("Weight");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setBounds(370, 45, 90, 45);
		add(weightLabel);
		
		//close botton
		JButton closeBtn = new JButton("C");
		closeBtn.setBounds(754, 30, 30, 30);
		closeBtn.setOpaque(false);
		closeBtn.setContentAreaFilled(true);
		closeBtn.setBorderPainted(false);
		add(closeBtn);
		closeBtn.setVisible(true);
		
		//help botton
		JButton helpBtn = new JButton("H");
		helpBtn.setBounds(719, 30, 30, 30);
		helpBtn.setOpaque(false);
		helpBtn.setContentAreaFilled(true);
		helpBtn.setBorderPainted(false);
		add(helpBtn);
		closeBtn.setVisible(true);
		
		//refresh botton
		JButton refreshBtn = new JButton("R");
		refreshBtn.setBounds(684, 30, 30, 30);
		refreshBtn.setOpaque(false);
		refreshBtn.setContentAreaFilled(true);
		refreshBtn.setBorderPainted(false);
		add(refreshBtn);
		refreshBtn.setVisible(true);
	
		
	}

}
