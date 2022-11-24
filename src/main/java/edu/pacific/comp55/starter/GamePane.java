package edu.pacific.comp55.starter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class GamePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage game;
	//private GParagraph para;

	public GamePane(MainApplication app) {
		this.program = app;
		game = new GImage("game.png", 0, 0);
		
		
	}

	@Override
	public void showContents() {
		program.add(game);
	}

	@Override
	public void hideContents() {
		program.remove(game);
	}

	/*@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == game) {
			program.switchToMenu();
		}
	}*/
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE) {
			System.out.println("esc pressed");
		}
	}
	
}