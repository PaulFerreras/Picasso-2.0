package picasso2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

//PF: This is where the actual buffered image is rendered

public class PicassoCanvas extends JPanel {
	
	private PicassoModel model;
	
	public PicassoCanvas(PicassoModel model) {
		//PF: Set to BorderLayout
		setLayout(new BorderLayout());
		
		this.model = model;
		
		//PF: Initialize size as Buffered Image size
		setPreferredSize(new Dimension(model.getBufferedImage().getWidth(), 
				model.getBufferedImage().getHeight()));
	}
	
	/*PF: This is the function called 
	 * when the Canvas gets repainted.
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
		g.drawImage(model.getBufferedImage(), 0, 0, null);
	}

}
