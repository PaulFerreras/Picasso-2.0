package picasso2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

/*PF: Draggable ToolBar that holds PicassoButtonPanel
 * Extends JToolBar
 * Is Observable by PicassoButtonPanel
 * Notifies PicassoButtonPanel when
 * PicassoToolBar's orientation has changed
 * Also houses PicassoToolBarListener
 */

public class PicassoToolBar extends JToolBar implements NewObservable {
	
	private int old_orientation;
	private NewObserver observer;
	
	public PicassoToolBar(String name) {
		//PF: Name gets delegated to JToolBar constructor
		super(name);
		
		/*PF: Create Background Panel
		 * and Button Panel
		 */
		JPanel background_panel = new JPanel(null);
		PicassoButtonPanel button_panel = new PicassoButtonPanel();
		
		/*PF: Must set preferred size of Background Panel
		 * for ToolBar to be visible
		 */
		background_panel.setPreferredSize(new Dimension(80, 80));
		
		//PF: Set black line borders around background panel
		background_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Add button panel to background panel
		background_panel.add(button_panel);
		
		//PF: Create PicassoToolBarListener
		PicassoToolBarListener picasso_tbl = new PicassoToolBarListener();
		
		/*PF: Add PicassoToolBarListener as Mouse Listener 
		 * and Mouse Motion Listener
		 */
		addMouseListener(picasso_tbl);
		addMouseMotionListener(picasso_tbl);
		
		//PF: Add background panel to PicassoToolBar
		add(background_panel);
	}


	@Override
	public void addObserver(NewObserver o) {
		observer = o;
		
	}


	@Override
	public void notifyObserver(Object obj) {
		observer.update(obj);
		
	}
	
//PF: Mouse and Mouse Motion Event Listener for PicassoToolBar
public class PicassoToolBarListener extends MouseInputAdapter {
	
	public PicassoToolBarListener() {
		
	}
	
	/*PF: When mouse is moved over 
	 * draggable part of PicassoToolBar,
	 * mouse turns into a hand cursor
	 * to indicate PicassoToolBar is draggable
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getX() < 14) {
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			setCursor(Cursor.getDefaultCursor());
		}
	}
	
	/*PF: When mouse is released,
	 * PicassoTBL checks to see if 
	 * PicassoTB's orientation has changed
	 * If so, notify PicassoButtonPanel 
	 * the new orientation
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(getOrientation() != old_orientation) {
			notifyObserver(getOrientation());
		}
	}
}
	
}
