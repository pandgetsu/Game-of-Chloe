import javax.swing.*;
import java.awt.*;
/**
 * Simple JPanel that replaces the contents within MasterGUI when the user is currently within 
 * DungeonGUI
 * 
 * @author Francis Nguyen
 * @version 01
 */
public class inGame extends JPanel
{
    private JLabel gameState;
    /**
     * Constructor for objects of class inGame
     * Simply displays with a JLabel "Player is Currently in Game"
     * 
     * 
     * 
     * That's it
     * 
     * ...
     * 
     * Seriously
     * 
     */
    public inGame()
    {
        gameState = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(960, 720));
        setLayout(new java.awt.BorderLayout());

        gameState.setFont(new java.awt.Font("Arial", 0, 48));
        gameState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameState.setText("Player is Currently In Game");
        add(gameState, java.awt.BorderLayout.CENTER);
    }


}
