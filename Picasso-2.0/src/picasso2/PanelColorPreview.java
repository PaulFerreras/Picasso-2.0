package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class PanelColorPreview extends JPanel {
	
	private int width = 50, height = 200;
	private float top_inset = 5, left_inset = 20,
				rectangle_width = 25;
	private Shape rectangle;
	private ChangeableColor changeable_color;

	public PanelColorPreview(ChangeableColor changeable_color) {
		setPreferredSize(new Dimension(width, height));
		
		rectangle = new Rectangle2D.Float(top_inset, left_inset, rectangle_width, rectangle_width);
		
		this.changeable_color = changeable_color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(changeable_color.getColor());
		g2.fill(rectangle);
		
		g2.setColor(Color.BLACK);
		g2.draw(rectangle);
	}
	
	public void setColor(Color c) {
		changeable_color.setColor(c);
		
		repaint();
	}
	
	public Color getColor() {
		return changeable_color.getColor();
	}

}
