import java.awt.Graphics;

public class DungeonInstance 
{
	private Handler myHandler;
	private String myPath;
	
	private int amountBadGuys;
	
	private int myWidth;
	private int myHeight;
	
	private int spawnX;
	private int spawnY;

	private EntityHandler entityHandler;

	private int girlSpawnX;
	private int girlSpawnY;
	
	private int amountItemChest;
	
	private int[] chestSpawnX;
	private int[] chestSpawnY;
	
	private int amountDoor;
	
	private int doorSpawnX[];
	private int doorSpawnY[];
	
	private int[] badGuySpawnX;
	private int[] badGuySpawnY;

	private int[][] tiles;
	
	public DungeonInstance(Handler handler, String path)
	{
		myHandler = handler; 
		myPath = path;

		loadWorld(myPath);



//		entityHandler.getMainCharacter().setMyX(spawnX * 32);
//		entityHandler.getMainCharacter().setMyY(spawnY * 32);
//		
//		entityHandler.getEntityList().get(0).setMyX(chestSpawnX * 32);
//		entityHandler.getEntityList().get(0).setMyY(chestSpawnY * 32);
//		
//		entityHandler.getEntityList().get(1).setMyX(girlSpawnX * 32);
//		entityHandler.getEntityList().get(1).setMyY(girlSpawnY * 32);
//		
		
	}
	
	public String getMyPath() {
		return myPath;
	}

	public void setMyPath(String myPath) {
		this.myPath = myPath;
	}

	public void loadWorld(String path)
	{
		readFile(path);
		loadEntities();
	}
	
	public void loadEntities()
	{
		entityHandler = new EntityHandler(myHandler, new Player(myHandler, spawnX * 32, spawnY * 32));
		entityHandler.addEntity(new EntityGirl(myHandler, girlSpawnX * 32, girlSpawnY * 32));
		
		
		for(int i = 0; i < amountItemChest; i++)
		{
			entityHandler.addEntity(new EntityItemChest(myHandler, chestSpawnX[i] * 32, chestSpawnY[i] * 32));
		}

		for(int i = 0; i < amountDoor; i++)
		{
			entityHandler.addEntity(new EntityWoodenDoor(myHandler, doorSpawnX[i] * 32, doorSpawnY[i] * 32));
		}
		
		for(int i = 0; i < amountBadGuys; i++)
		{
			entityHandler.addEntity(new EntityBadGuy(myHandler, badGuySpawnX[i] * 32, badGuySpawnY[i] * 32));
		}
	}
	
	public void tick()
	{
		entityHandler.tick();
	}
	
	public void render(Graphics g)
	{
		for(int y = 0; y < myHeight; y++)
		{
			for(int x = 0; x < myWidth; x++)
			{
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
		
		entityHandler.render(g);
	}
	
	public Tile getTile(int x, int y)
	{
		Tile someTile = Tile.tiles[tiles[x][y]];
		
		if(someTile == null)
		{
			return Tile.grassTile;
		}
		
		return someTile;
	}
	
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
//	public int getGirlSpawnX() {
//		return girlSpawnX;
//	}
//
//	public void setGirlSpawnX(int girlSpawnX) {
//		this.girlSpawnX = girlSpawnX;
//	}
//
//	public int getGirlSpawnY() {
//		return girlSpawnY;
//	}
//
//	public void setGirlSpawnY(int girlSpawnY) {
//		this.girlSpawnY = girlSpawnY;
//	}
//	
//	public int getChestSpawnX() {
//		return chestSpawnX;
//	}
//
//	public void setChestSpawnX(int chestSpawnX) {
//		this.chestSpawnX = chestSpawnX;
//	}
//
//	public int getChestSpawnY() {
//		return chestSpawnY;
//	}
//
//	public void setChestSpawnY(int chestSpawnY) {
//		this.chestSpawnY = chestSpawnY;
//	}

	public EntityHandler getEntityHandler() 
	{
		return entityHandler;
	}

	public void setEntityHandler(EntityHandler entityHandler) 
	{
		this.entityHandler = entityHandler;
	}
	
	private void readFile(String path)
	{
		String inFile = Utilities.loadFile(path);
		String[] token = inFile.split("\\s+");
		
		int coordinateIndex = 0;
		
		myWidth = Utilities.parseInt(token[0]);
		myHeight = Utilities.parseInt(token[1]);
		
		spawnX = Utilities.parseInt(token[2]);
		spawnY = Utilities.parseInt(token[3]);
		
		tiles = new int[myWidth][myHeight];
		
		for(int y = 0; y < myHeight; y++)
		{
			for(int x = 0; x < myWidth; x++)
			{
				tiles[x][y] = Utilities.parseInt(token[(x + y * myWidth) + 4]);
			}
		}
		
		girlSpawnX = Utilities.parseInt(token[4 + (myWidth * myHeight)]);
		girlSpawnY = Utilities.parseInt(token[4 + (myWidth * myHeight) + 1]);
		
		amountItemChest = Utilities.parseInt(token[4 + (myWidth * myHeight) + 2]);
		
		chestSpawnX = new int[amountItemChest];
		chestSpawnY = new int[amountItemChest];
		
		for(int i = 0; i < amountItemChest * 2; i += 2)
		{
			chestSpawnX[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 3 + i]);
			chestSpawnY[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 3 + (i + 1)]);
			coordinateIndex++;
		}
		
		coordinateIndex = 0;
		
		amountDoor = Utilities.parseInt(token[4 + (myWidth * myHeight) + 4 + amountItemChest]);
		
		doorSpawnX = new int[amountDoor];
		doorSpawnY = new int[amountDoor];
		
		for(int i = 0; i < amountDoor * 2; i += 2)
		{
			doorSpawnX[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 5 + amountItemChest + i]);
			doorSpawnY[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 5 + amountItemChest + (i + 1)]); 
			coordinateIndex++;
		}
		
		coordinateIndex = 0;
		
		amountBadGuys = Utilities.parseInt(token[4 + (myWidth * myHeight) + 6 + amountItemChest + amountDoor]);
		
		badGuySpawnX = new int[amountBadGuys];
		badGuySpawnY = new int[amountBadGuys];
		
		for(int i = 0; i < amountBadGuys * 2; i += 2)
		{
			badGuySpawnX[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 7 + amountItemChest + amountDoor + i]);
			badGuySpawnY[coordinateIndex] = Utilities.parseInt(token[4 + (myWidth * myHeight) + 7 + amountItemChest + amountDoor + (i + 1)]);
			coordinateIndex++;
		}
		
		coordinateIndex = 0;
	}

}
