package Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JumperKeyListener implements KeyListener {
	World w;

	public JumperKeyListener(World w) {
		this.w = w;
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode() + " " + e.getKeyChar());
	}

}
