package models;

import utils.Color;
import utils.Suit;

public class HeartsCard extends Card{

	public HeartsCard(int value) {
		super(value);
	}

    public Suit getSuit() {
        return Suit.HEARTS;
    }

    public Color getColor() {
        return Color.RED;
    }

}
