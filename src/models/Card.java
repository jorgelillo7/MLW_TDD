package models;

import utils.Color;
import utils.Suit;

public class Card {

	private boolean uncovered;
	private int value;
	private Suit suit;
	private Color color;


	public Card(int value, int suit) {
		this.value = value;
		this.suit = getSuit(suit);
		if((this.suit == Suit.SPADES) || (this.suit == Suit.CLUBS)){
			this.color = Color.BLACK;
		} else if((this.suit == Suit.HEARTS) || (this.suit == Suit.DIAMONDS)){
			this.color = Color.RED;
		} 
						
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}

	private Suit getSuit(int suitNum) {
		Suit newSuit = null;
		switch (suitNum) {
		case 0:
			newSuit = Suit.SPADES;
			break;
		case 1:
			newSuit = Suit.HEARTS;
			break;
		case 2:
			newSuit = Suit.DIAMONDS;
			break;
		case 3:
			newSuit = Suit.CLUBS;
			break;
		}

		return newSuit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
