package picasso2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

/*PF: Draggable ToolBar that holds PicassoButtonPanel
 * Extends JToolBar
 */

public class PicassoToolBar extends JToolBar {

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
		
		//PF: Add background panel to PicassoToolBar
		add(background_panel);
	}
	
}
