package picasso2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/*PF: JPanel that holds ToolButtons
 * Is placed in Background Panel in PicassoToolBar
 */

public class PanelToolBar extends JPanel implements InterfaceNewObserver {
	
	public PanelToolBar() {
		//PF: Set bounds
		setBounds(20, 5, 190, 70);
		
		/*PF: Set Layout to GridLayout
		 * 2 rows, 4 columns
		 * with 7 as a horizontal gap
		 * and 10 as a vertical gap
		 */
		setLayout (new GridLayout(2, 4, 7, 10));
		
		addButtons();
	}

	private void addButtons() {
		for (int i = 0; i < 6; i++) {
			JButton new_button = new JButton("" + (i + 1));
			this.add(new_button);
		}
	}
	
	//PF: Sets button panel horizontal
	private void setButtonLayoutHorizontal() {
		setBounds(20, 5, 190, 70);
		setLayout(new GridLayout(2, 4, 7, 10));
	}
	
	//PF: Sets button panel vertical
	private void setButtonLayoutVertical() {
		//PF: Create variable parent_width
		int parent_width = 0;
		
		/*PF: Check if PicassoToolBar is separated
		 * then set parent_width to appropriate width.
		 * **NOTE** This is needed because PicassoToolBar's
		 * minimum width when separated is 130 and 104
		 * when not separated. (126 and 100 for parent
		 * panel -background_panel-, respectively)
		 */
		if(isPicassoToolBarSeparated()) {
			parent_width = 126;
		} else {
			parent_width = 100;
		}
		
		/*PF: To find the left side of the button panel
		 * when centered is parent_width subtracted
		 * by this width, divided by 2 (for both sides)
		 */
		setBounds(((parent_width - 90) / 2), 20, 90, 190);
		setLayout(new GridLayout(4, 2, 5, 7));
	}
	
	//PF: Checks to see if PicassoToolBar is separated
	private boolean isPicassoToolBarSeparated() {
		
		/*PF: Store PicassoToolBar's parent's name 
		 * Hierarchy -
		 * null.ContentPane
		 * PicassoToolBar
		 * background panel
		 */
		String parent_name = getParent().getParent().getParent().getName();
		
		/*PF: Does so by checking to see if PicassoToolBar's
		 * parent's name is "null.contentPane"
		 * **NOTE** When not separated, PicassoToolBar's 
		 * parent's name comes out as null so have
		 * to check out for that first
		 */
		if(parent_name != null && parent_name.equals("null.contentPane")) {
			return true;
		} else {
			return false;
		}
	}

	/*PF: When PicassoToolBar's orientation changes,
	 * PicassoButtonPanel's UI is switched to fit
	 * inside of PicassoToolBar
	 */
	@Override
	public void update(Object obj) {
		
		switch((int) obj) {
		
		case JToolBar.VERTICAL:
			setButtonLayoutVertical();
			break;
			
		case JToolBar.HORIZONTAL:
			setButtonLayoutHorizontal();
			break;
		}
		
		/*PF: Need to call revalidate
		 * since Layout Manager is changing
		 */
		revalidate();
	}
	
}
