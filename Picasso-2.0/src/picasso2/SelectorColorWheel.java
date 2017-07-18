package picasso2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class SelectorColorWheel extends AbstractSelector {

	private int radius = 18;
	
	public SelectorColorWheel() {
		color_fill = Color.RED;
		color_draw = Color.BLACK;
	}
	
	public SelectorColorWheel(int x, int y) {
		super(x, y);
		
		color_fill = Color.RED;
		color_draw = Color.BLACK;
	}

	@Override
	public Shape getShape() {
		return new Ellipse2D.Float(x - (radius/2), y - (radius/2), radius, radius);
	}

}
