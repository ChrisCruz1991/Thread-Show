import java.awt.Color;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Figures class
 * This class will set the image in a thread and circle the image around
 * the screen in a circle
 * @author Christopher Cruz
 *
 */
public class Figures extends Thread {

	//static variables
	private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

	//Variables
	private JFrame frame;
	private ImageIcon img;
	private int x;
	private int y;
	private int time;
	private double multiplier;
	private double timediv;

	/**
	 * Figures Constructor
	 * To set the image in the frame and start the thread
	 * @param imgdir the image in the resources2 file
	 */
	public Figures(String imgdir) {
		time = new Random().nextInt();
		multiplier = 200.0;
		timediv = 1.0;
		img = new ImageIcon(imgdir);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.add(new JLabel(img));
		frame.pack();
		frame.setVisible(true);
		start();
	}

	/**
	 * run method
	 * In this method, the thread is gonna start
	 * and the images are going to circle 
	 * according to the Sine and Cosine functions.
	 * We take the multiplier and the timediv variables 
	 * and apply Cosine for x and Sine for y
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x = (int) ((SCREEN_WIDTH / 2) - (img.getIconWidth() / 2)
					+ (multiplier * Math.cos(Math.toRadians(time / timediv))));
			y = (int) ((SCREEN_HEIGHT / 2) - (img.getIconHeight() / 2)
					+ (multiplier * Math.sin(Math.toRadians(time / timediv))));
			frame.setLocation(x, y);
			time++;
			
			//To check the location for x and y
			System.out.println(x + "\t" + y);
		}
	}

	/**
	 * setMultiplier method
	 * to set the distance between the center area 
	 * and the other images
	 * @param mult
	 */
	public void setMultiplier(double mult) {
		multiplier = mult;
	}

	/**
	 * setTimeDivisor method
	 * to set the time of travel around the screen
	 * @param div
	 */
	public void setTimeDivisor(double div) {
		timediv = div;
	}
}