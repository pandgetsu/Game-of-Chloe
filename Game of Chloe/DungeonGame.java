import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * The large bulk of the game occurs here and the actual ingame timer is located in this class as well.
 * 
 *
 */
public class DungeonGame implements Runnable
{
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
	
	private void initGame()
	{
		Assets.init();
		
		handler = new Handler(this);
		
		myDisplay = new DungeonGUI(myTitle, handler, myMaster);
		myDisplay.getFrame().addKeyListener(keyboard);
				
		handler.addGUI(myDisplay);
		keyboard.addHandler(handler);
		
		dungeonState = new DungeonState(handler);
		State.setState(dungeonState);
	}
	
	private void tick()
	{
		
		myDisplay.tick();
		keyboard.tick();
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}
	
	private void drawToScreen()
	{
		myBuffer = myDisplay.getCanvas().getBufferStrategy();
		
		if(myBuffer == null)
		{
			myDisplay.getCanvas().createBufferStrategy(2);
			return;
		}
		
		myGraphics = myBuffer.getDrawGraphics();
		
		myGraphics.clearRect(0, 0, myWidth, myHeight);

		if(State.getState() != null)
		{
			State.getState().render(myGraphics);
		}
		
		myBuffer.show();
		myGraphics.dispose();
	}

	public int getWidth() 
	{
		return myWidth;
	}

	public void setWidth(int width) 
	{
		myWidth = width;
	}

	public int getHeight() 
	{
		return myHeight;
	}

	public void setHeight(int height)
	{
		myHeight = height;
	}

	public void run()
	{
		initGame();
		
		final int FPS = 60;
		double timePerTick = 1000000000/ FPS;
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
	
	public Keyboard getKeyboard()
	{
		return keyboard;
	}
	
	public synchronized void start()
	{
		if(gameRunning)
			return;
		
		gameRunning = true;
		
		myThread = new Thread(this);
		myThread.start();
	}
	
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
