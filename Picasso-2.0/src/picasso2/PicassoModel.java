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
	
	public PicassoModel() {
		
		/*PF: Instantiate Plain White Buffered Image
		 * Used as starting image when application opens
		 * Note: Graphics2D and Graphics are similar,
		 * however; Graphics2D support more complex drawing
		 */
		buffered_image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		
	}
	
	public void setBufferedImage(BufferedImage new_buffered_image) {
		buffered_image = new_buffered_image;
		return;
	}
	
	public BufferedImage getBufferedImage() {
		return buffered_image;
	}

}
