package ca.uwo.csd.cs2212.team05;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class NotificationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private LeftPanel scroll;
    private String text;
    private int index;
    private JButton notificationButton = new JButton();
	/**
	 * Create the panel.
	 */
	public NotificationPanel(LeftPanel left, String message, int i) {
		this.index = i;
		this.text = message;
		this.scroll = left;
		initialize();
	}
	
	public void initialize(){
		this.setSize(170, 50);
		this.setLayout(null);
		this.setLocation(0, 50*index);
		
		JButton deleButton = new JButton("");
		deleButton.setBounds(147, 3, 20, 20);
		deleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove();
			}
		});
		add(deleButton);
		
		notificationButton = new JButton();
		notificationButton.setBounds(0, 0, 145, 50);
		notificationButton.setOpaque(false);
		notificationButton.setContentAreaFilled(false);
		notificationButton.setBorderPainted(false);
		notificationButton.setText(text);
		add(notificationButton);
	}
	
	public void remove(){
		scroll.remove(this);
	}
	
	public String getText(){
		return text;
	}

	
}
