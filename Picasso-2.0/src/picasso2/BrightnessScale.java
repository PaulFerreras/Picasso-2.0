package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the brightness (value) of the color can be selected

public class BrightnessScale extends JPanel {

	private Shape rectangle;
	private int width = 100, height = 200,
				brightness_scale_width = 20,
				brightness_scale_height = 180;
	
	public BrightnessScale() {
		//PF: Set preferred size
		setPreferredSize(new Dimension(width, height));
		
		//PF: Create a black line border
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*PF: Shape used to draw Brightness Scale
		 * It must be centered
		 */
		rectangle = new Rectangle2D.Double((width - brightness_scale_width)/ 2, 
				(height - brightness_scale_height)/ 2, 
				brightness_scale_width, 
				brightness_scale_height);
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
		
		//PF: Cast graphics to Graphics2D object
		Graphics2D g2 = (Graphics2D) g;
		
		/*PF: Set paint to gradient paint to draw 
		 * a gradient from black to color chosen
		 */
		g2.setPaint(new GradientPaint(0f, 10f, Color.WHITE, 0f, 190f, Color.BLACK));
		
		//PF: Fill rectangle with gradient paint
		g2.fill(rectangle);
		
		//PF: Set Color to Black
		g2.setColor(Color.BLACK);
		
		//PF: Draw black outline around rectangle
		g2.draw(rectangle);
	}

}
