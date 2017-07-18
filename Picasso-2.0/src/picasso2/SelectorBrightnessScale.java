package picasso2;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class SelectorBrightnessScale extends AbstractSelector {

	private int height = 4, width;
	
	public SelectorBrightnessScale(int x, int y, int brightness_scale_width) {
		super(x, y);
		
		width = brightness_scale_width;
		
		color_fill = Color.RED;
		color_draw = Color.RED;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Float(x, y, width, height);
	}

}
