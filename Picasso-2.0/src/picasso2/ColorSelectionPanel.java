package picasso2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where different colors are chosen

public class ColorSelectionPanel extends JPanel {

	public ColorSelectionPanel() {
		//PF: Set Border to black line border
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setPreferredSize(new Dimension(300, 200));
	}

}
