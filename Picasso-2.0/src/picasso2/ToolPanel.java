package picasso2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the different tools are chosen

public class ToolPanel extends JPanel {

	public ToolPanel() {
		//PF: Set to BorderLayout
		setLayout(new BorderLayout());
		
		//PF: Set Border to Black Line Border
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Set preferred size
		setPreferredSize(new Dimension(500, 100));
	}

}
