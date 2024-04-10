package controller;

public class GameController {
    private int selectedColumn = -1;
    private int selectedCard = -1;
    private int targetColumn = -1;
    
    public GameController() {

    }

    public void setTarget(int column) {
        this.targetColumn = column;

    }

    public void selectCard(int card, int column) {
        this.selectedCard = card;
        this.selectedColumn = column;
    }
}
