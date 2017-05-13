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
	private CanvasPanel canvas_panel;
	
	public PicassoView(PicassoModel model) {
		
		//PF: Set Layout to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set model to Picasso Model
		this.model = model;
		
		/*PF: Create JPanels for the
		 * canvas and toolbar ui container,
		 * resizable canvas container,
		 * buffered image (canvas)
		 */
		JPanel canvas_and_toolbar_ui_container = new JPanel(new BorderLayout());
		canvas_panel = new CanvasPanel(this.model);
		CanvasContainer canvas_container = new CanvasContainer(canvas_panel);
		
		//PF: JPanels are added together
		add(canvas_and_toolbar_ui_container, BorderLayout.CENTER);
		
		canvas_and_toolbar_ui_container.add(canvas_container, BorderLayout.CENTER);
	}
	
	//PF: gets Canvas
	public CanvasPanel getPicassoCanvas() {
		return canvas_panel;
	}
	
}
