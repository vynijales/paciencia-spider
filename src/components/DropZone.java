package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JComponent;

import java.util.ArrayList;

public class DropZone extends JComponent {

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;
    private volatile int myZ;
    private SpriteSheet sprite;
    private ArrayList<DraggableComponent> cards;

    public DropZone() {
        this.sprite = new SpriteSheet("assets/images/cards.png", 13, 5);
        this.sprite.setCell(1, 4);
        setBounds(0, 0, 60, 92);
        setOpaque(false);
        this.cards = new ArrayList<DraggableComponent>();
    }

    public ArrayList<DraggableComponent> getCards() {
        return cards;
    }

    public void paintComponent(Graphics g) {
        sprite.draw((Graphics2D) g);
    }
}