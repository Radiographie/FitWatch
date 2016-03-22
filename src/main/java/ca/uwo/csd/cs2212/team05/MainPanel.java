package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private Frame mainFrame;
	
	/**
	 * Create the panel.
	 */
	public MainPanel(Frame mainFrame) {
		this.setMainFrame(mainFrame);
		this.setSize(800, 570);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		initialize();
	}
	
	public void initialize(){
		//add left panel
		JPanel leftPanel = new LeftPanel(mainFrame);
		leftPanel.setSize(182, 482);
		leftPanel.setLocation(0, 91);
		add(leftPanel);
		
		//add banner panel
		JPanel bannerPanel = new BannerPanel();
		bannerPanel.setSize(800, 90);
		bannerPanel.setLocation(0, 0);
		add(bannerPanel);
		
		//add content panel
		JPanel rightPanel = new RightPanel();
		rightPanel.setSize(616, 482);
		rightPanel.setLocation(184, 91);
		add(rightPanel);
	}

	public Frame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(Frame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
