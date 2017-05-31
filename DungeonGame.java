import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * The large bulk of the game occurs here and the actual ingame timer is located in this class as well.
 * 
 *
 */
public class DungeonGame implements Runnable
{
    //class variables
	private DungeonGUI myDisplay;
	
	private String myTitle;
	private int myWidth;
	private int myHeight;
	
	public static boolean myFlashlight;

	private boolean gameRunning;
	private Thread myThread;
	
	private BufferStrategy myBuffer;
	private Graphics myGraphics;
	
	private State dungeonState;
	
	private Keyboard keyboard;
	
	private Handler handler;
	
	private MasterGUI myMaster;
	
	//<<DEFAULT CONSTRUCTOR>>
	public DungeonGame(String title, int width, int height , boolean flashlight, MasterGUI parent)
	{
		myTitle = title;
		myWidth = width;
		myHeight = height;
		
		myMaster = parent;
		
		myFlashlight = flashlight;
		
		gameRunning = false;
		
		keyboard = new Keyboard();
	}
	
	/**
	 * The initGame() method initiates all of the game's rendered images before hand for maximum efficiency
	 * when grabbing for the image. 
	 * 
	 * Additionally, it will setup the GUI as well as the instance level.
	 */
	private void initGame()
	{
		Assets.init(); //loads in images
		
		handler = new Handler(this); //this class is very important. my team hates me.
		
		myDisplay = new DungeonGUI(myTitle, handler, myMaster); //creates the GUI of the game
		myDisplay.getFrame().addKeyListener(keyboard); //sets frame to gui
				
		handler.addGUI(myDisplay); //adds gui to the handler so it could be accessed from other classes. OOP wow!
		keyboard.addHandler(handler); //same as above but for keyboard and vice versa.
		
		dungeonState = new DungeonState(handler); 
		State.setState(dungeonState); //set state of game to dungeon
	}
	
	/**
	 * The tick() method helps update different elements of the program that must be checked
	 * constantly.
	 */
	private void tick()
	{
		myDisplay.tick(); //update gui
		keyboard.tick(); //update keyboard
		
		if(State.getState() != null)
		{
			State.getState().tick(); //if there is a state, tick it
		}
	}
	
	/**
	 * The drawToScreen() method draws specifically the dungeon state portion of the game.
	 */
	private void drawToScreen()
	{
		myBuffer = myDisplay.getCanvas().getBufferStrategy(); //send current bufferstrat to buffer of DungeonGame
		
		if(myBuffer == null) //if its null
		{
			myDisplay.getCanvas().createBufferStrategy(2); //create one
			return;
		}
		
		myGraphics = myBuffer.getDrawGraphics(); //graphics g object, willhonestly appear everywhere in this game
		
		myGraphics.clearRect(0, 0, myWidth, myHeight); //clean it up!

		if(State.getState() != null)
		{
			State.getState().render(myGraphics); //now render everything
		}
		
		myBuffer.show(); //visibility wow!
		myGraphics.dispose();
	}

	/**
	 * The getWidth() method returns the width of the game.
	 */
	public int getWidth() 
	{
		return myWidth;
	}

	/**
	 * The setWidth() method sets the width of the game.
	 */
	public void setWidth(int width) 
	{
		myWidth = width;
	}

	/**
	 * The getHeight() method returns the height of the game.
	 */
	public int getHeight() 
	{
		return myHeight;
	}

	/**
	 * The setHeight() method sets the height of the game.
	 */
	public void setHeight(int height)
	{
		myHeight = height;
	}

	/**
	 * This is probably the most pivotal method of the DungeonGame class.
	 * It is the overseer of the game as it makes sure the game is running.
	 * An FPS counter is also found here, credits to StackOverflow.
	 * Wow!
	 */
	public void run()
	{
		initGame(); //start game
		
		final int FPS = 60; //what the frames SHOULD be
		double timePerTick = 1000000000/ FPS; //all this math under this code could be attributed to StackOverflow :^)
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		while(gameRunning)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				drawToScreen();
				
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	/**
	 * The getKeyboard() method returns the keyboard object of the game.
	 */
	public Keyboard getKeyboard()
	{
		return keyboard;
	}
	
	/**
	 * The start() method starts the game.
	 */
	public void start()
	{
		if(gameRunning)
			return;
		
		gameRunning = true;
		
		myThread = new Thread(this);
		myThread.start();
	}
	
	/**
	 * The stop() method stops the game.
	 */
	public void stop()
	{
		if(!gameRunning)
			return;
		
		gameRunning = false;
		myDisplay.setVisible(false);
		myMaster.backToMenu();
		//System.exit(1);;
		
		try 
		{
			myThread.join();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * The VNScene() returns the user to the visual novel.
	 */
	public void VNScene()
	{
	    if(!gameRunning)
			return;
		
		gameRunning = false;
		myDisplay.setVisible(false);
		myMaster.goToVisualNovel("testDiag.txt"); 
		//System.exit(1);;
		
		try 
		{
			myThread.join();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	   }

}
