package PackageGraphicWindows;

import java.awt.Font;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import PackageDatabase.connectionFactory;
import PackageDatabase.dao.UsuarioDAO;
import PackageDatabase.model.Usuario;

public class windowLogin extends JDialog{

	JLabel lblLogin = new JLabel();
	JLabel lblPassword = new JLabel();
	JLabel lblCopyright = new JLabel();
	
	JTextField txfLogin = new JTextField();
	JPasswordField txfPassword = new JPasswordField();
	
	JButton btnLogin = new JButton();
	JButton btnCancel = new JButton();
	
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
			
			try {
				Connection conn = connectionFactory.getConnection("localhost", 3306, "ACADEMY_MASTER", "root", "root");
				
				if(conn!=null) {
					UsuarioDAO users = new UsuarioDAO(conn);
					
					List<Object> listUsers = users.Select(null);
					
					for(int i=0; i<listUsers.size(); i++) {
						Usuario user = (Usuario)listUsers.get(i);
						System.out.println("user: " + user.getUsuario() + "password: " + user.getSenha());
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
