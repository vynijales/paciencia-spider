import javax.swing.JFrame;
import javax.swing.JLabel;

import components.DraggableComponent;
import components.DropZone;
import components.GamePanel;

public class Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);

		GamePanel gamePanel = new GamePanel();
		JLabel label = new JLabel();
		label.setText("Hi");
		gamePanel.add(label);
		gamePanel.setLayout(null);

		DropZone dropZone = new DropZone();

		DraggableComponent drag = new DraggableComponent(dropZone);
		gamePanel.add(drag);

		// DraggableComponent drag2 = new DraggableComponent(dropZone);
		// gamePanel.add(drag2);

		dropZone.setBounds(100, 100, 60, 92);
		gamePanel.add(dropZone);

		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
