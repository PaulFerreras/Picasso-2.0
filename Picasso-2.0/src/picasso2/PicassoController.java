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
		 * view
		 */
		this.view.addMouseListener(this);
		this.view.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		/*PF: Offsets x and y so that
		 * the mouse cursor is in the 
		 * center of what is drawn
		 */
		int x = e.getX() - 5;
		int y = e.getY() - 5;
		
		/*PF: User presses invokes 
		 * draw method in model and 
		 * repaint method in view
		 */
		model.draw(x, y);
		canvas.repaint(x, y, 10, 10);
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
		/*PF: Offsets x and y so that
		 * the mouse cursor is in the 
		 * center of what is drawn
		 */
		int x = e.getX() - 5;
		int y = e.getY() - 5;
		
		/*PF: User presses invokes 
		 * draw method in model and 
		 * repaint method in view
		 */
		model.draw(x, y);
		canvas.repaint(x, y, 10, 10);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
