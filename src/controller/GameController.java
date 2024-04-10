package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import components.Card;

public class GameController {
    public enum Mode {
        SELECT,
        SELECT_TARGET,
        PULL_DECK,
    };

    private static final String file_path = "highscore.txt";
    private int highscore;
    private int selectedColumn = -1;
    private int selectedCard = -1;
    private int targetColumn = -1;
    private Card deckCard = null;
    
    private Mode mode = Mode.SELECT;
    private CardColumn[] columns;

    public GameController() {
        highscore = readHighScore();
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

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setTarget(CardColumn target) {
        CardColumn selected = columns[selectedColumn];

        if (selected.getSelected() != -1) {
            List<Card> resto = selected.split(selected.getSelected());

            if (target.size() > 0) {
                Card first = resto.get(0);
                Card last = target.getCard(target.size() - 1);

                int isRed1 = first.getSuit().ordinal() % 2;
                int isRed2 = last.getSuit().ordinal() % 2;

                if (isRed1 != isRed2 && last.getValue() == first.getValue() + 1) {
                    if (selected.size() > 0) {
                        Card lastSelected = selected.getCard(selected.size() - 1);
                        if (!lastSelected.isFaceUp()) {
                            lastSelected.flip();
                        }
                    }

                    target.extend(resto);
                    mode = Mode.SELECT;
                } else {
                    selected.extend(resto);
                    cancelSelection();
                }
            } else {
                if (selected.size() > 0) {
                    Card lastSelected = selected.getCard(selected.size() - 1);
                    if (!lastSelected.isFaceUp()) {
                        lastSelected.flip();
                    }
                }
                target.extend(resto);
            }

            System.out.println("Selected: " + selectedColumn + " Target: " + targetColumn);
            System.out.println();
        } else {
            cancelSelection();
        }
    }

    public void selectCard(int card, CardColumn column) {
        this.selectedCard = card;
        this.selectedColumn = column.getColumn();
        mode = Mode.SELECT_TARGET;
    }

    public void setDeckCard(Card card) {
        System.out.println("Deck selected2: " + card);
        this.deckCard = card;
    }

    public void pullDeck(CardColumn column) {
        if (deckCard == null) {
            System.out.println("CardColumn: " + column);
            return;
        }
        Card card = column.getCard(column.size() - 1);

        int isRed1 = card.getSuit().ordinal() % 2;
        int isRed2 = deckCard.getSuit().ordinal() % 2;

        if (isRed1 != isRed2 && card.getValue() == deckCard.getValue() + 1 ){
            column.append(deckCard);
            mode = Mode.SELECT;
        }
    }

    public void cancelSelection() {
        mode = Mode.SELECT;
        this.selectedCard = -1;
        this.selectedColumn = -1;
    }

    public int readHighScore() {
        int valor = 0;
        if (Files.exists(Paths.get(file_path))) {
            try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
                valor = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            writeHighScore(valor);
        }
        return valor;
    }

    public void writeHighScore(int valor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_path))) {
            bw.write(String.valueOf(valor));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
