package klondike;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToFoundationControllerTest {

	private MoveWasteToFoundationController moveWasteToFoundationController;
	private StartGameController startGameController;
	private final static int foundationPositionNumber = 1;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveWasteToFoundationController = new MoveWasteToFoundationController(startGameController);
	}
	 
	@Test
	public void moveTest(){
		int foundationSize, wasteSize; 
		Card heartTwo = new Card(2, 1);
		Card heartOne = new Card(1, 1);
		startGameController.addCardToWaste(heartTwo);
		startGameController.addCardToFundation(foundationPositionNumber, heartOne);
		
		Stack<Card> foundation = startGameController.getFoundation(foundationPositionNumber);
		foundationSize = foundation.size();
		wasteSize = startGameController.sizeWaste();
		
		moveWasteToFoundationController.move(foundationPositionNumber);
		assertEquals(wasteSize - 1, startGameController.sizeWaste());
		assertEquals(foundationSize + 1, startGameController.getFoundation(foundationPositionNumber).size());
		
	}
	
	@Test
	public void moveBadMovementTest(){
		int foundationSize, wasteSize; 
		Card spadesSix = new Card(6, 0);
		Card heartOne = new Card(1, 1);
		startGameController.addCardToWaste(spadesSix);
		startGameController.addCardToFundation(foundationPositionNumber, heartOne);
		
		Stack<Card> foundation = startGameController.getFoundation(foundationPositionNumber);
		foundationSize = foundation.size();
		wasteSize = startGameController.sizeWaste();
		
		moveWasteToFoundationController.move(foundationPositionNumber);
		assertEquals(wasteSize, startGameController.sizeWaste());
		assertEquals(foundationSize, startGameController.getFoundation(foundationPositionNumber).size());
		
	}

}
