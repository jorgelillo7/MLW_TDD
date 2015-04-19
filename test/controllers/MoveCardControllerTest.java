package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import models.Card;
import models.CardFactory;

import org.junit.Before;
import org.junit.Test;

public class MoveCardControllerTest {
	private MoveCardController moveCardController;
	private StartGameController startGameController;

	// Foundation to Tableau
	private final static int FOUNDATION_POSITION_NUMBER = 3;
	private static final int TABLEAU_NUMBER = 1;

	// Tableau to tableau
	private static final int TABLEAU_NUMBER_ORIGIN = 1;
	private static final int TABLEAU_NUMBER_DESTINATION = 2;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveCardController = new MoveCardController(startGameController);
	}

	@Test
	public void moveDeckToWasteWithSizeMoreOrEqualsToThreeTest() {
		int sizeDeck, sizeWaste;

		sizeDeck = startGameController.sizeDeck();
		sizeWaste = startGameController.sizeWaste();

		moveCardController.moveDeckToWaste();
		if (sizeDeck >= 3) {
			assertEquals(startGameController.sizeDeck(), (sizeDeck - 3));
			assertEquals(startGameController.sizeWaste(), (sizeWaste + 3));
		}
	}

	@Test
	public void moveDeckToWasteWithSizeLessThanThreeTest() {
		int sizeDeck, sizeWaste;
		startGameController.setSizeDeck(2);
		sizeDeck = startGameController.sizeDeck();
		sizeWaste = startGameController.sizeWaste();

		moveCardController.moveDeckToWaste();
		assertEquals(startGameController.sizeDeck(), 0);
		assertEquals(startGameController.sizeWaste(), (sizeWaste + sizeDeck));
	}

	@Test
	public void moveDeckToWasteWithSizeZeroTest() {
		int sizeWaste;
		startGameController.setSizeDeck(0);
		sizeWaste = startGameController.sizeWaste();

		moveCardController.moveDeckToWaste();
		assertEquals(startGameController.sizeDeck(), 0);
		assertEquals(startGameController.sizeWaste(), sizeWaste);
	}

	@Test
	public void moveTableauToFoundationTest() {
		Card heartOne = CardFactory.getCard(1,1);
		Card heartTwo = CardFactory.getCard(2, 1);
		Card heartThree = CardFactory.getCard(3, 1);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartOne);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartTwo);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartThree);

		startGameController.addCardToTableau(TABLEAU_NUMBER, CardFactory.getCard(4, 1));

		moveCardController.moveTableauToFoundation(FOUNDATION_POSITION_NUMBER,
				TABLEAU_NUMBER);
		assertEquals(0, startGameController.getTableau(TABLEAU_NUMBER).size());
		assertEquals(4,
				startGameController.getFoundation(FOUNDATION_POSITION_NUMBER)
						.size());
	}

	@Test
	public void moveTableauToFoundationBadMovementTest() {
		Card heartOne = CardFactory.getCard(1, 1);
		Card heartTwo = CardFactory.getCard(2, 1);
		Card heartThree = CardFactory.getCard(3, 1);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartOne);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartTwo);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartThree);

		startGameController.addCardToTableau(TABLEAU_NUMBER, CardFactory.getCard(5, 2));

		moveCardController.moveTableauToFoundation(FOUNDATION_POSITION_NUMBER,
				TABLEAU_NUMBER);
		assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER).size());
		assertEquals(3,
				startGameController.getFoundation(FOUNDATION_POSITION_NUMBER)
						.size());
	}

	@Test
	public void moveTableauToTableauTest() {
		// opposite color and lower
		startGameController.addCardToTableau(TABLEAU_NUMBER_ORIGIN, CardFactory.getCard(4,
				1));
		startGameController.addCardToTableau(TABLEAU_NUMBER_DESTINATION,
				CardFactory.getCard(5, 3));

		moveCardController.moveTableauToTableau(TABLEAU_NUMBER_ORIGIN,
				TABLEAU_NUMBER_DESTINATION);
		assertEquals(0, startGameController.getTableau(TABLEAU_NUMBER_ORIGIN)
				.size());
		assertEquals(2,
				startGameController.getTableau(TABLEAU_NUMBER_DESTINATION)
						.size());
	}

	@Test
	public void moveTableauToTableauWithDestinationEmptyTest() {

		// destination empty and King Card
		startGameController.addCardToTableau(TABLEAU_NUMBER_ORIGIN, CardFactory.getCard(
				12, 1));
		moveCardController.moveTableauToTableau(TABLEAU_NUMBER_ORIGIN,
				TABLEAU_NUMBER_DESTINATION);
		assertEquals(0, startGameController.getTableau(TABLEAU_NUMBER_ORIGIN)
				.size());
		assertEquals(1,
				startGameController.getTableau(TABLEAU_NUMBER_DESTINATION)
						.size());
	}

	@Test
	public void moveTableauToTableauBadMovementTest() {
		startGameController.addCardToTableau(TABLEAU_NUMBER_ORIGIN, CardFactory.getCard(4,
				1));
		startGameController.addCardToTableau(TABLEAU_NUMBER_DESTINATION,
				CardFactory.getCard(5, 1));

		moveCardController.moveTableauToTableau(TABLEAU_NUMBER_ORIGIN,
				TABLEAU_NUMBER_DESTINATION);
		assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER_ORIGIN)
				.size());
		assertEquals(1,
				startGameController.getTableau(TABLEAU_NUMBER_DESTINATION)
						.size());
	}

	@Test
	public void moveWasteToFoundationTest() {
		int foundationSize, wasteSize;
		Card heartTwo = CardFactory.getCard(2, 1);
		Card heartOne = CardFactory.getCard(1, 1);
		startGameController.addCardToWaste(heartTwo);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartOne);

		Stack<Card> foundation = startGameController
				.getFoundation(FOUNDATION_POSITION_NUMBER);
		foundationSize = foundation.size();
		wasteSize = startGameController.sizeWaste();

		moveCardController.moveWasteToFoundation(FOUNDATION_POSITION_NUMBER);
		assertEquals(wasteSize - 1, startGameController.sizeWaste());
		assertEquals(foundationSize + 1,
				startGameController.getFoundation(FOUNDATION_POSITION_NUMBER)
						.size());
	}

	@Test
	public void moveWasteToFoundationBadMovementTest() {
		int foundationSize, wasteSize;
		Card spadesSix = CardFactory.getCard(6, 0);
		Card heartOne = CardFactory.getCard(1, 1);
		startGameController.addCardToWaste(spadesSix);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER,
				heartOne);

		Stack<Card> foundation = startGameController
				.getFoundation(FOUNDATION_POSITION_NUMBER);
		foundationSize = foundation.size();
		wasteSize = startGameController.sizeWaste();

		moveCardController.moveWasteToFoundation(FOUNDATION_POSITION_NUMBER);
		assertEquals(wasteSize, startGameController.sizeWaste());
		assertEquals(foundationSize,
				startGameController.getFoundation(FOUNDATION_POSITION_NUMBER)
						.size());

	}

	@Test
	public void moveWasteToTableauTest() {
		startGameController.addCardToWaste(CardFactory.getCard(11, 2));
		startGameController.addCardToTableau(TABLEAU_NUMBER, CardFactory.getCard(12, 3));
		moveCardController.moveWasteToTableau(TABLEAU_NUMBER);
		assertEquals(2, startGameController.getTableau(TABLEAU_NUMBER).size());
		assertEquals(0, startGameController.sizeWaste());

	}

	@Test
	public void moveWasteToTableauBadMovementTest() {
		boolean checkMovementStatus;
		startGameController.addCardToWaste(CardFactory.getCard(11, 2));
		startGameController.addCardToTableau(TABLEAU_NUMBER, CardFactory.getCard(5, 3));
		checkMovementStatus = moveCardController
				.moveWasteToTableau(TABLEAU_NUMBER);
		assertFalse(checkMovementStatus);
		assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER).size());
		assertEquals(1, startGameController.sizeWaste());
	}
}
