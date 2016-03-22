package ca.uwo.csd.cs2212.team05;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RightPanel extends JPanel {

	private FeaturePanel chooser = new FeaturePanel();
	/**
	 * Create the panel.
	 */
	public RightPanel() {
		setLayout(null);
		initialize();
	}
	
	public void initialize(){
		this.setSize(610, 482);
		this.setLayout(null);
		
		chooser.setLocation(0, 0);
		add(chooser);
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		this.setLayout(null);
//		this.setSize(610,482);
//		this.setLocation(184,119);
//		
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("Ds.jpg"));
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		g.drawImage(image, 0, 0, getWidth(), getHeight(), 0, 0, image.getWidth(), image.getHeight(), null);
//	}
}
