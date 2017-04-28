package picasso2;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
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
	private PicassoCanvas canvas;
	
	public PicassoView(PicassoModel model) {
		
		//PF: Set Layout to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set model to Picasso Model
		this.model = model;
		
		/*PF: Create JPanels for the
		 * buffered image (canvas),
		 * color selection
		 */
		canvas = new PicassoCanvas(this.model);
//		JPanel color_selection = new JPanel(new BorderLayout());
		
		add(canvas, BorderLayout.CENTER);
//		add(color_selection, BorderLayout.SOUTH);
	}
	
	//PF: gets Canvas
	public PicassoCanvas getPicassoCanvas() {
		return canvas;
	}
	
}
