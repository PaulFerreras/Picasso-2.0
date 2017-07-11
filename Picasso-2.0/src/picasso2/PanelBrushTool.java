package picasso2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is the UI of the BrushTool

public class PanelBrushTool extends JPanel {
	
	private Dimension preferred_size = new Dimension(400, 300);

	public PanelBrushTool() {
		setLayout(null);
		setPreferredSize(preferred_size);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Panels
		PanelColorSelection color_selection_panel = new PanelColorSelection();
		
		//PF: Add panels
		add(color_selection_panel);
	}

}
