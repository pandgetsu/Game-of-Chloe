
public class Handler 
{
    private DungeonGame myGame;
    private DungeonInstance myInstance;
    private DungeonGUI ashdasjd;
    private int myDungeon;
    
    public Handler(DungeonGame game)
    {
        myGame = game;
    }
    
    public Keyboard getKeyboard()
    {
        return myGame.getKeyboard();
    }
    
    public void addGUI(DungeonGUI gui)
    {
        ashdasjd = gui;
    }
    
    public DungeonGUI getGUI()
    {
        return ashdasjd;
       }
    
    public int getWidth()
    {
        return myGame.getWidth();
    }
    
    public int getHeight()
    {
        return myGame.getHeight();
    }
    
    public DungeonGame getGame()
    {
        return myGame;
    }

    public void setGame(DungeonGame game) 
    {
        myGame = game;
    }

    public DungeonInstance getInstance() 
    {
        return myInstance;
    }

    public void setInstance(DungeonInstance instance) 
    {
        myInstance = instance;
    }
    public int getDungeon()
    {
        return myDungeon;
    }
    public void setDungeon(int d)
    {
        myDungeon = d;
    }

}
