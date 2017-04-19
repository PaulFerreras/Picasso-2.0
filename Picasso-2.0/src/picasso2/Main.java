package picasso2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Main {

	public static void main(String[] args) {
		
		paint();
		g2.draw(new Line2D.Double(x1, y1, x2, y2));

	}

	
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	}
}
