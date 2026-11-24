package SceneComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TextArea extends JTextArea{
	
	public Point position;
	public String text;
	
	
    public TextArea(Point p, int width, int height, String text) 
    {
    	super(text);

        this.position = p;
        this.text = text;

        setFont(new Font("Consolas", Font.PLAIN, 14));
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);

        setBounds(position.x, position.y, width, height);
    }

    
    public String GetContent() 
    {
        return getText();
    }
    
    public String[] GetListContent() {
        return getText().split("\\R");
    }
    
}
