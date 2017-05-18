package picasso2;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*PF: This is where the actual buffered image is rendered
 * Observable to CanvasConainer
 */

public class CanvasPanel extends JPanel implements INewObservable {
	
	private PicassoModel model;
	private INewObserver observer;
	
	public CanvasPanel(PicassoModel model) {
		//PF: Set bounds of Canvas
		setBounds(0, 0, 300, 300);
		
		//PF: Set MinimumSize of Canvas
		setMinimumSize(new Dimension(100, 100));
		
		//PF: Set MaximumSize of Canvas
		setMaximumSize(new Dimension(2000, 2000));
		
		//PF: Set Border to Black Line Border
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Store model in internal private variable
		this.model = model;
		
		//PF: Set observer to null
		observer = null;
		
	}
	
	/*PF: This is the function called 
	 * when the Canvas gets repainted.
	 * Overrides paintComponent of JPanel.
	 * This allows Buffered Images to be drawn
	 */
	@Override
	public void paintComponent(Graphics g) {
		/* PF: Send graphics to JPanel above.
		 * Allows the background of the component
		 * to be opaque
		 */
		super.paintComponent(g);
		
		//PF: Draw Buffered Image at (0,0)
		g.drawImage(model.getBufferedImage(), 0, 0, null);
	}
	
	/*PF: Returns the location of the left-side 
	 * of the canvas based off its container
	 */
	public int getLeftSide() {
		return getLocation().x;
	}

	/*PF: Returns the location of the top-side 
	 * of the canvas based off its container
	 */
	public int getTopSide() {
		return getLocation().y;
	}
	
	/*PF: Returns the location of the right-side 
	 * of the canvas based off its container
	 */
	public int getRightSide() {
		return getLocation().x + getWidth();
	}
	
	/*PF: Returns the location of the bottom-side 
	 * of the canvas based off its container
	 */
	public int getBottomSide() {
		return getLocation().y + getHeight();
	}

	//PF: Adds NewObserver into internal private variable observer
	@Override
	public void addObserver(INewObserver o) {
		observer = o;
	}

	//PF: Notifies the observer
	@Override
	public void notifyObserver(Object obj) {
		observer.update(obj);
	}
	
	/*PF: Sets Bounds for CanvasPanel
	 * Overridden to notify observer (Canvas Container)
	 * when resized so that JScrollPane can update
	 */
	@Override
	public void setBounds(int x, int y, int width, int height) {
		//PF: Delegates method to super class
		super.setBounds(x, y, width, height);
		
		/*PF: Notifies observer, but only 
		 * when observer is non-null
		 * Parameter is null because
		 * does not need to update with any info
		 */
		if (observer != null) notifyObserver(null);
	}
}
