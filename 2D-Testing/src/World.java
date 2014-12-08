import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel {

	private Jumper jumper;
int i = 0;
	public int x;
	public int y;
	public String key = "1";
	private BufferedImage image;
	
	
	public World() {		
		
		this.addKeyListener(new JumperKeyListener(this));
		
		try {
			image = ImageIO.read(new File("E:/icon.jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		jumper = new Jumper(image, this);
		jumper.move(); 

	}

	public void paintComponent(Graphics g) {
		
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
		g.drawString("fucker", 10, 20);
		jumper.draw(g);
		g.drawString(x + " " + y + "   " + key, 800, 800);
	}

	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}

	public Jumper getJumper() {
		return jumper;
	}

}
