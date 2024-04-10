package components;

import javax.swing.JPanel;

import controller.GameController;

public class GamePanel extends JPanel {
    GameController gameController;
    
    public GamePanel() {
        gameController = new GameController();
    }
}