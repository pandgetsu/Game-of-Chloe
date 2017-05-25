import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observer;

public class Player extends EntityLiving
{
	private final int ANIMATION_SPEED = 300;

	private Animation standing;
	private Animation upWalk;
	private Animation downWalk;
	private Animation leftWalk;
	private Animation rightWalk;

	public boolean hasItem()
	{
		return isHasKey();
	}
	
	public boolean isHasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

	private boolean hasKey;

	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, EntityLiving.DEFAULT_CREATURE_WIDTH - 2, EntityLiving.DEFAULT_CREATURE_HEIGHT - 2);

		//		boundingBox.x = 0;
		//		boundingBox.y = 0;
		//		boundingBox.width = 32;
		//		boundingBox.height = 32;

		standing = new Animation(ANIMATION_SPEED, Assets.mainCharacter_standing);
		upWalk = new Animation(ANIMATION_SPEED, Assets.mainCharacter_UpWalk);
		downWalk = new Animation(ANIMATION_SPEED, Assets.mainCharacter_DownWalk);
		leftWalk = new Animation(ANIMATION_SPEED, Assets.mainCharacter_LeftWalk);
		rightWalk = new Animation(ANIMATION_SPEED, Assets.mainCharacter_RightWalk);

		hasKey = false;

		setStat_HP(25);
	}

	public String getEntitySignature()
	{
		return "player";
	}

	public void tick() 
	{
		/*
		if(someGame.getKeyboard().moveUp)
		{
			myY -= 4;
		}
		if(someGame.getKeyboard().moveDown)
		{
			myY += 4;
		}
		if(someGame.getKeyboard().moveLeft)
		{
			myX -= 4;
		}
		if(someGame.getKeyboard().moveRight)
		{
			myX += 4;
		}*/
		standing.tick();
		upWalk.tick();
		downWalk.tick();
		leftWalk.tick();
		rightWalk.tick();

		getInput();
		
		//System.out.println("Player X: " + getMyX());
		//System.out.println("Player Y: " + getMyY());
		
		move();

	}

	private void getInput()
	{
		moveX = 0;
		moveY = 0;

		if(myHandler.getKeyboard().moveUp)
		{
			moveY = -myStep;
			//myY -= getMyStep();
		}
		if(myHandler.getKeyboard().moveDown)
		{
			moveY = myStep;
			//myY += getMyStep();
		}
		if(myHandler.getKeyboard().moveLeft)
		{
			moveX = -myStep;
			//myX -= getMyStep();
		}
		if(myHandler.getKeyboard().moveRight)
		{
			moveX = myStep;
			//myX += getMyStep();
		}
		if(myHandler.getKeyboard().interact)
		{
						int listSize = myHandler.getInstance().getEntityHandler().getEntityList().size();
						int sizeDifference = 0;
			
						for(int i = 0; i < myHandler.getInstance().getEntityHandler().getEntityList().size(); i++)
						{
							Entity ent = myHandler.getInstance().getEntityHandler().getEntityList().get(i);
							//Entity ent2 = entityList.get(i + 2);
			
			
							if(ent.equals(this))
							{
								continue;
							}
			
							if(ent.isInteractable())
							{
								ent.getAction();
			
								if(listSize != myHandler.getInstance().getEntityHandler().getEntityList().size())
								{
									sizeDifference = Math.abs(myHandler.getInstance().getEntityHandler().getEntityList().size() - listSize);
									listSize = myHandler.getInstance().getEntityHandler().getEntityList().size();
									i -= sizeDifference;
								}
							}
			
							//System.out.println("entity 2: " + ent2.isAlive());
			
						}
//			for(Entity ent : myHandler.getInstance().getEntityHandler().getEntityList())
//			{
//				if(ent.equals(this))
//				{
//					continue;
//				}
//
//				if(ent.isInteractable())
//				{
//					ent.getAction();
//				}
//			}
		}
		if(myHandler.getKeyboard().resetWorld)
		{
			myHandler.getInstance().loadWorld(myHandler.getInstance().getMyPath());
		}
	}
	public void getAction()
	{

	}

	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimation(), (int) getMyX(), (int) getMyY(), getMyWidth(), getMyHeight(), null);

		if(DungeonGame.myFlashlight)
		{
			g.drawImage(Assets.flashlight, (int) getMyX() - 1484, (int) getMyY() - 1484, null);
			//g.drawImage(Assets.flashlight, (int) myX - 1468, (int) myY - 1468, null);
		}

		//		g.setColor(Color.red);
		//		g.fillRect((int) (myX + boundingBox.x), (int) (myY + boundingBox.y), boundingBox.width, boundingBox.height);
	}

	private BufferedImage getCurrentAnimation()
	{
		if(moveX < 0)
		{
			return leftWalk.getCurrentSprite();
		}else if(moveX > 0)
		{
			return rightWalk.getCurrentSprite();
		}else if(moveY < 0)
		{
			return upWalk.getCurrentSprite();
		}else if(moveY > 0)
		{
			return downWalk.getCurrentSprite();
		}else
		{
			return standing.getCurrentSprite();
		}
	}

	

}
