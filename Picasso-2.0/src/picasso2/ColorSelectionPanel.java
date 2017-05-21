package picasso2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ColorSelectionPanel extends JPanel {

	public ColorSelectionPanel() {
		//PF: Set Bounds
		setBounds(0, 0, 400, 300);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		ColorWheel color_wheel = new ColorWheel();
		
		add(color_wheel);
	}

}
