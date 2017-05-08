package picasso2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

//PF: This is where the buffered image is located

public class PicassoModel {

	private BufferedImage buffered_image;
	private Graphics2D g2;
	int previous_x, previous_y;
	
	public PicassoModel() {
		
		/*PF: Instantiate Plain 
		 * White Buffered Image
		 * Used as starting image 
		 * when application opens
		 * Note: Graphics2D and 
		 * Graphics are similar,
		 * however; Graphics2D support 
		 * more complex drawing
		 */
		buffered_image = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
		
		/*PF: To set the buffered image white,
		 * used the graphics to draw a white
		 * rectangle the size of the 
		 * buffered image
		 */
		g2 = buffered_image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, buffered_image.getWidth(), buffered_image.getHeight());
		g2.dispose();
		
	}
	
	//PF: Sets buffered image
	public void setBufferedImage(BufferedImage new_buffered_image) {
		buffered_image = new_buffered_image;
		return;
	}
	
	
	//PF: Returns buffered image
	public BufferedImage getBufferedImage() {
		return buffered_image;
	}

	//PF: Method used to draw on buffered image
	public void draw(int x, int y, int mouse_event) {
		
		/*PF: To prevent the end of one stroke 
		 * connecting to the beginning of a
		 * new stroke, MousePressed and MouseDragged
		 * must be differentiated.
		 */
		
		/*PF: MousePressed resets the previous x
		 * and y values to the current x and y
		 * values to prevent any previous x and y
		 * values from previous strokes to connect
		 * to this new stroke.
		 * Since it draws a Line2D from the current
		 * x and y values to the same x and y values, 
		 * the method effectively draws a "circle" 
		 * at that coordinate (as a side effect)
		 */
		if(mouse_event == MouseEvent.MOUSE_PRESSED) {
			previous_x = x;
			previous_y = y;
		}
		
		/*PF: ^^^ is possible because these variables
		 * are reset BEFORE Line2D is drawn
		 */
		
		//PF: Graphics is gotten from the buffered image
		g2 = buffered_image.createGraphics();
		
		//PF: Color is set to Black
		g2.setColor(Color.BLACK);
		
		//PF: Stroke size is set to 10 (float value), cap is set to round, join is set to round
		g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		/*PF: Line2D is used to draw smooth lines
		 * between each point, rather than
		 * individual dots on each point (leaving gaps).
		 * This is possible by saving the previous x
		 * and y values as variables to be used as the
		 * starting point of the line and the current
		 * x and y values to be used as the ending point.
		 * (Float is used, since x and y values 
		 * coming in are only ints)
		 */
		g2.draw(new Line2D.Float(previous_x, previous_y, x, y));
		
		//PF: Graphics is disposed
		g2.dispose();
		
		
		/*PF: MouseDragged stores the current x 
		 * and y values AFTER the Line2D is drawn
		 * to the previous x and y variables
		 * to be used as the starting point
		 * of the next line.
		 */
		if(mouse_event == MouseEvent.MOUSE_DRAGGED) {
			previous_x = x;
			previous_y = y;
		}
		
	}
	
	

}