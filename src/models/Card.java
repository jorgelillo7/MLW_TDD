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
		this.color = getColor(this.suit);
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}
	
	private Color getColor(Suit suit) {
	    
	    switch (suit) {
            case SPADES:
            case CLUBS:
                return Color.BLACK;
            case HEARTS:
            case DIAMONDS:
                return Color.RED;
    }

    return null;
	    
	}

	private Suit getSuit(int suitNum) {
	    
		switch (suitNum) {
    		case 0:
    			return Suit.SPADES;
    		case 1:
    			return Suit.HEARTS;
    		case 2:
    			return Suit.DIAMONDS;
    		case 3:
    			return Suit.CLUBS;
		}

		return null;
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
