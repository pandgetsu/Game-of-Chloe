import java.awt.image.BufferedImage;
import java.util.*;

/**
 * The Assets class simply loads in all of the images, which will be done at the initiation of the program to improve efficiency throughout the program when
 * a sprite is needed. It also increases accessibility for a certain sprite.
 * 
 * @author Sean Tran
 */
public class Assets 
{
    //class variables
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;

    public static BufferedImage[] mainCharacter_standing;
    public static BufferedImage[] mainCharacter_UpWalk;
    public static BufferedImage[] mainCharacter_DownWalk;
    public static BufferedImage[] mainCharacter_LeftWalk;
    public static BufferedImage[] mainCharacter_RightWalk;
    
    public static BufferedImage[] badGuy_standing;
    
    public static BufferedImage[] itemChest;
    
    public static BufferedImage woodenDoor;

    public static BufferedImage grassTile;
    public static BufferedImage stoneTile;
    public static BufferedImage wallTile;
    public static BufferedImage badTile;
    
    public static List<BufferedImage> chloeEntity = new ArrayList<BufferedImage>();

    public static BufferedImage flashlight;
    
    public static BufferedImage doorKey;
    public static BufferedImage controlsWASD;
    
    public static BufferedImage diedState;

    public static BufferedImage tavern;
    
    public static BufferedImage fireBall;
    public static BufferedImage playerBall;
    
    public static BufferedImage shield;
    
    /**
     * The init() method is called to being the loading of the sprites into its specific variable.
     */
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/resources/textures/spriteSheet64.png")); //A SpriteSheet object is created to create easier access for cropping.

        //mainCharacter = sheet.cropImage(0, 0, WIDTH, HEIGHT);
        
        //for main character, use y axis HEIGHT*6 or HEIGHT*8
        //sprite croppings for main character standing animation
        mainCharacter_standing = new BufferedImage[4];
        mainCharacter_standing[0] = sheet.cropImage(0, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_standing[1] = sheet.cropImage(WIDTH * 3, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_standing[2] = sheet.cropImage(WIDTH * 6, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_standing[3] = sheet.cropImage(WIDTH * 9, HEIGHT * 8, WIDTH, HEIGHT);
        
        //sprite croppings for main character walking up animation
        mainCharacter_UpWalk = new BufferedImage[3];
        mainCharacter_UpWalk[0] = sheet.cropImage(WIDTH * 6, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_UpWalk[1] = sheet.cropImage(WIDTH * 7, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_UpWalk[2] = sheet.cropImage(WIDTH * 8, HEIGHT * 8, WIDTH, HEIGHT);
        
        //sprite croppings for main character walking down animation
        mainCharacter_DownWalk = new BufferedImage[3];
        mainCharacter_DownWalk[0] = sheet.cropImage(0, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_DownWalk[1] = sheet.cropImage(WIDTH, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_DownWalk[2] = sheet.cropImage(WIDTH * 2, HEIGHT * 8, WIDTH, HEIGHT);
        
        //sprite croppings for main character walking left animation
        mainCharacter_LeftWalk = new BufferedImage[3];
        mainCharacter_LeftWalk[0] = sheet.cropImage(WIDTH * 9, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_LeftWalk[1] = sheet.cropImage(WIDTH * 10, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_LeftWalk[2] = sheet.cropImage(WIDTH * 11, HEIGHT * 8, WIDTH, HEIGHT);
        
        //sprite croppings for main character walking right animation
        mainCharacter_RightWalk = new BufferedImage[3];
        mainCharacter_RightWalk[0] = sheet.cropImage(WIDTH * 4, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_RightWalk[1] = sheet.cropImage(WIDTH * 3, HEIGHT * 8, WIDTH, HEIGHT);
        mainCharacter_RightWalk[2] = sheet.cropImage(WIDTH * 5, HEIGHT * 8, WIDTH, HEIGHT);
        
        badGuy_standing = new BufferedImage[2];
        badGuy_standing[0] = sheet.cropImage(0, HEIGHT * 10, WIDTH, HEIGHT);
        badGuy_standing[1] = sheet.cropImage(WIDTH, HEIGHT * 10, WIDTH, HEIGHT);
        
        //chest entity
        itemChest = new BufferedImage[2];
        itemChest[0] = sheet.cropImage(0, HEIGHT * 2, WIDTH, HEIGHT);
        itemChest[1] = sheet.cropImage(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
        
        //wooden door entity
        woodenDoor = sheet.cropImage(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
        
        //tiles
        grassTile = sheet.cropImage(WIDTH, HEIGHT, WIDTH, HEIGHT);
        stoneTile = sheet.cropImage(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);
        wallTile = sheet.cropImage(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
        badTile = sheet.cropImage(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);
        
        //girl entity
        chloeEntity.add(sheet.cropImage(0, HEIGHT * 4, WIDTH, HEIGHT));
        chloeEntity.add(sheet.cropImage(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT));
        chloeEntity.add(sheet.cropImage(WIDTH, HEIGHT * 4, WIDTH, HEIGHT));
        chloeEntity.add(sheet.cropImage(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT));
        //chloeEntity.add(sheet.cropImage(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT));

        //flashlight = ImageLoader.loadImage("/textures/flashlight150.png");
        //flashlight image to black out the entire map except for a 150p circle centered at the player
        flashlight = ImageLoader.loadImage("/resources/textures/flashlight150_alpha.png");
        
        doorKey = sheet.cropImage(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
        
        //simple ui to display controls of game
        controlsWASD = ImageLoader.loadImage("/resources/textures/tile_WASD.png");
        
        //screen render for when the player dies
        diedState = ImageLoader.loadImage("/resources/textures/gameLost.png");
        
        //tavern background for MenuGUI
        tavern = ImageLoader.loadImage("/resources/images/Tavern.png");
       
        
        fireBall = sheet.cropImage(0, HEIGHT * 12, WIDTH, HEIGHT);
        playerBall = sheet.cropImage(WIDTH, HEIGHT * 12, WIDTH, HEIGHT);
        
        shield = sheet.cropImage(0, HEIGHT * 14, WIDTH, HEIGHT);
        
    }

}
