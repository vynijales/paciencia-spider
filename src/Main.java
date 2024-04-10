
import java.awt.Color;

import javax.swing.JFrame;

import components.GamePanel;

public class Main {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setLayout(null);
		gamePanel.setBackground(new Color(56, 168, 50));
	
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
