package controller;

import java.util.ArrayList;
import java.util.List;

import components.Card;

public class CardColumn {
    private List<Card> cards;
    private int hover = -1;
    private int selected = -1;
    private int column = -1;
    private GameController controller;

    public CardColumn(int column, GameController controller) {
        this.controller = controller;
        this.column = column;
        cards = new ArrayList<Card>();
    }
    
    public int getColumn() {
        return column;
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public int size() {
        return cards.size();
    }
    
    public Card getCard(int index) {
        return cards.get(index);
    }

    public List<Card> split(int index) {
        List<Card> a = cards.subList(0, index);
        List<Card> b = cards.subList(index, cards.size());
        cards = a;
        return b;
    }

    public void selectCard() {
        if (hover != -1) {
            if (selected == hover) {
                // selected = -1;
                controller.cancelSelection();
            } else {
                selected = hover;
                controller.selectCard(selected, this);
            }
        }
    }

    public void selectTarget() {
        controller.setTarget(this);
    }

    public void append(Card card) {
        this.cards.add(card);
    }

    public void extend(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void setHover(int hover) {
        this.hover = hover;
    }

    public int getHover() {
        return hover;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getSelected() {
        return selected;
    }
}
