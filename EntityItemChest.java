import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EntityItemChest extends EntityNonLiving
{

	private boolean isOpen;

	public EntityItemChest(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		// TODO Auto-generated constructor stub

		isOpen = false;

	}

	public void tick()
	{

	}

	public boolean isAlive()
	{
		return true;
	}

	public String getEntitySignature()
	{
		return "chest";
	}

	public void getAction()
	{
		if(!isOpen)
		{
			if(!myHandler.getInstance().getEntityHandler().getMainCharacter().hasItem())
			{
				isOpen = true;
				//System.out.println("Chest is opened!");
				myHandler.getInstance().getEntityHandler().getMainCharacter().setHasKey(true);
				System.out.println("Key acquired!");
			}else
			{
				System.out.println("You may only hold one item at a time!");
			}
		}
	}

	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimation(), (int) getMyX(), (int) getMyY(), getMyWidth(), getMyHeight(), null);
	}

	private BufferedImage getCurrentAnimation()
	{
		if(!isOpen)
		{
			return Assets.itemChest[0];
		}else
		{
			return Assets.itemChest[1];
		}
	}

}
