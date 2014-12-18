package Grid;

import java.awt.Color;
import java.awt.Graphics;

public class Square {

	private int posX;
	private int posY;
	private int width;
	private int height;
	Color squareColor = Color.WHITE;
	Color borderColor = Color.white;
	public boolean isDrawn = false;
	public boolean isSnake = false; 
	public boolean isEnemy = false;
	
	public Square(int x, int y, int width, int height) {
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}
		
	public void setFillColor(Color c) {
		this.squareColor = c;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void draw(Graphics g) {
		g.setColor(squareColor);
		g.fillRect(posX*width, posY*height, width, height);
		g.setColor(borderColor);
		g.drawRect(posX*width, posY*height, width, height);
	}

}
