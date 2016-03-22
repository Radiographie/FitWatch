package ca.uwo.csd.cs2212.team05;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Frame extends JFrame{

	private String currentPanelName;
	private JFrame mainFrame;
	private LoginPanel loginPanel;
	private MainPanel mainPanel;
	private static Point mouseDownCompCoords;
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
		mainFrame.setUndecorated(true);
		
		mainFrame.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });

		mainFrame.addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                mainFrame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
		
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
	
	
	////////////////////啊啊啊啊我不要进逼淋淋快点保佑我靴靴！我一定会买130张幺蛾子的/////////////////////////////////
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