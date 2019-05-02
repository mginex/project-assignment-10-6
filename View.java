//package birdyRun;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JFrame.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.BorderLayout;



public class View extends JFrame{
	private BufferedImage background;
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private BufferedImage birdImg;
	private Player bird;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ArrayList<BufferedImage> imgs = new ArrayList<>();

	static JFrame frame =  new JFrame("Bird Game");
	DrawPanel drawPanel;
	
    public View() {
		background = createImage("Images/GameBackground.jpg");
		birdImg = createImage("Images/osprey2d_img.png");
		imgs.add(createImage("Images/food_rfishd.png"));
		imgs.add(createImage("Images/branchesd-obs.png"));
		imgs.add(createImage("Images/crd_nestpiece.png"));
		bird = new Player(0, screenSize.height / 2, birdImg);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		drawPanel = new DrawPanel();
		frame.add(drawPanel);
		frame.pack();
		frame.setVisible(true);
    }	
	
    @SuppressWarnings("serial")
	private class DrawPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, 0, screenSize.width, screenSize.height,  this);
			g.drawImage(bird.Image, (int)bird.xloc, (int)bird.yloc, birdImg.getWidth(), birdImg.getHeight(),  this);
			for(Sprite s: sprites) {
				g.drawImage(s.Image, (int)s.xloc, (int)s.yloc, s.getImgWidth(), s.getImgHeight(),  this);
			}
		}
	}
	
	public void update(ArrayList<Sprite> s, Player b) {
		sprites = s;
		bird = b;
		try {
			Thread.sleep(5);//increase/decrease "speed"
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
		drawPanel.repaint();
	}
	
	private BufferedImage createImage(String img) {
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(img));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	public static void main(String[] args) {
		Controller a = new Controller();
		frame.addKeyListener(a);
		a.start();
	}

	public ArrayList<Sprite> getSprites() {
		return sprites;
	}
	
	public Player getPlayer() {
		return bird;
	}
	
	public Dimension getScreenSize() {
		return screenSize;
	}
	
	public ArrayList<BufferedImage> getImgs() {
		return imgs;
	}
}
