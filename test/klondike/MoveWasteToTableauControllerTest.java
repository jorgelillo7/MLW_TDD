package klondike;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToTableauControllerTest {

	private MoveWasteToTableauController moveWasteToTableauController;
	private StartGameController startGameController;
	private static final int FOUNDATION_NUMBER = 2;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveWasteToTableauController = new MoveWasteToTableauController(startGameController);
	}
	 
	@Test
	public void moveTest(){ 
				startGameController.addCardToWaste(new Card(11, 2));
				startGameController.addCardToFundation(FOUNDATION_NUMBER, new Card(12, 2));
			    moveWasteToTableauController.move(FOUNDATION_NUMBER);
				assertEquals(2, startGameController.getFoundation(FOUNDATION_NUMBER).size());
				assertEquals(0, startGameController.sizeWaste());
		 
	}
	
	@Test
	public void moveBadMovementTest(){
	    boolean checkMovementStatus;
		startGameController.addCardToWaste(new Card(11, 2));
		startGameController.addCardToFundation(FOUNDATION_NUMBER, new Card(5, 3));
	    checkMovementStatus = moveWasteToTableauController.move(FOUNDATION_NUMBER);
	    assertFalse(checkMovementStatus);
		assertEquals(1, startGameController.getFoundation(FOUNDATION_NUMBER).size());
		assertEquals(1, startGameController.sizeWaste());
	}

}
