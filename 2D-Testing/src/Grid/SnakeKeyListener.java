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
				snake.stop();
				snake.left = true;
//				snake.move();
			}
				break;

			case 38: {
				snake.stop();
				snake.up = true;
//				snake.move();
			}
				break;

			case 39: {
				snake.stop();
				snake.right = true;
//				snake.move();
			}
				break;

			case 40: {
				snake.stop();
				snake.down = true;
//				snake.move();
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
