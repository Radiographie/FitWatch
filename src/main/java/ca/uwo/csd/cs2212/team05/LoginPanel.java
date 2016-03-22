package ca.uwo.csd.cs2212.team05;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	
	private Frame mainFrame;

	private static final long serialVersionUID = 1L;
	private String panelForward;
	private JTextField usernameField;
	private JPasswordField passwordField;
	/**
	 * Create the panel.
	 */
	public LoginPanel(Frame mainFrame) {
		this.mainFrame = mainFrame;
		initialize();
	}
	
	private void initialize() {

		this.setSize(800, 600);
		this.setLayout(null);
		this.panelForward = "";
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameField.setBounds(532, 228, 200, 40);
		add(usernameField);
		usernameField.setColumns(10);
		
		//set up the password field
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(532, 305, 200, 40);
		add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginActionPerformed();
			}
		});
		loginButton.setBounds(532, 380, 200, 40);
		add(loginButton);
	}
	
    private void loginActionPerformed(){                                      
        String username = usernameField.getText();
		String password = passwordField.getText();

        if(password.contains("")&&username.contains("")){
        	usernameField.setText("");
        	passwordField.setText("");
			mainFrame.setCurrentPanel("DashBoardPanel");
			mainFrame.frameSwitch();
        }
        else {
            JOptionPane.showMessageDialog(null, "Unauthorized login!\nClick OK to try again","Wrong password", JOptionPane.ERROR_MESSAGE);
            usernameField.setText("");
            passwordField.setText("");
        }
    }

	public String getPanelForward() {
		return panelForward;
	}

	public void setPanelForward(String panelChange) {
		this.panelForward = panelChange;
	}    
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setLayout(null);
		this.setSize(800,600);
		this.setLocation(0,0);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("bg.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), 0, 0, image.getWidth(), image.getHeight(), null);
	}
}
