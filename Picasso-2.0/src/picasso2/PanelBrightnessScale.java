package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the brightness (value) of the color can be selected

public class PanelBrightnessScale extends JPanel {

	private PanelColorPreview color_preview;
	private BufferedImage brightness_scale_bi;
	private Shape rectangle;
	private int width = 50, height = 200,
				brightness_scale_width = 20,
				brightness_scale_height = 180;
	private Color cw_color = Color.WHITE, outline_color = Color.BLACK;                           //Color edited by color wheel;
	private SelectorBrightnessScale brightness_selector;
	
	public PanelBrightnessScale(PanelColorPreview cp) {
		setPreferredSize(new Dimension(width, height));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		color_preview = cp;
		
		brightness_scale_bi = new BufferedImage(brightness_scale_width,
				brightness_scale_height, 
				BufferedImage.TYPE_INT_ARGB);
		
		rectangle = new Rectangle2D.Float((width/2) - (brightness_scale_width/2),
				(height/2) - (brightness_scale_height/2), 
				brightness_scale_width,
				brightness_scale_height);
		
		//PF: Draw brightness scale
		repaintBufferedImage();
		
		brightness_selector = new SelectorBrightnessScale((width/2) - (brightness_scale_width/2), 0, brightness_scale_width);
		
		//PF: Placed brightness selector at the bottom of brightness scale
		moveSelector(0, 186);
		
		ListenerBrightnessScale brightness_scale_listener = new ListenerBrightnessScale(this);
		addMouseListener(brightness_scale_listener);
		addMouseMotionListener(brightness_scale_listener);
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
	
	public int getBrightnessScaleHeight() {
		return brightness_scale_height;
	}
	
	public int getSelectorHeight() {
		return brightness_selector.getHeight();
	}
	
	public Shape getBoundary() {
		return rectangle;
	}
	
	public void moveSelector(int x, int y) {
		brightness_selector.moveSelector(brightness_selector.getX(), y);
		
		setPreviewColor(x, y);
		
		repaint();
	}
	
	public void setBrightnessColor(Color c) {
		cw_color = c;
		
		repaintBufferedImage();
		
		setPreviewColor(brightness_selector.getX(), brightness_selector.getY());
		
		repaint();
	}
	
	public void setPreviewColor(int x, int y) {
		//PF: Shift x and y variables
		//to be on brightness_scale_bi
		x = 0;
		y -= 10;
		
		color_preview.setColor(new Color(brightness_scale_bi.getRGB(x, y)));
	}
	
	public void repaintBufferedImage() {
		Graphics2D g2 = brightness_scale_bi.createGraphics();
		g2.setPaint(new GradientPaint(0, 0, cw_color, 0, brightness_scale_height, Color.BLACK));
		g2.fillRect(0, 0, brightness_scale_width, brightness_scale_height);
	}

}
