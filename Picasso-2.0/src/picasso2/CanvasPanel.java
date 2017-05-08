package picasso2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

//PF: This is where the actual buffered image is rendered

public class CanvasPanel extends JPanel {
	
	private PicassoModel model;
	
	public CanvasPanel(PicassoModel model) {
		//PF: Set to BorderLayout
//		setLayout(new BorderLayout());
		
		//PF: Set Border to Black Line Border
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.model = model;
		
		//PF: Set bounds of Canvas
		setBounds(0, 0, 300, 300);

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