package controller;

import java.util.ArrayList;
import java.util.List;
import components.Card;

public class GameController {
    public enum Mode {
        SELECT,
        SELECT_TARGET,
    };

    private int selectedColumn = -1;
    private int selectedCard = -1;
    private int targetColumn = -1;

    private Mode mode = Mode.SELECT;
    private CardColumn[] columns;

    public GameController() {
        columns = new CardColumn[7];
        for (int i = 0; i < 7; i++) {
            columns[i] = new CardColumn(i, this);
        }
    }

    public CardColumn[] getColumns() {
        return columns;
    }

    public Mode getMode() {
        return this.mode;
    }

    public List<Card> getSelectedCards() {
        return null;
    }

    public void setTarget(CardColumn column) {
        List<Card> cards = column.getCards();
        CardColumn selected = columns[selectedColumn];
        
        List<Card> resto = selected.split(selected.getSelected());

        Card first = resto.get(0);
        Card last = cards.get(cards.size() - 1);

        int isRed1 = first.getSuit().ordinal() % 2;
        int isRed2 = last.getSuit().ordinal() % 2;

        if (isRed1 != isRed2 && last.getValue() == first.getValue() + 1) {
            column.extend(resto);
            mode = Mode.SELECT;
        } else {
            selected.extend(resto);
            cancelSelection();
        }
    }

    public void selectCard(int card, CardColumn column) {
        this.selectedCard = card;
        this.selectedColumn = column.getColumn();
        mode = Mode.SELECT_TARGET;
    }

    public void cancelSelection() {
        mode = Mode.SELECT;
        this.selectedCard = -1;
        this.selectedColumn = -1;
    }
}
