//package birdyRun;

import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

public class Controller implements KeyListener, ActionListener { 
	private Model model;
	private View view;
	int lastkey;
	Action drawAction;
	
	
	public Controller(){
		view = new View();
		model = new Model(view.getScreenSize(), view.getPlayer(), view.getImgs());
		view.start.addActionListener(this);
		view.drawPanel.addKeyListener(this);
	}
	
    //run the simulation
	public void start(){
		
		drawAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				model.updateLocation();
				view.update(model.getSprites(), model.getPlayer());
			}
		};
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Timer t = new Timer(0, drawAction);
				t.start();
			}
		});

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			model.move("up");
		}
		else if (key == KeyEvent.VK_DOWN) {
			model.move("down");
		}
	}
	
	public void keyReleased(KeyEvent e) {}
	
	public void keyTyped(KeyEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		view.removeMenu();
		start();
	}
}
