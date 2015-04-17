package klondike;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class StartGameController {
	private static final int TABLEAUS_NUMBER = 7;
	public static final int FOUNDATIONS_NUMBER = 4;

	private int sizeDeck;
	private int sizeWaste;

	public StartGameController() {
		sizeDeck = 24;
		sizeWaste = 0;
	}

	public int sizeWaste() {
		return sizeWaste;
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (int i = 0; i < FOUNDATIONS_NUMBER; i++) {
			sizeFoundations.add(0);
		}

		return sizeFoundations;
	}

	public int sizeDeck() {
		return sizeDeck;
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
			Random random = new Random();
			uncoveredCardsStack.add(new Card(random.nextInt(12), random.nextInt(4)));
			uncoveredCardsStack.peek().setUncovered(true);
			uncoveredCardsStackTableaus.add(uncoveredCardsStack);
		} 
		return uncoveredCardsStackTableaus;
	}

	public void setSizeDeck(int sizeDeck) {
		this.sizeDeck = sizeDeck;

	}

	public void setSizeWaste(int sizeWaste) {
		this.sizeWaste = sizeWaste;

	}

	public void addCardToWaste(Card card) {
		// TODO Auto-generated method stub
		
	}

	public void addCardToFundation(int foundationPositionNumber, Card card) {
		// TODO Auto-generated method stub
		
	}

	public Stack<Card> getFoundation(int foundationPositionNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
