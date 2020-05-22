package PackageGraphicWindows;

import java.awt.Font;
import java.sql.Connection;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import PackageClassLibrary.Observer;
import PackageDatabase.dao.DAOuser;
import PackageDatabase.model.modelUser;

public class windowCreateUser extends JInternalFrame implements Observer{
	
	private Connection conn;
	
	private String[] strProfile = {"Selecione","Administrador","Cadastral","Financeiro"};
	
	private JLabel lblUsername = new JLabel();
	private JLabel lblPassword = new JLabel();
	private JLabel lblConfirmPassword = new JLabel();
	private JLabel lblProfile =  new JLabel();
	
	private JTextField txfUsername = new JTextField();
	private JPasswordField txfPassword = new JPasswordField();
	private JPasswordField txfConfirmPassword = new JPasswordField();
	
	private JButton btnSave = new JButton();
	private JButton btnCancel = new JButton();
	private JButton btnConsult = new JButton();

	JComboBox<String> cbProfile = new JComboBox<>();
	
	JPanel panel = new JPanel();
	JDesktopPane desktop = new JDesktopPane();
	public windowCreateUser (Connection conn, final JDesktopPane desktop) {
		this.conn = conn;
		this.desktop = desktop;
		
		setSize(370,220);
		setTitle("Criar Usuário");
		setIconifiable(true);
		setMaximizable(false);
		setClosable(true);
		setResizable(false);
		setLocation(450, 200);
		setResizable(false);
		
		buildWindow();
		actionsButtons();
		
		setVisible(true);
	}
	
	public void buildWindow() {
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		
		lblUsername = new JLabel("Usuário");
		lblUsername.setBounds(25, 25, 100, 25);
		lblUsername.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(lblUsername);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setBounds(25, 55, 100, 25);
		lblPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirmar Senha");
		lblConfirmPassword.setBounds(25, 85, 150, 25);
		lblConfirmPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(lblConfirmPassword);
		
		lblProfile = new JLabel("Perfil");
		lblProfile.setBounds(25, 115, 100, 25);
		lblProfile.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(lblProfile);
		
		txfUsername = new JTextField();
		txfUsername.setBounds(150, 25, 150, 25);
		panel.add(txfUsername);
		
		txfPassword = new JPasswordField();
		txfPassword.setBounds(150, 55, 150, 25);
		panel.add(txfPassword);
		
		txfConfirmPassword = new JPasswordField();
		txfConfirmPassword.setBounds(150, 85, 150, 25);
		panel.add(txfConfirmPassword);
		
		cbProfile = new JComboBox<String>(strProfile);
		cbProfile.setBounds(150, 115, 150, 25);
		panel.add(cbProfile);
		
		btnConsult = new JButton("Consultar");
		btnConsult.setBounds(130, 150, 100, 25);
		btnConsult.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(btnConsult);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(240, 150, 100, 25);
		btnCancel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(btnCancel);
		
		btnSave = new JButton("Salvar");
		btnSave.setBounds(25, 150, 100, 25);
		btnSave.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		panel.add(btnSave);
	}
	
	
	public void actionsButtons() {
		
		btnSave.addActionListener(e->{
			
			String username = txfUsername.getText();
			String password = new String(txfPassword.getPassword());
			int profile = cbProfile.getSelectedIndex();
			
			if (validations() == true) {return;}
			try {
			 modelUser user = new modelUser();
			 user.setUser(username);
			 user.setPassword(password);
			 user.setProfile(profile - 1);
			 
			 DAOuser dao = new DAOuser(conn);
			 dao.Insert(user);
			 
			 JOptionPane.showMessageDialog(null, "Usuário Inserido");
			 
			 txfUsername.setText("");
			 txfPassword.setText("");
			 txfConfirmPassword.setText("");
			 cbProfile.setSelectedIndex(0);
			 
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao Inserir o usuário: " + e1.getMessage());
			}
		});
		
		
		btnConsult.addActionListener(e->{
			try {
				windowConsultUsers consultUsers = new windowConsultUsers(conn, windowCreateUser.this);
				desktop.add(consultUsers).setVisible(true);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir WindowClient Button", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnCancel.addActionListener(e->{
			dispose();
		});
		
	}
	
	public boolean validations() {
		boolean flag = false;
		
		String username = txfUsername.getText();
		String password = new String(txfPassword.getPassword());
		String confirmPassword = new String(txfConfirmPassword.getPassword());
		
		int profile = cbProfile.getSelectedIndex();
		try {
			if(username.isEmpty()) {
				throw new Exception("Campo Usuário Vazio");
			}else if(password.isEmpty()) {
				throw new Exception("Campo Senha Vazio");
			}else if(confirmPassword.isEmpty()) {
				throw new Exception("Campo Confirmar Senha Vazio");
			}else if(profile == 0) {
				throw new Exception("Selecione um Perfil");
			}else if(!password.equals(confirmPassword)) {
				throw new Exception("Senhas Não estão Iguais");
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			flag = true;
		}
		return flag;
		
	}

	@Override
	public void Update(Object obj) {
		modelUser user = (modelUser) obj;
		txfUsername.setText(user.getUser());
		txfPassword.setText(user.getPassword());
		txfConfirmPassword.setText(user.getPassword());
		cbProfile.setSelectedIndex(user.getProfile()+1);
	}

}
