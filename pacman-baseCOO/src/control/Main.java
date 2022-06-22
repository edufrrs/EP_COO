package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import utils.Stage;

public class Main {

	public static InitialScreen initialScreen; 
	public static int level = 1; 
	public static boolean openSavedGame = false; 
	public static long time;
	
	public static GameScreen gamePacMan;
	
    public static void main(String[] args) {
    	
    	initialScreen = new InitialScreen();
    	
    	initialScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	initialScreen.setVisible(true);
        
    }
	
    public static void startGame(){
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main.gamePacMan = new GameScreen();
                gamePacMan.setVisible(true);
                gamePacMan.createBufferStrategy(2);
                gamePacMan.go();
            }
        });
    }
    
}

