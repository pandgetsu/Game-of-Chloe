/**
 * Abstract class Mob - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Mob extends Character
{
    /**
     *  Constructs a mob object
     *  
     *  @param chloe         the name of the mob
     *  @param health        the current amount of health the mob has at the given time
     *  @param mana          the current amount of mana the mob has at the given time
     *  @param strength      the amount of strength the mob has which translates to physical damage
     *  @param vitality      the amount of vitality the mob has which translates to their maximum health
     *  @param intelligence  the amount of intelligence the mob has which translates to their maximum mana and magic damage
     *  @param dexterity     the amount of dexterity the mob has which translates to critical chance
     */
    public Mob(String chloe, int health, int mana, int strength, int vitality, int intelligence, int dexterity)
    {
        super(chloe, health, mana, strength, vitality, intelligence, dexterity);
    }
    
    /**
     * Mobs have set levels and do not earn or use exp
     */
    protected void setExpCap()
    {
        
    }
}
