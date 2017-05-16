package picasso2;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JToolBar;

/*PF: Draggable ToolBar that holds ToolButtons
 * Extends JToolBar
 */

public class PicassoToolBar extends JToolBar {

	public PicassoToolBar(String name) {
		super(name);
		
		/*PF: Create Background Panel
		 * and Button Panel
		 */
		JPanel background_panel = new JPanel(null);
//		JPanel button_panel = new JPanel(GridLayout());
		
		//PF: Set Preferred Size of Background Panel
//		background_panel.setPreferredSize(new Dimension(10, 10));
		
		//PF: Add Components together
		add(background_panel);
	}
	
}
