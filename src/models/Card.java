package models;

import utils.Color;
import utils.Suit;

public abstract class Card {

	protected boolean uncovered;
	protected int value;


	public Card(int value) {
		this.value = value;
	}

	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}
	
	public int getValue() {
		return value;
	}

	public abstract Color getColor();
	public abstract Suit getSuit();

}
