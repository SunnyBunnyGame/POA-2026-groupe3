package AssetManager;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Asset {
	private static final String BASE_PATH = "/Asset/";
	
	public static BufferedImage GetIm(String name)
	{
		BufferedImage im = null;
		try 
		{
			im = ImageIO.read(Asset.class.getResourceAsStream(BASE_PATH + name + ".png"));
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
		
		return im;
	}
}
