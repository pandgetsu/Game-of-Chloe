import java.awt.Graphics;

public class DungeonState extends State
{
    private DungeonInstance gameInstance;
    
    private boolean dungeon1 = false;
    private boolean dungeon2 = false;
    
    public DungeonState(Handler handler)
    {
        super(handler);
        switch(handler.getDungeon())
        {
            case 1 :
               gameInstance = new DungeonInstance(handler, "resources/instances/chloeInstance.txt");
               break;
            case 2 :
                gameInstance = new DungeonInstance(handler, "resources/instances/illyaInstance.txt");
                break;
            case 3 :
                gameInstance = new DungeonInstance(handler, "resources/instances/celicaInstance.txt");
                break;
            case 4 :
                gameInstance = new DungeonInstance(handler, "resources/instances/grillInstance.txt");
                break;
            
        }
//         if(dungeon1)
//         {
//             gameInstance = new DungeonInstance(handler, "resources/instances/instance01.txt");
//             dungeon1 = true;
//         }else if(!dungeon2)
//         {
//             gameInstance = new DungeonInstance(handler, "resources/instances/instance02.txt");
//             dungeon2 = true;
//         }else
//         {
//             gameInstance = new DungeonInstance(handler, "resources/instances/instance01.txt");
//         }

        //gameInstance = new DungeonInstance(handler, "resources/instances/instance01.txt");
        
        handler.setInstance(gameInstance);
//      mainPlayer = new Player(handler, gameInstance.getSpawnX() * 32, gameInstance.getSpawnY() * 32);
//      chloeEntity = new EntityGirl(handler, gameInstance.getGirlSpawnX() * 32, gameInstance.getGirlSpawnY() * 32);
//      itemChest = new EntityItemChest(handler, gameInstance.getChestSpawnX() * 32, gameInstance.getChestSpawnY() * 32);
        
    }
    
    public void tick() 
    {
        gameInstance.tick();
//      mainPlayer.tick();
//      chloeEntity.tick();
//      itemChest.tick();
    }

    public void render(Graphics g) 
    {
        gameInstance.render(g);
        
//      mainPlayer.render(g);
//  
//      chloeEntity.render(g);
//      
//      itemChest.render(g);
    }
    
}
