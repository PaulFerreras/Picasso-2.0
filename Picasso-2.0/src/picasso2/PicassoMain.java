package picasso2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PicassoMain {

	public static void main(String[] args) {
		
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
		
		/*PF: Pack pushes everything together
		 *Mainframe set to visible 
		 */
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
