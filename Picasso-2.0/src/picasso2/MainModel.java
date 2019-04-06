package picasso2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

//PF: This is where the buffered image is located

public class MainModel {

	private BufferedImage bi, bi_holder;
	private ChangeableColor changeable_color;
	
	public MainModel() {
		
		bi = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_RGB);
		
		//Make buffered image white
		Graphics2D g2 = bi.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, bi.getWidth(), bi.getHeight());
		g2.dispose();
		changeable_color = new ChangeableColor();
	}
	
	public void setBufferedImage(BufferedImage new_bi) {
		bi = new_bi;
		return;
	}
	
	public BufferedImage getBufferedImage() {
		return bi;
	}
	
	public ChangeableColor getChangeableColor() {
		return changeable_color;
	}
	
	public int getWidth() {
		return bi.getWidth();
	}
	
	public int getHeight() {
		return bi.getHeight();
	}
	
	private int previous_x, previous_y;

	//PF: Method used to draw on buffered image
	public void draw(int mouse_event, int x, int y, int brush_size, Color brush_color) {
		
		//Differentiating mouse pressed from mouse dragged
		//Prevents end of a line connecting to the beginning of another
		
		if(mouse_event == MouseEvent.MOUSE_PRESSED) {
			previous_x = x;
			previous_y = y;
		}
		
		Graphics2D g2 = bi.createGraphics();
		g2.setColor(brush_color);
		g2.setStroke(
				new BasicStroke(brush_size, 
						BasicStroke.CAP_ROUND,                   //Cap is round
						BasicStroke.JOIN_ROUND));                //Join is round
		
		//Line2D Allows for smooth drawing
		g2.draw(new Line2D.Float(previous_x, previous_y, x, y));
		g2.dispose();
		
		if(mouse_event == MouseEvent.MOUSE_DRAGGED) {
			previous_x = x;
			previous_y = y;
		}
		
	}
	
	//Used to hold buffered image temporarily when resizing images
	public void setBIHolder() {
		bi_holder = bi;
	}
	
	//Used to resize the buffered image
	public void setBufferedImageSize(int width, int height) {
		
		//Create buffered image with new size
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//Draw old image to the new image.
		Graphics2D g2 = bi.createGraphics();
		g2.setColor(Color.WHITE);                        //Buffered images are naturally black so need to fill up white space.
		g2.fillRect(0, 0, width, height);
		g2.drawImage(bi_holder, 0, 0, null);
		g2.dispose();
	}

}
