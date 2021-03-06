package test;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class NullAreaPanel extends JPanel implements NewObserver {
	
	private ResizablePanel observed_panel;
	
	public NullAreaPanel(LayoutManager layout) {
		super(layout);
	}

	@Override
	public void update(Object obj) {
		observed_panel = (ResizablePanel) obj;
		int left_side = observed_panel.getLeftSide();
		int right_side = observed_panel.getRightSide();
		int top_side = observed_panel.getTopSide();
		int bottom_side = observed_panel.getBottomSide();
		
		int w = getParent().getWidth();
		int h = getParent().getHeight();
		
		
		if(right_side > w) {
			w = right_side;
		}
		
		if(bottom_side > h) {
			h = bottom_side;
		}

		
		if(left_side < 0) {
			w -= left_side;
		}
		
		if(top_side <0) {
			h -= top_side;
		}
		
		
//		System.out.println("Bottom Side: " + bottom_side);
//		System.out.println("Parent: " + getParent());
//		System.out.println("Get Width: " + w);
//		System.out.println("Get Height: " + h);
//		System.out.println();
		
		if(w != getParent().getWidth() || 
				h != getParent().getHeight() || 
				getWidth() != getParent().getWidth() || 
				getHeight() != getParent().getHeight()) {
			
			setPreferredSize(new Dimension(w, h));
			revalidate();
			
		}
	}

}
