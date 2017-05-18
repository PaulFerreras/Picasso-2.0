package picasso2;

import java.awt.Cursor;

import javax.swing.event.MouseInputAdapter;

abstract public class AbstractTool extends MouseInputAdapter {
	
	public AbstractTool() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Cursor getCursor();

}
