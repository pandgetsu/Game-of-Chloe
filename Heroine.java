/**
 * Abstract class Heroine - write a description of the class here
 * 
 * @author Eric Kang
 * @version 0.2
 */
public class Heroine
{
    protected String name;          // Name
    protected int bondCap;          // Bond level experience cap
    protected int bondExp;          // Bond level experience
    protected int bondLevel;        // Bond level (Represents heroine's degree of affection towards player)
    protected boolean isFound;      // If the heroine is found yet or not
    
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
}
