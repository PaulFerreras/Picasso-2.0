package picasso2;

import java.awt.Shape;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

abstract public class AbstractChooserListener extends MouseInputAdapter {
	
	protected boolean in_bounds;
	protected Shape boundary;
	
	public AbstractChooserListener(Shape boundary) {
		this.boundary = boundary;
	}
	
	abstract public void moveSelector(int x, int y);
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(boundary.contains(e.getX(), e.getY())) {
			in_bounds = true;
			moveSelector(e.getX(), e.getY());
		} else {
			in_bounds = false;
		}
	}
	
	@Override
	abstract public void mouseDragged(MouseEvent e);
	
}