package ca.uwo.csd.cs2212.team05;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {

	private String currentPanelName;
	private JFrame mainFrame;
	private LoginPanel loginPanel;
	private MainPanel mainPanel;
	/**
	 * Create the application.
	 */
	public Frame() {
		this.currentPanelName = "";
		this.loginPanel = new LoginPanel(this);
		this.mainPanel = new MainPanel(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setSize(800, 600);
		centreWindow(this.mainFrame);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.currentPanelName = "LoginPanel";
		frameSwitch();
		this.setCurrentPanel(loginPanel.getPanelForward());
		frameSwitch();
	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	

	public void frameSwitch(){
		switch(this.currentPanelName){
			case "LoginPanel":{
				this.loginPanel.setVisible(true);
				mainFrame.setContentPane(this.loginPanel);
				this.mainPanel.setVisible(false);
			}break;
			case "DashBoardPanel":{
				this.mainPanel.setVisible(true);
				mainFrame.setContentPane(this.mainPanel);
				this.loginPanel.setVisible(false);
			}break;
		}
		
	}
	
	
	public String getCurrentPanel() {
		return currentPanelName;
	}

	public void setCurrentPanel(String currentPanel) {
		this.currentPanelName = currentPanel;
	}
	
	
	////////////////////����а��ķָ��ߣ�P������ϱ�///////////////////////////////////////////////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}