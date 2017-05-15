import chn.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    /**
     * Constructor for objects of class Player
     */
    public Player(String chloe, int health, int mana, int strength, int vitality, int intelligence, int dexterity)
    {
       super(chloe, health, mana, strength, vitality, intelligence, dexterity);
    }
    
//     private String readName()
//     {
//         ConsoleIO keyboard = new ConsoleIO();
//         String chloe;
//         
//         System.out.print("Enter player name: ");
//         chloe = keyboard.readLine();
//         
//         return chloe;
//     }
    
    /**
    *   Sets the experience cap for the current level
    */
    protected void setExpCap()
    {
        expCap += (100 * Math.pow(2, level - 1));
    }
}
