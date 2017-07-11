package picasso2;

import java.awt.Shape;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

abstract public class AbstractChooserListener extends MouseInputAdapter {
	
	protected boolean in_bounds;
	private Shape boundary;
	protected AbstractSelector selector;
	
	public AbstractChooserListener(AbstractSelector selector, Shape boundary) {
		this.selector = selector;
		this.boundary = boundary;
	}
	
	public void moveSelector(int x, int y) {
		selector.moveSelector(x, y);
		changeColor(x, y);
	}
	
	abstract public void moveSelectorToEdge(int x, int y);
	abstract public void changeColor(int x, int y);
	
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
	public void mouseDragged(MouseEvent e) {
		if(in_bounds) {
			if(boundary.contains(e.getX(), e.getY())) {
				
				moveSelector(e.getX(), e.getY());
				
			} else {
				
				moveSelectorToEdge(e.getX(), e.getY());
				
			}
		}
	}
	
}