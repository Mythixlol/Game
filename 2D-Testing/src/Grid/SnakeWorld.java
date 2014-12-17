package Grid;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnakeWorld extends JPanel {

	private int squareWidth = 20;
	private int squareHeight = 20;
	private int worldWidth;
	private int worldHeight;
	Square[][] squares;
	Snake snake;
	

	public SnakeWorld(JFrame frame) {

		worldWidth = frame.getWidth() / squareWidth;
		worldHeight = frame.getHeight() / squareHeight;
		squares = new Square[worldWidth][worldHeight];
		createWorld();
		Random r = new Random();
		snake = new Snake(r.nextInt(worldWidth), r.nextInt(worldHeight),this);
	}

	public void createWorld() {
		for (int i = 0; i < worldWidth; i++) {
			for (int k = 0; k < worldWidth; k++) {
				squares[i][k] = new Square(i, k, squareWidth, squareHeight);
			}
		}
	}

	public Snake getSnake() {
		return this.snake;
	}


	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		snake.drawSnake();
		paintGrid(g);
	}

	public void paintGrid(Graphics g) {
		for (Square[] s : squares) {
			for (Square square : s) {
				square.draw(g);
			}
		}
	}

	public Square getSquare(int indexX, int indexY) {
		return squares[indexX][indexY];
	}
	
	public int getWorldWidth(){
		return worldWidth;
	}
	public int getWorldHeight(){
		return worldHeight;
	}
}
