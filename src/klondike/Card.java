package klondike;

public class Card {

	private boolean uncovered;
	private int value;
	private Suit suit;

	public Card(int value, int suit) {
		this.value = value;
		this.suit = getSuit(suit);
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

}
