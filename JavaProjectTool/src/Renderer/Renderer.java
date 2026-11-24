package Renderer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import Core.Core;
import SceneComponent.*;

/*
 * Zone pour dessiner le Panel de la situation Core
 */


@SuppressWarnings("serial")
public class Renderer extends JPanel
{
	
	private Core core;
	
	private Draw draw;
	
	public Renderer(Core core) 
	{
		this.core = core;
		draw = new Draw();
		
		this.setLayout(null);
	}
	
	
	
	@Override
	public void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        /*
         * Zone pour dessiner
         */
        CleanComponent(g2);
        
        DrawAdvancement(g2);
        DrawProfil(g2);

    }
	
	/*
	 * Clean
	 */
	private void CleanComponent(Graphics2D g2) 
	{
		for(Component c : this.getComponents().clone()) 
		{
			// Advance
			if(ComponentInScene(c, core.advance.scene))
				continue;
				
			// Profil
			if(ComponentInScene(c, core.profil.currentScene))
				continue;
			
			
			this.remove(c);
		}
	}
	
	private boolean ComponentInScene(Component c, SceneComponent scene)
	{
		for(Button b : scene.button)
		{
			if(c == b)
				return true;
		}
		for(Label l : scene.label)
		{
			if(c == l)
				return true;
		}
		for(TextArea t : scene.text)
		{
			if(c == t)
				return true;
		}
		
		return false;
	}
	
	/*
	 * SceneComponent
	 */
	private void DrawScene(Graphics2D g2, SceneComponent scene)
	{
		for(Sprite s : scene.sprite)
		{
			draw.DrawSprite(g2, s);
		}
		for(Button b : scene.button)
		{
			if (b.getParent() != this)
				this.add(b);
				
				
			draw.DrawButton(g2, b);
		}
		for(Label l : scene.label)
		{
			if (l.getParent() != this)
				this.add(l);
				
				
			draw.DrawLabel(g2, l);
		}
		for(TextArea t : scene.text)
		{
			if (t.getParent() != this)
				this.add(t);
			
			draw.DrawText(g2, t);
		}
	}
	

	/*
	 * Advancement
	 */
	private void DrawAdvancement(Graphics2D g2)
	{
		DrawScene(g2, core.advance.scene);
		g2.drawString(String.valueOf(core.advance.score), 100, 600);
	}
	
	/*
	 * Profil
	 */
	private void DrawProfil(Graphics2D g2) {
		DrawScene(g2, core.profil.currentScene);
		
	}
	
}
