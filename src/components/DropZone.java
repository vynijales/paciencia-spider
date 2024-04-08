package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.util.ArrayList;

public class DropZone extends JComponent {

    private volatile int x = 0;
    private volatile int y = 0;
    private volatile int z;
    private SpriteSheet sprite;
    private ArrayList<DraggableComponent> cards;

    public DropZone() {
        this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
        this.sprite.setCell(1, 4);
        this.cards = new ArrayList<DraggableComponent>();

        setBounds(0, 0, 60, 92);
        setOpaque(false);
    }

    public void addCard(DraggableComponent card) {
        cards.add(card);
    }

    public ArrayList<DraggableComponent> getCards() {
        return cards;
    }

    public void paintComponent(Graphics g) {
        sprite.draw((Graphics2D) g);
    }
}