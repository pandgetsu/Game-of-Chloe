
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
public class Projectile extends MovingEntity
{
    protected EntityLiving myBadGuy;
    private final int DAMAGE = 5;
    protected boolean inBounds;         //Checks if the projectile is in bounds of the game
    protected boolean inPlayer;
    protected String id;
    /**
     * Constructor for objects of class Projectile
     */
    public Projectile(EntityLiving badGuy, Handler handler, float x, float y, int width, int height, int direction, String type)
    {
        super(handler, x, y, width, height, direction);
        myBadGuy = (EntityLiving)badGuy;
        inBounds = true;
        id = type;
    }

    private void checkBoundary()
    {
        if(myX > 960 || myX < 0|| myY < 0 || myY > 570)
        {
            myBadGuy.getProjectileList().remove(this);
            System.out.println("hello");
        }
    }

    public void tick()
    {
        //         myX += mySpd * Math.cos(myDirection * (Math.PI/180));
        //         myY += mySpd * Math.sin(myDirection * (Math.PI/180));
        changeX();
        changeY();
        checkSurrounding();

        //checkBoundary();
    }

    public void changeX()
    {
        double moveX = mySpd * Math.cos(myDirection * (Math.PI/180));

        //if move right
        if(mySpd * Math.cos(myDirection * (Math.PI/180)) > 0)
        {
            int tempX = (int) (myX + moveX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH;

            if(myX < 960 && myX > 0)//!collisionWithTile(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT))
            {
                myX += mySpd * Math.cos(myDirection * (Math.PI/180));
            }else
            {
                // myBadGuy.getProjectileList().remove(this);
                inBounds = false;
                //myX = tempX * Tile.TILE_WIDTH - boundingBox.x - boundingBox.width - 1;
            }
        }else if(mySpd * Math.cos(myDirection * (Math.PI/180)) < 0)
        {
            int tempX = (int) (myX + moveX + boundingBox.x) / Tile.TILE_WIDTH;

            if(myX < 960 && myX > 0)//!collisionWithTile(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT))
            {
                myX += mySpd * Math.cos(myDirection * (Math.PI/180));
            }else
            {
                //myBadGuy.getProjectileList().remove(this);
                inBounds = false;
                //myX = tempX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - boundingBox.x;
            }
        }
    }


    public void changeY()
    {
        double moveY = mySpd * Math.sin(myDirection * (Math.PI/180));
        if(mySpd * Math.sin(myDirection * (Math.PI/180)) < 0)
        {
            int tempY = (int) (myY + moveY + boundingBox.y) / Tile.TILE_HEIGHT;

            if(myY > 0 && myY < 570)//!collisionWithTile((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && !collisionWithTile((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY))
            {
                myY += mySpd * Math.sin(myDirection * (Math.PI/180));
            }else
            {
                //myBadGuy.getProjectileList().remove(this);
                inBounds = false;
                //myY = tempY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - boundingBox.y;
            }
        }else if(mySpd * Math.sin(myDirection * (Math.PI/180)) > 0)
        {
            int tempY = (int) (myY + moveY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT;

            if(myY > 0 && myY < 570)//!collisionWithTile((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && !collisionWithTile((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY))
            {
                myY += mySpd * Math.sin(myDirection * (Math.PI/180));
            }else
            {
                //myBadGuy.getProjectileList().remove(this);
                inBounds = false;
                // myY = tempY * Tile.TILE_HEIGHT - boundingBox.y - boundingBox.width - 1;
            }
        }
    }

    public boolean checkBounds()
    {
        return inBounds;
    }

    protected boolean collisionWithTile(int x, int y)
    {
        return myHandler.getInstance().getTile(x, y).isSolid();
    }

    @Override
    public String getEntitySignature()
    {
        return "Projectile";
    }

    public void attack(EntityLiving e)
    {
        //      Timer timer = new Timer();
        //      TimerTask myTask = new TimerTask()
        //              {
        // 
        //                  @Override
        //                  public void run() {
        //                      // TODO Auto-generated method stub
        if(!id.equals(e.getEntitySignature()))
        {
            e.setStat_HP(e.getStat_HP() - (DAMAGE - e.getStat_DEF()));
            inPlayer = true;
        }
        //                      System.out.println("Wow!");
        //                      timer.cancel();
        //                      
        //                  }
        //              };
        //      
        //              timer.schedule(myTask, 2000, 2000);

    }

    /**
     * returns whether or not the projectile is in the player
     */
    public boolean checkPlayer()
    {
        return inPlayer;
    }

    public void checkSurrounding()
    {
        double differenceOfX = 0;
        double differenceOfY = 0;
        double moveX = mySpd * Math.cos(myDirection * (Math.PI/180));
        double moveY = mySpd * Math.sin(myDirection * (Math.PI/180));
        moveX = 0;
        moveY = 0;

        //int entityListLastIndex = myHandler.getInstance().getEntityHandler().getEntityList().size() - 1;
        List<Entity> temp;
        temp = myHandler.getInstance().getEntityHandler().getEntityList();
        if(!id.equals("player"))
        {
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
    
    
            if(distance <= 5)
            {
                if(myX < myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() - 32)
                {
                    moveX++;
                }else if(myX > myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() + 32)
                {
                    moveX--;
                }
    
                if(myY < myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() - 32)
                {
                    moveY++;
                }else if(myY > myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() + 32)
                {
                    moveY--;
                }
            }
            
            if(distance <= 0.5)
            {
                attack(myHandler.getInstance().getEntityHandler().getMainCharacter());
            }
        }
        for(Entity e: temp)
        {
            try
            {
                try
                {
                    differenceOfX = e.getMyX() - myX;//myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() - myX;
                    differenceOfY = e.getMyY() - myY;//myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() - myY;
                }catch(NullPointerException E)
                {
                    E.printStackTrace();
                }
        
                double distance = Math.sqrt(Math.pow(differenceOfX, 2)+ Math.pow(differenceOfY, 2)) / 32;
                //double distance2 = Point2D.distance(myHandler.getInstance().getEntityHandler().getEntityList().get(2).getMyX(), myHandler.getInstance().getEntityHandler().getEntityList().get(2).getMyY(), myX, myY) / 32;
        
                //         if(distance <= 5)
                //         {
                //             if(myX < myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() - 32)
                //             {
                //                 moveX++;
                //             }else if(myX > myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX() + 32)
                //             {
                //                 moveX--;
                //             }
                // 
                //             if(myY < myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() - 32)
                //             {
                //                 moveY++;
                //             }else if(myY > myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY() + 32)
                //             {
                //                 moveY--;
                //             }
                //         }
        
                if(distance <= 0.5 && !e.getEntitySignature().equals(id))
                {
                    attack((EntityLiving)e);
                }
            }
            catch(ClassCastException E)
            {
                
            }
        }
    }

}