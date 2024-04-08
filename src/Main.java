import javax.swing.JFrame;
import javax.swing.JLabel;

import components.DraggableComponent;
import components.DropZone;
import components.GameManager;
import components.GamePanel;

public class Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);

		GameManager gameManager = new GameManager();

		GamePanel gamePanel = new GamePanel();
		gamePanel.setLayout(null);

		DropZone dropZone = new DropZone();
		DropZone dropZone2 = new DropZone();

		DraggableComponent drag = new DraggableComponent(gameManager);
		gamePanel.add(drag);

		DraggableComponent drag2 = new DraggableComponent(gameManager, 1, "spades");
		gamePanel.add(drag2);

		// DraggableComponent drag2 = new DraggableComponent(dropZone);
		// gamePanel.add(drag2);

		dropZone.setBounds(100, 100, 60, 92);
		dropZone2.setBounds(200, 100, 60, 92);

		gamePanel.add(dropZone);
		gameManager.addDropZone(dropZone);

		gamePanel.add(dropZone2);
		gameManager.addDropZone(dropZone2);

		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
