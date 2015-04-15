package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class StartGameController {
	private static final int TABLEAUS_NUMBER = 7;
	public static final int FOUNDATIONS_NUMBER = 4;

	public int sizeWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (int i = 0; i < FOUNDATIONS_NUMBER; i++) {
			sizeFoundations.add(0);
		}

		return sizeFoundations;
	}

	public int sizeDeck() {
		return 24;
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> sizeTableaus = new ArrayList<Integer>();
		for (int i = 0; i < TABLEAUS_NUMBER; i++) {
			sizeTableaus.add(i + 1);
		}
		return sizeTableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {
		ArrayList<Stack<Card>> uncoveredCardsStackTableaus = new ArrayList<Stack<Card>>();
		for (int i = 0; i < TABLEAUS_NUMBER; i++) {
			Stack<Card> uncoveredCardsStack = new Stack<Card>();
			uncoveredCardsStack.add(new Card());
			uncoveredCardsStackTableaus.add(uncoveredCardsStack);
		}
		return uncoveredCardsStackTableaus;
	}

	public void setSizeDeck(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setSizeWaste(int i) {
		// TODO Auto-generated method stub
		
	}

}
