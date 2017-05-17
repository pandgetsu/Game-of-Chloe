
/**
 * Write a description of class MovingEntities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingEntity
{
    protected int myX;
    protected int myY;
    protected int myWidth;
    protected int myHeight;
    protected int mySpd;
    
    /**
     * Constructor for objects of class MovingEntity
     */
    public MovingEntity(int x, int y, int width, int height)
    {
        myX = x;
        myY = y;
        myWidth = width;
        myHeight = height;
        mySpd = 1;
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
}
