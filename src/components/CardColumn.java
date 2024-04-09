package components;

import java.util.List;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

import components.CardColumn;

public class CardColumn extends JComponent{
    private List<Card> cards;
    private int hover = -1;

    public CardColumn() {
        cards = new ArrayList<Card>();
        updateBounds();
        setOpaque(false);
    }

    private List<Card> split() {
        List<Card> a = cards.subList(0, hover);
        List<Card> b = cards.subList(hover, cards.size());
        cards = a;
        return b;
    }

    public void updateBounds() {
        setBounds(this.getX(), this.getY(), 60, 20 * (cards.size() -1) + 92);
    }

    public void append(Card card) {
        this.cards.add(card);
        updateBounds();
    }

    public void extend(List<Card> cards) {
        this.cards.addAll(cards);
        updateBounds();
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            card.draw((Graphics2D) g, 0, i*20);
        }
	}
}
