
public class WallTile extends Tile
{
	public WallTile(int id)
	{
		super(Assets.wallTile, id);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}
