package SceneComponent;

import java.util.ArrayList;

/*
 * Zone où on place Tout les composants du systeme pour le stockage et aider l'affichage
 */
public class SceneComponent 
{
	
	public ArrayList<Sprite> sprite;
	public ArrayList<Button> button;
	public ArrayList<Label> label;
	
	public SceneComponent() 
	{
		sprite = new ArrayList<Sprite>();
		button = new ArrayList<Button>();
		label = new ArrayList<Label>();
	}
	
}
