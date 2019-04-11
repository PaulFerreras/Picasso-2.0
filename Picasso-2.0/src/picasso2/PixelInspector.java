package picasso2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class PixelInspector {

	private int cursor_x, cursor_y;
	private Color border_color = Color.BLACK, 
			fill_color = Color.GRAY, 
			text_color = Color.WHITE;
	private RoundRectangle2D coor_x_shape, coor_y_shape;
	
	public PixelInspector(PanelCanvasContainer cc) {
		
		//Set shapes of pixel inspector to be Round Rectangles - PF
		coor_x_shape = new RoundRectangle2D.Float(cc.getCanvasPanelWidth() + 100, 100, 40, 30, 10, 10);
		//coor_y_shape = new RoundRectangle2D.Float(cc.getCanvasPanelWidth(), 0, 40, 30, 10, 10);
		
		
	}
	
	public void setCoords(int x, int y) {
		cursor_x = x;
		cursor_y = y;
	}
	
	public void paint(Graphics g) {
		//Needs g2 graphics to draw ellipse -PF
		Graphics2D g2 = (Graphics2D) g;
		
		
		//Set color to fill_color declared at beginning of class - PF
		g2.setColor(fill_color);
		
		
		//Draw ellipses - PF
		g2.fill(coor_x_shape);
		//g2.fill(coor_y_shape);
		
		//Set color to border color and draw borders
		g2.setColor(border_color);
		g2.draw(coor_x_shape);
		
		//Set color to text color and write text
		g2.drawString("X is " + cursor_x, (int) coor_x_shape.getX(), (int) coor_x_shape.getY());
		
	}

}
