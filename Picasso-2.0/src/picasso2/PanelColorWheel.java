package picasso2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

//PF: This is where color (chroma) can be selected

public class PanelColorWheel extends JPanel {
	
	private PanelBrightnessScale brightness_scale;
	private BufferedImage color_wheel_bi;
	private int width = 200, height = 200,
				radius, inset = 10,
				smaller_radius, larger_inset = 13,
				center_x, center_y;
	private Shape circle, selection_circle;
	private SelectorColor color_selector;

	public PanelColorWheel(PanelBrightnessScale bs) {
		brightness_scale = bs;
		
		//PF: Set preferred size
		setPreferredSize(new Dimension(width, height));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*PF: Create a buffered image with alpha values
		 * Set to the size of the JPanel
		 * **NOTE** alpha values code for transparency
		 * (0 is transparent, 255 is opaque)
		 * BufferedImages of type INT_ARGB 
		 * start with alpha values of 0
		 * Therefore, will be completely transparent
		 * **NOTE** BufferedImage is where the color wheel
		 * will be drawn. This is because when we need to
		 * retrieve the color from the color wheel,
		 * it will be easier to call BufferedImage.getRGB()
		 * than calculating for the actual color
		 */
		color_wheel_bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		/*PF: Get and store radius
		 * Using inset to make the circle smaller
		 */
		radius = (width / 2) - inset;
		
		/*PF: Create circle shape to use 
		 * Shape.contains() method in double for loop.
		 * This will make sure that it will only
		 * color inside of the circle
		 * Ellipse2D.Float only takes in float values
		 */
		circle = new Ellipse2D.Float((float) inset, (float) inset, (float) radius * 2, (float) radius * 2);
		
		//PF: Place circle at the center of the buffered_image
		center_x = width / 2;
		center_y = height / 2;
		
		//PF: Two for loops are used to draw the color wheel
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				
				/*PF: Use Shape.contains() method to draw 
				 * only when inside of the circle
				 */
				if(circle.contains(col, row)) {
					
					/*PF: We must first adjust the
					 * x and y values so that they are in 
					 * reference the center of the circle
					 * **NOTE** Subtraction is used here
					 * because we are actually moving the
					 * x and y values towards the origin
					 * of the component (0, 0),
					 * not the origin of the component
					 * to the center of the circle.
					 */
					
					int x = col - center_x;
					int y = row - center_y;
					
					/*PF: To draw the color wheel, 
					 * we will be using the HSB Color Model
					 * AKA HSV Color Model
					 
					 * **NOTE** HSB Color Model and HSV Color Model
					 * for all intents and purposes are the same.
					 * Java does not support HSL Color Model methods
					 
					 * This is because the HSB Color 
					 * Model is a cylindrical 3D shape which
					 * will be easier to draw on a circle
					 * rather than the RGB Color model
					 * which is a 3D cube.
					 * HSB (HSV) stands for,
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
					 * model would require a cross-section of the 
					 * color model to be taken. This is 
					 * done by keeping one of the variables constant
					 
					 * Therefore, brightness is set at 1.0, always
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
		
		Graphics2D g2 = color_wheel_bi.createGraphics();
		g2.setColor(Color.BLACK);
		g2.draw(circle);
		g2.dispose();
		
		color_selector = new SelectorColor(width/2, height/2);
		
		//PF: Smaller circle created so user doesn't 
		//choose colors on border/outside of the color wheel
		smaller_radius = (width / 2) - larger_inset;
		selection_circle = new Ellipse2D.Float(larger_inset, larger_inset, smaller_radius*2, smaller_radius*2);

		ColorWheelListener cwl = new ColorWheelListener(color_selector, selection_circle);
		
		addMouseListener(cwl);
		addMouseMotionListener(cwl);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(color_wheel_bi, 0, 0, null);
		
		color_selector.draw((Graphics2D) g); 
	}

	
	public class ColorWheelListener extends AbstractChooserListener {
		
		public ColorWheelListener(AbstractSelector selector, Shape boundary) {
			super(selector, boundary);
		}

		@Override
		public void changeColor(int x, int y) {
			brightness_scale.setColor(new Color(color_wheel_bi.getRGB(x, y)));
			getParent().repaint();
		}

		@Override
		public void moveSelectorToEdge(int x, int y) {
			/*PF: The location of the Color Wheel Selector
			 * is calculated on the circumference 
			 * of the Color Wheel Circle.
			 * This is done by calculating the polar 
			 * coordinates of the location and converting 
			 * them to x, y (cartesian) coordinates.
			 */
			
			//PF: Calculate theta by using Math.atan2 method (y, x)
			double radians = Math.atan2(y - center_y, x - center_x);

			/*PF: Convert polar coordinates to x, y coordinates 
			 * using following equations:
			 * x = r * cos(theta)
			 * y = r * sin(theta)
			 * with r being the radius of the circle
			 */
			double new_x = (smaller_radius * Math.cos(radians)) + center_x;
			double new_y = (smaller_radius * Math.sin(radians)) + center_y;

			moveSelector((int) new_x, (int) new_y);
			
		}
		
	}
	
}
