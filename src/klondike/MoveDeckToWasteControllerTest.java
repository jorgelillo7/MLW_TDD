package klondike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveDeckToWasteControllerTest {

	private MoveDeckToWasteController moveDeckToWasteController;
	private StartGameController startGameController;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveDeckToWasteController = new MoveDeckToWasteController(
				startGameController);
	}

	@Test
	public void moveDeckSizeMoreOrEqualsToThreeTest() {
		int sizeDeck, sizeWaste;

		sizeDeck = startGameController.sizeDeck();
		sizeWaste = startGameController.sizeWaste();

		moveDeckToWasteController.move();
		if (sizeDeck >= 3) {
			assertEquals(startGameController.sizeDeck(), (sizeDeck - 3));
			assertEquals(startGameController.sizeWaste(), (sizeWaste + 3));
		}
	}

	@Test
	public void moveDeckSizeLessThanThreeTest() {
		int sizeDeck, sizeWaste;
		startGameController.setSizeDeck(2);
		sizeDeck = startGameController.sizeDeck();
		sizeWaste = startGameController.sizeWaste();

		moveDeckToWasteController.move();
		assertEquals(startGameController.sizeDeck(), 0);
		assertEquals(startGameController.sizeWaste(), (sizeWaste + sizeDeck));
	}

	@Test
	public void moveDeckSizeZeroTest() {
		int sizeWaste;
		startGameController.setSizeDeck(0);
		sizeWaste = startGameController.sizeWaste();
		moveDeckToWasteController.move();
		assertEquals(startGameController.sizeDeck(), 0);
		assertEquals(startGameController.sizeWaste(), sizeWaste);
	}

}
