import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage mySheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		mySheet = sheet;
	}
	
	public BufferedImage cropImage(int x, int y, int width, int height)
	{
		return mySheet.getSubimage(x, y, width, height);
	}

}
