package teste;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import control.GameScreen;
import utils.Stage;

public class TesteGameScreen {

	@Test
	public void testStage() {
		
		for(int i=1;i<=4;i++) {
			GameScreen screen = new GameScreen();
			Stage stage = new Stage(i);
			screen.setStage(stage);
			screen.fillInitialElemArrayFromMatrix(stage.getMatrix());
			
			assertEquals(2,screen.getPacman().getLifes());
			assertEquals(0,screen.getPacman().getScore());
			
			if(i==4)
				assertEquals(5,screen.getPacman().getNumberGhosttoEat());
			else
				assertEquals(4,screen.getPacman().getNumberGhosttoEat());
			
			
			if(i==1)
				assertEquals(242,screen.getPacman().getNumberDotstoEat());
			if(i==2)
				assertEquals(246,screen.getPacman().getNumberDotstoEat());
			if(i==3)
				assertEquals(245,screen.getPacman().getNumberDotstoEat());
			if(i==4)
				assertEquals(234,screen.getPacman().getNumberDotstoEat());
			
		}
			
	}
	
	@Test
	public void testLoad() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		GameScreen screen = new GameScreen();
		screen.openSavedGame("saveTest.ser");
		
		assertEquals(4,screen.getStage().getId());
		assertEquals(1,screen.getPacman().getLifes());
		assertEquals(2020,screen.getPacman().getScore());
		assertEquals(177,screen.getPacman().getNumberDotstoEat());
		assertEquals(2,screen.getPacman().getNumberGhosttoEat());
		
	}
	
	@Test 
	public void testRestartGame() throws FileNotFoundException, ClassNotFoundException, IOException {
		GameScreen screen = new GameScreen();
		screen.openSavedGame("saveTest.ser");
		screen.reStartGame(2, 0, 0);
		
		assertEquals(1,screen.getStage().getId());
		assertEquals(2,screen.getPacman().getLifes());
		assertEquals(0,screen.getPacman().getScore());
		assertEquals(242,screen.getPacman().getNumberDotstoEat());
		assertEquals(4,screen.getPacman().getNumberGhosttoEat());
		
	}

}
