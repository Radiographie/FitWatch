package ca.uwo.csd.cs2212.team05;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RightPanel extends JPanel {

	private FeaturePanel chooser = new FeaturePanel(this);
	private CaloriesPanel caloriePanel = new CaloriesPanel();
	private DailyDataPanel dailyPanel = new DailyDataPanel();
	private GoalPanel goalPanel = new GoalPanel();
	private AchievementPanel achiPanel = new AchievementPanel();
	
	/**
	 * Create the panel.
	 */
	public RightPanel() {
		this.setLayout(null);
		this.setSize(610, 482);
		this.setLayout(null);
		initialize(0);
	}
	
	public void initialize(int i){
		
		chooser.setLocation(0, 0);
		add(chooser);
		
		switch(i){
			case 0:{
				dailyPanel.setLocation(0, 30);
				dailyPanel.setVisible(true);
				caloriePanel.setVisible(false);
				goalPanel.setVisible(false);
				achiPanel.setVisible(false);
				add(dailyPanel);
			}break;
			case 1:{
				caloriePanel.setLocation(0, 30);
				dailyPanel.setVisible(false);
				caloriePanel.setVisible(true);
				goalPanel.setVisible(false);
				achiPanel.setVisible(false);
				add(caloriePanel);
			}break;
			case 2:{
				goalPanel.setLocation(0, 30);
				dailyPanel.setVisible(false);
				caloriePanel.setVisible(false);
				goalPanel.setVisible(true);
				achiPanel.setVisible(false);
				add(goalPanel);
			}break;
			case 3:{
				achiPanel.setLocation(0, 30);
				dailyPanel.setVisible(false);
				caloriePanel.setVisible(false);
				goalPanel.setVisible(false);
				achiPanel.setVisible(true);
				add(achiPanel);
			}break;
		}
		
		revalidate();
		repaint();
	}

}
