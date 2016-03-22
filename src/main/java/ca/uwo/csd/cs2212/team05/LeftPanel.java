package ca.uwo.csd.cs2212.team05;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.table.*;
import java.awt.*;

public class LeftPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JScrollPane scrollPane = new JScrollPane();
	private Frame mainFrame;
	private ArrayList<String> messageList = new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public LeftPanel(Frame mainFrame) {
		this.mainFrame = mainFrame;
		this.setSize(182, 482);
		this.setLayout(null);
		this.setLayout(null);
		this.setBackground(new Color(245, 245, 245));
		initialize();
		
	}
		
	
	public void initialize(){

		
		//switch user botton
//		JButton refreshBtn = new JButton("Refresh");	
//		refreshBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				lastUpdateRefresh(evt);
//			}
//		});
//		
//		refreshBtn.setBounds(0, 452, 182, 30);
//		refreshBtn.setOpaque(false);
//		refreshBtn.setContentAreaFilled(true);
//		refreshBtn.setBorderPainted(false);
//		add(refreshBtn);
//		refreshBtn.setVisible(true);
		
		//last update label
//		JLabel lastUpdateLabel = new JLabel("Last Update:");
//		lastUpdateLabel.setBounds(2, 421, 82, 30);
//		add(lastUpdateLabel);
		
		scrollPane.setBounds(0, 32, 182, 450);
		add(scrollPane);		

		add("Yooooooooo");
		add("mofomomfomofmofmfofmofm");
		add("PBPBPBPBPBPB");
		add("PBPBPBPBPBPB");
		add("PBPBPBPBPBPB");
		add("PBPBPBPBPBPB");
		add("PBPBPBPBPBPB");
		add("PBPBPBPBPBPB");
		add("PBPBPB");
		add("Pasdfad PB");
		add("PBPB12312314PB");
		add("123142234525B");
		

		refreshNotifications();
	}
	
	public void add(String message){
		messageList.add(0, message);
		refreshNotifications();
	}
	
	public void remove(NotificationPanel n){
		messageList.remove(n.getText());
		refreshNotifications();
	}
		
	public void refreshNotifications(){
		scrollPane.removeAll();
		for (int i=0; i<messageList.size(); i++){
			NotificationPanel n = new NotificationPanel(this, messageList.get(i), i);
			scrollPane.add(n);
		}	
		scrollPane.revalidate();
		scrollPane.repaint();
		mainFrame.pack();
	}
	
//	private void lastUpdateRefresh(ActionEvent evt)
//	{
//		//display time
//		Calendar cal = Calendar.getInstance();
//		cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		lastUpdateDisplayLabel.setText(sdf.format(cal.getTime()));
//	}
}
