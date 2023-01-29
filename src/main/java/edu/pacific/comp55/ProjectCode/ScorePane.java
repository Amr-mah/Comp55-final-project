package edu.pacific.comp55.ProjectCode;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import edu.pacific.comp55.starter.GraphicsPane;

public class ScorePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage scores;
	//private GParagraph para;

	public ScorePane(MainApplication app) {
		this.program = app;
		scores = new GImage("Scores.png", 0, 0);
		scores.setSize(program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		//para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
		//para.setFont("Arial-24");
		
		
	}

	@Override
	public void showContents() {
		program.add(scores);
		
		//program.add(para);
	}

	@Override
	public void hideContents() {
		program.remove(scores);
		//program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == scores) {
			program.switchToMenu();
		}
	}
}