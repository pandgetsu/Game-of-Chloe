
/**
 * Write a description of class Weapon here.
 * 
 * @author Eric Kang
 * @version 0.11
 */
public abstract class Weapon extends Item
{
    protected String dmgType;       // Type of damage this weapon deals (Physical/Magical)
    protected double dmgModifier;   // Determines damage based upon multiplier by character's stats
                                    // Strength for physical, Intelligence for magical
    protected int damage;
    
    /**
     * Constructor for objects of class Weapon
     */
    public Weapon()
    {
        
    }
}
