package PackageClassLibrary;

import java.io.File;

import javax.swing.JOptionPane;

public class classBackup {
	
	
	public static void makeBackup() {
		
		File directory = new File("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup");
		File archive = new File("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup\\AcademyBackup.sql");

		if(!directory.isDirectory()) {
			directory.mkdir();
		}
		
		try {
			if(archive.exists()) {	
				if(JOptionPane.showConfirmDialog(null, "Já existe um arquivo de Backup. \nDeseja Sobreescrever?", "Backup", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					archive.delete();
					
					if(new File("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup.bat").isFile()) {
						Process process = Runtime.getRuntime().exec("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup.bat root root");
						process.waitFor();
						if(process.exitValue()==0) {
							JOptionPane.showMessageDialog(null, "Backup Feito com Sucesso!");	
						}else {
							JOptionPane.showMessageDialog(null, "Falha no Backup");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Arquivo BAT inexistente");	
					}
				}else {
					JOptionPane.showMessageDialog(null, "Backup cancelado pelo usuário!");
					
				}
				
			}else if(new File("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup.bat").isFile()) {
				Process process = Runtime.getRuntime().exec("C:\\WorksSpaces\\ProjectGymUNESC\\ClassLibrary\\Backup.bat");
				process.waitFor();
				if(process.exitValue()==0) {
					JOptionPane.showMessageDialog(null, "Backup Feito com Sucesso!");	
				}else {
					JOptionPane.showMessageDialog(null, "Falha no Backup");
				}
			
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exceção no Backup: " + e.getMessage());
		}
		
		
	}
}
