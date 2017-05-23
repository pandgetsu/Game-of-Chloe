import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EntityBadGuy extends EntityLiving
{

	private final int ANIMATION_SPEED = 300;

	private Animation standing;

	public EntityBadGuy(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		// TODO Auto-generated constructor stub

		standing = new Animation(ANIMATION_SPEED, Assets.badGuy_standing);
	}
	
	public String getEntitySignature()
	{
		return "mob";
	}

	public void tick()
	{
		standing.tick();
	}

	public void getAction()
	{
		getDamaged();

	}

	public void render(Graphics g)
	{
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
