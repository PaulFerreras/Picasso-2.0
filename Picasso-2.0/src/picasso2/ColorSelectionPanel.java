package picasso2;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the color and brightness of the brush is selected

public class ColorSelectionPanel extends JPanel {

	public ColorSelectionPanel() {
		//PF: Set Bounds
		setBounds(0, 0, 400, 300);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Create UI
		ColorWheel color_wheel = new ColorWheel();
		BrightnessScale brightness_scale = new BrightnessScale();
		
		/*PF: Add UI to ColorSelectionPanel
		 * Layout is FlowLayout
		 */
		add(color_wheel);
		add(brightness_scale);
	}

}
