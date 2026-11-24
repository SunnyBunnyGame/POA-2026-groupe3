package SceneComponent;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Sprite 
{
	public Point position;
	public int width;
	public int height;
	public BufferedImage im;
	
	public Sprite(Point p, int width, int height, BufferedImage im) 
	{
		position = p;
		this.width = width;
		this.height = height;
		this.im = im;
	}
	
	public void ChangeIm(BufferedImage im) {
        this.im = im;
    }
}
