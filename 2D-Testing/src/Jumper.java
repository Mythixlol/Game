import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Jumper extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX = 100;
	private int posY = 100;
	private int width = 5;
	private int height = 5;
	private Color color = Color.RED;
	BufferedImage image = null;
	private boolean jumperMoveUp = false;
	private boolean jumperMoveDown = false;
	private boolean jumperMoveLeft = false;
	private boolean jumperMoveRight = false;
	private int speed = 5;
	Thread movement;
	World w;

	public Jumper(World w) {
		this.w = w;
	}

	public Jumper(BufferedImage image, World w) {
		this.image = image;
		this.w = w;
	}

	public void setColor(Color c) {
		this.color = c;

	}

	public void setX(int x) {
		this.posX = x;
	}

	public void setY(int y) {
		this.posY = y;
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(Graphics g) {
		if (image == null) {
			g.setColor(color);
			g.fillRect(posX, posY, width, height);
			g.drawRect(posX, posY, width, height);
		} else {
			g.drawImage(image, posX, posY, null);
		}
	}

	/**
	 * 
	 * Bewege auf Position
	 * 
	 */
	public void moveTo(int x, int y) {
		this.posX = x - (width / 2);
		this.posY = y - (height / 2);

	}

	public boolean isJumperMoveUp() {
		return jumperMoveUp;
	}

	public void setJumperMoveUp(boolean jumperMoveUp) {
		this.jumperMoveUp = jumperMoveUp;
	}

	public boolean isJumperMoveLeft() {
		return jumperMoveLeft;
	}

	public void setJumperMoveLeft(boolean jumperMoveLeft) {
		this.jumperMoveLeft = jumperMoveLeft;
	}

	public boolean isJumperMoveDown() {
		return jumperMoveDown;
	}

	public void setJumperMoveDown(boolean jumperMoveDown) {
		this.jumperMoveDown = jumperMoveDown;
	}

	public boolean isJumperMoveRight() {
		return jumperMoveRight;
	}

	public void setJumperMoveRight(boolean jumperMoveRight) {
		this.jumperMoveRight = jumperMoveRight;
	}

	/**
	 * 
	 * Bewege um X , Y
	 * 
	 */

	public void move() {

		if (movement == null) {
			movement = new Thread(new Runnable() {

				@Override
				public void run() {

					while (true) {

						if (jumperMoveDown) {
							posY += speed;
							if ((posY + height) >= w.getHeight()) {

								posY = w.getHeight() - 1 - height;
							}

						}

						if (jumperMoveLeft) {
							posX -= speed;
							if (posX <= 0)
								posX = 1;
						}

						if (jumperMoveRight) {
							posX += speed;
							if (posX + width >= w.getWidth())
								posX = w.getWidth() - 1 - width;
						}

						if (jumperMoveUp) {
							posY -= speed;
							if (posY <= 0)
								posY = 1;
						}

						Enemy enemy = w.getEnemy();
						if ((posX + width > enemy.getPosX() && posX < enemy.getPosX()
								+ enemy.getWidth())
								&& (posY + height > enemy.getPosY() && posY < enemy
										.getPosY() + enemy.getHeight())) {
							enemy.setColor(Color.black);
							eatEnemy(enemy);
						}

						w.paint(w.getGraphics());
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			});
		}

		movement.start();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void eatEnemy(Enemy e) {
		width += 10;
		height += 10;
		w.spawnEnemy();

	}

}
