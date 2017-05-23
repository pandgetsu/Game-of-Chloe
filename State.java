import java.awt.Graphics;

public abstract class State 
{
	protected Handler myHandler;
	
	private static State currentState = null;
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	public State(Handler handler)
	{
		myHandler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
