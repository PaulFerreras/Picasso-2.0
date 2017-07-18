package picasso2;

import java.awt.Color;

//PF: Wrapper for Color that has getters and setters
//Allows for sharing of same color between different classes

public class ChangeableColor {

	private Color color;
	
	public ChangeableColor() {
		color = Color.BLACK;
	}
	
	public ChangeableColor(Color c) {
		color = c;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}

}
