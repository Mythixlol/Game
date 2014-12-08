import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JumperMouseListener implements MouseListener {

	World w;
	Jumper j;

	public JumperMouseListener(World w) {
		this.w = w;
	}

	public JumperMouseListener(Jumper j) {
		this.j = j;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		w.getJumper().moveTo(e.getX(), e.getY());
		w.x = e.getX();
		w.y = e.getY();
		w.paint(w.getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}

}
