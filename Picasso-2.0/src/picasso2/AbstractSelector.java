package picasso2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

abstract public class AbstractSelector {
	
	protected int x, y;
	protected Color color_fill, color_draw;

	public AbstractSelector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveSelector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract public Shape getShape();
	
	public void draw(Graphics2D g2) {
		g2.setColor(color_fill);
		g2.fill(getShape());
		
		g2.setColor(color_draw);
		g2.draw(getShape());
	}

}
