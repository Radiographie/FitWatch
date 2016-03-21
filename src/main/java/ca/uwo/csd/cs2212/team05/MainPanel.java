package ca.uwo.csd.cs2212.team05;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -3254396276834789802L;
	private Frame mainFrame;
	
	/**
	 * Create the panel.
	 */
	public MainPanel(Frame mainFrame) {
		this.setMainFrame(mainFrame);
		this.setSize(800, 600);
		this.setLayout(null);
		
		initialize();
	}
	
	public void initialize(){
		//add left panel
		JPanel leftPanel = new LeftPanel();
		leftPanel.setLocation(0, 120);
		add(leftPanel);
		
		//add banner panel
		JPanel bannerPanel = new BannerPanel();
		bannerPanel.setLocation(0, 0);
		add(bannerPanel);
		
		//add feature panel
		JPanel featurePanel = new FeaturePanel();
		featurePanel.setLocation(0, 90);
		add(featurePanel);
		
		//add content panel
		JPanel contentPanel = new ContentPanel();
		contentPanel.setLocation(184, 120);
		add(contentPanel);
	}

	public Frame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(Frame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
