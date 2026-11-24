package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

import Input.Input;

/*
 * Gestionnaire pour la Frame
 */
@SuppressWarnings("serial")
public class Frame extends JFrame
{
	
	private final String Title = "JavaProject";
	private final Dimension FrameDim = new Dimension(2000,1000);
	
	// Initialisation
	public Frame(Input input) 
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setTitle(Title);
	    this.setPreferredSize(FrameDim);
	    this.setLocation(0,0);
	    
	    SetListener(input);
	}
	
	public void Visible() 
	{
		this.pack();
		this.setVisible(true);
	}
	
	/*
	 * Si besoin de lui ajouté des Listeners spécifique
	 */
	private void SetListener(Input input) 
	{
		
		this.addMouseListener(input.mouse);
		this.addMouseMotionListener(input.mouse);
		
		this.addKeyListener(input.keys);
	}
}
