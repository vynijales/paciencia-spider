package components;

import java.awt.Graphics2D;

import components.SpriteSheet;

public class Card {
	private int value;
	private String suit;
	private boolean faceUp;
	public SpriteSheet sprite;

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.faceUp = false;

		this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
		this.setupSprite();
	}

	private void setupSprite() {
		int row;
		int col = (this.value - 1) % 13;

		if (suit.equals("clubs")) {
			row = 0;
		} else if (suit.equals("hearts")) {
			row = 1;
		} else if (suit.equals("spades")) {
			row = 2;
		} else if (suit.equals("diamonds")) {
			row = 3;
		} else {
			row = 4;
		}
		this.sprite.setCell(col, row);
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}
	
	public void setPosition(int x, int y) {
		this.sprite.setPosition(x, y);
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void flip() {
		if (!faceUp) {
			this.sprite.setCell(1, 4);
		} else {
			this.setupSprite();
		}
		this.faceUp = !this.faceUp;
	}

	public String toString() {
		return this.value + " of " + this.suit;
	}

	public void draw(Graphics2D graphics2d) {
		sprite.draw(graphics2d);
	}

	public void draw(Graphics2D graphics2d, int x, int y) {
		sprite.draw(graphics2d, x, y);
	}
}