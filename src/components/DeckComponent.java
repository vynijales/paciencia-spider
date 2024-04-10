package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GameController;
import controller.GameController.Mode;

import Stack.Stack;

public class DeckComponent extends JPanel implements MouseListener {
    private Stack<Card>cards;
    private int selected = -1;
    private SpriteSheet sprite;
    private GameController gameController; 

    public void setupSprite() {
        if (cards.size() > 0) {
            Card card = cards.peek();
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

    public DeckComponent(GameController gameController, Stack cards) {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        this.gameController = gameController;
        this.cards = cards;
        this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
        setupSprite();
        JButton deckButton = new JButton();
        deckButton.setText("Deck");

        deckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card lastcard = (Card) cards.peek();
                try {
                    cards.pop();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                cards.addFirst(lastcard);
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


    public int getSelected() {
        return selected;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Card lastcard = cards.peek();
        selected = cards.size() - 1;
        System.out.println("Mouse Clicked: " + cards.get(selected));
        gameController.setMode(Mode.PULL_DECK);
        gameController.setDeckCard(lastcard);

        
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
