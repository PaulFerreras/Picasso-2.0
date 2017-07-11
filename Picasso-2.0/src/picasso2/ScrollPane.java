package picasso2;

import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrollPane extends JScrollPane {

	public ScrollPane(Component view) {
		super(view);

		 /*PF: Set vertical and horizontal 
		 * scroll bars to always visible
		 */
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollBar vertical = getVerticalScrollBar();
		JScrollBar horizontal = getHorizontalScrollBar();
		int unit_inc = 7;
		int block_inc = 250;
		
		/*PF: Set new unit increments for 
		 * Vertical and Horizontal scroll bars
		 * This changes how quickly the scroll bar
		 * scrolls when pressing the arrows
		 * or scrolling the mouse wheel 
		 */
		vertical.setUnitIncrement(unit_inc);
		horizontal.setUnitIncrement(unit_inc);
		
		/*PF: Set new block increments for
		 * Vertical and Horizontal scroll bars
		 * This changes how quickly the scroll bar
		 * scrolls when pressing on the track
		 * (area the slider is not on)
		 */
		vertical.setBlockIncrement(block_inc);
		horizontal.setBlockIncrement(block_inc);
	}

}
