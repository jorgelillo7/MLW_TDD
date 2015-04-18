package controllers;

import java.util.Stack;

import models.Card;

public class MoveTableauToFoundationController {
	private StartGameController startGameController;

	public MoveTableauToFoundationController(
			StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public void move(int foundationPositionNumber, int tableauNumber) {
		Stack<Card> tableau = startGameController.getTableau(tableauNumber);
		Stack<Card> foundation = startGameController
				.getFoundation(foundationPositionNumber);

		Card cardToMoveFromTablaeu = tableau.peek();
		Card lastCardFoundation = foundation.peek();

		if (cardToMoveFromTablaeu.getSuit() == lastCardFoundation.getSuit()
				&& (cardToMoveFromTablaeu.getValue() == 1 && foundation.size() == 0)
				|| cardToMoveFromTablaeu.getValue()
						- lastCardFoundation.getValue() == 1) {
				startGameController.removeTableauCard(tableauNumber);
				startGameController.addCardToFundation(foundationPositionNumber, cardToMoveFromTablaeu);
		}

	}
}
