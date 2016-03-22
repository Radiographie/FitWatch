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
		this.setSize(794, 120);
		this.setLayout(null);
		
		//avatar label
		JLabel avatarLabel = new JLabel("Avatar");
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarLabel.setBounds(0, 0, 120, 120);
		add(avatarLabel);
		
		//welcome label
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeLabel.setBounds(130, 0, 160, 60);
		add(welcomeLabel);
		
		//username label
		JLabel userLabel = new JLabel();
		userLabel.setText("username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setBounds(130, 60, 160, 60);
		add(userLabel);
		
		
		//sex label
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sexLabel.setBounds(300, 0, 92, 60);
		add(sexLabel);
		
		//age label
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ageLabel.setBounds(300, 60, 92, 60);
		add(ageLabel);
		
		//height label
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setHorizontalAlignment(SwingConstants.LEFT);
		heightLabel.setBounds(402, 0, 82, 60);
		add(heightLabel);
		
		//weight label
		JLabel weightLabel = new JLabel("Weight:");
		weightLabel.setHorizontalAlignment(SwingConstants.LEFT);
		weightLabel.setBounds(402, 60, 82, 60);
		add(weightLabel);
		
		//close botton
		JButton closeBtn = new JButton("C");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeBtn.setBounds(754, 45, 30, 30);
		closeBtn.setOpaque(false);
		closeBtn.setContentAreaFilled(true);
		closeBtn.setBorderPainted(false);
		add(closeBtn);
		closeBtn.setVisible(true);
		
		//help botton
		JButton helpBtn = new JButton("H");
		helpBtn.setBounds(719, 45, 30, 30);
		helpBtn.setOpaque(false);
		helpBtn.setContentAreaFilled(true);
		helpBtn.setBorderPainted(false);
		add(helpBtn);
		closeBtn.setVisible(true);
		
		//last update display label
		lastUpdateDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastUpdateDisplayLabel.setText("");
		lastUpdateDisplayLabel.setBounds (500, 60, 191, 30);
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
		refreshDateBtn.setBounds(609, 30, 82, 30);
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
		dateChooser.setBounds(500, 30, 106, 30);
		add(dateChooser);
        }
	
	
	public void refreshDate(ActionEvent a){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.date = dateFormat.format(dateChooser.getDate());
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		lastUpdateDisplayLabel.setText("Last Update:"+"      "+sdf.format(cal.getTime()));
	}
}
