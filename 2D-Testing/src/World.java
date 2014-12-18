import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel {

	private Jumper jumper;
	Random r = new Random();
	int i = 0;
	public int x;
	public int y;
	@SuppressWarnings("unused")
	private BufferedImage image = null;
	private Enemy enemy;
	 

	public World() {
		
		calcNewCoords();
		reset();
		

	}

	public void paintComponent(Graphics g) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}
		super.paintComponent(g);
		jumper.draw(g);
		enemy.draw(g);
	}

	public Enemy getEnemy(){
		return enemy;
	}
	
	public void setEnemy(int x, int y){
		enemy = new Enemy(x,y);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}

	public Jumper getJumper() {
		return jumper;
	}

	public void spawnEnemy() {
		if(x >= jumper.getX() && x < jumper.getX()+jumper.getWidth() && y>= jumper.getY() && x < jumper.getY()+jumper.getWidth()){
			calcNewCoords();
			spawnEnemy();
		}
		enemy = new Enemy(x, y);
		calcNewCoords();
	}

	public void calcNewCoords() {

		x = r.nextInt(1100);
		y = r.nextInt(600);
	}

	public void reset() {

		try {
			image = ImageIO.read(new File("E:/icon.jpg"));
		} catch (IOException e) {

			e.printStackTrace();
			jumper = new Jumper(this);
		}

		spawnEnemy();
//		jumper.move();

	}

}
