package Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeKeyListener implements KeyListener {
	SnakeWorld w;
	Snake snake;
	boolean pressed = true;

	public SnakeKeyListener(SnakeWorld w) {
		this.w = w;
		this.snake = w.getSnake();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (pressed = true) {
			pressed = false;
			switch (e.getKeyCode()) {
			case 32: {
				snake.stop();
			}
				break;
			case 37: {
				if (!snake.right && !snake.left) {
					snake.stop();
					snake.left = true;
					// snake.move();
				}
			}
				break;

			case 38: {
				if (!snake.down && !snake.up) {
					snake.stop();
					snake.up = true;
					// snake.move();
				}
			}
				break;

			case 39: {
				if (!snake.left && !snake.right) {
					snake.stop();
					snake.right = true;
					// snake.move();
				}
			}
				break;

			case 40: {
				if (!snake.up && !snake.down) {
					snake.stop();
					snake.down = true;
					// snake.move();
				}
			}
				break;

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
