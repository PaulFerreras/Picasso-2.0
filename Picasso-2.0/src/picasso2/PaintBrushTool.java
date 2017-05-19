package picasso2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

//PF: PaintBrushTool contains all the data used to draw on PicassoModel

public class PaintBrushTool extends AbstractTool {

	private PicassoModel model;
	private CanvasPanel canvas;
	private int brush_size = 10;
	private Color brush_color = Color.BLACK;
	
	public PaintBrushTool(PicassoModel model, CanvasPanel canvas) {
		this.model = model;
		this.canvas = canvas;
	}

	//PF: Returns size
	private int getSize() {
		return brush_size;
	}
	
	/*PF: Sets size
	 * **NOTE** one int value (width) will be used 
	 * to determine the entire size of the brush
	 */
	private void setSize(int width) {
		brush_size = width;
	}
	
	//PF: Returns color
	private Color getColor() {
		return brush_color;
	}
	
	//PF: Sets color
	private void setColor(Color new_color) {
		brush_color = new_color;
	}
	
	//PF: Returns cursor specified by PaintBrushTool
	@Override
	public Cursor getCursor() {
		/*PF: Build 32x32 brush cursor image
		 * BufferedImageType is ARGB which allows for alpha values
		 * **NOTE** alpha values are necessary 
		 * for the transparent pixels
		 */
		BufferedImage brush_cursor_image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		
		//PF: Create Graphics2D object
		Graphics2D g2 = brush_cursor_image.createGraphics();

		/*PF: Set Composite to AlphaComposite.Clear (transparent pixels)
		 * and fill the entire buffered image with them
		 */
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		g2.fillRect(0, 0, brush_cursor_image.getWidth(), brush_cursor_image.getHeight());

		/*PF: Set Composite to AlphaComposite.SRC_Over
		 * which allows the buffered image to be redrawn over
		 */
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		//PF: Set brush color and fill the appropriate size 
		g2.setColor(brush_color);
		g2.fillRect(0, 0, brush_size, brush_size);
		
		/*PF: This point (hot spot) is the 
		 * location at which mouse events occur
		 */
		Point brush_cursor_hot_spot = new Point(brush_size/2, brush_size/2);
		
		//PF: Toolkit is required to create the custom cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Cursor brush_cursor = toolkit.createCustomCursor(brush_cursor_image, brush_cursor_hot_spot, "Brush Cursor");

		//PF: returns Brush Cursor
		return brush_cursor;
	}

	/*PF: When user presses or drags mouse,
	 * calls draw method in model and 
	 * repaint method in canvas
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		model.draw(e.getID(),e.getX(), e.getY(), brush_size, brush_color);
		canvas.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		model.draw(e.getID(),e.getX(), e.getY(), brush_size, brush_color);
		canvas.repaint();
	}
}