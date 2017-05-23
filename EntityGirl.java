import java.awt.Graphics;

public class EntityGirl extends EntityNonLiving
{

	public EntityGirl(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		// TODO Auto-generated constructor stub
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.chloeEntity, (int) getMyX(), (int) getMyY(), getMyWidth(), getMyHeight(), null);
	}
	
	public String getEntitySignature()
	{
		return "girl";
	}

	public boolean isAlive()
	{
		return true;
	}

	public void getAction()
	{
		myHandler.getGame().VNScene(); //*********
	}

}
