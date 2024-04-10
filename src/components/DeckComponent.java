package components;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DeckComponent extends JPanel {
    private List<Card> cards;
    private int selected = -1;
    private SpriteSheet sprite;

    public DeckComponent(List<Card> cards) {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        this.cards = cards;
        this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
        this.sprite.setCell(0, 0);

        JButton deckButton = new JButton();
        deckButton.setText("Deck");
        add(deckButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite.draw((Graphics2D)g, 0, 100);
    }
}
