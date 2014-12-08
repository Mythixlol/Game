import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JumperKeyListener implements KeyListener {
	World w;

	public JumperKeyListener(World w) {
		this.w = w;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getExtendedKeyCode()) {
		case 32: {
			w.getJumper().setJumperMoveLeft(true);
			w.getJumper().setJumperMoveUp(true);
			w.getJumper().setJumperMoveRight(true);
			w.getJumper().setJumperMoveDown(true);
		}
			break;
		case 37: {
			w.getJumper().setJumperMoveLeft(true);
//			w.getJumper().setJumperMoveRight(false);
		}
			break;
		case 38: {
			w.getJumper().setJumperMoveUp(true);
//			w.getJumper().setJumperMoveDown(false);
		}
			break;
		case 39: {
//			w.getJumper().setJumperMoveLeft(false);
			w.getJumper().setJumperMoveRight(true);
		}
			break;
		case 40: {
			w.getJumper().setJumperMoveDown(true);
//			w.getJumper().setJumperMoveUp(false);
		}
			break;

		}

		w.print(w.getGraphics());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (e.getExtendedKeyCode()) {
			
		case 37: {
			w.getJumper().setJumperMoveLeft(false);
			
		}
			break;
		case 38: {
			w.getJumper().setJumperMoveUp(false);
		
		}
			break;
		case 39: {
			w.getJumper().setJumperMoveRight(false);
			
		}
			break;
		case 40: {
			w.getJumper().setJumperMoveDown(false);
			
		}
			break;

		}

		w.print(w.getGraphics());

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode() + " " + e.getKeyChar());
	}

}
