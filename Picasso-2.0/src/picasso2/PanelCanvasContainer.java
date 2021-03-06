package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/*PF: This is the container that holds Canvas
 * **NOTE** This is also the viewport for JScrollPane
 * Observer of Canvas
 */

public class PanelCanvasContainer extends JPanel implements InterfaceNewObserver {
	
	private PanelCanvas canvas_panel;
	private PixelInspector pixel_inspector;
	private int se_circle_x;
	private int se_circle_y;
	private int se_circle_radius;
	private Color se_circle_colorfill;
	private Color se_circle_colordraw;
	
	public PanelCanvasContainer(PanelCanvas cp) {
		/*PF: Set Layout to null to 
		 * allow for resizing Canvas
		 */
		setLayout(null);
		
		//PF: Save Canvas into a variable
		canvas_panel = cp;
		
		//PF: Add Canvas to container
		this.add(canvas_panel);
		
		/*PF: Create SE circle for resizing
		 * Set fill (inside) to white
		 * Set draw (border) to black
		 */
		se_circle_x = canvas_panel.getX() + canvas_panel.getWidth() - 2;
		se_circle_y = canvas_panel.getY() + canvas_panel.getHeight() - 2;
		se_circle_radius = 7;
		se_circle_colorfill = Color.WHITE;
		se_circle_colordraw = Color.BLACK;
		
		/*PF: Set preferred size to canvas
		 * width and height + the SE
		 * resize circle to always allow
		 * resizing
		 * **NOTE** The preferred size is
		 * only used as a reference for
		 * JScrollPane's scrollbars.
		 * The true size of CanvasContainer
		 * is decided by the layout
		 * managers of its Containers
		 */
		
		setPreferredSize(new Dimension(canvas_panel.getWidth() + se_circle_radius, 
				canvas_panel.getHeight() + se_circle_radius));
		
		
		//Declare pixel inspector -PF
		pixel_inspector = new PixelInspector(this);
		
		/*PF: Create ResizeListener.
		 * Bottom and Right inset are set
		 * to diameter of SE circle - 1
		 * **NOTE** Insets are empty spaces 
		 * around Canvas where the 
		 * cursor can resize Canvas 
		 * (where cursor turns into resize cursors)
		 */
		ResizeListener rl = new ResizeListener(this, canvas_panel, 0, se_circle_radius*2 - 1, 0, se_circle_radius*2 - 1);
		
		//PF: Add ResizeListener as MouseListener and MouseMotionListener
		addMouseListener(rl);
		addMouseMotionListener(rl);
	}

	//Allows for Canvas Container to set the coords of the mouse
	//Must repaint to allow pixels to change- PF
	public void setPixelInspectorCoords(int x, int y) {
		pixel_inspector.setCoords(x, y);
		repaint();
	}
	
	
	//Allows for Pixel Inspector to get width of screen
	//Will need to clean up this code -PF
	public int getCanvasPanelWidth() {
		return canvas_panel.getWidth();
	}
	
	/*PF: This is the function called 
	 * when the container gets repainted.
	 * Overrides paintComponent of JPanel.
	 * This allows for the SE circle 
	 * for the resize cursor to be drawn
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		se_circle_x = canvas_panel.getX() + canvas_panel.getWidth() - 2;
		se_circle_y = canvas_panel.getY() + canvas_panel.getHeight() - 2;
		
		//PF: Draw SE circle for cursor
		
		//PF: Set fill (interior) color of SE circle
		g.setColor(se_circle_colorfill);
		
		//PF: Fill in this circle with this size
		g.fillOval(se_circle_x, se_circle_y, se_circle_radius, se_circle_radius);
		
		//PF: Set draw (border) color of SE circle
		g.setColor(se_circle_colordraw);
		
		//PF: Draw in this circle with this size
		g.drawOval(se_circle_x, se_circle_y, se_circle_radius, se_circle_radius);
		
		//Repaints pixel_inspector to show new coordinates -PF
		pixel_inspector.paint(g);
	}

	public void update(Object obj) {
		//Void Method lmao
	}
}
