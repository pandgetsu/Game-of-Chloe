import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;
public class EntityBadGuy extends EntityLiving
{

    private final int ANIMATION_SPEED = 300;
    private final int PROJECTILE_INTERVAL = 300;                    //Time until projectiles fire again
    private final int PROJECTILE_ANGLE = 15;                        //How many projectiles fire 360/PROJECTILE_ANGLE
    private Animation standing;
    private int projectileTime;
    public EntityBadGuy(Handler handler, float x, float y) 
    {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        // TODO Auto-generated constructor stub
      

        standing = new Animation(ANIMATION_SPEED, Assets.badGuy_standing);
        projectileTime = 0;
        chloe = new ArrayList<Projectile>();
    }
    
    public String getEntitySignature()
    {
        return "mob";
    }

    public void tick()
    {
        standing.tick();
        checkSurrounding();
        move();
        System.out.println(myHandler.getInstance().getEntityHandler().getEntityList().size());
        System.out.println(chloe.size());
         if(projectileTime <= 100)
         {
            for(int x = 0; x < 360; x += PROJECTILE_ANGLE)
                shoot(x);
            projectileTime = PROJECTILE_INTERVAL;
        }
        for(int x = 0; x < chloe.size(); x++)
        {
            if(chloe.get(x).checkBounds() && !chloe.get(x).checkPlayer())
                chloe.get(x).tick();
            else
            {
                chloe.remove(x);
                x--;
            }
        }
        projectileTime--;
        
        //shoot();
//         
//         for(Entity e : myHandler.getInstance().getEntityHandler().getEntityList())
//         {
//             if(e.getEntitySignature().equals("Projectile"))
//             {
//                 e.tick();
//             }
//         }
    }
    
   public void shoot(int direction)
    {
        
        chloe.add(new Projectile(this, myHandler, myX, myY, myWidth, myHeight, direction * -1, "mob"));
        //myHandler.getInstance().getEntityHandler().addEntity(chloe);

    }
    
    public int calculatePlayerAngle()
    {
        int x = 0;
        int y = 0;
        x = (int)myHandler.getInstance().getEntityHandler().getMainCharacter().getMyX();
        y = (int)myHandler.getInstance().getEntityHandler().getMainCharacter().getMyY();
        x -= myX;
        y -= myY;
        
        return (int)Math.atan((double) y/x);
    }
    
    public void checkSurrounding()
    {
        double differenceOfX = 0;
        double differenceOfY = 0;
        
        moveX = 0;
        moveY = 0;

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
        
        if(distance <= 1.5)
        {
            attack(myHandler.getInstance().getEntityHandler().getMainCharacter());
        }
    }

    public void getAction()
    {
        getDamaged();
        //System.out.println("ow");
    }

    public void render(Graphics g)
    {
        for(Projectile p : chloe)
        {
            p.render(g);
        }
//         chloe.render(g);
        if(getStat_HP() > 0)
        {
            g.drawImage(getCurrentAnimation(), (int) getMyX(), (int) getMyY(), getMyWidth(), getMyHeight(), null);
            
        }
    }

    private BufferedImage getCurrentAnimation()
    {
        return standing.getCurrentSprite();
    }

}