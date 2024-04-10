package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import controller.GameController;
import controller.CardColumn;

public class GamePanel extends JPanel {
    public GameController gameController;
    private Random rnd = new Random();

    public GamePanel() {
        gameController = new GameController();
        CardColumn[] columns = gameController.getColumns();
        
        List<Card> deck = new ArrayList<Card>();
        
        for (int i = 0; i < 13 * 4; i++) {
            Card card = new Card(i % 13 + 1, Card.SUIT.values()[i / 13]);
            deck.add(card);
        };
        
        for (int i = 0; i < columns.length; i++) {
            CardColumn column = columns[i];
            CardColumnComponent columnComponent = new CardColumnComponent(gameController, column);

			columnComponent.setBounds(120 + i * 100, 20, 0, 0);
			columnComponent.updateBounds();

			for (int j = 0; j < i + 1; j++) {
                Card card = deck.remove(rnd.nextInt(deck.size() - 1));
                
                if (j < i) {
                    card.flip();
                }
                
				columnComponent.append(card);
			}
            
	        add(columnComponent);
        }

        DeckComponent deckComponent = new DeckComponent(deck);
        deckComponent.setBounds(10, 10, 60, 200);
        add(deckComponent);
    }
}