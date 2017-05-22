package picasso2;

import javax.swing.JToolBar;

/*PF: This is the where the UI of all of the tools are created 
 * Extends PicassoAbstractToolBar
 */

public class PicassoToolUIToolBar extends PicassoAbstractToolBar {

	public PicassoToolUIToolBar() {
		//PF: Set orientation to vertical
		setOrientation(JToolBar.VERTICAL);
		
		//PF: Create Panels
		BrushPanel brush_panel = new BrushPanel();
		
		//PF: Add Panels
		add(brush_panel);
	}

}
