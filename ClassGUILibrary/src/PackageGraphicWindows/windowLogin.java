package PackageGraphicWindows;

import java.awt.Font;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import PackageDatabase.connectionFactory;
import PackageDatabase.dao.DAOuser;
import PackageDatabase.model.modelUser;

@SuppressWarnings("serial")
public class windowLogin extends JDialog{

	JLabel lblLogin = new JLabel();
	JLabel lblPassword = new JLabel();
	JLabel lblCopyright = new JLabel();
	
	JTextField txfLogin = new JTextField();
	JPasswordField txfPassword = new JPasswordField();
	
	JButton btnLogin = new JButton();
	JButton btnCancel = new JButton();
	
	Connection conn;
	
	public windowLogin () { 
		setSize(500, 200);
		setModal(true);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BuildWindow();
		actionsButtons();
	}
	public void BuildWindow() {
		
		lblCopyright = new JLabel("Copyright by Victor Casagrande V 1.0");
		lblCopyright.setBounds(100, 20, 500, 250);
		lblCopyright.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblCopyright);
		
		lblLogin = new JLabel("Usuário");
		lblLogin.setBounds(90, 10, 200, 25);
		lblLogin.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblLogin);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setBounds(90, 50, 200, 25);
		lblPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		getContentPane().add(lblPassword);
		
		txfLogin.setBounds(150, 10, 200, 25);
		txfLogin.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfLogin);
		
		txfPassword.setBounds(150, 50, 200, 25);
		txfPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		getContentPane().add(txfPassword);
		
		btnCancel = new JButton("Cancelar");	
		btnCancel.setBounds(125, 90, 100, 25);
		btnCancel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		getContentPane().add(btnCancel);
		
		btnLogin = new JButton("Entrar");
		btnLogin.setBounds(235, 90, 100, 25);
		btnLogin.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
		getContentPane().add(btnLogin);
	}
	
	public void actionsButtons() {
		btnLogin.addActionListener(e->{
			String username = txfLogin.getText();
			String password = new String(txfPassword.getPassword());
			//dispose();
			//new windowMenu(conn, txfLogin.getText(), 0).setVisible(true);
			
			try {
				if(username.isEmpty()) {
					throw new Exception("Campo Usuario Vazio");
				}else
				if(password.isEmpty()) {
					throw new Exception("Campo Senha Vazio");
				}
				
				conn = connectionFactory.getConnection("localhost", 3306, "academy_primal", "root", "root");

				if(conn != null) {
					
					DAOuser dao = new DAOuser(conn);
					modelUser user = dao.SelectLogin(username, password);
					if(user != null) {
						dispose();
						new windowMenu(conn, txfLogin.getText(), user.getProfile()).setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");
					}
				}
				
				
				
				
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
			}	
		});
		btnCancel.addActionListener(e->{
			dispose();
		});
	}	
}
