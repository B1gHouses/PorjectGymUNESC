package PackageGraphicWindows;

import java.awt.Font;
import java.awt.Image;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import PackageDatabase.connectionFactory;
import java.sql.Connection;
public class windowConfigure extends JInternalFrame{
	private Connection conn;
	private String[] combBoxtextPrinters = new String[] {"Selecione"/*mapear impressoras*/};
	
	private JLabel lblPrinter = new JLabel();
	private JLabel lblModality = new JLabel();
	private JLabel lblValue = new JLabel();
	private JLabel lblDays = new JLabel();
	private JLabel lblDegree = new JLabel();
	
	private JTextField txfModality = new JTextField();
	private JTextField txfValue = new JTextField();
	private JTextField txfDays = new JTextField();
	private JTextField txfDegree = new JTextField();
	
	private JButton btnCancel = new JButton();
	private JButton btnGeneral = new JButton();
	private JButton btnSaveGeneral = new JButton();
	
	private JButton btnPlan = new JButton();
	private JButton btnSavePlan = new JButton();
	private JButton btnRemovePan = new JButton();
	
	private JButton btnModality = new JButton();
	private JButton btnSaveModality = new JButton();
	private JButton btnRemoveModality = new JButton();
	
	private JButton btnDegree = new JButton();
	private JButton btnSaveDegree  = new JButton();
	private JButton btnRemoveDegree = new JButton();
	
	private JPanel panel = new JPanel();
	
	private JComboBox<String> cbPrinter = new JComboBox<String>();
	private JComboBox<String> cbModality = new JComboBox<String>();
	
	public windowConfigure(Connection conn) {
		this.conn = conn;
		setSize(500,200);
		setTitle("Configuração");
		setIconifiable(true);
		setMaximizable(false);
		setClosable(true);
		setResizable(false);
		setLocation(350, 100);
		
		buildWindow();
		actionsButtons();
	}
	
	public void buildWindow(){
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);		
		
		//Labels
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 90, 100, 25);
		panel.add(btnModality);
		
		
	}
	public void buildWindowGeneral(){
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);		
		
		//Labels
		
		lblPrinter = new JLabel("Impressora");
		lblPrinter.setBounds(125, 25, 100, 20);
		lblPrinter.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblPrinter);
		
		//ComboBox
				
		cbPrinter = new JComboBox<String>();
		cbPrinter.setBounds(250, 25, 100, 20);
		cbPrinter.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbPrinter);
		
		//Textbox
		
		
		
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 90, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	public void buildWindowPlan(){

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		
		//Labels
		
		lblModality = new JLabel("Modalidade");
		lblModality.setBounds(125, 20, 100, 20);
		lblModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblModality);
		
		lblValue = new JLabel("Valor");
		lblValue.setBounds(125, 45, 100, 20);
		lblValue.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblValue);
		
		lblDays = new JLabel("Dias Equivalentes");
		lblDays.setBounds(125, 70, 150, 20);
		lblDays.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblDays);
		
		
		//Textbox
		
		txfValue = new JTextField();
		txfValue.setBounds(250, 45, 100, 20);
		txfValue.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfValue);
		
		txfDays = new JTextField();
		txfDays.setBounds(250, 70, 100, 20);
		txfDays.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfDays);
		
		//ComboBox
		
		cbModality = new JComboBox<String>();
		cbModality.setBounds(250, 20, 100, 20);
		cbModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbModality);
		
		
		//Buttons
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 90, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	public void buildWindowModality(){
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		
		lblModality = new JLabel("Modalidade");
		lblModality.setBounds(125, 20, 100, 20);
		lblModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblModality);
		
		lblDegree = new JLabel("Grauduções");
		lblDegree.setBounds(125, 45, 100, 20);
		lblDegree.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblDegree);
		
		txfModality = new JTextField();
		txfModality.setBounds(250, 20, 100, 20);
		txfModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfModality);
		
		txfDegree = new JTextField();
		txfDegree.setBounds(250, 45, 100, 20);
		txfDegree.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfDegree);
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 90, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	public void actionsButtons(){
		btnGeneral.addActionListener(e->{
			buildWindowGeneral();
		});
		
		btnPlan.addActionListener(e->{
			buildWindowPlan();
		});
		
		btnModality.addActionListener(e->{
			buildWindowModality();
		});
		
		btnCancel.addActionListener(e->{
			dispose();
		});
		
		btnSaveGeneral.addActionListener(e->{
			
		});
		
		btnSavePlan.addActionListener(e->{
			
		});
	}

}
