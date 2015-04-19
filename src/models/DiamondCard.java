package models;

import utils.Color;
import utils.Suit;

public class DiamondCard {

	private boolean uncovered;
	private int value;


	public DiamondCard(int value, int suit) {
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
        return Suit.DIAMONDS;
    }

    public Color getColor() {
        return Color.RED;
    }

}
