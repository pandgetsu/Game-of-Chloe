import java.awt.event.*;
/**
 * 
 */
public class enterNameGUI extends javax.swing.JPanel {
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField nameTextField1;
    private MasterGUI parentGUI;
    private String playerName; 
    /**
     * Creates new form enterName
     */
    public enterNameGUI(MasterGUI parent) {
        parentGUI = parent;
        initComponents();
    }
                      
    private void initComponents() {

        nameTextField1 = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(960, 720));

        nameTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        nameLabel.setText("Enter Your Name");

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); 
        titleLabel.setText("The Game Of Chloe");
        
        nameTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                playerName = nameTextField1.getText();
                parentGUI.setPlayerName(playerName);
                parentGUI.backToMenu();
            }
        });
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(nameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(nameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(titleLabel)
                .addGap(55, 55, 55)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }  
 
}