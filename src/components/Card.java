package components;

import java.awt.Graphics2D;

import components.SpriteSheet;

public class Card {
	public enum SUIT {
		CLUBS,
		HEARTS,
		SPADES,
		DIAMONDS
	};

	private int value;
	private SUIT suit;
	private boolean faceUp;
	public SpriteSheet sprite;

	public Card(int value, SUIT suit) {
		this.value = value;
		this.suit = suit;
		this.faceUp = false;

		this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
		this.setupSprite();
	}

	private void setupSprite() {
		int row;
		int col = (this.value - 1) % 13;

		if (suit == SUIT.CLUBS) {
			row = 0;
		} else if (suit == SUIT.HEARTS) {
			row = 1;
		} else if (suit == SUIT.SPADES) {
			row = 2;
		} else if (suit == SUIT.DIAMONDS) {
			row = 3;
		} else {
			row = 4;
		}
		this.sprite.setCell(col, row);
	}

	public int getValue() {
		return value;
	}

	public SUIT getSuit() {
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