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
	private JScrollPane scroll_pane;
	
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
		 * Set vertical and horizontal 
		 * scroll bars to always visible
		 * **NOTE** JScrollPane's preferred 
		 * size gets set to its 
		 * container's width and height when
		 * PicassoView gets resized
		 */
		scroll_pane = new JScrollPane(canvas_container, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		/*PF: Set new unit increments for 
		 * Vertical and Horizontal scroll bars
		 * This changes how quickly the scroll bar
		 * scrolls when pressing the arrows
		 * or scrolling the mouse wheel 
		 */
		scroll_pane.getVerticalScrollBar().setUnitIncrement(7);
		scroll_pane.getHorizontalScrollBar().setUnitIncrement(7);
		
		/*PF: Set new block increments for
		 * Vertical nad Horizontal scroll bars
		 * This changes how quickly the scroll bar
		 * scrolls when pressing on the track
		 * (area the slider is not on)
		 */
		scroll_pane.getVerticalScrollBar().setBlockIncrement(300);
		scroll_pane.getHorizontalScrollBar().setBlockIncrement(300);
		
		//PF: JPanels are added together
		add(canvas_and_toolbar_ui_container, BorderLayout.CENTER);
		
				/*PF: **NOTE** JScrollPane is added 
				 * here NOT canvas container
				 * as canvas container is the 
				 * viewport of JScrollPane
				 */
		canvas_and_toolbar_ui_container.add(scroll_pane, BorderLayout.CENTER);
		
		//PF: Canvas adds CanvasContainer as an observer
		canvas_panel.addObserver(canvas_container);
	}
	
	//PF: gets Canvas
	public CanvasPanel getPicassoCanvas() {
		return canvas_panel;
	}
	
}
