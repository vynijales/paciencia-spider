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
        column.extend(resto);
        
        mode = Mode.SELECT;
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
