package utils;

import models.Card;

public class CheckCorrectMove {

	public static boolean checkMoveTableauToFoundation(
			Card cardToMoveFromTablaeu, Card lastCardFoundation) {
		if (lastCardFoundation != null) {
			if (cardToMoveFromTablaeu.getSuit() == lastCardFoundation.getSuit()
					&& cardToMoveFromTablaeu.getValue()
							- lastCardFoundation.getValue() == 1) {
				return true;
			}
		} else if (lastCardFoundation == null
				&& cardToMoveFromTablaeu.getValue() == 1) {
			return true;
		}

		return false;
	}

	public static boolean checkMoveTableauToTableau(Card cardToMove,
			Card lastCardOfTableauDestination) {
		if (lastCardOfTableauDestination != null) {
			if ((cardToMove.getColor() != lastCardOfTableauDestination
					.getColor() && cardToMove.getValue() < lastCardOfTableauDestination
					.getValue())) {
				return true;
			}
		} else if (lastCardOfTableauDestination == null
				&& cardToMove.getValue() == 12) {
			return true;
		}
		return false;
	}

}
