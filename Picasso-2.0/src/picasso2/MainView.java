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

public class MainView extends JPanel {

	private Dimension preferred_size = new Dimension(1100, 600);
	private MainModel model;
	private PanelCanvas canvas;
	private ScrollPane scroll_pane;
	private ToolBar tool_bar;
	private ToolBarToolUI tool_bar_tool_ui;
	
	public MainView(MainModel model) {
		setLayout(new BorderLayout());
		setPreferredSize(preferred_size);
		
		this.model = model;
		
		//PF: Panels
		JPanel canvas_and_toolbar_ui_container = new JPanel(new BorderLayout());
		canvas = new PanelCanvas(this.model);
		PanelCanvasContainer canvas_container = new PanelCanvasContainer(canvas);
		
		scroll_pane = new ScrollPane(canvas_container);
		
		//PF: ToolBars
		tool_bar = new ToolBar("ToolBar");
		tool_bar_tool_ui = new ToolBarToolUI(model.getChangeableColor());
		
		//PF: Add Panels together
		add(canvas_and_toolbar_ui_container, BorderLayout.CENTER);
		add(tool_bar, BorderLayout.PAGE_START);
		
		canvas_and_toolbar_ui_container.add(scroll_pane, BorderLayout.CENTER);
		canvas_and_toolbar_ui_container.add(tool_bar_tool_ui, BorderLayout.LINE_START);
		
		canvas.addObserver(canvas_container);
	}
	
	public PanelCanvas getPicassoCanvas() {
		return canvas;
	}
	
	public ToolBar getToolBar() {
		return tool_bar;
	}
	
	public ToolBarToolUI getToolBarToolUI() {
		return tool_bar_tool_ui;
	}
	
}
