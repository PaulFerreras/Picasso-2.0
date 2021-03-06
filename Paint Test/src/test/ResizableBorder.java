package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class ResizableBorder implements Border {

	private int inset_dist = 10;
	
	public ResizableBorder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(inset_dist, inset_dist, inset_dist, inset_dist);
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.setColor(Color.BLACK);
		g.drawRect(x + (inset_dist-1), y + (inset_dist-1), width - ((inset_dist*2)-1), height - ((inset_dist*2)-1));
		
	}

}
