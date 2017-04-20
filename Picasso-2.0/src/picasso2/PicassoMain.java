package picasso2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PicassoMain {

	public static void main(String[] args) {
		
		/*PF: Instantiate Mainframe
		 *Set Title
		 *Set to EXIT_ON_CLOSE
		 *Set size to 500x500
		 */
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Picasso");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//main_frame.setSize(500, 500);
		
		/*PF: Instantiate Menubar
		 * Set Mainframe's Menubar
		 */
		PicassoMenuBar menu_bar = new PicassoMenuBar();
		main_frame.setJMenuBar(menu_bar);
		
//		/*PF: Create MainPanel that will hold the picture
//		 * Set color to White
//		 */
//		JPanel main_panel = new JPanel();
//		main_panel.setBackground(Color.WHITE);
//		
//		//PF: Create blank Buffered Image
//		BufferedImage main_image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
//		
//		Graphics2D g2 = main_image.createGraphics();
//		g2.drawImage(main_image, 0, 0, null);
//		
//		//PF: MainPanel is placed inside of Mainframe
//		main_frame.setContentPane(main_panel);
		
		/*PF: Pack pushes everything together
		 *Mainframe set to visible 
		 */
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
