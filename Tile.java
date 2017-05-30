import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	public static Tile[] tiles = new Tile[256];
	
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new StoneTile(1);
	public static Tile wallTile = new WallTile(2);
	public static Tile badTile = new BadTile(3);
	
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	
	protected BufferedImage tileTexture;
	protected final int tileID;

	public Tile(BufferedImage texture, int id)
	{
		tileTexture = texture;
		tileID = id;
		
		tiles[id] = this;
	}

	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(tileTexture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean dealsDOT()
	{
		return false;
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public int getTileID()
	{
		return tileID;
	}
}
