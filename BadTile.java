/**
 * The BadTile class is a type of tile. Only important here is that it is a tile that does indeed deal damage.
 */
public class BadTile extends Tile
{
	//constructor that saves texture and id of tile
	public BadTile(int id)
	{
		super(Assets.badTile, id);
	}
	
	//overriding method
	public boolean dealsDOT()
	{
		return true;
	}
}
