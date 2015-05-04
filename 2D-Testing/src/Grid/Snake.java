package Grid;

import java.awt.Color;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

	private int headIndexX;
	private int headIndexY;
	private SnakeWorld world;
	private Thread m;
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	Deque<Square> body = new LinkedList<Square>();
	public int speed = 0 ;			//Snakeworld.snakespeed

	public Snake(int x, int y, SnakeWorld world) {
		this.world = world;

		headIndexX = x;
		headIndexY = y;
		
		move();
	}

	public void addToBody(Square square) {
		body.addLast(square);
		square.isSnake = true;
		square.borderColor = Color.RED;

	}

	public Deque<Square> getBody() {
		return body;
	}

	public void removeFromBody() {
		Square s = body.removeLast();

		s.setFillColor(Color.WHITE);
		s.borderColor = Color.WHITE;
		s.isSnake = false;

	}

	public void eatEnemy() {
		Square es = world.getEnemySquare();
		if (es.getPosX() == headIndexX && es.getPosY() == headIndexY) {
			world.spawnEnemy();
			System.out.println("enemy!");
			addToBody(es);
		}

	}

	public int getHeadIndexX() {
		return headIndexX;
	}

	public int getHeadIndexY() {
		return headIndexY;
	}

	public void drawSnake() {
		// System.out.println(headIndexX + " " + headIndexY + " ");
		world.getSquare(headIndexX, headIndexY).setFillColor(Color.GREEN);
		world.getSquare(headIndexX, headIndexY).isSnake = true;
		for (Square square : body) {
			square.setFillColor(Color.BLUE);
			square.setBoarderColor(Color.BLUE);
			
		}
	}

	public void checkCollision() {
		for (Square s : body) {
			if (s.getPosX() == headIndexX && s.getPosY() == headIndexY) {
				stop();
				System.out.println("schwanz!!!");
				world.restart();

			}
		}
	}

	public void move() {

		if (m == null) {
			m = new Thread(new Runnable() {

				@Override
				public void run() {

					while (true) {

						if (left) {
							world.repaint();
							moveLeft();

						} else if (right) {

							world.repaint();
							moveRight();
						} else if (down) {
							world.repaint();
							moveDown();
						} else if (up) {
							world.repaint();
							moveUp();

						}
						checkCollision();
						if (world.getEnemySquare() != null) {
							eatEnemy();

						}

						try {
							
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}

			});
			m.start();
		}
	}

	public void stop() {
		left = false;
		up = false;
		down = false;
		right = false;
		world.drawNow = false;

	}

	public void moveLeft() {

		if (headIndexX > 0) {
			world.drawNow = true;
			body.addFirst(world.getSquare(headIndexX, headIndexY));
			removeFromBody();
			headIndexX--;
		} else {

			System.out.println(headIndexX);
			stop();
			world.restart();
		}

	}

	public void moveRight() {
		if (headIndexX < world.getWorldWidth() - 1) {
			world.drawNow = true;
			body.addFirst(world.getSquare(headIndexX, headIndexY));
			removeFromBody();
			headIndexX++;
		} else {
			System.out.println(headIndexX);
			stop();
			world.restart();
		}
	}

	public void moveUp() {

		if (headIndexY > 0) {
			world.drawNow = true;
			body.addFirst(world.getSquare(headIndexX, headIndexY));
			removeFromBody();
			headIndexY--;
		} else {
			System.out.println("tot");
			stop();
			world.restart();
		}
	}

	public void moveDown() {
		if (headIndexY < world.getWorldHeight() - 1) {
			world.drawNow = true;
			body.addFirst(world.getSquare(headIndexX, headIndexY));
			removeFromBody();
			headIndexY++;
		} else {
			System.out.println("tot");
			stop();
			world.restart();
		}
	}

}
