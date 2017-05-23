import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * A particular game state where the player has died.
 */
public class DiedState extends State
{
	//class variables
	private State dungeonState;
	
	private Handler myHandler;
	
	//default constructor
	public DiedState(Handler handler)
	{
		super(handler);
		
		myHandler = handler;
		
		/*
		gameInstance = new DungeonInstance(handler, "resources/instances/instance01.txt");
		handler.setInstance(gameInstance);
		mainPlayer = new Player(handler, gameInstance.getSpawnX() * 32, gameInstance.getSpawnY() * 32);*/
		
	}
	
	public void tick() 
	{
		/*
		gameInstance.tick();
		mainPlayer.tick();*/
	}

	/**
	 * The render() method for the DiedState class is unlike any other render method. It initially renders the image that indicates to the user
	 * that the player has died. Then a timer is set for 5000 milliseconds(5 seconds) and at the conclusion of those 5000 milliseconds, the game
	 * is returned to its initial state.
	 */
	public void render(Graphics g) 
	{
		g.drawImage(Assets.diedState, 0, 0, null); //draws died screen
		
		dungeonState = new DungeonState(myHandler); //new dungeon state

		
		//timer prep
		Timer timer = new Timer(5000, new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
				State.setState(dungeonState); //event to occur after 5000 milliseconds
		  }
		} );
		timer.setRepeats(false);
		timer.start(); //timer start
	}
	
}
