package picasso2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/*PF: JPanel that holds ToolButtons
 * Is placed in Background Panel in PicassoToolBar
 */

public class PicassoButtonPanel extends JPanel {

	public PicassoButtonPanel() {
		//PF: Set bounds
		setBounds(20, 5, 190, 70);
		
		/*PF: Create and Store GridLayout
		 * in an internal variable
		 * **NOTE** This is so we can
		 * use it to add gaps between
		 * the buttons
		 */
		GridLayout grid_layout = new GridLayout(2, 4);
		
		/*PF: Set Layout to GridLayout
		 * 2 rows, 4 columns
		 */
		setLayout (grid_layout);
		
		//PF: Set Vertical and Horizontal Gaps between buttons
		grid_layout.setVgap(10);
		grid_layout.setHgap(7);
		
		addButtons();
	}

	private void addButtons() {
		for (int i = 0; i < 8; i++) {
			JButton new_button = new JButton("" + (i + 1));
			this.add(new_button);
		}
	}
}
