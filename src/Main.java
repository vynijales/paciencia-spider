import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.DraggableComponent;
import components.GamePanel;

public class Main {
	public static void main(String[] args) {
		final Color bgColor = new Color(20, 179, 51);

		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);

		// JPanel gamePanel = new JPanel();
		// gamePanel.setSize(600, 300);
		// gamePanel.add();
		// gamePanel.setLayout(new GridBagLayout());
		// panel.setBackground(bgColor);

		
		// JLabel allCards = new JLabel(new ImageIcon("assets/images/cards.png"));
		// panel.add(allCards);
		
		GamePanel gamePanel = new GamePanel();
		JLabel label = new JLabel();
		label.setText("Hi");
		gamePanel.add(label);
		gamePanel.setLayout(null);
		// gamePanel.setBackground(bgColor);
		
		DraggableComponent drag = new DraggableComponent();
		gamePanel.add(drag);
		
		DraggableComponent drag2 = new DraggableComponent();
		gamePanel.add(drag2);
		
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
