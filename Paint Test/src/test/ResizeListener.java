package test;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

public class ResizeListener implements MouseInputListener {

	private int top_inset, bottom_inset, left_inset, right_inset;
	
	public ResizeListener(Insets border_inset) {
		top_inset = border_inset.top;
		bottom_inset = border_inset.bottom;
		left_inset = border_inset.left;
		right_inset = border_inset.right;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private ResizablePanel current_panel = null;
	private int min_width, min_height;
				
	@Override
	public void mouseEntered(MouseEvent e) {
		current_panel = (ResizablePanel) e.getComponent();
		min_width = (int) current_panel.getMinimumSize().getWidth();
		min_height = (int) current_panel.getMinimumSize().getHeight();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		current_panel = null;
	}

	private Point start_point = null;
	
	@Override
	public void mousePressed(MouseEvent e) {
		start_point = e.getPoint();
//		current_panel.requestFocus();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Reset start point
//		start_point = null;
	}

	private int right_side, bottom_side,
				x, y, w, h, 
				dx, dy;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(current_panel.getCursor() != Cursor.getDefaultCursor()) {

			x = current_panel.getX();
			y = current_panel.getY();
			w = current_panel.getWidth();
			h = current_panel.getHeight();

			right_side = current_panel.getRightSide();
			bottom_side = current_panel.getBottomSide();
			
			dx = e.getX() - start_point.x;
			dy = e.getY() - start_point.y;

			switch(current_panel.getCursor().getType()) {
			case Cursor.NW_RESIZE_CURSOR:
				if(w - dx <= min_width) {
					x = right_side - min_width;
					w = min_width;
				} else {
					x += dx;
					w -= dx;
				}
				
				if(h - dy <= min_height) {
					y = bottom_side - min_height;
					h = min_height;
				} else {
					y += dy;
					h -= dy;
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.N_RESIZE_CURSOR:
				if(h - dy <= min_height) {
					y = bottom_side - min_height;
					h = min_height;
				} else {
					y += dy;
					h -= dy;
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.NE_RESIZE_CURSOR:
				if(w + dx <= min_width) {
					w = min_width;
					start_point.setLocation(min_width - right_inset, start_point.y);
				} else {
					w += dx;
					start_point.setLocation(e.getX(), start_point.y);
				}
				
				if(h - dy <= min_height) {
					y = bottom_side - min_height;
					h = min_height;
				} else {
					y += dy;
					h -= dy;
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.E_RESIZE_CURSOR:
				if(w + dx <= min_width) {
					w = min_width;
					start_point.setLocation(min_width - right_inset, start_point.y);
				} else {
					w += dx;
					start_point.setLocation(e.getX(), start_point.y);
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.SE_RESIZE_CURSOR:
				if(w + dx <= min_width) {
					w = min_width;
					start_point.setLocation(min_width - right_inset, start_point.y);
				} else {
					w += dx;
					start_point.setLocation(e.getX(), start_point.y);
				}
				
				if(h + dy <= min_height) {
					h = min_height;
					start_point.setLocation(start_point.x, min_height - bottom_inset);
				} else {
					h += dy;
					start_point.setLocation(start_point.x, e.getY());
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.S_RESIZE_CURSOR:
				if(h + dy <= min_height) {
					h = min_height;
					start_point.setLocation(start_point.x, min_height - bottom_inset);
				} else {
					h += dy;
					start_point.setLocation(start_point.x, e.getY());
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.SW_RESIZE_CURSOR:
				if(w - dx <= min_width) {
					x = right_side - min_width;
					w = min_width;
				} else {
					x += dx;
					w -= dx;
				}
				
				if(h + dy <= min_height) {
					h = min_height;
					start_point.setLocation(start_point.x, min_height - bottom_inset);
				} else {
					h +=dy;
					start_point.setLocation(start_point.x, e.getY());
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.W_RESIZE_CURSOR:
				if(w - dx <= min_width) {
					x = right_side - min_width;
					w = min_width;
				} else {
					x += dx;
					w -= dx;
				}
				
//				setBounds(x, y, w, h);
				break;
				
			case Cursor.MOVE_CURSOR:
				x += dx;
				y += dy;
//				setBounds(x, y, w, h);
				break;
			}
			
			setBounds(x, y, w, h);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		current_panel.setCursor(this.getCursor(e.getX(),e.getY()));
	}
	
	private Cursor getCursor(int x, int y) {
		if(y <= top_inset) {
			if(x < left_inset) {
				return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
			} else if (x < current_panel.getWidth() - right_inset) {
				return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
			} else {
				return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
			}
			
			
		}else if(x >= current_panel.getWidth() - right_inset) {
			if(y < current_panel.getHeight() - bottom_inset) {
				return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
			} else {
				return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
			}
			
			
		}else if(y >= current_panel.getHeight() - bottom_inset) {
			if(x < left_inset) {
				return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
			} else {
				return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
			}
			
			
		}else if(x <= left_inset) {
			return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
			
		} else {
			return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		}
	}
	
	private void setBounds(int x, int y, int w, int h) {
		current_panel.setBounds(x, y, w, h);
		current_panel.getParent().revalidate();
	}

}
