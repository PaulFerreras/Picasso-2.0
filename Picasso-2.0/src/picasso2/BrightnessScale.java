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

public class BrightnessScale extends JPanel {

	private int width = 100, height = 200,
				brightness_scale_width = 20,
				brightness_scale_height = 180;
	private Shape rectangle;
	
	public BrightnessScale() {
		//PF: Set preferred size
		setPreferredSize(new Dimension(width, height));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*PF: Shape used to draw Brightness Scale
		 * Must be centered
		 */
		rectangle = new Rectangle2D.Double((width - brightness_scale_width)/ 2, 
				(height - brightness_scale_height)/ 2, 
				brightness_scale_width, 
				brightness_scale_height);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(new GradientPaint(0f, 0f, Color.WHITE, 0f, 180f, Color.BLACK));
		g2.fill(rectangle);
		
		g2.setColor(Color.BLACK);
		g2.draw(rectangle);
	}

}
