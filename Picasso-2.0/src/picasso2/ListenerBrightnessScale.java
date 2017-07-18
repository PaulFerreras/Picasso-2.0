package picasso2;

import java.awt.event.MouseEvent;

public class ListenerBrightnessScale extends AbstractChooserListener {
	
	private PanelBrightnessScale brightness_scale;
	private int top_boundary, bottom_boundary;
	
	public ListenerBrightnessScale(PanelBrightnessScale pbs) {
		super(pbs.getBoundary());
		
		brightness_scale = pbs;
		
		top_boundary = (int) ((pbs.getPreferredSize().getHeight() 
				- pbs.getBrightnessScaleHeight())/2);
		
		bottom_boundary = (int) ((pbs.getPreferredSize().getHeight()  
				- top_boundary  
				- pbs.getSelectorHeight()));
	}

	@Override
	public void moveSelector(int x, int y) {
		brightness_scale.moveSelector(x, y);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(in_bounds) {
			if(e.getY() < top_boundary) {
				moveSelector(e.getX(), top_boundary);
			} else if (e.getY() > bottom_boundary) {
				moveSelector(e.getX(), bottom_boundary);
			} else {
				moveSelector(e.getX(), e.getY());
			}
		}
	}

}
