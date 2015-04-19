package controllers;

import java.util.Random;
import java.util.Stack;

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
	
	public void moveTableauToFoundation(int foundationPositionNumber, int tableauNumber) {
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
	
	public void moveTableauToTableau(int tableauNumberOrigin, int tableauNumberDestination) {
		Stack<Card> tableauOrigin = startGameController
				.getTableau(tableauNumberOrigin);
		Stack<Card> tableauDestination = startGameController
				.getTableau(tableauNumberDestination);

		Card cardToMove = tableauOrigin.peek();
		Card lastCardOfTableauDestination = null;

		if (tableauDestination.size() > 0) {
			lastCardOfTableauDestination = tableauDestination.peek();
			if ((cardToMove.getColor() != lastCardOfTableauDestination
					.getColor() && cardToMove.getValue() < lastCardOfTableauDestination
					.getValue())) {
				doMovementFromTableauToTableau(tableauNumberOrigin,tableauNumberDestination,cardToMove);
			}
		} else {
			if (tableauDestination.size() == 0 && cardToMove.getValue() == 12) {
				doMovementFromTableauToTableau(tableauNumberOrigin,tableauNumberDestination,cardToMove);
			}
		}

	}
	
	private void doMovementFromTableauToTableau(int origin, int destination, Card cardToMove){
		startGameController.addCardToTableau(destination,
				cardToMove);
		startGameController.removeTableauCard(origin);
	}
	
	
	public boolean moveWasteToFoundation(int foundationPositionNumber) {
		Card wasteCard, foundationLastCard;
	    wasteCard = startGameController.getFirstCardWaste();
		Stack<Card> foundation = startGameController.getFoundation(foundationPositionNumber);
		if(foundation.size() > 0){
			foundationLastCard = foundation.peek();
			if((wasteCard.getValue() == foundationLastCard.getValue()+1) && (wasteCard.getSuit() == foundationLastCard.getSuit())){
				startGameController.addCardToFundation(foundationPositionNumber, wasteCard);
				startGameController.removeWasteCard();
				return true;
			}
			
		} else if (wasteCard.getValue() == 1){  //empty foundation
			startGameController.addCardToFundation(foundationPositionNumber, wasteCard);
			startGameController.removeWasteCard();
			return true;
		}
		return false;
		
	}
	
	public boolean moveWasteToTableau(int tableauNumber) {
		Stack<Card> tableau = startGameController.getTableau(tableauNumber);
		Card cardToMove = startGameController.getFirstCardWaste();
		if( (tableau.size() == 0) && (cardToMove.getValue() == 12)){
			startGameController.addCardToTableau(tableauNumber, cardToMove);
			startGameController.removeWasteCard();
			return true;
		}
		else if(tableau.size() > 0){
			Card lastCard = tableau.peek();
			if((lastCard.getValue()==(cardToMove.getValue()+1))&&(lastCard.getColor()!=cardToMove.getColor())){
				startGameController.addCardToTableau(tableauNumber, cardToMove);
				startGameController.removeWasteCard();
				return true;
			}
		}
		return false;
	}
	  
	
	
	
}
