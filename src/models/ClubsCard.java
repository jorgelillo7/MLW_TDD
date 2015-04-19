package models;

import utils.Color;
import utils.Suit;

public class ClubsCard {

	private boolean uncovered;
	private int value;


	public ClubsCard(int value) {
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

	public Suit getSuit() {
		return Suit.CLUBS;
	}

	public Color getColor() {
		return Color.BLACK;
	}

}
