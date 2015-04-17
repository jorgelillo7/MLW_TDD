package klondike;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveWasteToFoundationControllerTest {

	private MoveWasteToFoundationController moveWasteToFoundationController;
	private StartGameController startGameController;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveWasteToFoundationController = new MoveWasteToFoundationController();
	}
	 
	@Test
	public void moveTest(){
		int foundationPositionNumber, foundationSize, wasteSize; 
		foundationPositionNumber = 1;
		Random random = new Random();
		Card card = new Card(random.nextInt(12), random.nextInt(4));
		startGameController.addCardToWaste(card);
		startGameController.addCardToFundation(foundationPositionNumber, card);
		
		Stack<Card> foundation = startGameController.getFoundation(foundationPositionNumber);
		foundationSize = foundation.size();
		wasteSize = startGameController.sizeWaste();
		
		moveWasteToFoundationController.move(foundationPositionNumber);
		assertEquals(wasteSize - 1, startGameController.sizeWaste());
		assertEquals(foundationSize + 1, startGameController.getFoundation(foundationPositionNumber));
		
	}

}
