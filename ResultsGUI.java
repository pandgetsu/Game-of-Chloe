import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * Write a description of class ResultsGUII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultsGUI extends JPanel
{
    private ArrayList<Heroine> heroineList;
    private MasterGUI parentGUI;
    private JLabel title;
    private JLabel girl1, girl2, girl3, girl4;
    private JButton returnButton;
    /**
     * Constructor for objects of class ResultsGUII
     */
    public ResultsGUI(ArrayList<Heroine> girls, MasterGUI parent)
    {
        heroineList = girls; 
        parentGUI = parent; 
        
        initGUI();
    }
    public void initGUI()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setSize(960, 720);
        title = new JLabel("How did you do?");
        girl1 = new JLabel("With " + heroineList.get(0).getName() + 
            " you scored a bond level of: " + heroineList.get(0).getBond());
        girl2 = new JLabel("With " + heroineList.get(1).getName() + 
            " you scored a bond level of: " + heroineList.get(1).getBond());
        girl3 = new JLabel("With " + heroineList.get(2).getName() + 
            " you scored a bond level of: " + heroineList.get(2).getBond());
        girl4 = new JLabel("With " + heroineList.get(3).getName() + 
            " you scored a bond level of: " + heroineList.get(3).getBond());
        returnButton = new javax.swing.JButton("Return to the Tavern");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parentGUI.backToMenu();
            }
        });
        
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
        add(title);
        add(new JLabel(" "));
        add(girl1);
        add(girl2);
        add(girl3);
        add(girl4);
        add(new JLabel(" "));
        add(returnButton);
    }


}
