package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

//PF: This is where the brightness (value) of the color can be selected

public class PanelBrightnessScale extends JPanel {

	private BufferedImage brightness_scale_bi;
	private Shape rectangle;
	private int width = 100, height = 200,
				brightness_scale_width = 20,
				brightness_scale_height = 180;
	private Color cw_color = Color.WHITE, outline_color = Color.BLACK;                           //Color edited by color wheel;
	private BrightnessSelector brightness_selector;
	
	public PanelBrightnessScale() {
		setPreferredSize(new Dimension(width, height));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		brightness_scale_bi = new BufferedImage(brightness_scale_width,
				brightness_scale_height, 
				BufferedImage.TYPE_INT_ARGB);
		
		rectangle = new Rectangle2D.Float((width/2) - (brightness_scale_width/2),
				(height/2) - (brightness_scale_height/2), 
				brightness_scale_width,
				brightness_scale_height);
		
		//PF: Draw brightness scale
		repaintBufferedImage();
		
		//PF: Placed brightness selector at top of brightness scale
		brightness_selector = new BrightnessSelector((width/2) - (brightness_scale_width/2), height/2);
		
		BrightnessScaleListener bs_listener = new BrightnessScaleListener(brightness_selector, rectangle);
		
		addMouseListener(bs_listener);
		addMouseMotionListener(bs_listener);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(brightness_scale_bi, 
				(width - brightness_scale_width)/ 2,
				(height - brightness_scale_height)/2, 
				null);
		
		brightness_selector.draw(g2);
		
		g2.setColor(outline_color);
		g2.draw(rectangle);
	}
	
	public void setColor(Color c) {
		cw_color = c;
		
		repaintBufferedImage();
		
		repaint();
	}
	
	public void repaintBufferedImage() {
		Graphics2D g2 = brightness_scale_bi.createGraphics();
		g2.setPaint(new GradientPaint(0, 0, cw_color, 0, brightness_scale_height, Color.BLACK));
		g2.fillRect(0, 0, brightness_scale_width, brightness_scale_height);
	}
	
	private class BrightnessSelector extends AbstractSelector {
		
		private int height = 4;
		
		public BrightnessSelector(int x, int y) {
			super(x, y);
		}
		
		public int getX() {
			return x;
		}

		public int getHeight() {
			return height;
		}
		
		@Override
		public Shape getShape() {
			return new Rectangle2D.Float(x, y, brightness_scale_width, height);
		}

		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(Color.RED);
			g2.fill(getShape());
		}
		
	}
	
	private class BrightnessScaleListener extends AbstractChooserListener {
		
		private int top_boundary, bottom_boundary;
		
		private BrightnessScaleListener(AbstractSelector selector, Shape boundary) {
			super(selector, boundary);
			
			top_boundary = (height - brightness_scale_height)/2;
			bottom_boundary = height - top_boundary  - ((BrightnessSelector) selector).getHeight();
		}

		@Override
		public void moveSelector(int x, int y) {
			selector.moveSelector(((BrightnessSelector) selector).getX(), y);
			
			changeColor(x, y);
		}
		
		@Override
		public void changeColor(int x, int y) {
			getParent().repaint();
			
		}

		@Override
		public void moveSelectorToEdge(int x, int y) {
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(in_bounds) {
				if(e.getY() < top_boundary) {
					moveSelector(e.getX(), top_boundary);
				} else if (e.getY() > bottom_boundary) {
					moveSelector(e.getX(), bottom_boundary);
				} else {
					moveSelector(e.getX(), e.getY());
				}
			}
		}
		
	}

}
