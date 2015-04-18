package controllers;

import java.util.Random;

import models.Card;

public class MoveDeckToWasteController {
	private StartGameController startGameController;

	public MoveDeckToWasteController(StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public void move() {
		int sizeDeck, sizeWaste;
		Card card;
		Random random = new Random();

		sizeDeck = startGameController.sizeDeck();
		sizeWaste = startGameController.sizeWaste();

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

}
