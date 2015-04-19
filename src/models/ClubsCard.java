package models;

import utils.Color;
import utils.Suit;

public class ClubsCard extends Card{

	public ClubsCard(int value) {
	    super(value);
	}

	public Suit getSuit() {
		return Suit.CLUBS;
	}

	public Color getColor() {
		return Color.BLACK;
	}

}
