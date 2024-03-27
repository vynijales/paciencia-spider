package components;

public class Card {
	private int value;
	private String suit;
	private boolean faceUp;

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.faceUp = false;
	}

	public void flip() {
		this.faceUp = !this.faceUp;
	}

	public String toString() {
		return this.value + " of " + this.suit;
	}

}