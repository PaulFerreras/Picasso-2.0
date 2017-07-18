package picasso2;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//PF: This is where the color and brightness of the brush is selected

public class PanelColorSelection extends JPanel {
	
	private int width = 400, height = 300;
	private PanelColorPreview color_preview;
	private PanelBrightnessScale brightness_scale;
	private PanelColorWheel color_wheel;

	public PanelColorSelection(ChangeableColor changeable_color) {
		setBounds(0, 0, width, height);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//PF: Create UI
		color_preview = new PanelColorPreview(changeable_color);
		brightness_scale = new PanelBrightnessScale(color_preview);
		color_wheel = new PanelColorWheel(brightness_scale);
		
		//PF: Add UI to ColorSelectionPanel
		//Layout is FlowLayout
		add(color_wheel);
		add(brightness_scale);
		add(color_preview);
	}
	
	public PanelColorWheel getColorWheel() {
		return color_wheel;
	}
	
	public PanelBrightnessScale getBrightnessScale() {
		return brightness_scale;
	}
	
	public PanelColorPreview getColorPreview() {
		return color_preview;
	}

}
