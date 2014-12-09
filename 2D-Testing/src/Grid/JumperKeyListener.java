package Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JumperKeyListener implements KeyListener {
	World w;

	public JumperKeyListener(World w, Snake snake) {
		this.w = w;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		case 37: {
			snake.stop();
			snake.moveLeft();
		}
			break;

		case 38: {
			snake.stop();
			snake.moveUp();
		}
			break;

		case 39: {
			snake.stop();
			snake.moveRight();
		}
			break;

		case 30: {
			snake.stop();
			snake.moveDown();
		}
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
