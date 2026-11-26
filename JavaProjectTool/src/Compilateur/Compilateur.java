package Compilateur;

import java.awt.Point;

import AssetManager.Asset;
import Core.Core;
import EventManager.CompilateurEvent;
import SceneComponent.TextArea;
import SceneComponent.SceneComponent;
import SceneComponent.Sprite;

public class Compilateur 
{
	private Core core;
	private CompilateurEvent eventManager;
	
	public String name;
	public String grade;
	
	public SceneComponent scene;
	public TextArea script;
	
	public Compilateur(Core core) 
	{
		this.core = core;
		this.eventManager = new CompilateurEvent(this);
		
		this.scene = new SceneComponent();
		SetScene();
		
	}

	
	/*
	 * Scene Creation
	 */
	private void SetScene() 
	{
		// Sprite
		scene.sprite.add(new Sprite(new Point(300,0), 160, 160, Asset.GetIm("Yellow")));			// Changer d'image
		
		//Button
		// Créer un bouton Run

		// TextArea
		script = new TextArea(new Point(400, 400), 1000, 1000, "");
		scene.text.add(script);
		
	}
}
	
