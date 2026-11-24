package EventManager;

public class Event 
{
	private Runnable act;
	
	public Event(Runnable act) 
	{
		this.act = act;
	}

	public void Execute() 
	{
		act.run();
		
	}
}
