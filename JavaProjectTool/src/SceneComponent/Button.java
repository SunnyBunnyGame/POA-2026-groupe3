package SceneComponent;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import EventManager.Event;

@SuppressWarnings("serial")
public class Button extends JButton
{
	public Point position;
	public BufferedImage im;
	public String label;
	
	private Event event;
	
	// Constructeur principal
    public Button(Point p, int width, int height) 
    {

        this.position = p;
        this.setBounds(p.x, p.y, width, height);

        // Position du texte sur l'image
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);

        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        
        // Apparence
        this.setIconTextGap(0);

        this.addActionListener(e -> ExecuteEvent());
    }
	
	/*
	 * Other Call
	 */
    public Button(Point p, int width, int height, String label, BufferedImage im) 
    {
        this(p, width, height);

        ChangeLabel(label);
        ChangeIm(im);
    }
	
    public Button(Point p, int width, int height, String label) 
    {
        this(p, width, height);

        ChangeLabel(label);
    }
    
    public Button(Point p, int width, int height, BufferedImage im) 
    {
        this(p, width, height);

        ChangeIm(im);
    }

	/*
	 * Buttons Functions
	 */
	public void ChangeIm(BufferedImage im)
	{
		this.im = im;

		if (im == null)
            return;

        Image resized = im.getScaledInstance(
            this.getWidth(),
            this.getHeight(),
            Image.SCALE_SMOOTH
        );

        this.setIcon(new ImageIcon(resized));
		
	}
	
	public void ChangeLabel(String label) 
	{
		this.label = label;
		this.setText(label);
	}
	
	public void AddEvent(Runnable act) 
	{
		this.event = new Event(act);
	}
	
	public void ExecuteEvent()
	{
		if(event != null)
	        event.Execute();
	    
	}
	
}
