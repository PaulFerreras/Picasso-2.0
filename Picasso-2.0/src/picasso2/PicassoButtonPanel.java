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

public class PicassoButtonPanel extends JPanel implements NewObserver {

	public PicassoButtonPanel() {
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
		for (int i = 0; i < 8; i++) {
			JButton new_button = new JButton("" + (i + 1));
			this.add(new_button);
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
			System.out.println(obj);
			setBounds(5, 20, 90, 190);
			setLayout(new GridLayout(4, 2, 5, 7));
			break;
			
		case JToolBar.HORIZONTAL:
			setBounds(20, 5, 190, 70);
			setLayout(new GridLayout(2, 4, 7, 10));
			break;
		}
		
		/*PF: Need to call revalidate
		 * since Layout Manager is changing
		 */
		revalidate();
	}
}
