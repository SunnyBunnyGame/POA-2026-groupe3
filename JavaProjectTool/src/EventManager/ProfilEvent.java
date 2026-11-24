package EventManager;

import java.awt.Point;

import Profil.Profil;
import SceneComponent.SceneComponent;
import SceneComponent.Sprite;

public class ProfilEvent {
	
	private Profil profil;
	
	public ProfilEvent(Profil profil)
	{
		this.profil = profil;
	}
	
	public Runnable SwitchCurrentScene(SceneComponent scene)
	{
		Runnable act = () -> 
		{
            profil.currentScene = scene;
        };
		
		return act;
	}
	
	public Runnable SwitchPdp(boolean right) {
	    return () -> {

	        int index = profil.listIm.indexOf(profil.SpritePdp.im);

	        // true = droite, false = gauche
	        if (right)
	            index++;
	        else
	            index--;

	        // Boucler sur la liste
	        if (index >= profil.listIm.size())
	            index = 0;

	        if (index < 0)
	            index = profil.listIm.size() - 1;

	        // Changer uniquement l'image
	        profil.SpritePdp.ChangeIm(profil.listIm.get(index));
	        profil.ButtonPdp1.ChangeIm(profil.listIm.get(index));
	        profil.ButtonPdp2.ChangeIm(profil.listIm.get(index));

	        System.out.println(index);
	    };
	}
}
