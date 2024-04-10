package components;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeckComponent extends JPanel implements MouseListener {
    private List<Card> cards;
    private int selected = -1;
    private SpriteSheet sprite;

    public void setupSprite() {
        if (cards.size() > 0) {
            Card card = cards.get(cards.size() - 1);
            int row;
            int col = (card.getValue() - 1) % 13;

            if (card.getSuit() == Card.SUIT.CLUBS) {row = 0;} 
            else if (card.getSuit() == Card.SUIT.HEARTS) {row = 1;}
            else if (card.getSuit() == Card.SUIT.SPADES) {row = 2;}
            else if (card.getSuit() == Card.SUIT.DIAMONDS) {row = 3;}
            else {row = 4;}
            this.sprite.setCell(col, row);
        } else {
            this.sprite.setCell(1, 4);
        }
        repaint();
    }

    public DeckComponent(List<Card> cards) {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        this.cards = cards;
        this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
        this.sprite.setCell(0, 0);

        JButton deckButton = new JButton();
        deckButton.setText("Deck");

        deckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card lastcard = cards.get(cards.size() - 1);
                cards.remove(cards.size() - 1);
                cards.add(0, lastcard);
                setupSprite();
                repaint();
            }
        
        });

        add(deckButton);

        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        sprite.draw((Graphics2D)g, 0, 100);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selected = cards.size() - 1;
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
