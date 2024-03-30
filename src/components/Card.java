package components;

import java.awt.Graphics2D;

public class Card {
	private int value;
	private String suit;
	private boolean faceUp;
	private SpriteSheet sprite;

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.faceUp = false;

		this.sprite = new SpriteSheet("../assets/images/cards-sheet.png", 13, 5);
		this.sprite.setCell(1, 4);
	}
	
	public void setPosition(int x, int y) {
		this.sprite.setPosition(x, y);
	}

	public void flip() {
		this.faceUp = !this.faceUp;
	}

	public String toString() {
		return this.value + " of " + this.suit;
	}

	public void draw(Graphics2D graphics2d) {
		sprite.draw(graphics2d);
	}
}