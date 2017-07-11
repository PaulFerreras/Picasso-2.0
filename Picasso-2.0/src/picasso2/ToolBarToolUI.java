package picasso2;

import javax.swing.JToolBar;

//PF: This is the where the UI of all of the tools are created

public class ToolBarToolUI extends AbstractToolBar {

	public ToolBarToolUI() {
		setOrientation(JToolBar.VERTICAL);
		
		//PF: Panels
		PanelBrushTool brush_tool_panel = new PanelBrushTool();
		
		//PF: Add Panels
		add(brush_tool_panel);
	}

}
