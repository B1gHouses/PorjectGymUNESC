package PackageGraphicWindows;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class windowConfigure extends JDialog{
	
	String[] combBoxtextPrinters = new String[] {"Selecione"/*mapear impressoras*/};
	
	JLabel lblPrinter = new JLabel();
	JLabel lblValueJiuJitsu = new JLabel();
	JLabel lblValueCapoeira = new JLabel();
	JLabel lblValueMuayThai = new JLabel();
	
	JTextField txfValueJiuJitsu = new JTextField();
	JTextField txfValueCapoeira = new JTextField();
	JTextField txfValueMuayThai = new JTextField();
	
	
	JComboBox<String> cbPrinter = new JComboBox<String>(combBoxtextPrinters);
	
	public windowConfigure() {
		setSize(500,400);
		setTitle("Configuração");
		setModal(true);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		buildWindow();
		actionsButtons();
	}
	
	public void buildWindow(){
		
		//Labels
		
		lblPrinter = new JLabel("Impressora");
		lblPrinter.setBounds(50, 25, 100, 25);
		lblPrinter.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblPrinter);
	
		lblValueJiuJitsu = new JLabel("Valor Jiu-Jitsu");
		lblValueJiuJitsu.setBounds(50, 75, 150, 25);
		lblValueJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueJiuJitsu);
	
		lblValueCapoeira = new JLabel("Valor Capoeira");
		lblValueCapoeira.setBounds(50, 100, 150, 25);
		lblValueCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueCapoeira);
		
		lblValueMuayThai = new JLabel("Valor Muay Thai");
		lblValueMuayThai.setBounds(50, 125, 150, 25);
		lblValueMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueMuayThai);
		
		//TextFields
		
		txfValueJiuJitsu = new JTextField();
		txfValueJiuJitsu.setBounds(175, 75, 150, 20);
		txfValueJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfValueJiuJitsu);
		
		txfValueCapoeira = new JTextField();
		txfValueCapoeira.setBounds(175, 100, 150, 20);
		txfValueCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfValueCapoeira);

		txfValueMuayThai = new JTextField();
		txfValueMuayThai.setBounds(175, 125, 150, 20);
		txfValueMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfValueMuayThai);
		
		//Guardar informação banco
		
		cbPrinter = new JComboBox<String>(combBoxtextPrinters);
		cbPrinter.setBounds(140, 25, 100, 20);
		cbPrinter.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbPrinter);
		
	}
	
	public void actionsButtons(){
		
	}
	
}
