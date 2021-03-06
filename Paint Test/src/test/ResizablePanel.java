package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ResizablePanel extends JPanel implements NewObservable {
	
	private ResizableBorder resizable_border;
	private Insets border_insets;
	private NewObserver observer;

	public ResizablePanel() {
		setBounds(50, 50, 150, 150);
		
		setLayout(new BorderLayout());
		
		setMinimumSize(new Dimension(100, 100));
		
		resizable_border = new ResizableBorder();
		
		setBorder(resizable_border);
		
		border_insets = resizable_border.getBorderInsets(this);
		
		ResizeListener resize_listener = new ResizeListener(border_insets);
		
		addMouseListener(resize_listener);
		addMouseMotionListener(resize_listener);
		
//		ResizeAndDragListener resize_and_drag_listener = new ResizeAndDragListener(border_insets);
//				
//		addMouseListener(resize_and_drag_listener);
//		addMouseMotionListener(resize_and_drag_listener);
	}
	
	public int getLeftSide() {
		return getLocation().x;
	}
	
	public int getTopSide() {
		return getLocation().y;
	}
	
	public int getRightSide() {
		return getLocation().x + getWidth();
	}
	
	public int getBottomSide() {
		return getLocation().y + getHeight();
	}

	@Override
	public void addObserver(NewObserver o) {
		observer = o;
	}

	@Override
	public void notifyObserver() {
		observer.update(this);
	}
	
	@Override
	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		
		if(observer != null) notifyObserver();
	}
	
}
