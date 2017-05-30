import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * MenuGUI AKA "The Tavern" serves as the main hub to go to the different aspects of the game
 * that being mainly the dungeon and the visual novel.
 * 
 * Mainly consists of JButtons, some of which appear only after that content is unlocked
 * within the respective dungeon. 
 * 
 * @author Francis Nguyen
 * @version 02
 */
public class MenuGUI extends JPanel
{
    private javax.swing.JButton d1Button;
    private javax.swing.JButton d2Button;
    private javax.swing.JButton d3Button;
    private javax.swing.JButton d4Button;
    private javax.swing.JButton finalDButton;
    private javax.swing.JButton girl1Button;
    private javax.swing.JButton girl2Button;
    private javax.swing.JButton girl3Button;
    private javax.swing.JButton girl4Button;
    private javax.swing.JButton start;
    
    public MasterGUI parentGUI;
    public MenuGUI(MasterGUI parent){//, Girl girl1, Girl girl2, Girl girl3){
        parentGUI = parent;

        initGUI();
    }
    @Override
    public void paintComponent(Graphics g) {
    
        //super.paintComponent(g);
            g.drawImage(ImageLoader.loadImage("/resources/images/Tavern.png"), 0, 0, null);
    }
    private void initGUI()
    {
        
        java.awt.GridBagConstraints gridBagConstraints;

        start = new javax.swing.JButton();
        d1Button = new javax.swing.JButton();
        girl1Button = new javax.swing.JButton();
        d2Button = new javax.swing.JButton();
        girl2Button = new javax.swing.JButton();
        d3Button = new javax.swing.JButton();
        girl3Button = new javax.swing.JButton();
        d4Button = new javax.swing.JButton();
        girl4Button = new javax.swing.JButton();
        finalDButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(960, 720));
        setLayout(new java.awt.GridBagLayout());

        start.setText("Start Game");
        start.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        add(start, gridBagConstraints);

        d1Button.setText("jButton2");
        d1Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(d1Button, gridBagConstraints);

        girl1Button.setText("Test VN");
        girl1Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
            add(girl1Button, gridBagConstraints);

        d2Button.setText("jButton4");
        d2Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(d2Button, gridBagConstraints);

        girl2Button.setText("jButton5");
        girl2Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(girl2Button, gridBagConstraints);

        d3Button.setText("jButton6");
        d3Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(d3Button, gridBagConstraints);

        girl3Button.setText("jButton7");
        girl3Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(girl3Button, gridBagConstraints);

        d4Button.setText("jButton1");
        d4Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(d4Button, gridBagConstraints);

        girl4Button.setText("jButton2");
        girl4Button.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(girl4Button, gridBagConstraints);

        finalDButton.setText("jButton8");
        finalDButton.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        add(finalDButton, gridBagConstraints);
    }
}
