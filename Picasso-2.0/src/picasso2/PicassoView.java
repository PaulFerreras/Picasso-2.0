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
		 * resizable canvas container,
		 * canvas and toolbar ui container,
		 * buffered image (canvas)
		 */
		JPanel canvas_and_toolbar_ui_container = new JPanel(new BorderLayout());
		ResizableCanvasContainer resizable_canvas_container = new ResizableCanvasContainer(null);
		canvas_panel = new CanvasPanel(this.model);
		
		//PF: JPanels are added together
		add(canvas_and_toolbar_ui_container, BorderLayout.CENTER);
		
		canvas_and_toolbar_ui_container.add(resizable_canvas_container, BorderLayout.CENTER);
		
		resizable_canvas_container.add(canvas_panel);
	}
	
	//PF: gets Canvas
	public CanvasPanel getPicassoCanvas() {
		return canvas_panel;
	}
	
}
