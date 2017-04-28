package picasso2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*PF: This is the UI of the program.
 * This is what the user sees and
 * interacts with.
 */

public class PicassoView extends JPanel {

	private PicassoModel model;
	private int height;
	private int width;
	
	public PicassoView(PicassoModel model) {
		
		//PF: Set Layout to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set model to Picasso Model
		this.model = model;
		
		//PF: Initialize size as Buffered Image size
		setPreferredSize(new Dimension(model.getBufferedImage().getWidth(), 
				model.getBufferedImage().getHeight()));
	}

	/*PF: This is the function called 
	 * when View gets repainted.
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
		
		/*PF: Cast graphics to graphics 2D.
		 * Graphics 2D is required to draw
		 * and edit buffered images
		 */
//		Graphics2D g2 = (Graphics2D) g;
		
		/*PF: Set new size of View
		 * to accommodate picture;
		 */
//		this.setPreferredSize(new Dimension(model.getBufferedImage().getWidth(), 
//				model.getBufferedImage().getHeight()));
		
		//PF: Assign graphics 2D to BufferedImage in model
//		g = model.getBufferedImage().getGraphics();
		
		//PF: Draw Buffered Image at (0,0)
		g.drawImage(model.getBufferedImage(), 0, 0, null);
	}
}
