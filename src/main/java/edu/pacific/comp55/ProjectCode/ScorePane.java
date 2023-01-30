package edu.pacific.comp55.ProjectCode;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import acm.graphics.GImage;
import acm.graphics.GObject;
import edu.pacific.comp55.starter.GraphicsPane;

public class ScorePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage scores;
	private List<String> l;
	private List<Integer> l2;
	//private GParagraph para;
	
	File scoresFile;
	Scanner myReader;

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
		
		l = new ArrayList<String>();
		l2 = new ArrayList<Integer>();
		
//		try {
//			  System.out.println("Read");
//		      scoresFile = new File("Scores.txt");
//		      myReader = new Scanner(scoresFile);
//		      while (myReader.hasNextLine()) {
//		        String data = myReader.nextLine();
//		        System.out.println(data);
//		      }
//		      myReader.close();
//		    } catch (FileNotFoundException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		    }
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Scores.txt"));
			String currentLine = reader.readLine();
			while (currentLine != null) {
				l.add(currentLine);
				currentLine = reader.readLine();
			}
			
			for (int i = 0; i < l.size(); i++) {
				int num = Integer.parseInt(l.get(i));
				l2.add(num);
			}
			
			System.out.println(l2);
			
			Collections.sort(l2,Collections.reverseOrder());
			
			System.out.println(l2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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