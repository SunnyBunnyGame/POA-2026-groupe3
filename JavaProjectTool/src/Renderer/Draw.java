package Renderer;

import java.awt.Graphics2D;

import SceneComponent.*;

public class Draw 
{
	public Draw()
	{
		
	}
	
	public void DrawSprite(Graphics2D g2, Sprite s)
	{
		g2.drawImage(s.im, s.position.x, s.position.y, s.width, s.height, null);
	}
	
	// Surement pas besoin
	public void DrawButton(Graphics2D g2, Button b) 
	{
		
	}

	public void DrawLabel(Graphics2D g2, Label l) {
		// TODO Auto-generated method stub
		
	}
	
}
