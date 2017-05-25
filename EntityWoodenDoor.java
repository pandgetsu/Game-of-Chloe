import java.awt.Graphics;

public class EntityWoodenDoor extends EntityNonLiving
{

	private boolean isOpen;

	public EntityWoodenDoor(Handler handler, float x, float y) 
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

	public void getAction()
	{
		if(!myHandler.getInstance().getEntityHandler().checkAliveMobs())
		{
			if(myHandler.getInstance().getEntityHandler().getMainCharacter().isHasKey())
			{
				isOpen = true;
				System.out.println("Door is opened!");
				myHandler.getInstance().getEntityHandler().getEntityList().remove(EntityWoodenDoor.this);
				myHandler.getInstance().getEntityHandler().getMainCharacter().setHasKey(false);
			}else
			{
				System.out.println("A key is required!");
			}
		}else
		{
			System.out.println("All mobs must be cleared in the level before proceeding!");
		}
	}

	public void render(Graphics g)
	{
		if(!isOpen)
		{
			g.drawImage(Assets.woodenDoor, (int) getMyX(), (int) getMyY(), getMyWidth(), getMyHeight(), null);
		}
	}

	@Override
	public String getEntitySignature()
	{
		return "door";
	}
}
