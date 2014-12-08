import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	private int posX;
	private int posY;
	private int height = 15;
	private int width = 15;
	private Color color = Color.BLUE;

	public Enemy(int x, int y) {

		this.posX = x;
		this.posY = y;

	}

	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(posX, posY, width, height);
		g.drawRect(posX, posY, width, height);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setColor(Color c) {
		this.color = c;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

}
