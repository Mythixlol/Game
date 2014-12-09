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
		World world = new World(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(world);

		frame.setVisible(true);
		frame.addKeyListener(new JumperKeyListener(world, new Snake(250, 250)) );
		frame.addMouseListener(new JumperMouseListener(world));
	}

}
