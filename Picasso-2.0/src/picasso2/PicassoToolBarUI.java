package picasso2;

import javax.swing.JToolBar;

public class PicassoToolBarUI extends PicassoAbstractToolBar {

	public PicassoToolBarUI() {
		//PF: Set orientation to vertical
		setOrientation(JToolBar.VERTICAL);
		
		//PF: Create ColorSelectionPanel
		ColorSelectionPanel color_selection_panel = new ColorSelectionPanel();
		
		//PF: Add ColorSelectionPanel
		add(color_selection_panel);
	}

}