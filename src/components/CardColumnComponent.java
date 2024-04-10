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
import javax.swing.JComponent;

import components.CardColumnComponent;
import controller.GameController;
import controller.CardColumn;

public class CardColumnComponent extends JComponent implements MouseMotionListener, MouseListener, FocusListener {
    private GameController controller;
    private CardColumn column;

    public CardColumnComponent(GameController controller, CardColumn column) {
        this.controller = controller;
        this.column = column;

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
        if (controller.getMode() == GameController.Mode.SELECT) {
            selectCard();
        } else if (controller.getMode() == GameController.Mode.SELECT_TARGET) {
            selectTarget();
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
        // hover = -1;
        column.setHover(-1);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        column.setHover(y / 20);

        if (column.getHover() >= column.getCards().size()) {
            column.setHover(column.getCards().size() - 1);
        }
        repaint();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        column.setSelected(-1);
        repaint();
    }

    private void selectCard() {
        column.selectCard();
    }

    private void selectTarget() {
        column.selectTarget();
        updateBounds();
    }

    public void updateBounds() {
        setBounds(this.getX(), this.getY(), 60, 20 * (column.getCards().size() - 1) + 92);
    }

    public void append(Card card) {
        column.append(card);
        updateBounds();
    }

    public void extend(List<Card> cards) {
        column.extend(cards);
        updateBounds();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        Card card;
        int selected = column.getSelected();
        int hover = column.getHover();
        List<Card> cards = column.getCards();

        if (selected != -1) {
            for (int i = 0; i < selected; i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i * 20);
            }

            for (int i = selected; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i * 20);

                g.setColor(new Color(0, 255, 0, 255));
                g.drawRect(0, i * 20, 59, 91);

                g.setColor(new Color(50, 255, 50, 70));
                g.fillRect(0, i * 20, 59, 91);
            }

        } else if (hover != -1) {
            for (int i = 0; i < hover; i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i * 20);
            }

            card = cards.get(hover);
            card.draw((Graphics2D) g, 0, hover * 20);

            g.setColor(new Color(100, 100, 255, 50));

            g.fillRect(0, hover * 20, 59, 91);

            for (int i = hover + 1; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i * 20);
            }

        } else {
            for (int i = 0; i < cards.size(); i++) {
                card = cards.get(i);
                card.draw((Graphics2D) g, 0, i * 20);
            }
        }

    }
}
