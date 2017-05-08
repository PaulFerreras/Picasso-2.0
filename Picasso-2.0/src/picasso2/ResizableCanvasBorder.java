package picasso2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

//PF: This is the resizable border around Canvas

public class ResizableCanvasBorder implements Border {

	//PF: Set this as a standardized distance
	private int distance = 10;
	
	public ResizableCanvasBorder() {
	}

	//PF: This is the thickness of the border
	@Override
	public Insets getBorderInsets(Component arg0) {
		return new Insets(distance, distance, distance, distance);
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return false;
	}

	/*PF: This is the method used 
	 * to draw the border
	 */
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		//PF: Set color to Black
		g.setColor(Color.BLACK);
		
		/*PF: This draws a black rectangle
		 * around the canvas as a border,
		 * but leaves an extra empty border
		 * outside of it
		 * **Note** This is required so
		 * the user may resize the canvas
		 * by clicking on the empty border
		 * instead of on the canvas
		 */
		g.drawRect(x + (distance-1), y + (distance-1), width - ((distance*2)-1), height - ((distance*2)-1));
	}

}
