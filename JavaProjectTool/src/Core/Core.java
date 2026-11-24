package Core;

import Advancement.Advance;
import Input.Input;
import Profil.Profil;
import Setting.InputConst;

/*
 * Corp du jeu
 */
public class Core 
{
	
	private Input input;
	
	public int currentLvl;
	public int topLvl;
	
	public Advance advance;
	public Profil profil;
	
	public Core(Input input) 
	{
		this.input = input;
		
		currentLvl = 1;
		topLvl = Math.max(currentLvl, topLvl);
		
		advance = new Advance(this);
		profil = new Profil(this, "Moi");
	}
	
	// Boucle de mise a jour
	public void Update() 
	{
		
		if(input.mouse.click(InputConst.LEFT_CLICK))
			System.out.println("click gauche");
		if(input.mouse.click(InputConst.RIGHT_CLICK))
			System.out.println("click droit");
		if(input.mouse.click(InputConst.WHEEL_CLICK))
			System.out.println("click molette");
		if(input.keys.pressed(InputConst.ENTER))
			System.out.println("entré");
	}
}
