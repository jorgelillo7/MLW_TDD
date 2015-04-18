package controllers;

import java.util.Stack;

import models.Card;

public class MoveTableauToTableauController {
	private StartGameController startGameController;

	public MoveTableauToTableauController(
			StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public void move(int tableauNumberOrigin, int tableauNumberDestination) {
		Stack<Card> tableauOrigin = startGameController
				.getTableau(tableauNumberOrigin);
		Stack<Card> tableauDestination = startGameController
				.getTableau(tableauNumberDestination);

		Card cardToMove = tableauOrigin.peek();
		Card lastCardOfTableauDestination = tableauDestination.peek();

		if ((cardToMove.getColor() != lastCardOfTableauDestination.getColor() && cardToMove
				.getValue() < lastCardOfTableauDestination.getValue())
				|| (tableauDestination.size() == 0 && cardToMove.getValue() == 12)) {
			startGameController.addCardToTableau(tableauNumberDestination,
					cardToMove);
			startGameController.removeTableauCard(tableauNumberOrigin);
		}

	}

}
