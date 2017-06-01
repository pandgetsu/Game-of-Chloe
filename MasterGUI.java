import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class MasterGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MasterGUI extends JFrame implements ActionListener
{
    private MenuGUI menu;
    private JPanel currentPanel; 
    private JPanel dummyPanel;
    private ArrayList<Heroine> heroineList;
    private String playerName = "Mark";
    
    public MasterGUI(){
        initGirlList();

        
        setTitle("TGoC - The Game of Chloe");
        setSize(960, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        menu = new MenuGUI(this, heroineList);
        //add(menu);
        add(new enterNameGUI(this));
        
        dummyPanel = new JPanel();
        dummyPanel.add(new JLabel("fuck you"));
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("") || command.equals("menu"))
            backToMenu();
        else
            if(command.equals("Start Game"))
            {
                goToVisualNovel("resources/scenes/start/start01.txt");
            }   
            else
                if(command.equals("Results"))
                {
                    swapPanels(new ResultsGUI(heroineList, this));
                }
                    else
                        swapPanels(dummyPanel);
    }    
    private void swapPanels(JPanel newPanel)
    { 
        getContentPane().removeAll();
        add(newPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    public void backToMenu()
    {
        getContentPane().removeAll();
        menu.checkState();
        add(menu);
        revalidate();
        repaint();
        pack();
    }
    public void goToDungeon()
    {
        swapPanels(new inGame());
        DungeonGame TGOC = new DungeonGame("The Game of Chloe", 960, 720, false, this, heroineList.get(0)); //(Game Title, Width, Height, Flashlight)
        TGOC.start();
    }
    public void goToDungeon(Heroine h)
    {
        swapPanels(new inGame());
        DungeonGame TGOC = new DungeonGame("The Game of Chloe", 960, 720, false, this, h); //(Game Title, Width, Height, Flashlight)
        TGOC.start();
    }
    public void goToVisualNovel(String fileName)
    {
        getContentPane().removeAll();
        add(new VisualNovelGUI(fileName, this));
        revalidate();
        repaint();
        pack();
    }
    public void goToVisualNovel(Heroine h)
    {
        getContentPane().removeAll();
        add(new VisualNovelGUI(h.getScene(), h, this));
        revalidate();
        repaint();
        pack();
    }
    public void setPlayerName(String pName)
    {
        playerName = pName;
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public void doneWithStart()
    {
        menu.setPostStart(true);
    }
    private void initGirlList()
    {
        heroineList = new ArrayList<Heroine>(4);
        heroineList.add(new Heroine("Chloe", 1));
        heroineList.add(new Heroine("Illya", 2));
        heroineList.add(new Heroine("Celica", 3));
        heroineList.add(new Heroine("Grill", 4));
    }
    
}
