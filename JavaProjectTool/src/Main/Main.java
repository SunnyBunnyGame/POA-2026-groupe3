package Main;

import Core.Core;
import Input.Input;
import Renderer.Renderer;

public class Main 
{
	public static void main(String[] args) 
	{
		
		Input input = new Input();
		
		// Initialisation
		Core core = new Core(input);
		Renderer renderer = new Renderer(core);
		Loop loop = new Loop(core, renderer);
		
		// Create Frame
		Frame frame = new Frame(input);
		frame.add(renderer);
		frame.Visible();
		
		// Start
		loop.StartLoop();
	}
}
