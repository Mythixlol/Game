import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Execution {

	public Execution() {
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
		JFrame frame = new JFrame("Fucker");
		frame.setSize(1200, 700);
		World world = new World();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(world);

		frame.setVisible(true);
		frame.addKeyListener(new JumperKeyListener(world));
		frame.addMouseListener(new JumperMouseListener(world));
	}

}
