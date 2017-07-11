package picasso2;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//PF: This is what is running the main program

public class Main {
	
	public static void main(String[] args) {
		
		/* PF: All Swing code must be created
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
		
		//PF: JFrame
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Picasso");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PF: MenuBar
		MenuBar menu_bar = new MenuBar();
		main_frame.setJMenuBar(menu_bar);
		
		//PF: Instantiate Model, View, and Controller
		MainModel model = new MainModel();
		MainView view = new MainView(model);
		MainController controller = new MainController(model, view);
		
		main_frame.setContentPane(view);
		main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);            //Set Maximized at Start
		main_frame.setMinimumSize(new Dimension(230, 0));
		main_frame.pack();
		main_frame.setVisible(true);
		
	}

}
