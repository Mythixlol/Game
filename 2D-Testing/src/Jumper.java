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
	private int width = 200;
	private int height = 200;
	private Color color = Color.WHITE;
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

						if (jumperMoveDown)
							posY += speed;
						if (jumperMoveLeft)
							posX -= speed;
						if (jumperMoveRight)
							posX += speed;
						if (jumperMoveUp)
							posY -= speed;

						w.paint(w.getGraphics());
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (!jumperMoveDown && !jumperMoveLeft && !jumperMoveRight && !jumperMoveRight) {

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
}
