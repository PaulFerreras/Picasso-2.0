package picasso2;

import java.awt.event.MouseEvent;

public class ListenerColorWheel extends AbstractChooserListener {
	
	private PanelColorWheel color_wheel;
	private int center_x, center_y, radius;

	public ListenerColorWheel(PanelColorWheel pcw) {
		super(pcw.getBoundary());
		
		color_wheel = pcw;
		
		center_x = pcw.getCenterX();
		center_y = pcw.getCenterY();
		radius = pcw.getSmallerRadius();
	}

	@Override 
	public void moveSelector(int x, int y) {
		color_wheel.moveSelector(x, y);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(in_bounds) {
			if(boundary.contains(e.getX(), e.getY())) {
				
				moveSelector(e.getX(), e.getY());
				
			} else {
				
				/*PF: The location of the Color Wheel Selector
				 * is calculated on the circumference 
				 * of the Color Wheel Circle.
				 * This is done by calculating the polar 
				 * coordinates of the location and converting 
				 * them to x, y (cartesian) coordinates.
				 */
				
				//PF: Calculate theta by using Math.atan2 method (y, x)
				double radians = Math.atan2(e.getY() - center_y, e.getX() - center_x);

				/*PF: Convert polar coordinates to x, y coordinates 
				 * using following equations:
				 * x = r * cos(theta)
				 * y = r * sin(theta)
				 * with r being the radius of the circle
				 */
				double x = (radius * Math.cos(radians)) + center_x;
				double y = (radius * Math.sin(radians)) + center_y;

				moveSelector((int) x, (int) y);
				
			}
		}
	}

}
