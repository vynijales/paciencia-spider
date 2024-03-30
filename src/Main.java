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

		// JPanel panel = new JPanel();
		// panel.setSize(600, 300);
		// panel.setLayout(new GridBagLayout());
		// panel.setBackground(bgColor);

		// JLabel label = new JLabel();
		// label.setText("Hi");
		// panel.add(label);

		// JLabel allCards = new JLabel(new ImageIcon("assets/images/cards.png"));
		// panel.add(allCards);

		GamePanel gamePanel = new GamePanel();
		gamePanel.setBackground(bgColor);
		frame.add(gamePanel);

		// DraggableComponent drag = new DraggableComponent();
		// Graphics graphics = drag.getGraphics();
		// BufferedImage image = null;
		
		// try {
		// 	image = ImageIO.read(new File("../assets/images/cards.png"));
		// } catch (Exception e) {
		// 	System.out.println("Erro ao carregar imagem da carta. Error: "+ e.toString());
		// }
		
		// if (image != null) {
		// 	graphics.drawImage(image, 0, 0, drag);
		// }

		// frame.add(drag);


		// frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
