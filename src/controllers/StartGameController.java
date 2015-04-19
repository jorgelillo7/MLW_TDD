package controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import utils.Suit;
import models.Card;

public class StartGameController {
	private static final int TABLEAUS_NUMBER = 7;
	private static final int DECK_CARDS = 24;
	public static final int FOUNDATIONS_NUMBER = 4;

	private int sizeDeck;

	private ArrayList<Stack<Card>> foundations;
	private Stack<Card> waste;
	private ArrayList<Stack<Card>> tableaus;

	public StartGameController() {
		this.createTableaus();
		this.createFoundations();
		this.createDeck();
		this.createWaste();
	}

	private void createWaste() {
		waste = new Stack<Card>();
	}

	private void createDeck() {
		sizeDeck = DECK_CARDS;
	}

	private void createFoundations() {
		foundations = new ArrayList<Stack<Card>>(4);
		for (int i = 0; i < FOUNDATIONS_NUMBER; i++) {
			foundations.add(new Stack<Card>());
		}
	}

	private void createTableaus() {
		tableaus = new ArrayList<Stack<Card>>(TABLEAUS_NUMBER);
		for (int i = 0; i < TABLEAUS_NUMBER; i++) {
			Stack<Card> tableau = new Stack<Card>();
			 for (int j = 0; j < i + 1; j++) {
	                tableau.add(this.createRandomCard());
	         }
			tableaus.add(new Stack<Card>());
		}
	}

	private Card createRandomCard() {
		Random rn = new Random();
        return new Card(rn.nextInt(12), rn.nextInt(4));
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
			uncoveredCardsStack.add(this.createRandomCard());
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

	public Card getFirstCardWaste() {
		return waste.peek();
	}

	public void removeWasteCard() {
		waste.pop();
	}

	public void addCardToFundation(int foundationPositionNumber, Card card) {
		getFoundation(foundationPositionNumber).add(card);
	}

	public Stack<Card> getFoundation(int foundationPositionNumber) {
		return foundations.get(foundationPositionNumber);
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

	public boolean checkWin() {
		boolean win = false;
		boolean error = false;
		for (int i = 0; i < FOUNDATIONS_NUMBER; i++) {

			Stack<Card> foundation = this.getFoundation(i);
			for (int j = 0; j < 12; j++) {
				Suit foundationSuit = null;
				Card card = foundation.get(j);
				if (card.getValue() == (j + 1)) {
					foundationSuit = card.getSuit();
					if (i > 1) {
						if (card.getSuit() == foundationSuit) {
							win = true;
						}
					}
				} else {
					error = true;
				}
			}
		}

		if (win && !error) {
			return true;
		} else {
			return false;
		}

	}

}
