import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;
public class Keyboard implements KeyListener
{
	private boolean[] keys;
	
	public boolean moveUp;
	public boolean moveDown;
	public boolean moveLeft;
	public boolean moveRight;
	
	public boolean interact;	
	
	public boolean resetWorld;
	
	private Handler myHandler;
	
	public Keyboard()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		moveUp = keys[KeyEvent.VK_W];
		moveDown = keys[KeyEvent.VK_S];
		moveLeft = keys[KeyEvent.VK_A];
		moveRight = keys[KeyEvent.VK_D];
		
		interact = keys[KeyEvent.VK_SPACE];
		
		resetWorld = keys[KeyEvent.VK_NUMPAD0];
		//InputMap test = ((JComponent)(myHandler.getGUI())).getInputMap();
	}
	
	public void addHandler(Handler handler)
	{
	    myHandler = handler;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
		
		//System.out.println(e.getKeyCode() + " pressed.");
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
		//isKeyPressed = false;
	}

	public void keyTyped(KeyEvent e)
	{

	}

}
