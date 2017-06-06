package picasso2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

//PF: This is the selector used to choose the color in the color wheel

public class ColorWheelSelector {
	
	public int radius = 18;
	public Shape outer_shape; // inner_shape;
	
	public ColorWheelSelector(int x, int y) {
		//PF: Gets outer shape
		outer_shape = getOuterShape(x, y);
	}
	
	/*PF: Creates and returns an Ellipse2D.Float 
	 * using the x, y, and radius values
	 * **NOTE** Ellipse2D.Float only takes in float values
	 * as parameters
	 */
	public Shape getOuterShape(int x, int y) {
		return new Ellipse2D.Float((float) x - (radius / 2), 
				(float) y - (radius / 2), (float) radius, (float) radius);
	}
	
//	public Shape getInnerShape(int x, int y) {
//		
//	}
	
	//PF: Moves selector by getting a new outer shape at x, y
	public void moveSelector(int x, int y) {
		outer_shape = getOuterShape(x, y);
	}

	/*PF: Gets Graphics 2D object from the Color Wheel
	 * Draws Color Wheel Selector
	 */
	public void drawSelector(Graphics2D g2) {
		//PF: Set color to Red
		g2.setColor(Color.RED);
		
		//PF: Fill Outer Shape
		g2.fill(outer_shape);
		
		//PF: Outline the Outer Shape black
		g2.setColor(Color.BLACK);
		g2.draw(outer_shape);
	}
}
