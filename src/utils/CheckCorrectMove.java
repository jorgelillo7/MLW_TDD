package utils;

import models.Card;

public class CheckCorrectMove {
	
	public static boolean checkMoveTableauToFoundation(Card cardToMoveFromTablaeu, Card lastCardFoundation){
		if (lastCardFoundation != null) {
			if (cardToMoveFromTablaeu.getSuit() == lastCardFoundation.getSuit()
					&& cardToMoveFromTablaeu.getValue()
							- lastCardFoundation.getValue() == 1) {
				return true;
			}
		} else if (lastCardFoundation == null && cardToMoveFromTablaeu.getValue() == 1) {
				return true;
		}
		
		return false;
	}

}
