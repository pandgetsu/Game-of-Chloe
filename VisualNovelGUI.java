import javax.swing.*;
import javax.swing.OverlayLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import chn.util.*;
/**
 * VisualNovelGUI is a JPanel with 3 major components: 
 * 
 * A JPanel (imagePanel) which contains both a JButton to advance the scene and a JLabel to show the user an image of the NPC
 * 
 * A JLabel that indicates either the name of the player or the name of the NPC, depending on who is talking
 * 
 * A JPanel (textPanel) that contains both a JLabel that holds the actual dialogue, and another JPanel that holds 3 JButtons for purposes of dialogue choice
 * 
 * All dialogue is based off an inputed text file (formating for such a file is shown under readFromFile()) 
 * 
 * @Author Francis Nguyen
 */
public class VisualNovelGUI extends JPanel
{
    private MasterGUI parentGUI;
    private JPanel imagePanel, textPanel;
    private JButton backgroundButton;
    private JLabel npc, textField, nameLabel;
    private ImageIcon background, character;
    private CardLayout c;
    
    private ArrayList<VNDialogue> textList;
    private String playerName;
    private int index;
    
    private Heroine chloe;
    private JButton selection1, selection2, selection3;
    private JPanel selectionPanel;
    private boolean selectionState; //indicates if the user is currently making a dialogue choice (this disables backgroundButton from advancing until a choice is made)
    private String sceneSwap = null;
    /**
     * Constructor that reads from the file given by the String argument and then initilizes the GUI accordingly
     * Sets the default name to Mark
     */
    public VisualNovelGUI(String fileName, MasterGUI parent)
    {
        parentGUI = parent; 
        playerName = "Mark";
        index = 0;
        selectionState = false;
        chloe = new Heroine("empty", 0);
        
        npc = new JLabel();
        backgroundButton = new JButton();
        
        readFromFile(fileName);
        initGUI();
    }
    public VisualNovelGUI(String fileName, Heroine girl, MasterGUI parent)
    {
        parentGUI = parent; 
        playerName = parentGUI.getPlayerName();
        index = 0;
        selectionState = false;
        chloe = girl;
                
        npc = new JLabel();
        backgroundButton = new JButton();
        
        readFromFile(fileName);
        initGUI();
    }
    /**
     * Constructor that reads from the file given by the String argument, sets the name to what was given by pName, and the initilizes the GUI accordingly
     */
    public VisualNovelGUI(String fileName, String pName, MasterGUI parent)
    {
        parentGUI = parent;
        playerName = pName;
        index = 0;
        selectionState = false;
        chloe = new Heroine("empty", 0);
                
        npc = new JLabel();
        backgroundButton = new JButton();
        
        readFromFile(fileName);
        initGUI();
    }
    /**
     * readFromFile() takes from a string file and adds blocks of dialogue stored as VNDialogue objects (one VNDialogue object represents one block of dialogue)
     * and adds them to an array.
     * The text file MUST follow the following format for the dialogue to be set up correctly
     * 
     * __________________________________ 
     * <filelocation/NPCimage.whatever>                                  //<Nobody> indicates there is no npc
     * <filelocation/backgroundimage.whatever>
     * <Number of Dialogue Blocks> 
     * <Character Name>   
     * <Dialogue>  ******ALWAYS ONE LINE OF TEXT*******
     * <Character Name> 
     * <Dialogue>
     * <<Selection>>
     * <First Choice>|<First Response>|<BondChange>
     * <Second Choice>|<Second Response>|<BondChange>
     * <Third Choice>|<Third Response>|<BondChange>
     * ...
     * __________________________________
     * 
     * <Event> denotes no name
     * <Player> denotes playerName
     * <Selection> denotes player choice in dialogue
     * 
     * 
     * <Next Scene> indicates that we are swapping to another text file, always follow this by a txt file location i.e:
     * <filelocation/nextScene.txt>
     */
    private void readFromFile(String fileName)
    {        
        sceneSwap = null;
        FileInput inFile = new FileInput(fileName);
        
        String c = inFile.readToken();
        if(c.equals("<Nothing>") || c.equals("<nothing>"))
            character = null;
        else
            if(c.equals(chloe.getName()))
                character = new ImageIcon("resources/images/" + chloe.getName() + ".png");
            else
                if(c.equals("ChloeNoHood"))
                    character = new ImageIcon("resources/images/ChloeNoHood.png");
                else
                    character = new ImageIcon(c);
        String b = inFile.readToken();
        if(b.equals("Dungeon") || b.equals("dungeon") || b.equals("DungeonBackground"))
        {
            background = new ImageIcon(new ImageIcon("resources/images/ddungeonbackground.jpg")
                .getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT));
        }
        else
            if(b.equals("Tavern") || b.equals("tavern"))
            {
                background = new ImageIcon(new ImageIcon("resources/images/Tavern.png")
                    .getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT));
            }
            else
            {
                background = new ImageIcon(new ImageIcon(b)
                    .getImage().getScaledInstance(960, 720, Image.SCALE_DEFAULT));
            }
        int howMany = inFile.readInt(); //how many blocks of dialogue there are
        textList = new ArrayList<VNDialogue>(howMany);
        for(int k = 0; k < howMany; k++) 
        {
            VNDialogue temp;
            String name = inFile.readLine();
            name = name.trim();
            if(name.equals("<Selection>") || name.equals("<selection>"))
            {
                int firstLine;
                int secondLine;
                temp = new VNSelection();
                temp.setName(playerName);
                
                String tempString = inFile.readLine();
                firstLine = tempString.indexOf("|");
                secondLine = tempString.indexOf("|", firstLine + 1);
                temp.setDiag(tempString.substring(0, firstLine));
                ((VNSelection)temp).setResponse1(tempString.substring(firstLine + 1, secondLine));
                ((VNSelection)temp).setBond1(tempString.substring(secondLine + 1));
                
                tempString = inFile.readLine();
                firstLine = tempString.indexOf("|");
                secondLine = tempString.indexOf("|", firstLine + 1);
                ((VNSelection)temp).setDiag2(tempString.substring(0, firstLine));
                ((VNSelection)temp).setResponse2(tempString.substring(firstLine + 1, secondLine));
                ((VNSelection)temp).setBond2(tempString.substring(secondLine + 1));
                
                tempString = inFile.readLine();
                firstLine = tempString.indexOf("|");
                secondLine = tempString.indexOf("|", firstLine + 1);
                ((VNSelection)temp).setDiag3(tempString.substring(0, firstLine));
                ((VNSelection)temp).setResponse3(tempString.substring(firstLine + 1, secondLine));
                ((VNSelection)temp).setBond3(tempString.substring(secondLine + 1));
                
                textList.add(temp);
            }
            else
                if(name.equals("<Next Scene>") || name.equals("<next scene>") || name.equals("<Next Event>") || name.equals("<next event>"))
                {
                    sceneSwap = "resources/scenes/" + chloe.getName() + "/" + inFile.readLine() + ".txt";
                }
                else
                    if(name.equals("<Next Event SPECIAL>"))
                        sceneSwap = "resources/scenes/start/start02.txt";
                else
                {
                    temp = new VNDialogue();
                    if(name.equals("<Player>") || name.equals("<player>"))
                        temp.setName(playerName);
                        else
                            if(name.equals("<" + chloe.getName() + ">"))
                                temp.setName(chloe.getName());
                            else
                            if(name.equals("<Event>") || name.equals("<event>"))
                                temp.setName("");    
                                else
                                    temp.setName(name);  
                    temp.setDiag(inFile.readLine());
                    
                    textList.add(temp);
                }   
            
        }
        npc.setIcon(character);
        backgroundButton.setIcon(background);
        //initComponents();
    }
    /*
     * Mainly sets up all the JPanels, calls initComponents() to set up the minor components (JLabels and JButtons) and then adds the components to the secondary panels
     * and then adds those panels to the main panel
     */
    private void initGUI()
    {
        imagePanel = new JPanel();
        textPanel = new JPanel();
        selectionPanel = new JPanel();
        
        initComponents();

        setPreferredSize(new java.awt.Dimension(960, 737));

        imagePanel.setLayout(new javax.swing.OverlayLayout(imagePanel));

        imagePanel.add(npc);

        imagePanel.add(backgroundButton);

        c = new CardLayout();
        textPanel.setLayout(c);

        textField.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        textField.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));
        textPanel.add(textField, "card2");

        selectionPanel.setLayout(new java.awt.GridLayout(3, 0));

        selection1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectionPanel.add(selection1);

        selection2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectionPanel.add(selection2);

        selection3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectionPanel.add(selection3);

        textPanel.add(selectionPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        c.first(textPanel);
    }
    /**
     * Sets up the secondary components (Jbuttons and JLabels)
     */
    private void initComponents(){
        selection1 = new JButton();
        selection2 = new JButton();
        selection3 = new JButton();
        selectionPanel.add(selection1);
        selectionPanel.add(selection2);
        selectionPanel.add(selection3);
        
        //backgroundButton = new JButton(background);
        backgroundButton.setOpaque(false);
        //if(character != null)
           // npc = new JLabel(character);
        //else
            //npc = new JLabel("There's nobody here");
        textField = new JLabel(textList.get(0).getDiag());
        nameLabel = new JLabel(textList.get(0).getName());
        
        backgroundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextText();
            }
        });
        selection1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select1();
            }
        });
        selection2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select2();
            }
        });
        selection3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select3();
            }
        });
    }
    /**
     * Transitions to the next dialogue block (represented by the Object VNDialogue)
     * 
     * If the Object indicates that it is a selection scenario, then invokeSelection() is called which sets up the dialogue selection scene
     * 
     * Nothing occurs if there are no more dialogue blocks (this will likely change to exit the VNGUI and return to the previous GUI)
     */
    private void nextText()
    {
        if(!selectionState)
        {
            if(index < textList.size() - 1)
            {
                index++;
                if(textList.get(index).getName().equals("<Start Game>"))
                    parentGUI.goToDungeon();
                else
                {
                    if(!textList.get(index).isSelection())
                    {
                        textField.setText(textList.get(index).getDiag());
                        nameLabel.setText(textList.get(index).getName());
                    }
                    else
                    {
                        nameLabel.setText(textList.get(index).getName());
                        invokeSelection();
                    }      
                }
            }
            else
            {
                if(sceneSwap != null)
                {
                    readFromFile(sceneSwap);
                    index = 0;
                    if(!textList.get(index).isSelection())
                    {
                        textField.setText(textList.get(index).getDiag());
                        nameLabel.setText(textList.get(index).getName());
                        if(index == textList.size() - 1)
                        {
                            backgroundButton.removeActionListener(backgroundButton.getActionListeners()[0]);
                            backgroundButton.addActionListener(parentGUI);
                        }
                    }
                    else
                    {
                        nameLabel.setText(textList.get(index).getName());
                        invokeSelection();
                        if(index == textList.size() - 1)
                        {
                            backgroundButton.removeActionListener(backgroundButton.getActionListeners()[0]);
                            backgroundButton.addActionListener(parentGUI);
                        }
                    }    
                }
                else
                    parentGUI.backToMenu();
            }
        }
    }
    private void invokeSelection()
    {
        selectionState = true;
        
        selection1.setText(textList.get(index).getDiag());
        selection2.setText(((VNSelection)textList.get(index)).getDiag2());
        selection3.setText(((VNSelection)textList.get(index)).getDiag3());

        c.last(textPanel);
    }
    private void select1()
    {
        selectionState = false;
        chloe.adjustBond(((VNSelection)textList.get(index)).getBond1());
        textField.setText(((VNSelection)textList.get(index)).getResponse1());
        c.first(textPanel);
    }
    private void select2()
    {
        selectionState = false;
        chloe.adjustBond(((VNSelection)textList.get(index)).getBond2());
        textField.setText(((VNSelection)textList.get(index)).getResponse2());
        c.first(textPanel);
    }
    private void select3()
    {
        selectionState = false;
        chloe.adjustBond(((VNSelection)textList.get(index)).getBond3());
        textField.setText(((VNSelection)textList.get(index)).getResponse3());
        c.first(textPanel);
    }
}
