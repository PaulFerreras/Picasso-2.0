package picasso2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/*PF: This is the container that holds Canvas
 * **NOTE** This is also the viewport for JScrollPane
 */

public class CanvasContainer extends JPanel {
	
	private CanvasPanel canvas_panel;
	private int se_circle_x;
	private int se_circle_y;
	private int se_circle_radius;
	private Color se_circle_colorfill;
	private Color se_circle_colordraw;
	
	public CanvasContainer(CanvasPanel cp) {
		/*PF: Set Layout to null to 
		 * allow for resizing Canvas
		 */
		setLayout(null);
		
		//PF: Save Canvas into a variable
		canvas_panel = cp;
		
		//PF: Add Canvas to container
		this.add(canvas_panel);
		
		//PF: Create SE circle for cursor
		se_circle_x = canvas_panel.getX() + canvas_panel.getWidth() - 2;
		se_circle_y = canvas_panel.getY() + canvas_panel.getHeight() - 2;
		se_circle_radius = 7;
		se_circle_colorfill = Color.WHITE;
		se_circle_colordraw = Color.BLACK;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//PF: Draw SE circle for cursor
		g.setColor(se_circle_colorfill);
		g.fillOval(se_circle_x, se_circle_y, se_circle_radius, se_circle_radius);
		g.setColor(se_circle_colordraw);
		g.drawOval(se_circle_x, se_circle_y, se_circle_radius, se_circle_radius);
	}
}
