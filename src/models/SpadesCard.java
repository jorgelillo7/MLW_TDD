package models;

import utils.Color;
import utils.Suit;

public class SpadesCard extends Card{

	public SpadesCard(int value) {
	    super(value);
	}

    public Suit getSuit() {
        return Suit.SPADES;
    }

    public Color getColor() {
        return Color.BLACK;
    }

}
