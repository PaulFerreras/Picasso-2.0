package picasso2;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JToolBar;

//PF: This is the where the UI of all of the tools are created

public class ToolBarToolUI extends AbstractToolBar {
	
	private PanelColorSelection color_selection_panel;
	private JPanel brush_tool_panel;

	public ToolBarToolUI(ChangeableColor changeable_color) {
		setOrientation(JToolBar.VERTICAL);
		
		color_selection_panel = new PanelColorSelection(changeable_color);
		
		//PF: Panels
		brush_tool_panel = new JPanel(null);
		brush_tool_panel.setPreferredSize(new Dimension(400, 300));
		
		//PF: set as BrushToolPanel to start
		setBrushToolPanel();
	}
	
	private void setBrushToolPanel() {
		brush_tool_panel.add(color_selection_panel);
		add(brush_tool_panel);
	}
	
	public PanelColorWheel getColorWheel() {
		return color_selection_panel.getColorWheel();
	}
	
	public PanelBrightnessScale getBrightnessScale() {
		return color_selection_panel.getBrightnessScale();
	}

}
