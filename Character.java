
/**
 * Write a description of class Character here.
 * test
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Character
{
    protected int stat_hp;      //Health points
    protected int stat_mp;      //Mana points
    protected int stat_str;     //Strength
    protected int stat_vit;     //Vitality
    protected int stat_int;     //Intelligence
    protected int stat_dex;     //Dexterity
    protected String name;      //Name
    
    /**
     * Constructor for objects of class Character
     */
    public Character()
    {
        
    }
    
    /**
     * Constructs a character object with all stats for general character
     * 
     * @param health        the current amount of health the character has at the given time
     * @param mana          the current amount of mana the character has at the given time
     * @param strength      the amount of strength the character has which translates to physical damage
     * @param vitality      the amount of vitality the character has which translates to their maximum health
     * @param intelligence  the amount of intelligence the character has which translates to their maximum mana and magic damage
     * @param dexterity     the amount of dexterity the character has which translates to critical chance
     * 
     */
    public Character(int health, int mana, int strength, int vitality, int intelligence, int dexterity, String chloe)
    {
        stat_hp = health;
        stat_mp = mana;
        stat_str = strength;
        stat_vit = vitality;
        stat_int = intelligence;
        stat_dex = dexterity;
        name = chloe;
        
    }
    
    /**
     * @return      current health points of the character
     */
    public int getHp()
    {
        return stat_hp;
    }
    
    /**
     * @return      current mana points of the character
     */
    public int getMp()
    {
        return stat_mp;
    }
    
    /**
     * @return      amount of strength the character has
     */
    public int getStr()
    {
        return stat_str;
    }
    
    /**
     * @return      amount of vitality the character has
     */
    public int getVit()
    {
        return stat_vit;
    }
    
    /**
     * @return      amount of intelligence the character has
     */
    public int getInt()
    {
        return stat_int;
    }
    
    /**
     * @return      amount of dexterity the character has
     */
    public int getDex()
    {
        return stat_dex;
    }
    
    public String getName()
    {
        return name;
    }
    /**
     * Here is the main() method
     * 
     */
    public static void main(String[] args)
    {
        // put your code here

    }
}