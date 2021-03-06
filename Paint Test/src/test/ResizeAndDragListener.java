package test;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class ResizeAndDragListener extends MouseInputAdapter {

	private int top_inset, bottom_inset, left_inset, right_inset,
				min_height, min_length;
	
	public ResizeAndDragListener(Insets border_inset) {
		top_inset = border_inset.top;
		bottom_inset = border_inset.bottom;
		left_inset = border_inset.left;
		right_inset = border_inset.right;
	}

	private Component current_panel = null;
	
	@Override
	public void mouseEntered(MouseEvent e) {
		current_panel = e.getComponent();
	}
	
	private int mx, my;
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		if(my <= top_inset) {
			if(mx < left_inset) {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
			} else if (mx < current_panel.getWidth() - right_inset) {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
			} else {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
			}
			
			
		}else if(mx >= current_panel.getWidth() - right_inset) {
			if(my < current_panel.getHeight() - bottom_inset) {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			} else {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
			}
			
			
		}else if(my >= current_panel.getHeight() - bottom_inset) {
			if(mx < left_inset) {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
			} else {
				current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
			}
			
			
		}else if(mx <= left_inset) {
			current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
			
		} else {
			current_panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
	}
	
	private Point start_point = null;
	
	@Override
	public void mousePressed(MouseEvent e) {
		start_point = e.getLocationOnScreen();
	}
	
	private int cx, cy, cw, ch, dx, dy;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
}
