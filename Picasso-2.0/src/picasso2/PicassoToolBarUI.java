package picasso2;

import javax.swing.JColorChooser;
import javax.swing.JToolBar;

public class PicassoToolBarUI extends PicassoAbstractToolBar {

	public PicassoToolBarUI() {
		//PF: Set orientation to vertical
		setOrientation(JToolBar.VERTICAL);
		
		//PF: Create BrushPanel
		BrushPanel brush_panel = new BrushPanel();
		
		//PF: Add BrushPanel
		add(brush_panel);
	}

}
