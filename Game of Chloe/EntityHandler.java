import java.awt.Graphics;
import java.util.ArrayList;

public class EntityHandler 
{
	private ArrayList<Entity> entityList;

	private Handler myHandler;
	private Player mainCharacter;



	public EntityHandler(Handler handler, Player player)
	{
		entityList = new ArrayList<Entity>();

		myHandler = handler;
		mainCharacter = player;
	}
	
	public boolean checkAliveMobs()
	{
		for(Entity e : myHandler.getInstance().getEntityHandler().getEntityList())
		{
			if(e.getEntitySignature().equalsIgnoreCase("mob"))
			{
				return true;
			}
		}
		return false;
	}

	public void tick()
	{		

		mainCharacter.tick();
		
		for(int i = 0; i < entityList.size(); i++)
		{
			Entity ent = entityList.get(i);
			//Entity ent2 = entityList.get(i + 2);
			ent.tick();
			
			
			//System.out.println("entity 2: " + ent2.isAlive());
			
			if(!ent.isAlive())
			{
				entityList.remove(ent);
				i--;
			}
		}
		

		

		
	}

	public void render(Graphics g)
	{
		for(Entity ent: entityList)
		{
			ent.render(g);

		}
		
		mainCharacter.render(g);
	}

	public void addEntity(Entity someEntity)
	{
		entityList.add(someEntity);
	}

	public ArrayList<Entity> getEntityList() 
	{
		return entityList;
	}

	public void setEntityList(ArrayList<Entity> entityList) 
	{
		this.entityList = entityList;
	}

	public Handler getMyHandler()
	{
		return myHandler;
	}

	public void setMyHandler(Handler myHandler)
	{
		this.myHandler = myHandler;
	}

	public Player getMainCharacter() 
	{
		return mainCharacter;
	}

	public void setMainCharacter(Player mainCharacter)
	{
		this.mainCharacter = mainCharacter;
	}

}
