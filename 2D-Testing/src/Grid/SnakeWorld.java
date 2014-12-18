package Grid;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnakeWorld extends JPanel {

	private int squareWidth = 30;
	private int squareHeight = 30;
	private int worldWidth;
	private int worldHeight;
	Square[][] squares;
	Snake snake;
	public boolean drawNow = true;
	private Square enemySquare = null; 
	
	
	public SnakeWorld(JFrame frame) {

		worldWidth = frame.getWidth() / squareWidth;
		worldHeight = frame.getHeight() / squareHeight;
		squares = new Square[worldWidth][worldHeight];
		createWorld();
		Random r = new Random();
		snake = new Snake(r.nextInt(worldWidth), r.nextInt(worldHeight), this);
		
	}

	public void createWorld() {
		for (int i = 0; i < worldWidth; i++) {
			for (int k = 0; k < worldWidth; k++) {
				squares[i][k] = new Square(i, k, squareWidth, squareHeight);
			}
		}
		spawnEnemy();
	}

	public Snake getSnake() {
		return this.snake;
	}

	public void paintComponent(Graphics g) {
		if (drawNow) {

			super.paintComponent(g);
			snake.drawSnake();
			paintGrid(g);
		}
	}

	public void paintGrid(Graphics g) {
		for (Square[] s : squares) {
			for (Square square : s) {

				square.draw(g);

			}
		}
	}
	
	public void spawnEnemy(){
		Random r = new Random(); 
		int x = r.nextInt(squares.length);
		Square s = squares[x][r.nextInt(squares[x].length)];
		s.setFillColor(Color.YELLOW);
		s.isEnemy = true; 
		enemySquare = s; 
	}

	public Square getSquare(int indexX, int indexY) {
		return squares[indexX][indexY];
	}

	public int getWorldWidth() {
		return worldWidth;
	}

	public int getWorldHeight() {
		return worldHeight;
	}
	
	
	public Square getEnemySquare() {
		return enemySquare;
	}

	public void setEnemySquare(Square enemySquare) {
		this.enemySquare = enemySquare;
	}
	
	public void restart(){
		createWorld();
		snake.body.clear();
		
	}
}
