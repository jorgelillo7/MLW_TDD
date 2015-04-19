package models;

import utils.Color;
import utils.Suit;

public class DiamondsCard extends Card{

	public DiamondsCard(int value) {
		super(value);
	}

    public Suit getSuit() {
        return Suit.DIAMONDS;
    }

    public Color getColor() {
        return Color.RED;
    }

}
