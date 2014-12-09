package Grid;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class World extends JPanel {

	private int squareWidth = 10;
	private int squareHeight = 10;

	ArrayList<Square> squareList = new ArrayList<Square>();

	public World(JFrame frame) {
		int index = 0; 
		for (int i = 0; i < frame.getHeight(); i += squareWidth) {
			for (int k = 0; k < frame.getWidth(); k += squareHeight) {
				squareList.add(new Square(index, i, k, squareWidth, squareHeight)); 
				index++;
				System.out.println(i + "  " + k );
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGrid(g);
	}

	public void paintGrid(Graphics g) {
		for(Square square : squareList){
			square.draw(g);
		}

	}
}
