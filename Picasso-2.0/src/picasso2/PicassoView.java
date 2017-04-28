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
	private ToolPanel tool_panel;
	private ColorSelectionPanel color_selection_panel;
	
	public PicassoView(PicassoModel model) {
		
		//PF: Set Layout to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set model to Picasso Model
		this.model = model;
		
		/*PF: Create JPanels for the
		 * buffered image (canvas),
		 * color selection
		 */
		canvas_panel = new CanvasPanel(this.model);
		tool_panel = new ToolPanel();
		color_selection_panel = new ColorSelectionPanel();
		
		add(canvas_panel, BorderLayout.CENTER);
	}
	
	//PF: gets Canvas
	public CanvasPanel getPicassoCanvas() {
		return canvas_panel;
	}
	
}
