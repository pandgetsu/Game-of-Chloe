import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
public abstract class EntityLiving extends Entity
{
    //Default Statistics of Living Entities
    public final int DEFAULT_HP = 10;
    public final int DEFAULT_ATK = 1;
    public final int DEFAULT_DEF = 0;

    //Default Step Speed of Living Entities
    public final float DEFAULT_STEP = 5.5f;

    //Default Dimensions of Living Entities
    public static final int DEFAULT_CREATURE_WIDTH = 32;
    public static final int DEFAULT_CREATURE_HEIGHT = 32;

    protected int myStat_HP;
    private int myStat_ATK;
    private int myStat_DEF;

    protected float myStep;

    protected float moveX;
    protected float moveY;

    private State diedState;

    protected List<Projectile> chloe;

    public EntityLiving(Handler handler, float x, float y, int width, int height) 
    {
        super(handler, x, y, width, height);

        myStat_HP = DEFAULT_HP;
        myStat_ATK = DEFAULT_ATK;
        myStat_DEF = DEFAULT_DEF;

        myStep = DEFAULT_STEP;

        moveX = 0;
        moveY = 0;
    }

    public List getProjectileList()
    {
        return chloe;
    }

    public boolean isAlive()
    {
        if(getStat_HP() > 0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public void checkAlive()
    {
        if(!isAlive())
        {
            diedState = new DiedState(myHandler);
            State.setState(diedState);
        }
    }

    public void getDamaged()
    {
        setStat_HP(getStat_HP() - 1);

        if(getStat_HP() <= 0)
        {
            dieMove();
        }
    }

    public void dieMove()
    {
        setAlive(false);
    }

    public static void setAlive(boolean alive) 
    {
        setCheckAlive(alive);
    }

    /**
     * The move() method handles the movement of an entity by tracking changes in its x and y coordinate.
     */
    public void move()
    {
        if(this.getEntitySignature().equals("player"))
            checkGround();

        if(!checkEntityCollisions(moveX, 0.0f))
        {
            changeX();
        }
        if(!checkEntityCollisions(0.0f, moveY))
        {
            changeY();
        }
    }

    public void attack(EntityLiving e)
    {
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask()
            {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    e.setStat_HP(e.getStat_HP() - (getStat_ATK() - e.getStat_DEF()));
                    System.out.println("Wow!");
                    timer.cancel();

                }
            };

        timer.schedule(myTask, 2000, 2000);

    }

    public void checkGround()
    {
        int tempX = (int) (myX + moveX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH;
        int tempY = (int) (myY + moveY + boundingBox.y) / Tile.TILE_HEIGHT;

        if(onBadGround(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && !onBadGround(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT) ||
        onBadGround(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && onBadGround(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT) ||
        onBadGround((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && onBadGround((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY) ||
        onBadGround((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && onBadGround((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY))
        {
            diedState = new DiedState(myHandler);
            State.setState(diedState);
        }
    }

    public void changeX()
    {
        //if move right
        if(moveX > 0)
        {
            int tempX = (int) (myX + moveX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT))
            {
                myX += moveX;
            }else
            {
                myX = tempX * Tile.TILE_WIDTH - boundingBox.x - boundingBox.width - 1;
            }
        }else if(moveX < 0)
        {
            int tempX = (int) (myX + moveX + boundingBox.x) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tempX, (int) (myY + boundingBox.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tempX, (int) (myY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT))
            {
                myX += moveX;
            }else
            {
                myX = tempX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - boundingBox.x;
            }
        }
    }

    public void changeY()
    {
        if(moveY < 0)
        {
            int tempY = (int) (myY + moveY + boundingBox.y) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && !collisionWithTile((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY))
            {
                myY += moveY;
            }else
            {
                myY = tempY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - boundingBox.y;
            }
        }else if(moveY > 0)
        {
            int tempY = (int) (myY + moveY + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (myX + boundingBox.x) / Tile.TILE_WIDTH, tempY) && !collisionWithTile((int) (myX + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, tempY))
            {
                myY += moveY;
            }else
            {
                myY = tempY * Tile.TILE_HEIGHT - boundingBox.y - boundingBox.width - 1;
            }
        }
    }

    protected boolean onBadGround(int x, int y)
    {
        return myHandler.getInstance().getTile(x, y).dealsDOT();
    }

    protected boolean collisionWithTile(int x, int y)
    {
        return myHandler.getInstance().getTile(x, y).isSolid();
    }

    public float getMoveX() 
    {
        return moveX;
    }

    public void setMoveX(float x) 
    {
        moveX = x;
    }

    public float getMoveY() 
    {
        return moveY;
    }

    public void setMoveY(float y) 
    {
        moveY = y;
    }

    public int getStat_HP() 
    {
        return myStat_HP;
    }

    public void setStat_HP(int hp) 
    {
        myStat_HP = hp;
    }

    public int getStat_ATK() 
    {
        return myStat_ATK;
    }

    public void setStat_ATK(int stat_ATK)
    {
        myStat_ATK = stat_ATK;
    }

    public int getStat_DEF() 
    {
        return myStat_DEF;
    }

    public void setStat_DEF(int stat_DEF)
    {
        myStat_DEF = stat_DEF;
    }

    public float getMyStep() 
    {
        return myStep;
    }

    public void setMyStep(float step) 
    {
        myStep = step;

    }
}