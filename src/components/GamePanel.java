package components;

import java.util.List;

import javax.swing.JPanel;

import controller.GameController;
import controller.CardColumn;

public class GamePanel extends JPanel {
    public GameController gameController;
    
    public GamePanel() {
        gameController = new GameController();
        CardColumn[] columns = gameController.getColumns();
        
        for (int i = 0; i < columns.length; i++) {
            CardColumn column = columns[i];
            CardColumnComponent columnComponent = new CardColumnComponent(gameController, column);

			columnComponent.setBounds(20 + i * 100, 20, 0, 0);
			columnComponent.updateBounds();

			for (int j = 13; j > i + 2; j--) {
				columnComponent.append(new Card(j,"hearts"));
			}
            
	        add(columnComponent);
        }
    }
}