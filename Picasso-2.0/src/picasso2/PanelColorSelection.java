package picasso2;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the color and brightness of the brush is selected

public class PanelColorSelection extends JPanel {
	
	private int width = 400, height = 300;

	public PanelColorSelection() {
		setBounds(0, 0, width, height);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Create UI
		PanelBrightnessScale brightness_scale = new PanelBrightnessScale();
		PanelColorWheel color_wheel = new PanelColorWheel(brightness_scale);
		
		//PF: Add UI to ColorSelectionPanel
		//Layout is FlowLayout
		add(color_wheel);
		add(brightness_scale);
	}

}
