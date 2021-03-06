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

public class ToolBar extends AbstractToolBar implements InterfaceNewObservable {
	private JPanel background_panel;
	private PanelToolBar tool_panel;
	private InterfaceNewObserver observer;
	
	public ToolBar(String name) {
		//PF: Name gets delegated to PicassoAbstractToolBar constructor
		super(name);
		
		/*PF: Create Background Panel
		 * and Button Panel
		 */
		background_panel = new JPanel(null);
		tool_panel = new PanelToolBar();
		
		//PF: Add PicassoButtonPanel as observer
		addObserver(tool_panel);
		
		/*PF: Must set preferred size of Background Panel
		 * for ToolBar to be visible. Sets Background Panel
		 * for Horizontal Position
		 */
		setBackgroundPanelHorizontal();
		
		//PF: Set black line borders around background panel
		background_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Add button panel to background panel
		background_panel.add(tool_panel);
		
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
	
	//PF: Sets JToolBar for Vertical Size
	private void setBackgroundPanelVertical() {
		background_panel.setPreferredSize(new Dimension(100, 230));
	}
	
	//PF: Sets JToolBar for Horizontal Size
	private void setBackgroundPanelHorizontal() {
		background_panel.setPreferredSize(new Dimension(230, 80));
	}

	//PF: Stores observer in private internal variable
	@Override
	public void addObserver(InterfaceNewObserver o) {
		observer = o;
	}

	//PF: Notifies observer with object argument
	@Override
	public void notifyObserver(Object obj) {
		observer.update(obj);
	}
	
//PF: Mouse and Mouse Motion Event Listener for PicassoToolBar
public class PicassoToolBarListener extends PicassoAbstractToolBarListener {
	
	public PicassoToolBarListener() {
		
	}
	
	/*PF: When mouse is released,
	 * PicassoButtonPanel is notified
	 * about the orientation and is updated
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
			switch(getOrientation()) {
			
			case JToolBar.VERTICAL:
				setBackgroundPanelVertical();
				break;
				
			case JToolBar.HORIZONTAL:
				setBackgroundPanelHorizontal();
				break;
			}
			
			notifyObserver(getOrientation());
	}
	
}
	
}
