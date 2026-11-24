package Main;

import Core.Core;
import Renderer.Renderer;

/*
 * Boucle d'action a faire en continue
 */
public class Loop 
{
	
	private Core core;
	private Renderer renderer;
	
	private int FPS = 30;
	
	public Loop(Core core, Renderer renderer) 
	{
		this.core = core;
		this.renderer = renderer;
	}
	
	public void StartLoop() {
		
		int frame = 1000000000;								// une frame
		
		double nbUpdate = (1.0*frame) / FPS;				// nb de calcule
		
        double deltaUpdate = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (true) 
        {
        	// Gestion du temps
            currentTime = System.nanoTime();
            deltaUpdate += (currentTime - lastTime) / nbUpdate;
            lastTime = currentTime;

            if (deltaUpdate >= 1) {
            	// Update
                core.Update();
                renderer.repaint();
                
                deltaUpdate--;
            }
        }
	}
	
	
}
