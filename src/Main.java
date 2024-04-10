
import javax.swing.JFrame;

import components.GamePanel;

public class Main {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setLayout(null);
		
		// Create card columns
		// for (int i = 0; i < 7; i++) {
		// 	CardColumn cardColumn = new CardColumn(gamePanel.gameController, i);
		// 	cardColumn.setBounds(20 + i * 100, 20, 0, 0);
		// 	cardColumn.updateBounds();

		// 	for (int j = 13; j > i + 2; j--) {
		// 		cardColumn.append(new Card(j,"hearts"));
		// 	}
		// 	gamePanel.add(cardColumn);
		// }
	
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
