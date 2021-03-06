package picasso2;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.JToolBar;
import javax.swing.event.MouseInputAdapter;

//PF: Abstract class that extends JToolBar

abstract public class AbstractToolBar extends JToolBar {

	public AbstractToolBar() {
		//PF: Add PicassoAbstractToolBarListener as a mouse motion listener
		addMouseMotionListener(new PicassoAbstractToolBarListener());
	}
	
	public AbstractToolBar(String name) {
		//PF: Name gets delegated to JToolBar constructor
		super(name);
		
		//PF: Add PicassoAbstractToolBarListener as a mouse motion listener
		addMouseMotionListener(new PicassoAbstractToolBarListener());
	}

//PF: Mouse and Mouse Motion Event Listener for PicassoToolBar
public class PicassoAbstractToolBarListener extends MouseInputAdapter {

	public PicassoAbstractToolBarListener() {

	}

	/*PF: When mouse is moved over 
	 * draggable part of PicassoToolBar,
	 * mouse turns into a hand cursor
	 * to indicate PicassoToolBar is draggable
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		/*PF: Checks to see which orientation
		 * JToolBar is in
		 * **NOTE** Draggable part is only in
		 * first 13 pixels of panel
		 */

		if(getOrientation() == JToolBar.VERTICAL) {
			if(e.getY() < 14) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(Cursor.getDefaultCursor());
			}
		}

		if(getOrientation() == JToolBar.HORIZONTAL) {
			if(e.getX() < 14) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(Cursor.getDefaultCursor());
			}
		}
	}
}
	
}
