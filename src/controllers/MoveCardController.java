package controllers;

import java.util.Random;
import java.util.Stack;

import utils.CheckCorrectMove;
import models.Card;

public class MoveCardController {
	private StartGameController startGameController;

	public MoveCardController(StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public void moveDeckToWaste() {
		int sizeDeck;
		Card card;
		Random random = new Random();

		sizeDeck = startGameController.sizeDeck();

		if (sizeDeck >= 3) {
			startGameController.setSizeDeck(sizeDeck - 3);
			for (int i = 0; i < 3; i++) {
				card = new Card(random.nextInt(12), random.nextInt(4));
				startGameController.addCardToWaste(card);
			}
		} else if (sizeDeck > 0) { // caso quedan 1 o 2 cartas en baraja
			startGameController.setSizeDeck(0);
			for (int i = 0; i < sizeDeck; i++) {
				card = new Card(random.nextInt(12), random.nextInt(4));
				startGameController.addCardToWaste(card);
			}
		}
	}

	public void moveTableauToFoundation(int foundationPositionNumber,
			int tableauNumber) {
		Stack<Card> tableau = startGameController.getTableau(tableauNumber);
		Stack<Card> foundation = startGameController
				.getFoundation(foundationPositionNumber);

		Card cardToMoveFromTablaeu = tableau.peek();
		Card lastCardFoundation = null;

		if (foundation.size() > 0) {
			lastCardFoundation = foundation.peek();
		}

		if (CheckCorrectMove.checkMoveTableauToFoundation(
				cardToMoveFromTablaeu, lastCardFoundation)) {
			doMovementFromTableauToFoundation(tableauNumber,
					foundationPositionNumber, cardToMoveFromTablaeu);
		}
	}

	private void doMovementFromTableauToFoundation(int tableauNumber,
			int foundationPositionNumber, Card cardToMoveFromTablaeu) {
		startGameController.removeTableauCard(tableauNumber);
		startGameController.addCardToFundation(foundationPositionNumber,
				cardToMoveFromTablaeu);
	}

	public void moveTableauToTableau(int tableauNumberOrigin,
			int tableauNumberDestination) {
		Stack<Card> tableauOrigin = startGameController
				.getTableau(tableauNumberOrigin);
		Stack<Card> tableauDestination = startGameController
				.getTableau(tableauNumberDestination);

		Card cardToMove = tableauOrigin.peek();
		Card lastCardOfTableauDestination = null;

		if (tableauDestination.size() > 0) {
			lastCardOfTableauDestination = tableauDestination.peek();
		}

		if (CheckCorrectMove.checkMoveTableauToTableau(cardToMove,
				lastCardOfTableauDestination)) {
			doMovementFromTableauToTableau(tableauNumberOrigin,
					tableauNumberDestination, cardToMove);
		}
	}

	private void doMovementFromTableauToTableau(int origin, int destination,
			Card cardToMove) {
		startGameController.addCardToTableau(destination, cardToMove);
		startGameController.removeTableauCard(origin);
	}

	public void moveWasteToFoundation(int foundationPositionNumber) {
		Card wasteCard, foundationLastCard = null;
		wasteCard = startGameController.getFirstCardWaste();
		Stack<Card> foundation = startGameController
				.getFoundation(foundationPositionNumber);
		if (foundation.size() > 0) {
			foundationLastCard = foundation.peek();
		}
		
		if (CheckCorrectMove.checkMoveWasteToFoundation(wasteCard,
				foundationLastCard)) {
			doMovementFromWasteToFoundation(foundationPositionNumber, wasteCard);
		}
	}

	private void doMovementFromWasteToFoundation(int foundationPositionNumber,
			Card wasteCard) {
		startGameController.addCardToFundation(foundationPositionNumber,
				wasteCard);
		startGameController.removeWasteCard();
	}

	public boolean moveWasteToTableau(int tableauNumber) {
		Stack<Card> tableau = startGameController.getTableau(tableauNumber);
		Card cardToMove = startGameController.getFirstCardWaste();
		if ((tableau.size() == 0) && (cardToMove.getValue() == 12)) {
			doMovementFromWasteToTableau(tableauNumber, cardToMove);
			return true;
		} else if (tableau.size() > 0) {
			Card lastCard = tableau.peek();
			if ((lastCard.getValue() == (cardToMove.getValue() + 1))
					&& (lastCard.getColor() != cardToMove.getColor())) {
				doMovementFromWasteToTableau(tableauNumber, cardToMove);
				return true;
			}
		}
		return false;
	}

	private void doMovementFromWasteToTableau(int tableauNumber, Card cardToMove) {
		startGameController.addCardToTableau(tableauNumber, cardToMove);
		startGameController.removeWasteCard();
	}

}
