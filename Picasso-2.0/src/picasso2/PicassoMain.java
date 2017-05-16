package picasso2;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//PF: This is what is running the main program

public class PicassoMain {
	
	public static void main(String[] args) {
		
		/*PF: All Swing code must be created
		 * and invoked in the Event Dispatch Thread
		 * (EDT). This is to prevent deadlock and
		 * random bugs from occuring.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		
	}

	//PF: Create GUI on Event Dispatch Thread
	private static void createAndShowGUI() {
		/*PF: Instantiate Mainframe
		 *Set Title
		 *Set to EXIT_ON_CLOSE
		 */
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Picasso");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*PF: Instantiate Menubar
		 * Set Mainframe's Menubar
		 */
		PicassoMenuBar menu_bar = new PicassoMenuBar();
		main_frame.setJMenuBar(menu_bar);
		
		//PF: Instantiate Model, View, and Controller
		PicassoModel model = new PicassoModel();
		PicassoView view = new PicassoView(model);
		PicassoController controller = new PicassoController(model, view);
		
		//PF: Set View as ContentPane of MainFrame
		main_frame.setContentPane(view);
		
		//PF: Set Frame to Maximized at start
		//main_frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
		//PF: Set minimum size for Frame
		main_frame.setMinimumSize(new Dimension(350, 400));
		
		/*PF: Pack pushes everything together
		 * (When screen is not maximized)
		 *Mainframe set to visible 
		 */
		main_frame.pack();
		main_frame.setVisible(true);
		
	}

}
