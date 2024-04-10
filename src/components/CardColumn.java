package components;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

import components.CardColumn;

public class CardColumn extends JComponent implements MouseMotionListener, MouseListener, FocusListener {
    private List<Card> cards;
    private int hover = -1;
    private int selected = -1;

    public CardColumn() {
        cards = new ArrayList<Card>();
        updateBounds();
        setOpaque(false);

        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // cards.get(hover).flip();
        requestFocus();
        if (selected == hover) {
            selected = -1;
        } else {
            selected = hover;
        }
        paintComponent(getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hover = -1;
        printComponent(getGraphics());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        hover = y / 20;
        
        if (hover >= cards.size()) {
            hover = cards.size() - 1;
        }
        printComponent(getGraphics());
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        selected = -1;
        printComponent(getGraphics());
    }
    
    private List<Card> split() {
        List<Card> a = cards.subList(0, hover);
        List<Card> b = cards.subList(hover, cards.size());
        cards = a;
        return b;
    }

    public void updateBounds() {
        setBounds(this.getX(), this.getY(), 60, 20 * (cards.size() -1) + 92);
    }

    public void append(Card card) {
        this.cards.add(card);
        updateBounds();
    }

    public void extend(List<Card> cards) {
        this.cards.addAll(cards);
        updateBounds();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        Card card;
        
        if (selected != -1) {
            for (int i = 0; i < selected; i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i*20);
            }

            for (int i = selected; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i*20);
                
                g.setColor(new Color(0, 255, 0, 255));
                g.drawRect(0, i*20, 59, 91);

                g.setColor(new Color(50, 255, 50, 70));
                g.fillRect(0, i*20, 59, 91);
            }

        } else if (hover != -1) {
            for (int i = 0; i < hover; i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i*20);
            }


            card = cards.get(hover);
            card.draw((Graphics2D) g, 0, hover*20);

            g.setColor(new Color(100, 100, 255, 50));
            
            g.fillRect(0, hover*20, 59, 91);
    
            for (int i = hover + 1; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i*20);
            }


        } else {
            for (int i = 0; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i*20);
            }
        }
        
	}
}
