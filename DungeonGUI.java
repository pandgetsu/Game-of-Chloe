import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class DungeonGUITake3 here.
 * 
 * @author Sean Tran and Francis Nguyen
 * @version (a version number or a date)
 */
public class DungeonGUI extends JFrame
{
    private javax.swing.JPanel clientPanel;
    private javax.swing.JButton controlsButton;
    private javax.swing.JButton giveUpButton;
    private javax.swing.JLabel instructions1;
    private javax.swing.JLabel instructions2;
    private javax.swing.JLabel keyIcon;
    private javax.swing.JLabel stat_ATK_Display;
    private javax.swing.JLabel stat_DEF_Display;
    private javax.swing.JLabel stat_HP_Display;  
    private JLabel controls_WASD;
    
    private Canvas clientCanvas;
    private Handler myHandler;
    private boolean keyAdded = false;
    private MasterGUI myMaster; 
        public DungeonGUI(String title, Handler handler, MasterGUI parent) {
        setTitle(title);
        setSize(960, 720);
        
        myHandler = handler;
        myMaster = parent;
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
        
    }
                  
    private void initComponents() {

        clientPanel = new javax.swing.JPanel();
        giveUpButton = new javax.swing.JButton();
        instructions1 = new javax.swing.JLabel();
        instructions2 = new javax.swing.JLabel();
        keyIcon = new javax.swing.JLabel(new ImageIcon(Assets.doorKey));
        controls_WASD = new JLabel(new ImageIcon(Assets.controlsWASD));
        controlsButton = new javax.swing.JButton();
        stat_HP_Display = new javax.swing.JLabel();
        stat_ATK_Display = new javax.swing.JLabel();
        stat_DEF_Display = new javax.swing.JLabel();
        
        clientCanvas = new Canvas();
        clientCanvas.setPreferredSize(new Dimension(945, 570));
        clientCanvas.setMaximumSize(new Dimension(945, 570));
        clientCanvas.setMinimumSize(new Dimension(945, 570));
        clientCanvas.setFocusable(false);
        

        giveUpButton.setText("Give Up?");

        instructions1.setText("All mobs must be killed first");

        instructions2.setText("A key is required to open the door");

        controlsButton.setText("Controls");
        
        setUpButtons();
        
        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(instructions2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(instructions1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(keyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(99, 99, 99)))
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stat_HP_Display)
                            .addComponent(stat_ATK_Display)
                            .addComponent(stat_DEF_Display))))
                .addGap(399, 399, 399)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giveUpButton)
                    .addComponent(controlsButton))
                .addGap(97, 97, 97))
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(controlsButton)
                        .addGap(18, 18, 18)
                        .addComponent(giveUpButton))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(stat_HP_Display)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stat_ATK_Display))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(keyIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stat_DEF_Display)
                            .addComponent(instructions1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(instructions2)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(clientCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }                                         
    public void tick()
    {
        stat_HP_Display.setText("HP: " + myHandler.getInstance().getEntityHandler().getMainCharacter().getStat_HP());
        stat_ATK_Display.setText("ATK: " + myHandler.getInstance().getEntityHandler().getMainCharacter().getStat_ATK());
        stat_DEF_Display.setText("DEF: " + myHandler.getInstance().getEntityHandler().getMainCharacter().getStat_DEF());
        if(myHandler.getInstance().getEntityHandler().getMainCharacter().hasItem())
        {
            if(myHandler.getInstance().getEntityHandler().getMainCharacter().isHasKey() || !keyAdded)
            {
                keyIcon.setVisible(true);
                //clientPanel.add(keyIcon);
                keyAdded = true;
            }
        }else
        {
            keyIcon.setVisible(false);
            //clientPane    l.remove(keyIcon);
        }
        
        pack();
    }
    public Canvas getCanvas()
    {
        return clientCanvas;
    }

    public JFrame getFrame()
    {
        return this;
    }   
    private void setUpButtons()
    {
        controlsButton.setFocusable(false);
        giveUpButton.setFocusable(false);
        controlsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JFrame(), "0 To Reset Dungeon\nSpace to Shoot\nE to interact", "Controls", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Assets.controlsWASD));
                clientCanvas.requestFocusInWindow();
            }
        });
        giveUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myMaster.backToMenu();
                clientCanvas.requestFocusInWindow();
                myHandler.getGame().stop();
            }
        });
    }
}
