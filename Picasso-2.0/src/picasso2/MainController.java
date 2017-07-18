package picasso2;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.List;

/*PF: This is where the actions of
 * the user are taken in and 
 *  are processed in the program
 */

public class MainController implements MouseListener, MouseMotionListener {
	
	private MainModel model;
	private MainView view;
	private PanelCanvas canvas;
	private ChangeableColor changeable_color;
	private ToolBar tool_bar;
	private ToolBarToolUI tool_bar_tool_ui;
	private AbstractTool current_tool;
	private ToolPaintBrush paint_brush_tool;

	public MainController(MainModel model, MainView view) {
		/*PF: PicassoController gets model
		 * and view, so user actions in
		 * view can be used to edit the model.
		 */
		this.model = model;
		this.view = view;
		canvas = view.getPicassoCanvas();
		
		changeable_color = model.getChangeableColor();
		
		//PF: ToolBars
		tool_bar = view.getToolBar();
		tool_bar_tool_ui = view.getToolBarToolUI();
		
		PanelColorWheel color_wheel = tool_bar_tool_ui.getColorWheel();
		PanelBrightnessScale brightness_scale = tool_bar_tool_ui.getBrightnessScale();
		
		//PF: Create tools
		paint_brush_tool = new ToolPaintBrush(model, canvas, changeable_color);
		
		/*PF: PicassoController is added
		 * as a MouseListener and 
		 * a MouseMotionListener to
		 * canvas
		 */
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		//PF: Current Tool set to PaintBrushTool
		current_tool = paint_brush_tool;
	}
	
	private void setTool(String tool_name) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	/*PF: When mouse has entered Canvas Panel
	 * set cursor to proper tool cursor
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		canvas.setCursor(current_tool.getCursor());
	}

	/*PF: When mouse has exited Canvas Panel
	 * set cursor back to default cursor
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		canvas.setCursor(Cursor.getDefaultCursor());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		current_tool.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		 current_tool.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
