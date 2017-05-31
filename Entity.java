import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

public abstract class Entity
{
	protected Handler myHandler;
	
	//Positions of Entity
	protected float myX;
	protected float myY;
	
	//Dimensions of Entity
	protected int myWidth;
	protected int myHeight;
	
	//Collision Box Checking of Entity
	protected Rectangle boundingBox;
	
	public boolean isCheckAlive() 
	{
		return checkAlive;
	}

	public static void setCheckAlive(boolean wowAlive)
	{
		checkAlive = wowAlive;
	}

	protected static boolean checkAlive;
	

	
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		myHandler = handler;
		
		myX  = x;
		myY = y;
		
		myWidth = width;
		myHeight = height;
		
		checkAlive = true;
		
		
		
		boundingBox = new Rectangle(0, 0, myWidth, myHeight);
	}
	
	public abstract boolean isAlive();
	
	public abstract String getEntitySignature();

	public boolean isInteractable()
	{
		double differenceOfX = 0;
		double differenceOfY = 0;
		
		//int entityListLastIndex = myHandler.getInstance().getEntityHandler().getEntityList().size() - 1;

		
		try
		{
			differenceOfX = myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() - myX;
			differenceOfY = myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() - myY;
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
		double distance = Math.sqrt(Math.pow(differenceOfX, 2)+ Math.pow(differenceOfY, 2)) / 32;
		//double distance2 = Point2D.distance(myHandler.getInstance().getEntityHandler().getEntityList().get(2).getMyX(), myHandler.getInstance().getEntityHandler().getEntityList().get(2).getMyY(), myX, myY) / 32;
		
		
		if(distance <= 1.5)
		{
			return true;
		}
		
//		System.out.println("differenceOfX: " + differenceOfX);
//		System.out.println("differenceOfY: " + differenceOfY);
//		System.out.println("DISTANCE: " + distance);
		
		return false;
	}
	
	public abstract void getAction();
	
	public boolean checkEntityCollisions(float offsetX, float offsetY)
	{
		for(Entity ent : myHandler.getInstance().getEntityHandler().getEntityList())
		{
			if(ent.equals(this))
			{
				continue;
			}
			
			if(ent.getCollisionBounds(0.0f, 0.0f).intersects(getCollisionBounds(offsetX, offsetY)))
			{
				return true;
			}
		}

		return false;
	}
	
	public Rectangle getCollisionBounds(float offsetX, float offsetY)
	{
		return new Rectangle((int) (myX + boundingBox.x + offsetX), (int) (myY + boundingBox.y + offsetY), boundingBox.width, boundingBox.height);
	}
	
	public float getMyX() 
	{
		return myX;
	}

	public void setMyX(float x) 
	{
		myX = x;
	}

	public float getMyY()
	{
		return myY;
	}

	public void setMyY(float y) 
	{
		myY = y;
	}

	public int getMyWidth() 
	{
		return myWidth;
	}

	public void setMyWidth(int width) 
	{
		myWidth = width;
	}

	public int getMyHeight() 
	{
		return myHeight;
	}

	public void setMyHeight(int height) 
	{
		myHeight = height;
	}

	
	public void addObserver(Observer obs)
	{
		
		
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
