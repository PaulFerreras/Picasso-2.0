package picasso2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

//PF: This is where color (chroma) can be selected

public class ColorWheel extends JPanel {
	
	private BufferedImage color_wheel_bi;
	
	/*PF: Width and height variables determine
	 * size of buffered image. Inset determines
	 * distance of color wheel from edges of
	 * buffered image.
	 */
	private int width = 200, height = 200,
				center_x, center_y,
				inset = 10;

	public ColorWheel() {
		//PF: Set preferred size
		setPreferredSize(new Dimension(width, height));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*PF: Create a buffered image with alpha values
		 * Set to the size of the JPanel
		 * **NOTE** alpha values code for transparency
		 * (0 is transparent, 255 is opaque)
		 * BufferedImages of type INT_ARGB 
		 * start with alpha values of 0
		 * **NOTE** BufferedImage is where the color wheel
		 * will be drawn. This is because when we need to
		 * retrieve the color from the color wheel,
		 * it will be easier to call BufferedImage.getRGB()
		 * rather than doing the calculations again
		 */
		color_wheel_bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		//PF: Get and store radius
		int radius = width / 2;
		
		/*PF: Create circle shape to use 
		 * Shape.contains() method in double for loop.
		 * Use inset to make circle smaller
		 */
		Shape circle = new Ellipse2D.Float(inset, inset, (radius - inset) * 2, (radius - inset) * 2);
		
		//PF: Save x and y coordinates of center
		center_x = radius;
		center_y = radius;
		
		//PF: Two for loops to draw the color wheel
		for (int row = 0; row < color_wheel_bi.getHeight(); row++) {
			for (int col = 0; col < color_wheel_bi.getWidth(); col++) {
				
				/*PF: Use Shape.contains() method to draw 
				 * only when inside of the circle
				 */
				if(circle.contains(col, row)) {
					
					/*PF: We must first adjust the
					 * x and y values so that they are in 
					 * reference the center of the circle
					 */
					
					int x = col - center_x;
					int y = row - center_y;
					
					/* **NOTE** Subtraction is used here
					 * because we are actually moving the
					 * x and y values towards the origin
					 * of the component (0, 0),
					 * not the origin of the component
					 * to the center of the circle.
					 */
					
					/*PF: To draw the color wheel, 
					 * we will be using the HSB Color Model
					 * AKA HSV Color Model
					 
					 * **NOTE** HSB Color Model and HSV Color Model
					 * for all intents and purposes is the same.
					 * Java does not support HSL Color model methods
					 
					 * This is because the HSB Color 
					 * Model is a cylindrical 3D shape which
					 * will be easier to draw on a circle
					 * rather than the RGB Color model
					 * which is a 3D cube.
					 * HSL stands for,
					 * Hue,
					 * Saturation,
					 * Brightness (or value),
					 
					 * Reference: https://en.wikipedia.org/wiki/HSL_and_HSV
					 */
					
					/*PF: HUE
					 * Hue is calculated by the
					 * degrees/radians relative to the
					 * center of the circle (x = 0);
					
					 * We may then use the Math.atan2()
					 * method to find Hue in radians
					 * which we then have to divide
					 * the by the total radians (2 PI)
					 * because the HSB color model only 
					 * takes in a decimal hue value
					 */
					double hue = Math.atan2(y, x) / (2 * Math.PI);
					
					
					/*PF: SATURATION
					 * AKA more accurately as CHROMA
					 * Saturation is calculated by the
					 * distance from the point on the
					 * circle to the center of the circle
					 
					 * Point2D.distance() method is used
					 * to determine the distance between
					 * the two points
					 
					 * **NOTE** The center of the circle
					 * is now at (0, 0) 
					 */
					double saturation = Point2D.distance(x, y, 0, 0) / center_x;
					
					/*PF: BRIGHTNESS
					 * Since the HSB color model is a 
					 * cylindrical 3D model, to draw
					 * a 2D circle from this color
					 * model would require a slice of the 
					 * color model to be taken. This is 
					 * done by keeping one of the variables constant
					 
					 * Therefore, brightness is set at 1.0
					 */
					double brightness = 1;
					
					/*PF: Get HSB color from hue, saturation, and brightness values
					 * **NOTE** Color.getHSBColor() only takes in float values
					 */
					Color hsb_color = Color.getHSBColor((float) hue, (float) saturation, (float) brightness);
					
					/*PF: Set pixel in that BufferedImage to HSB color
					 * **NOTE** BufferedImages only takes in RGB value
					 * so have to convert HSB color back to RGB color using
					 * Color.getRGB();
					 */
					color_wheel_bi.setRGB(col, row, hsb_color.getRGB());
					
					/*PF: Just to clarify, we only need
					 * to use the HSB color model
					 * to map out the RGB color model
					 * onto a circle shape
					 */
				}
			}
		}
		
		//PF: Create graphics from buffered image
		Graphics2D g2 = color_wheel_bi.createGraphics();
		
		//PF: Set color to black
		g2.setColor(Color.BLACK);
		
		//PF: Draw black circle around color wheel as outline
		g2.draw(circle);
		
		//PF: Dispose Graphics2D
		g2.dispose();
		
		//PF: Create ColorWheelListener
		ColorWheelListener cwl = new ColorWheelListener();
		
		//PF: Add ColorWheelListener as Mouse and MouseMotion Listener
		addMouseListener(cwl);
		addMouseMotionListener(cwl);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	/*PF: This is the function called 
	 * when ColorWheel gets repainted.
	 * Overrides paintComponent of JPanel.
	 * This allows Buffered Images to be drawn
	 */
	@Override
	public void paintComponent(Graphics g) {
		/* PF: Send graphics to JPanel above.
		 * Allows the background of the component
		 * to be opaque
		 */
		super.paintComponent(g);
		
		//PF: Draw Buffered Image at (0,0)
		g.drawImage(color_wheel_bi, 0, 0, null);
	}
	
//Mouse and MotionListener for ColorWheel	
public class ColorWheelListener extends MouseInputAdapter {
	
	public ColorWheelListener() {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Graphics2D g2 = color_wheel_bi.createGraphics();
		
		int radius = 5;
		
		g2.setColor(Color.BLACK);
		g2.drawOval(e.getX() - radius, e.getY() - radius, radius * 2, radius * 2);
		
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics2D g2 = color_wheel_bi.createGraphics();
		
		int radius = 5;
		
		g2.setColor(Color.BLACK);
		g2.drawOval(e.getX() - radius, e.getY() - radius, radius * 2, radius * 2);
		
		repaint();
	}
	
//	int x = e.getX() - center_x;
//	int y = e.getY() - center_y;
//	
//	double degrees= Math.toDegrees(Math.atan2(y, x));
//	double distance = Point2D.distance(x, y, 0, 0) / center_x;
//	
//	System.out.println("X: " + x);
//	System.out.println("Y: " + y);
//	System.out.println("Degrees: " + degrees);
//	System.out.println("Distance: " + distance);
 }
	
}
