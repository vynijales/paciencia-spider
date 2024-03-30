package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    private Card card;

    public GamePanel() {
        this.card = new Card(1, "copas");
        this.card.setPosition(20, 20);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.WHITE);
        
        card.draw(graphics2D);

        graphics2D.dispose();
    }
}