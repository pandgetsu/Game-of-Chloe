import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
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
    private JButton dblank1, dblank2, dblank3, dblank4, rblank;
    private JButton blank1, blank2, blank3, blank4;
    private boolean postStart;
    public MasterGUI parentGUI;
    private ArrayList<Heroine> heroineList;
    public MenuGUI(MasterGUI parent, ArrayList<Heroine> girl){
        parentGUI = parent;
        heroineList = girl;
        postStart = true;
        initGUI();
        checkState();
    }
   /**
    *For purposes of changing the background of the menuGUI
    */
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
        dblank1 = new JButton("    ???     ");
        dblank2 = new JButton("    ???     ");
        dblank3 = new JButton("    ???     ");
        dblank4 = new JButton("    ???     ");
        rblank = new JButton("    ???     ");
        blank1 = new JButton("    ???     ");
        blank2 = new JButton("    ???     ");
        blank3 = new JButton("    ???     ");
        blank4 = new JButton("    ???     ");
        
        setPreferredSize(new java.awt.Dimension(960, 720));
        setLayout(new java.awt.GridBagLayout());

        start.setText("Start Game");
        start.addActionListener(parentGUI);
        //start.setOpaque(true);
        start.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        add(start, gridBagConstraints);
        
        d1Button.setText("Dungeon 1");
        d1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToDungeon(heroineList.get(0));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(d1Button, gridBagConstraints);
        add(dblank1, gridBagConstraints);

        girl1Button.setText("  Chloe  ");
        girl1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToVisualNovel(heroineList.get(0));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(girl1Button, gridBagConstraints);
        add(blank1, gridBagConstraints);

        d2Button.setText("Dungeon 2");
        d2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToDungeon(heroineList.get(1));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(d2Button, gridBagConstraints);
        add(dblank2, gridBagConstraints);

        girl2Button.setText("  Illya  ");
        girl2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToVisualNovel(heroineList.get(1));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(girl2Button, gridBagConstraints);
        add(blank2, gridBagConstraints);

        d3Button.setText("Dungeon 3");
        d3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToDungeon(heroineList.get(2));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(d3Button, gridBagConstraints);
        add(dblank3, gridBagConstraints);
        

        girl3Button.setText("  Celica  ");
        girl3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToVisualNovel(heroineList.get(2));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(girl3Button, gridBagConstraints);
        add(blank3, gridBagConstraints);

        d4Button.setText("Dungeon 4");
        d4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToDungeon(heroineList.get(3));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(d4Button, gridBagConstraints);
        add(dblank4, gridBagConstraints);

        girl4Button.setText("  Grill?  ");
        girl4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.goToVisualNovel(heroineList.get(3));
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(girl4Button, gridBagConstraints);
        add(blank4, gridBagConstraints);

        finalDButton.setText("Results");
        finalDButton.addActionListener(parentGUI);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        add(finalDButton, gridBagConstraints);
        add(rblank, gridBagConstraints);
    }
    public void checkState()
    {
        if(heroineList.get(0).isFound)
        {
            girl1Button.setVisible(true);
            blank1.setVisible(false);
        }
        else
        {
            girl1Button.setVisible(false);
            blank1.setVisible(true);
        }
            
        if(heroineList.get(1).isFound)
        {
            girl2Button.setVisible(true);
            blank2.setVisible(false);
        }
        else
        {
            girl2Button.setVisible(false);
            blank2.setVisible(true);
        }
            
        if(heroineList.get(2).isFound)
        {
            girl3Button.setVisible(true);
            blank3.setVisible(false);
        }
        else
        {
            girl3Button.setVisible(false);
            blank3.setVisible(true);
        }
            
        if(heroineList.get(3).isFound)
        {
            girl4Button.setVisible(true);
            blank4.setVisible(false);
        }
        else
        {
            girl4Button.setVisible(true);
            blank4.setVisible(false);
        }
        
        if(postStart)
        {
            dblank1.setVisible(false);
            d1Button.setVisible(true);
            
            dblank2.setVisible(false);
            d2Button.setVisible(true);
            
            dblank3.setVisible(false);
            d3Button.setVisible(true);
            
            dblank4.setVisible(false);
            d4Button.setVisible(true);
            
            rblank.setVisible(false);
            finalDButton.setVisible(true);
        }
        else
        {
            dblank1.setVisible(true);
            d1Button.setVisible(false);
            
            dblank2.setVisible(true);
            d2Button.setVisible(false);
            
            dblank3.setVisible(true);
            d3Button.setVisible(false);
            
            dblank4.setVisible(true);
            d4Button.setVisible(false);
            
            rblank.setVisible(true);
            finalDButton.setVisible(false);
        }
    }
    public void setPostStart(boolean state)
    {
        postStart = state;
    }
}
