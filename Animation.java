import java.awt.image.BufferedImage;

/**
 * The Animation class is in charge of handling the animation of an entity(specifically the walking animation of the main character).
 */
public class Animation 
{
	//class variables
	private int animationSpeed;
	private int spriteIndex;
	
	private long lastTime;
	private long timer;
	
	private BufferedImage[] sprites; //holds an array of the sprites
	
	public Animation(int aniSpeed, BufferedImage[] spriteFrames)
	{
		animationSpeed = aniSpeed; //speed in between each render of sprites
		spriteIndex = 0;
		
		lastTime = System.currentTimeMillis();
		timer = 0;
		
		sprites = spriteFrames;
	}
	
	/**
	 * The tick() method for the Animation class will cycle through the indexes of the sprites BufferedImage[] accordingly with the animation speed
	 * passed to the constructor.
	 */
	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer> animationSpeed) //once timer reaches the set speed
		{
			spriteIndex++; //change sprite frame
			
			timer = 0; //reset timer
			
			if(spriteIndex >= sprites.length) //once all the animation frames have rendered
			{
				spriteIndex = 0; //reset sprite index to get the first frame again
			}
		}
	}
	
	public BufferedImage getCurrentSprite()
	{
		return sprites[spriteIndex];
	}

}
