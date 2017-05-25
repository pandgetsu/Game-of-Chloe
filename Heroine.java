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
    protected int bondCap;          // Bond level experience cap
    protected int bondExp;          // Bond level experience
    protected int bondLevel;        // Bond level (Represents heroine's degree of affection towards player)
    protected boolean isFound;      // If the heroine is found yet or not (for purposes of unlocking) 
    private ArrayList<String> scenes;
    private int index;
    /**
     *  Constructs a heroine object
     *  bondLevel starts at 0
     *  bondExp starts at 0
     *  initial bondCap is 1000
     *  Heroine starts as not found
     *  
     *  @param chloe         the name of the heroine
     */
    public Heroine(String chloe)
    {
        name = chloe;
        bondCap = 1000;
        bondExp = 0;
        bondLevel = 0;
        isFound = false;
        
        index = 0;
        scenes = new ArrayList<String>(6);
        scenes.add("resources/scenes/" + chloe + "/scene0.txt");
        scenes.add("resources/scenes/" + chloe + "/scene1.txt");
        scenes.add("resources/scenes/" + chloe + "/scene2.txt");
        scenes.add("resources/scenes/" + chloe + "/scene3.txt");
        scenes.add("resources/scenes/" + chloe + "/scene4.txt");
        scenes.add("resources/scenes/" + chloe + "/scene5.txt");
    }
    
    /**
    *   Adds the amount of bond experience earned or lost to the heroine's experience
    *   
    *   @param bondEarned     the amount of bond exp earned (positive or negative)
    */
    public void adjustBond(int bondEarned)
    {
        bondExp += bondEarned;
        checkBond();
    }
    
    /**
    *   Checks if the heroine has earned enough bond experience to reach the next bond level
    */
    private void checkBond()
    {
        if (bondExp >= bondCap)
            bondUp();
    }
    
    /**
    *   If the bond experience cap is reached, the experience cap for the level is subtracted
    *   from the current experience of the character
    *   The level of the character increases by one
    */
    private void bondUp()
    {
        bondExp -= bondCap;
        bondLevel++;
        setBondCap();
    }
    
    /**
    *   Sets the bond cap for the current bond level
    */
    protected void setBondCap()
    {
        bondCap += (100 * Math.pow(2, bondLevel - 1));
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
}
