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

public class DungeonGUIOLD  extends JPanel implements ActionListener
{
	/**
	 * eclipse told me to create this VVV
	 */
	private static final long serialVersionUID = 1L;
	private JFrame clientFrame;
	private JPanel clientPanel;
	private Canvas clientCanvas;
	
	private JLabel stat_HP_Display;
	private JLabel stat_ATK_Display;
	private JLabel stat_DEF_Display;
	
	private JLabel keyIcon;
	private JLabel controls_WASD;

	private String myTitle;
	private int myWidth;
	private int myHeight;
	
	private Handler myHandler;
	
	private boolean keyAdded = false;
	
	//private MasterGUI parentGUI;

	public DungeonGUIOLD(String title, int width, int height, Handler handler)
	{
		//parentGUI = parent;
		myTitle = title;
		myWidth = width;
		myHeight = height;
		
		myHandler = handler;

		initGUI();
	}

	private void initGUI()
	{
		//Game Window
		clientFrame = new JFrame(myTitle);
		clientFrame.setSize(myWidth, myHeight);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setResizable(false);
		clientFrame.setLocationRelativeTo(null);
		clientFrame.setVisible(true);
		clientFrame.setLayout(new BorderLayout());

		//Player Information
		clientPanel = new JPanel();
		clientPanel.setSize(960, 200);
		clientPanel.setLocation(0, 576);

		clientCanvas = new Canvas();
		clientCanvas.setPreferredSize(new Dimension(myWidth, myHeight));
		clientCanvas.setMaximumSize(new Dimension(myWidth, myHeight));
		clientCanvas.setMinimumSize(new Dimension(myWidth, myHeight));
		clientCanvas.setFocusable(false);
		
		stat_HP_Display = new JLabel();
	//	stat_HP_Display.setText("HP: " + Player.getStat_HP());
		//stat_HP_Display.setToolTipText("Current HEALTH POINT is " + Player.getStat_HP());
		stat_HP_Display.setVisible(true);
		
		stat_ATK_Display = new JLabel();
	//	stat_ATK_Display.setText("ATK: " + Player.getStat_ATK());
	//	stat_ATK_Display.setToolTipText("Current ATTACK is " + Player.getStat_ATK());
		stat_ATK_Display.setVisible(true);
		
		stat_DEF_Display = new JLabel();
	//	stat_DEF_Display.setText("DEF: " + Player.getStat_DEF());
	//	stat_DEF_Display.setToolTipText("Current DEFENSET is " + Player.getStat_DEF());
		stat_DEF_Display.setVisible(true);

		controls_WASD = new JLabel(new ImageIcon(Assets.controlsWASD));
		keyIcon = new JLabel(new ImageIcon(Assets.doorKey));
		

		clientPanel.add(stat_HP_Display);
		clientPanel.add(stat_ATK_Display);
		clientPanel.add(stat_DEF_Display);
		clientPanel.add(controls_WASD, BorderLayout.EAST);
		clientFrame.add(clientPanel);
		clientFrame.add(clientCanvas);

		clientFrame.pack();
	}
	
	public void setVisible(boolean someBool)
	{
		clientFrame.setVisible(someBool);
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
				clientPanel.add(keyIcon);
				keyAdded = true;
			}
		}else
		{
			clientPanel.remove(keyIcon);
		}
		
		clientFrame.pack();
	}

	public Canvas getCanvas()
	{
		return clientCanvas;
	}

	public JFrame getFrame()
	{
		return clientFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

}
