package PackageClassLibrary;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class createClientLib  {
	
	private JInternalFrame windowClient;
	
	public createClientLib(final JInternalFrame Frame) {
		windowClient = Frame;
	}
	
	public void chooseImageForPerson(JLabel lblImage) {
		JFileChooser fcFile = new JFileChooser();
		fcFile.setDialogTitle("Selecione a imagem");
		fcFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int op = fcFile.showOpenDialog(windowClient);
		if(op == JFileChooser.APPROVE_OPTION) {
			ImageIcon image = new ImageIcon(fcFile.getSelectedFile().getPath());
			lblImage.setIcon(new ImageIcon(image.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT)));
		}
	}
	
	public void validations(JComboBox<String> cbSex) {
		try {
			if(cbSex.getSelectedIndex() == 0) {
				throw new Exception("Selecione o gênero.");
			}	
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Erro Validação cbSex: " + e2.getMessage());
			//add label com imagem vermelaha dizendo que esta errado ou faltando
		}
		 try {
		
			 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro Validação cpf: " + e.getMessage());
		}
	}
}
