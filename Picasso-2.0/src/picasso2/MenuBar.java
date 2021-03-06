package picasso2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

//PF: This is the Menubar of the program

public class MenuBar extends JMenuBar implements ActionListener {

	private JMenu file_menu;
	private JMenuItem open_menu_item, save_menu_item;
	
	public MenuBar() {
		//PF: Create JMenus
		file_menu = new JMenu("File");
		
		//PF: Create JMenuItems
		open_menu_item = new JMenuItem("Open", 'o');
		save_menu_item = new JMenuItem("Save", 's');
		
		//PF: Add MenuBar as an ActionListener to Menu Items
		open_menu_item.addActionListener(this);
		save_menu_item.addActionListener(this);
		
		//PF: Set Action Commands for Menu Items
		open_menu_item.setActionCommand("Open");
		save_menu_item.setActionCommand("Save");
		
		//PF: Add Hotkeys options to Menu Items
		open_menu_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		save_menu_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		//PF: Add JMenuItems to File Menu
		file_menu.add(open_menu_item);
		file_menu.add(save_menu_item);
		
		//PF: Add JMenus to MenuBar
		add(file_menu);
	}

	
	//PF: Action Listener for Menu Items
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*PF: Switch case is used to determine 
		 * which menu item is pressed through 
		 * its action command
		 */
		switch(e.getActionCommand()) {
		
		//PF: Code for what happens when open is pressed
		case "Open":
			System.out.println("Open menu item was pressed");
			break;
		
		//PF: Code for what happens when save is pressed
		case "Save":
			System.out.println("Save menu item was pressed");
			break;
		
		}
		
	}

}
