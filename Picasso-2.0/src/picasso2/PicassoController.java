package picasso2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*PF: This is where the actions of
 * the user are taken in and 
 *  are processed in the program
 */

public class PicassoController implements MouseListener, MouseMotionListener {
	
	private PicassoModel model;
	private PicassoView view;
	private CanvasPanel canvas;
	private PaintBrushTool paint_brush_tool;

	public PicassoController(PicassoModel model, PicassoView view) {
		/*PF: PicassoController gets model
		 * and view, so user actions in
		 * view can be used to edit the model.
		 */
		this.model = model;
		this.view = view;
		this.canvas = view.getPicassoCanvas();
		
		/*PF: PicassoController is added
		 * as a MouseListener and 
		 * a MouseMotionListener to
		 * canvas
		 */
		this.canvas.addMouseListener(this);
		this.canvas.addMouseMotionListener(this);
		
		//PF: Create Tools
		paint_brush_tool = new PaintBrushTool();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		canvas.setCursor(paint_brush_tool.getCursor());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*PF: When user presses cursor,
	 * controller draws on canvas
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		/*PF: User presses invokes 
		 * draw method in model and 
		 * repaint method in view
		 */
		model.draw(e.getX(), e.getY(), e.getID());
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*PF: When user presses and drags cursor,
	 * controller draws on canvas
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		/*PF: User presses and drags
		 * invokes draw method in model 
		 * and repaint method in view
		 */
		model.draw(e.getX(), e.getY(), e.getID());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
