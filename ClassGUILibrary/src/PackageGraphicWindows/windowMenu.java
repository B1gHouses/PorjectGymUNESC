package PackageGraphicWindows;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class windowMenu extends JFrame{

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu();
	private JMenuItem menuItemConfigure = new JMenuItem();
	private JMenuItem menuItemExit = new JMenuItem();
	
	JButton btnClient = new JButton();
	JButton btnPayent = new JButton();
	JButton btnBackupSystem = new JButton();
	JButton btnExit = new JButton();	
	
	public windowMenu (final String username) { 
		setSize(1280, 720);
		setTitle("Ultimate Academy V 1.0 Logado:" + username);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		buildWindow();
		actionsButtons();
	}

	public void buildWindow() {

		setJMenuBar(menuBar);
		
		menuFile = new JMenu("Arquivo");
		menuBar.add(menuFile);
		
		menuItemConfigure = new JMenuItem("Configuração");
		menuFile.add(menuItemConfigure);
		
		menuItemExit = new JMenuItem("Sair");
		menuFile.add(menuItemExit);
		
		
		
		btnClient = new JButton("Cliente");
		btnClient.setBounds(25, 150, 75, 70);
		btnClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnClient.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\ClassImageLibrary\\src\\48x48\\Client.png"));
		btnClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClient.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnClient);
		
		btnPayent = new JButton("Receber");
		btnPayent.setBounds(25, 245, 75, 70);
		btnPayent.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnPayent.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\ClassImageLibrary\\src\\48x48\\Cashier.png"));
		btnPayent.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPayent.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnPayent);
		
		btnBackupSystem = new JButton("Backup");
		btnBackupSystem.setBounds(25, 340, 75, 70);
		btnBackupSystem.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		btnBackupSystem.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\ClassImageLibrary\\src\\48x48\\Backup.png"));
		btnBackupSystem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBackupSystem.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnBackupSystem);
		
		btnExit = new JButton("Sair");
		btnExit.setBounds(25, 435, 75, 70);
		btnExit.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnExit.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\ClassImageLibrary\\src\\48x48\\Exit.png"));
		btnExit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnExit);
		
		
	}

	public void actionsButtons() {
		
		menuItemExit.addActionListener(e->{
			dispose();
		});
		
		menuItemConfigure.addActionListener(e->{
			new windowConfigure().setVisible(true);;
		});
		
		btnClient.addActionListener(e->{
				try {
					new windowClient().setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		});
		
		btnPayent.addActionListener(e->{
			new windowPayment().setVisible(true);
		});
		
		btnBackupSystem.addActionListener(e->{
			
		});
		
		btnExit.addActionListener(e->{
			dispose();
			new windowLogin().setVisible(true);
		});
		

	}
}
