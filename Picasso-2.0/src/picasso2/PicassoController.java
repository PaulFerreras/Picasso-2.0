package picasso2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*PF: This is where the actions of
 * the user are taken in and 
 *  are processed in the program
 */

public class PicassoController implements MouseListener {
	
	private PicassoModel model;
	private PicassoView view;

	public PicassoController(PicassoModel model, PicassoView view) {
		this.model = model;
		this.view = view;
		
		this.view.addMouseListener(this);
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

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
