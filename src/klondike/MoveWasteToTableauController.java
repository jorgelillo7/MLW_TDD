package klondike;

import java.util.Stack;

public class MoveWasteToTableauController {
	private StartGameController startGameController;

	public MoveWasteToTableauController(StartGameController startGameController) {
		this.startGameController = startGameController;
	}

	public boolean move(int tableauNumber) {
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
