package ca.uwo.csd.cs2212.team05;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class BannerPanel extends JPanel {
	private String date;
	JDateChooser dateChooser = new JDateChooser();
	private JLabel lastUpdateDisplayLabel = new JLabel();
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
		
		//hello label
		JLabel helloLabel = new JLabel("Welcome");
		helloLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		helloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		helloLabel.setBounds(100, 0, 160, 45);
		add(helloLabel);
		
		//username label
		JLabel userLabel = new JLabel();
		userLabel.setText("username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setBounds(100, 45, 160, 45);
		add(userLabel);
		
		
		//sex label
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexLabel.setBounds(270, 0, 45, 45);
		add(sexLabel);
		
		//sex display label
		JLabel sexDisplayLabel = new JLabel();
		sexDisplayLabel.setText("");
		sexDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexDisplayLabel.setBounds(270+45, 0, 50, 45);
		add(sexDisplayLabel);
		
		//age label
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setBounds(270, 45, 45, 45);
		add(ageLabel);
		
		//age display label
		JLabel ageDisplayLabel = new JLabel();
		ageDisplayLabel.setText("");
		ageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageDisplayLabel.setBounds(270+45, 45, 50, 45);
		add(ageDisplayLabel);
		
		//height label
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightLabel.setBounds(370, 0, 45, 45);
		add(heightLabel);
		
		//height display label
		JLabel heightDisplayLabel = new JLabel();
		heightDisplayLabel.setText("");
		heightDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightDisplayLabel.setBounds(370+45, 0, 50, 45);
		add(heightDisplayLabel);
		
		//weight label
		JLabel weightLabel = new JLabel("Weight:");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setBounds(370, 45, 45, 45);
		add(weightLabel);
		
		//height display label
		JLabel weightDisplayLabel = new JLabel();
		weightDisplayLabel.setText("");
		weightDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightDisplayLabel.setBounds(370+45, 45, 50, 45);
		add(weightDisplayLabel);
		
		//close botton
		JButton closeBtn = new JButton("C");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		
		//last update display label
		lastUpdateDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastUpdateDisplayLabel.setText("");
		lastUpdateDisplayLabel.setBounds (515, 50, 166, 25);
		add(lastUpdateDisplayLabel); 
		
		//refresh date botton
		JButton refreshDateBtn = new JButton("Refresh Date");
		refreshDateBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		refreshDateBtn.setHorizontalAlignment(SwingConstants.LEFT);
		refreshDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				refreshDate(a);
			}
		});
		refreshDateBtn.setBounds(624, 25, 57, 25);
		refreshDateBtn.setOpaque(false);
		refreshDateBtn.setContentAreaFilled(true);
		refreshDateBtn.setBorderPainted(false);
		add(refreshDateBtn);
		refreshDateBtn.setVisible(true);
	
		dateChooser.addPropertyChangeListener("day", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				final Calendar c = (Calendar) e.getNewValue();   
				System.out.println(c.get(Calendar.DAY_OF_MONTH));
			}
		});
		dateChooser.setBounds(515, 25, 106, 25);
		add(dateChooser);
        }
	
	
	public void refreshDate(ActionEvent a){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.date = dateFormat.format(dateChooser.getDate());
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		lastUpdateDisplayLabel.setText(sdf.format(cal.getTime()));
	}
}
