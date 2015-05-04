package Grid;

import java.awt.Color;
import java.awt.Graphics;

public class Square {

	private int posX;
	private int posY;
	private int width;
	private int height;
	public Color  squareColor = Color.WHITE;
	public Color borderColor = Color.WHITE;
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
	public void setBoarderColor(Color c){
		this.borderColor = c;
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
