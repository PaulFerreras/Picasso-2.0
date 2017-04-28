package picasso2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

//PF: This is where the buffered image is located

public class PicassoModel {

	private BufferedImage buffered_image;
	private Graphics2D g2;
	
	public PicassoModel() {
		
		/*PF: Instantiate Plain 
		 * White Buffered Image
		 * Used as starting image 
		 * when application opens
		 * Note: Graphics2D and 
		 * Graphics are similar,
		 * however; Graphics2D support 
		 * more complex drawing
		 */
		buffered_image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		
		/*PF: To set the buffered image white,
		 * used the graphics to draw a white
		 * rectangle the size of the 
		 * buffered image
		 */
		g2 = buffered_image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, buffered_image.getWidth(), buffered_image.getHeight());
		g2.dispose();
		
	}
	
	//PF: Sets buffered image
	public void setBufferedImage(BufferedImage new_buffered_image) {
		buffered_image = new_buffered_image;
		return;
	}
	
	
	//PF: Returns buffered image
	public BufferedImage getBufferedImage() {
		return buffered_image;
	}

	//PF: Method used to draw on the buffered image
	public void draw(int x, int y) {
		g2 = buffered_image.createGraphics();
		g2.setColor(Color.BLACK);
		g2.fillOval(x, y, 10, 10);
		g2.dispose();
	}

}
