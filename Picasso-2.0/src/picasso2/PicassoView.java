package picasso2;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*PF: This is the UI of the program.
 * This is what the user sees and
 * interacts with.
 */

public class PicassoView extends JPanel {

	private PicassoModel model;
	private CanvasPanel canvas_panel;
	private PicassoScrollPane scroll_pane;
	
	public PicassoView(PicassoModel model) {
		
		//PF: Set Layout to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set preferred size
		setPreferredSize(new Dimension(500, 500));
		
		//PF: Set model to Picasso Model
		this.model = model;
		
		/*PF: Create JPanels for the
		 * canvas and toolbar ui container,
		 * buffered image (canvas)
		 * canvas container
		 */
		JPanel canvas_and_toolbar_ui_container = new JPanel(new BorderLayout());
		canvas_panel = new CanvasPanel(this.model);
		CanvasContainer canvas_container = new CanvasContainer(canvas_panel);
		
		/*PF: Create JScrollPane with 
		 * canvas container as the viewport
		 * **NOTE** JScrollPane's preferred 
		 * size gets set to its 
		 * container's width and height when
		 * PicassoView gets resized
		 */
		scroll_pane = new PicassoScrollPane(canvas_container);
		
		//PF: Create ToolBars
		PicassoToolBar tool_bar = new PicassoToolBar("ToolBar");
		PicassoToolUIToolBar tool_ui_tool_bar = new PicassoToolUIToolBar();
		
		//PF: JPanels are added together
		add(canvas_and_toolbar_ui_container, BorderLayout.CENTER);
		add(tool_bar, BorderLayout.PAGE_START);
		
				/*PF: **NOTE** JScrollPane is added 
				 * here NOT canvas container
				 * as canvas container is the 
				 * viewport of JScrollPane
				 */
		canvas_and_toolbar_ui_container.add(scroll_pane, BorderLayout.CENTER);
		canvas_and_toolbar_ui_container.add(tool_ui_tool_bar, BorderLayout.LINE_START);
		
		//PF: Canvas adds CanvasContainer as an observer
		canvas_panel.addObserver(canvas_container);
	}
	
	//PF: gets Canvas
	public CanvasPanel getPicassoCanvas() {
		return canvas_panel;
	}
	
}
