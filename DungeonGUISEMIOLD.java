/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Jrmcjr
 */
public class DungeonGUISEMIOLD extends javax.swing.JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private javax.swing.JPanel clientPanel;
    private Canvas clientCanvas;
    private javax.swing.JButton controlsButton;
    private javax.swing.JButton giveUpButton;
    private javax.swing.JLabel instructions1;
    private javax.swing.JLabel instructions2;
    private javax.swing.JLabel keyIcon;
    private javax.swing.JLabel stat_ATK_Display;
    private javax.swing.JLabel stat_DEF_Display;
    private javax.swing.JLabel stat_HP_Display;
    
    private JLabel controls_WASD;
    private String myTitle;
    private int myWidth;
    private int myHeight;
    
    private Handler myHandler;
    
    private boolean keyAdded = false;
    
    private MasterGUI myMaster;
    /**
     * Creates new form DungeonGUI
     */
    public DungeonGUISEMIOLD(String title, int width, int height, Handler handler, MasterGUI parent) {
        myTitle = title;
        myWidth = width;
        myHeight = height;
        
        myHandler = handler;
        myMaster = parent;
        
        setTitle(myTitle);
        setSize(myWidth, myHeight);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        initComponents();
    }
    
    public DungeonGUISEMIOLD getGUI()
    {
        return this;
    }

                            
    private void initComponents() {
        clientCanvas = new Canvas();
        clientCanvas.setPreferredSize(new Dimension(myWidth, myHeight));
        clientCanvas.setMaximumSize(new Dimension(myWidth, myHeight));
        clientCanvas.setMinimumSize(new Dimension(myWidth, myHeight));
        clientCanvas.setFocusable(false);
        //add(clientCanvas);
        
        
        clientPanel = new javax.swing.JPanel();
        
        giveUpButton = new javax.swing.JButton();
        instructions1 = new javax.swing.JLabel();
        instructions2 = new javax.swing.JLabel();
        keyIcon = new javax.swing.JLabel(new ImageIcon(Assets.doorKey));
        controlsButton = new javax.swing.JButton();
        stat_HP_Display = new javax.swing.JLabel();
        stat_ATK_Display = new javax.swing.JLabel();
        stat_DEF_Display = new javax.swing.JLabel();
//         jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        giveUpButton.setText("Give Up?");

        instructions1.setText("All mobs must be killed first");

        instructions2.setText("A key is required to open the door");

        controlsButton.setText("Controls");

        stat_HP_Display.setText("jLabel1");

        stat_ATK_Display.setText("jLabel6");

        stat_DEF_Display.setText("jLabel7");

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(instructions2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(keyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructions1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stat_HP_Display)
                    .addComponent(stat_ATK_Display)
                    .addComponent(stat_DEF_Display))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giveUpButton)
                    .addComponent(controlsButton))
                .addGap(95, 95, 95))
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addComponent(controlsButton)
                                .addGap(18, 18, 18)
                                .addComponent(giveUpButton))
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addComponent(stat_HP_Display)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stat_ATK_Display)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stat_DEF_Display))))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addComponent(keyIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instructions1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructions2)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    
//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//             .addComponent(clientCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                 .addComponent(clientCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                 .addComponent(clientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//         );
        //controls_WASD = new JLabel(new ImageIcon(Assets.controlsWASD));
        //clientPanel.add(controls_WASD, BorderLayout.EAST);
        clientPanel.setSize(960, 50);
        
        setUpButtons();
        
        add(clientPanel, BorderLayout.SOUTH);
        add(clientCanvas);
        clientCanvas.requestFocusInWindow();
        pack();
    }// </editor-fold>                        
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
    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
        // TODO Auto-generated method stub

    }
    private void setUpButtons()
    {
        controlsButton.setFocusable(false);
        giveUpButton.setFocusable(false);
        controlsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");
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
