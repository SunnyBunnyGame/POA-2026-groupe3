package EventManager;

import Advancement.Advance;

public class AdvanceEvent {
	
	private Advance advance;
	
	public AdvanceEvent(Advance advance)
	{
		this.advance = advance;
	}
	
	public Runnable ChangeScore(int grind)
	{
		Runnable act = () -> 
		{
            advance.score += grind;
            advance.scoreLabel.ChangeLabel(String.valueOf(advance.score));
        };
		
		return act;
	}
}
