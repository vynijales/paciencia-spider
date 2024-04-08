package components;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DraggableComponent extends JComponent {

	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int x = 0;
	private volatile int y = 0;
	private volatile int z;
	private Card card;

	public DraggableComponent(GameManager gameManager) {
		setBounds(0, 0, 60, 92);
		setOpaque(false);

		card = new Card(1, "hearts");
		card.setPosition(0, 0);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				bringToFront();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// card.flip();
				paintComponent(getGraphics());

				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();

				x = getX();
				y = getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				for (DropZone dropZone : gameManager.getDropZones()) {
					if (isContainedIn(dropZone)) {
						Point newLocation = dropZone.getLocation();
						setLocation(newLocation);
						dropZone.addCard(DraggableComponent.this);
						break;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - screenX;
				int deltaY = e.getYOnScreen() - screenY;

				setLocation(x + deltaX, y + deltaY);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

		});
	}

	public DraggableComponent(GameManager gameManager, int value, String suit) {
		setBounds(0, 0, 60, 92);
		setOpaque(false);

		card = new Card(value, suit);
		card.setPosition(0, 0);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// card.flip();
				paintComponent(getGraphics());

				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();

				x = getX();
				y = getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				for (DropZone dropZone : gameManager.getDropZones()) {
					if (isContainedIn(dropZone)) {
						Point newLocation = dropZone.getLocation();
						setLocation(newLocation);
						dropZone.addCard(DraggableComponent.this);
						break;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - screenX;
				int deltaY = e.getYOnScreen() - screenY;

				setLocation(x + deltaX, y + deltaY);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

		});
	}

	public boolean isContainedIn(DropZone c) {
		Point p = DraggableComponent.this.getLocationOnScreen();
		final int WIDTH = 60;
		final int HEIGHT = 92;
		final int MARGIN = 2;
		SwingUtilities.convertPointFromScreen(p, c);
		Rectangle expandedDropZone = new Rectangle(-WIDTH + MARGIN, -HEIGHT + MARGIN, WIDTH * 2 - MARGIN,
				HEIGHT * 2 - MARGIN);
		if (expandedDropZone.contains(p)) {
			return true;
		}
		return false;
	}


	public void bringToFront() {
		Container parent = SwingUtilities.getUnwrappedParent(this);
		parent.setComponentZOrder(this, parent.getComponentCount() - 1);
	}

	public void paintComponent(Graphics g) {
		card.draw((Graphics2D) g);
	}

}
