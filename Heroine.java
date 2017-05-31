import java.util.*;
/**
 * Abstract class Heroine - write a description of the class here
 * Modified by Francis Nguyen to connect to the other classes within TGoC
 * 
 * @author Eric Kang 
 * @version 0.3
 */
public class Heroine
{
    protected String name;          // Name
    protected int bondLevel;        // Bond level (Represents heroine's degree of affection towards player)
    protected boolean isFound;      // If the heroine is found yet or not (for purposes of unlocking) 
    private ArrayList<String> scenes;
    private int index;
    private int myDungeon;
    /**
     *  Constructs a heroine object
     *  bondLevel starts at 0
     *  bondExp starts at 0
     *  initial bondCap is 1000
     *  Heroine starts as not found
     *  
     *  @param chloe         the name of the heroine
     */
    public Heroine(String chloe, int dungeon)
    {
        name = chloe;
        bondLevel = 0;
        isFound = false;
        myDungeon = dungeon;
        
        index = 0;
        scenes = new ArrayList<String>(6);
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene0_01.txt");
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene1_01.txt");
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene2_01.txt");
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene3_01.txt");
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene4_01.txt");
        scenes.add("resources/scenes/" + chloe + "/" + chloe + "Scene5_01.txt");
    }
    public String getName()
    {
        return name;
    }
    
    public void adjustBond(int bChange)
    {
        bondLevel += bChange;
    }
    public int getBond()
    {
        return bondLevel;
    }
    public boolean isFound()
    {
        return isFound;
    }
    public void setIsFound(boolean state)
    {
        isFound = state;
    }
    public String getScene()
    {
        if(index < scenes.size())
        {
            String temp = scenes.get(index);
            index++;
            return temp;
        }
        else
            return "resources/scenes/stopTalkingToHer.txt";
    }
    public String getScene(int i)
    {
        return scenes.get(i);
    }
    public int getDungeon()
    {
        return myDungeon;
    }
}
