/**
 * Abstract class Heroine - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Heroine extends Character
{
    protected int bondExp;          // Bond level experience
    protected int bondCap;          // Bond level experience cap
    protected int bondLevel;        // Bond level (Represents heroine's degree of affection towards player)
    
    /**
     *  Constructs a heroine object
     *  bondLevel starts at 0
     *  bondExp starts at 0
     *  initial bondCap is 1000
     *  
     *  @param chloe         the name of the heroine
     *  @param health        the current amount of health the heroine has at the given time
     *  @param mana          the current amount of mana the heroine has at the given time
     *  @param strength      the amount of strength the heroine has which translates to physical damage
     *  @param vitality      the amount of vitality the heroine has which translates to their maximum health
     *  @param intelligence  the amount of intelligence the heroine has which translates to their maximum mana and magic damage
     *  @param dexterity     the amount of dexterity the heroine has which translates to critical chance
     */
    public Heroine(String chloe, int health, int mana, int strength, int vitality, int intelligence, int dexterity)
    {
        super(chloe, health, mana, strength, vitality, intelligence, dexterity);
        bondLevel = 0;
        bondExp = 0;
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
    protected abstract void setBondCap();
}
