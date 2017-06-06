package picasso2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is the UI of the BrushTool

public class BrushPanel extends JPanel {

	public BrushPanel() {
		//PF: Set Layout to null
		setLayout(null);
		
		//PF: Set Border to black line border
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Set preferred size
		setPreferredSize(new Dimension(400, 300));
		
		//PF: Create panels
		ColorSelectionPanel color_selection_panel = new ColorSelectionPanel();
		
		//PF: Add panels
		add(color_selection_panel);
	}

}