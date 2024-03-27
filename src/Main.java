import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		final Color bgColor = new Color(20, 179, 51);

		JFrame frame = new JFrame("Paciencia Spider");
		frame.setSize(800, 600);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setSize(600, 300);
		panel.setLayout(new GridBagLayout());
		panel.setBackground(bgColor);

		JLabel label = new JLabel();
		label.setText("Hi");

		panel.add(label);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}