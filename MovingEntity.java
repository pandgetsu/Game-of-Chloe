import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
/**
 * Write a description of class MovingEntity here.
 * 
 * @author Eric Kang
 * @version 0.1
 */
public class MovingEntity extends EntityNonLiving
{
    protected float mySpd;          // How fast this entity moves every tick
    protected int myDirection;      // Direction this entity is facing in degrees
    
    /**
     * Constructor for objects of class MovingEntity
     * mySpd is initialized at 1.5 pixels
     * 
     * @param handler       handler class
     * @param x             x coordinate of this entity
     * @param y             y coordinate of this entity
     * @param width         width of this entity in pixels
     * @param height        height of this entity in pixels
     * @param direction     direction this entity is currently facing in degrees
     */
    public MovingEntity(Handler handler, float x, float y, int width, int height, int direction)
    {
        super(handler, x, y, width, height);
        mySpd = 3.5f;
        myDirection = direction;
    }
    
    /**
     * Moves the entity
     * 
     * @param x     x coordinate for this entity to move to
     * @param y     y coordinate for this entity to move to
     */
    public void move(int x, int y)
    {
        if (checkX(x))
            moveX(x);
        else
            if (checkY(y))
                moveY(y);
    }
    
    /**
     * Checks to see if the entity can move on the x axis
     * 
     * @param x     x coordinate for this entity to move to
     * 
     * @return      true if this entity is not at the same x coordinate as the location to move to
     */
    private boolean checkX(int x)
    {
        return myX != x;
    }
    
    /**
     * Checks to see if the entity can move on the y axis
     * 
     * @param y     y coordinate for this entity to move to
     * 
     * @return      true if this entity is not at the same y coordinate as the location to move to
     */
    private boolean checkY(int y)
    {
        return myY != y;
    }
    
    /**
     * Moves the entity on the x axis based of where the entity is compared to the x coordinate to
     * move to
     * The entity moves mySpd pixels
     * 
     * @param x     x coordinate for this entity to move to
     */
    private void moveX(int x)
    {
        if (myX < x)
            myX += mySpd;
        else
            if (myX > x)
                myX -= mySpd;
    }
    
    /**
     * Moves the entity on the y axis based of where the entity is compared to the y coordinate to
     * move to
     * The entity moves mySpd pixels
     * 
     * @param y     y coordinate for this entity to move to
     */
    private void moveY(int y)
    {
        if (myY < y)
            myY += mySpd;
        else
            if (myY > y)
                myY -= mySpd;
    }
    
    public boolean isAlive()
    {
        return false;
    }
    
    @Override
    public String getEntitySignature()
    {
        return "MovingEntity";
    }
   
    
    public void getAction()
    {
        
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Assets.fireBall, (int)myX, (int)myY, myWidth, myHeight, null);
    }
    
}