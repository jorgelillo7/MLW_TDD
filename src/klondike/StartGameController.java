package klondike;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class StartGameController {
	private static final int TABLEAUS_NUMBER = 7;
	public static final int FOUNDATIONS_NUMBER = 4;

	private int sizeDeck;
	
	private ArrayList<Stack<Card>> foundations;
	private Stack<Card> waste;
	private ArrayList<Stack<Card>> tableaus;

	public StartGameController() {
		sizeDeck = 24;
		foundations= new ArrayList<Stack<Card>>(4);
		for (int i = 0; i <FOUNDATIONS_NUMBER; i++){
			foundations.add(new Stack<Card>());
		}
		
		tableaus = new ArrayList<Stack<Card>>(TABLEAUS_NUMBER);
		for(int i = 0; i < TABLEAUS_NUMBER; i++){
			tableaus.add(new Stack<Card>());
		}
		
		waste = new Stack<Card>();
	}

	public int sizeWaste() {
		return waste.size();
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


	public void addCardToWaste(Card card) {
		waste.add(card);
	}

	public void addCardToFundation(int foundationPositionNumber, Card card) {
		getFoundation(foundationPositionNumber).add(card);
		
	}

	public Stack<Card> getFoundation(int foundationPositionNumber) {
		return foundations.get(foundationPositionNumber);
	}

	public Card getFirstCardWaste() {
		return waste.peek();
	}

	public void removeWasteCard() {
		waste.pop();
		
	}

	public Stack<Card> getTableau(int tableauNumber) {
		return tableaus.get(tableauNumber);
	}
	
	
	
	public void addCardToTableau(int tableau, Card card) {
		tableaus.get(tableau).add(card);
	}

	public void removeTableauCard(int tableauNumber) {
		this.getTableau(tableauNumber).pop();
		
	}

}
