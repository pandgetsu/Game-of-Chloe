import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    public MasterGUI(){
        setTitle("TGoC - The Game of Chloe");
        setSize(960, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        menu = new MenuGUI(this);
        //add(menu);
        add(new enterNameGUI(this));
        
        dummyPanel = new JPanel();
        dummyPanel.add(new JLabel("Wow"));
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("Test VN"))
            swapPanels(new VisualNovelGUI("testDiag.txt", this));
        else
            if(command.equals("") || command.equals("menu"))
                backToMenu();
            else
                if(command.equals("Start Game"))
                {
                    swapPanels(new inGame());
                    DungeonGame TGOC = new DungeonGame("The Game of Chloe", 960, 720, false, this); //(Game Title, Width, Height, Flashlight)
                    TGOC.start();
                }                        
                else
                    swapPanels(dummyPanel);
        pack();
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
        add(menu);
        revalidate();
        repaint();
        pack();
    }
    public void goToVisualNovel(String fileName)
    {
        getContentPane().removeAll();
        add(new VisualNovelGUI(fileName, this));
        revalidate();
        repaint();
    }
}
