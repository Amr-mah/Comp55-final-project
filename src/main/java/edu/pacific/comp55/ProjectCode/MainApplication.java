package edu.pacific.comp55.ProjectCode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.Timer;

import acm.graphics.GLabel;
import edu.pacific.comp55.starter.AudioPlayer;
import edu.pacific.comp55.starter.GraphicsApplication;
import javafx.scene.paint.Color;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1050;
	public static final int WINDOW_HEIGHT = 650;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String SOUND_FILE = "Tetris.mp3";

	private SomePane somePane;
	private MenuPane menu;
	private GamePane game;
	private PausePane pause;
	private ScorePane scores;
	private QuitPane quit;
	private GameOverPane over; 
	
	private List<String> l;
	private List<Integer> l2;
	
	Scanner myReader;
	
	private File scoresFile;
	
	private Game consoleGame;
	
	private Block block;	
	private Board board;

	private GLabel timer;
	private GLabel scoreLabel;
	private GLabel score;
	private GLabel high1;
	private GLabel high2;
	private GLabel high3;
	private GLabel high4;
	private GLabel high5;
	
	public int score1 = 0;
	public int score2 = 0;
	public int score3 = 0;
	public int score4 = 0;
	public int score5 = 0;
	
	
	public int min = 0;
	public int sec = 0;
	public int scoreNum = 0;
	public boolean newGame = false;
	
	private Timer time = new Timer(1000, this);
	
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}

	public void run() {
		timer = new GLabel("timer", 0, 100);
		scoreLabel = new GLabel("SCORE: ", 20, 100);
		score = new GLabel(Integer.toString(scoreNum), 10, 100);
		high1 = new GLabel(Integer.toString(score1),50,50);
		high2 = new GLabel(Integer.toString(score2),50,100);
		high3 = new GLabel(Integer.toString(score3),50,150);
		high4 = new GLabel(Integer.toString(score4),50,200);
		high5 = new GLabel(Integer.toString(score5),50,250);
		
		add(high1);
		add(high2);
		add(high3);
		add(high4);
		add(high5);
		add(timer);
		add(scoreLabel);
		add(score);
	
		System.out.println("Hello, world!");
		over = new GameOverPane(this);
		quit = new QuitPane(this);
		pause = new PausePane(this);
		scores = new ScorePane(this);
		game = new GamePane(this);
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		scoresFile = new File("Scores.txt");
		try {
		      scoresFile = new File("Scores.txt");
		      if (scoresFile.createNewFile()) {
		        System.out.println("File created: " + scoresFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		setupInteractions();
		switchToMenu();
	}
	
	public void actionPerformed(ActionEvent e) {
		// timer
		min++;
		sec++;
		
		timer.setFont(Font.MONOSPACED);
		timer.setLocation(85, 75);
		timer.sendToFront();
		timer.setLabel(min/60 + ":" + sec);
		
		if(sec <= 9) {
			timer.setLabel(min/60 + ":0" + sec); // makes the timer have a zero before single integers like 0:05
		}
		if(sec == 59) {
			sec = 0;
		}
		
		// scoreLabel
		
		scoreLabel.setFont(Font.MONOSPACED);
		// score.setColor(Color.WHITE);
		scoreLabel.setLocation(40, 110);
		scoreLabel.sendToFront();
		
		// score
		
		score.setFont(Font.MONOSPACED);
		// score.setColor(Color.WHITE);
		score.setLocation(85, 110);
		score.sendToFront();
		
		scoreNum = game.getScore();
		score.setLabel(Integer.toString(scoreNum));
		
	}
	
	public int getScore() {
		return scoreNum;
	}
	
	public void startTime() {
		time.start();
	}
	
	public void restartTime() {
		time.restart();
	}
	
	public void stopTime() {
		time.stop();
	}

	public void switchToMenu() {
		count++;
		switchToScreen(menu);
	}

	public void switchToSome() {
		switchToScreen(somePane);
	}
	
	public void switchToGame() {
		game.gamePaused = false;
		if(newGame) {
			game.newGame = true;
		}
		switchToScreen(game);
	}
	
	public void switchToPause() {
		switchToScreen(pause);
	}
	
	public void switchToScores() {
		l = new ArrayList<String>();
		l2 = new ArrayList<Integer>();
		
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
		
//		score1 = new GLabel(Integer.toString(l2.get(0)),100,100);
		switchToScreen(scores);
		if (l2.size() >= 1)
			high1.setLabel(Integer.toString(l2.get(0)));
		high1.setFont("Arial-Bold-38");
		high1.setLocation(450, 180);
		high1.sendToFront();
		if (l2.size() >= 2)
			high2.setLabel(Integer.toString(l2.get(1)));
		high2.setFont("Arial-Bold-38");
		high2.setLocation(450, 242);
		high2.sendToFront();
		if (l2.size() >= 3)
			high3.setLabel(Integer.toString(l2.get(2)));
		high3.setFont("Arial-Bold-38");
		high3.setLocation(450, 304);
		high3.sendToFront();
		if (l2.size() >= 4)
			high4.setLabel(Integer.toString(l2.get(3)));
		high4.setFont("Arial-Bold-38");
		high4.setLocation(450, 366);
		high4.sendToFront();
		if (l2.size() >= 5) 
			high5.setLabel(Integer.toString(l2.get(4)));
		high5.setFont("Arial-Bold-38");
		high5.setLocation(450, 428);
		high5.sendToFront();
	}
	
	public void switchToQuit() {
		switchToScreen(quit);
	}
	
	public void switchToGameOver() {
		switchToScreen(over);
	}
	
	/*public void displayBlock(Block b) {
		
		Space[] space = new Space[4];
		if (b.getBlockType() == BlockType.BAR) {
 			space.
 		}
 		else if (b.getBlockType() == BlockType.RIGHTL) {
 			space
 		}
 		else if (b.getBlockType() == BlockType.LEFTL) {
 			space
 		}
 		else if (b.getBlockType() == BlockType.RIGHTS) {
 			space 
 		}
 		else if (b.getBlockType() == BlockType.SQUARE) {
 			space 
 		}
 		else {
 			space 
 		}
	}*/

	

	public void playSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILE, true);
	}
	
	public void pauseSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.pauseSound(MUSIC_FOLDER, SOUND_FILE);
	}
	
	public void stopSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.stopSound(MUSIC_FOLDER, SOUND_FILE);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
}
