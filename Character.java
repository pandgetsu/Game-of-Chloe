/**
 *  Write a description of class Character here.
 * 
 *  @author Brian Lu, Eric Kang
 *  @version (a version number or a date)
 */
public abstract class Character
{
    protected String name;      // Name
    protected int level;        // Level
    protected int exp;          // Experience
    protected int expCap;       // Highest amount of experience for current level
    protected int stat_hp;      // Health points
    protected int stat_mp;      // Mana points
    protected int stat_str;     // Strength
    protected int stat_vit;     // Vitality
    protected int stat_int;     // Intelligence
    protected int stat_dex;     // Dexterity
    
    /**
     *  Constructs a character object with all stats for general character
     *  Level starts at 1
     *  Experience starts at 0
     *  Experience Cap starts at 1000
     *  
     *  @param health        the current amount of health the character has at the given time
     *  @param mana          the current amount of mana the character has at the given time
     *  @param strength      the amount of strength the character has which translates to physical damage
     *  @param vitality      the amount of vitality the character has which translates to their maximum health
     *  @param intelligence  the amount of intelligence the character has which translates to their maximum mana and magic damage
     *  @param dexterity     the amount of dexterity the character has which translates to critical chance
     */
    public Character(int health, int mana, int strength, int vitality, int intelligence, int dexterity, String chloe)
    {
        level = 1;
        exp = 0;
        expCap = 1000;
        stat_hp = health;
        stat_mp = mana;
        stat_str = strength;
        stat_vit = vitality;
        stat_int = intelligence;
        stat_dex = dexterity;
        name = chloe;
    }
    
    /**
    *   Checks if the character has earned enough experience to reach the next level
    */
    public void nextLevel()
    {
        if (exp >= expCap)
            levelUp();
    }
    
    /**
    *   If the experience cap is reached, the experience cap for the level is subtracted
    *   from the current experience of the character
    *   The level of the character increases by one
    */
    private void levelUp()
    {
        exp -= expCap;
        level++;
        setExpCap();
    }
    
    /**
    *   Sets the experience cap for the current level
    */
    private void setExpCap()
    {
        expCap += (100 * Math.pow(2, level - 1));
    }
    
    /**
    *   @return     name of the character
    */
    public String getName()
    {
        return name;
    }
    
    /**
     *  @return      current level of the character
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     *  @return      current amount of experience the character has
     */
    public int getExp()
    {
        return exp;
    }
    
    /**
     *  @return      current experience cap of the character
     */
    public int getExpCap()
    {
        return expCap;
    }
    
    /**
     *  @return      current health points of the character
     */
    public int getHp()
    {
        return stat_hp;
    }
    
    /**
     *  @return      current mana points of the character
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
     *  @return      amount of vitality the character has
     */
    public int getVit()
    {
        return stat_vit;
    }
    
    /**
     *  @return      amount of intelligence the character has
     */
    public int getInt()
    {
        return stat_int;
    }
    
    /**
     *  @return      amount of dexterity the character has
     */
    public int getDex()
    {
        return stat_dex;
    }
}
