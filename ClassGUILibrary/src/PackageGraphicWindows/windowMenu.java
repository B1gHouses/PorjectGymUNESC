package PackageGraphicWindows;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import PackageClassLibrary.classBackup;

@SuppressWarnings("serial")
public class windowMenu extends JFrame{

		private JMenuBar menuBar = new JMenuBar();
		
		private JMenu menuSystem = new JMenu();
		private JMenu menuClient = new JMenu();
		private JMenu menuHelp = new JMenu();
		private JMenu menuReport = new JMenu();
		
		private JMenuItem menuItemReports= new JMenuItem();
		private JMenuItem menuItemHelp = new JMenuItem(); 
		
		private JMenuItem menuItemClient = new JMenuItem();
		private JMenuItem menuItemClientPayment = new JMenuItem(); 
		
		private JMenuItem menuItemConfigure = new JMenuItem();
		private JMenuItem menuItemCreateUser = new JMenuItem();
		private JMenuItem menuItemExit = new JMenuItem();
		
		private JButton btnClient = new JButton();
		private JButton btnPayent = new JButton();
		private JButton btnBackupSystem = new JButton();
		private JButton btnExit = new JButton();	
		
		private JDesktopPane desktop = new JDesktopPane();
		

		
		private Connection conn;

	public windowMenu (final Connection conn,final String username, final int profile) {
		this.conn = conn;
		
		setSize(1280, 720);
		setTitle("Ultimate Academy V 1.0 Logado: " + username);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		buildWindow();
		actionsButtons();
		profilePermissions(profile);
		
	}

	public void profilePermissions(final int profile) {
		switch (profile) {
		case 1:
			menuItemCreateUser.setEnabled(false);
			break;
		case 2:
			menuItemCreateUser.setEnabled(false);
			break;
		default:
			break;
		}
	}
	
	public void buildWindow() {
		
		desktop = new JDesktopPane();
		desktop.setBackground(Color.LIGHT_GRAY);
		setContentPane(desktop);
		
		setJMenuBar(menuBar);
		
		/*
		 * Bar Menu System
		 */
		menuSystem = new JMenu("Sistema");
		menuBar.add(menuSystem);
		
		menuItemConfigure = new JMenuItem("Configuração");
		menuSystem.add(menuItemConfigure);
		
		menuItemCreateUser = new JMenuItem("Criar Usuario");
		menuSystem.add(menuItemCreateUser);
		
		menuItemExit = new JMenuItem("Sair");
		menuSystem.add(menuItemExit);
		
		
		/*
		 * Bar Menu Client
		 */
		
		menuClient = new JMenu("Cliente");
		menuBar.add(menuClient);
		
		menuItemClient = new JMenuItem("Cadastro");
		menuClient.add(menuItemClient);
		
		menuItemClientPayment = new JMenuItem("Receber");
		menuClient.add(menuItemClientPayment);
		
		/*
		 * Bar Menu Help
		 */
		
		menuReport = new JMenu("Relatório");
		menuBar.add(menuReport);
		
		menuItemReports = new JMenuItem("Relatório");
		menuReport.add(menuItemReports);
		
		/*
		 * Bar Menu Help
		 */
		
		menuHelp = new JMenu("Ajuda");
		menuBar.add(menuHelp);
		
		menuItemHelp = new JMenuItem("Ajuda");
		menuHelp.add(menuItemHelp);
		
		//End JMenu
		
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
	
	private windowClient windowClient; 
	private windowConfigure windowConfigure;
	private windowCreateUser windowCreateUser;
	private windowPayment windowPayment;
	
	public void actionsButtons() {
		
		menuItemExit.addActionListener(e->{
			dispose();
		});
		
		menuItemConfigure.addActionListener(e->{
			try {
				if(windowConfigure == null) {
					windowConfigure = new windowConfigure(conn);
				}
				
				if(CheckWindow(windowConfigure.getName())) {
					windowFocus(windowConfigure);
				}else {
					windowConfigure.setName("windowConfigure");
					desktop.add(windowConfigure).setVisible(true);	
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir windowConfigure Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuItemCreateUser.addActionListener(e->{
			try {
				if(windowCreateUser == null) {
					windowCreateUser = new windowCreateUser(conn);
				}
				
				if(CheckWindow(windowCreateUser.getName())) {
					windowFocus(windowCreateUser);
				}else {
					windowCreateUser.setName("windowCreateUser");
					desktop.add(windowCreateUser).setVisible(true);	
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir createUser Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuItemClient.addActionListener(e->{
			try {
				if(windowClient == null) {
					windowClient = new windowClient(conn);
				}
				
				if(CheckWindow(windowClient.getName())) {
					windowFocus(windowClient);
				}else {
					windowClient.setName("windowClient");
					desktop.add(windowClient).setVisible(true);	
				}
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir WindowClient Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		menuItemClientPayment.addActionListener(e->{
			try {
				if(windowPayment == null) {
					windowPayment = new windowPayment(conn);
				}
				
				if(CheckWindow(windowPayment.getName())) {
					windowFocus(windowPayment);
				}else {
					windowPayment.setName("windowPayment");
					desktop.add(windowPayment).setVisible(true);	
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir createUser Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		btnClient.addActionListener(e->{
			try {
				if(windowClient == null) {
					windowClient = new windowClient(conn);
				}
				
				if(CheckWindow(windowClient.getName())) {
					windowFocus(windowClient);
				}else {
					windowClient.setName("windowClient");
					desktop.add(windowClient).setVisible(true);	
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir WindowClient Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnPayent.addActionListener(e->{
			try {
				if(windowPayment == null) {
					windowPayment = new windowPayment(conn);
				}else {
					if(CheckWindow(windowPayment.getName())) {
						windowFocus(windowPayment);
					}else {
						windowPayment.setName("windowPayment");
						desktop.add(windowPayment).setVisible(true);	
					}	
				}
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir windowPayment Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnBackupSystem.addActionListener(e->{
			classBackup.makeBackup();
		});
		
		btnExit.addActionListener(e->{
			dispose();
			new windowLogin().setVisible(true);
		});
	}
	
	
	private boolean CheckWindow(final String windowName) {
		
		JInternalFrame[] windows = desktop.getAllFrames();
		
		for(JInternalFrame frame : windows) {
			if(frame.getName().equals(windowName)) {
				return true;
			}
		}
		return false;
	}
	
	private void windowFocus(final JInternalFrame frame) {
		try {
			frame.setSelected(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro Focar Function", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
