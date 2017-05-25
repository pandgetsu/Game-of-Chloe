
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends MovingEntity
{
    /**
     * Constructor for objects of class Projectile
     */
    public Projectile(Handler handler, float x, float y, int width, int height, int direction)
    {
        super(handler, x, y, width, height, direction);
    }
    
    private void checkBoundary()
    {
        if(myX > 960 || myX < 0|| myY < 0 || myY > 570)
            myHandler.getInstance().getEntityHandler().getEntityList().remove(this);
    }
    
    public void tick()
    {
        myX += mySpd * Math.cos(Math.PI/2);
        myY += mySpd * Math.sin(Math.PI/2);
        checkBoundary();
    }
    
    @Override
    public String getEntitySignature()
    {
        return "Projectile";
    }
    
}