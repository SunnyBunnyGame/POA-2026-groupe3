package SceneComponent;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Label extends JLabel
{
	public Point position;
	public String label;
	public Font font;
	public Dimension size;
	
	public Label(Point p, String label, Font font) 
	{
		this.position = p;
		this.label = label;
		this.font = font;
		
		this.setText(label);
        this.setFont(font);
		
        this.size = this.getPreferredSize();
		this.setBounds(p.x, p.y, size.width, size.height);
	}
	
	
	public void ChangeLabel(String label)
	{
		this.label = label;
		this.setText(label);
		
		this.size = this.getPreferredSize();
		this.setBounds(position.x, position.y, size.width, size.height);
	}

}
