package klondike;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveTableauToFoundationControllerTest {

	private MoveTableauToFoundationController moveTableauToFoundationController;
	private StartGameController startGameController; 

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveTableauToFoundationController = new MoveTableauToFoundationController(startGameController);
	}
	 
	@Test
	public void moveTest(){
		 
	}
	
	@Test
	public void moveBadMovementTest(){
		 
		
	}

}
