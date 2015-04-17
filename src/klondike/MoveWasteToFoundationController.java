package klondike;

import java.util.Stack;

public class MoveWasteToFoundationController {
	private StartGameController startGameController;
	
	public MoveWasteToFoundationController(StartGameController starGameController){
		this.startGameController = starGameController;
	}
		 
	public boolean move(int foundationPositionNumber) {
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

}
