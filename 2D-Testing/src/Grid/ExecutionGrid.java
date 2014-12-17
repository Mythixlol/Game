package Grid;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ExecutionGrid {

	public ExecutionGrid() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				create();

			}

		});

	}

	public static void create() {
		JFrame frame = new JFrame("Grid");
		frame.setSize(500, 500);
		SnakeWorld world = new SnakeWorld(frame);
		frame.addKeyListener(new SnakeKeyListener(world));
		frame.addMouseListener(new SnakeMouseListener(world));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(world);

		frame.setVisible(true);
		;
	}
}
