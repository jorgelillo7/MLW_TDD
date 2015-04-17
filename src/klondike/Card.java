package klondike;

public class Card {

	private boolean uncovered;
	private int value;
	private int suit;
	
	public Card (int value, int suit){
		this.value = value;
		this.suit = suit;
	}
	
	public boolean isUncovered() {
		return uncovered;
	}

	public void setUncovered(boolean uncovered) {
		this.uncovered = uncovered;
	}
	
	

}
