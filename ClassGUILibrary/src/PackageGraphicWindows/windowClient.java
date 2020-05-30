package PackageGraphicWindows;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import PackageClassLibrary.createClientLib;

@SuppressWarnings("serial")
public class windowClient extends JInternalFrame{
	
	Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
	
	private createClientLib clientLib;
	private windowConfigure configureGUI;
	
	String[] combBoxTextsSex = new String[] {"Selecione", "Feminino", "Masculino"}; 
	String[] combBoxTextsStates = new String[] 
			{"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
					"GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
					"PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	
	JLabel lblCodClient = new JLabel();
	JLabel lblFullName = new JLabel();
	JLabel lblCPF = new JLabel();
	JLabel lblRG = new JLabel();
	JLabel lblDateOfBirth = new JLabel();
	JLabel lblNumberPhone = new JLabel();
	JLabel lblNumberHouse = new JLabel();
	JLabel lblSex = new JLabel();
	JLabel lblAdrress = new JLabel();
	JLabel lblCodHouse = new JLabel();
	JLabel lblZipCode = new JLabel();
	JLabel lblHouseNearWhat = new JLabel();
	JLabel lblneighborhood = new JLabel();
	JLabel lblCity = new JLabel();
	JLabel lblState = new JLabel();
	JLabel lblObservation = new JLabel();
	JLabel lblModals = new JLabel();
	JLabel lblDegree = new JLabel();
	JLabel lblImage = new JLabel();
	JLabel lblValue = new JLabel();
	JLabel lblValueJiuJitsu = new JLabel();
	JLabel lblValueCapoeira = new JLabel();
	JLabel lblValueMuayThai = new JLabel();
	JLabel lblDegreeJiuJitsu = new JLabel();
	JLabel lblDegreeCapoeira = new JLabel();
	JLabel lblDegreeMuayThai = new JLabel();
	
	JTextField txfCodClient = new JTextField();
	JTextField txfFullName = new JTextField();
	JTextField txfRG = new JTextField();
	JTextField txfSex = new JTextField();
	JTextField txfneighborhood = new JTextField();
	JTextField txfCity = new JTextField();
	JTextField txfState = new JTextField();
	JTextField txfAdrress = new JTextField();
	JTextField txfCodHouse = new JTextField();
	JTextField txfZipCode = new JTextField();
	JTextField txfHouseNearWhat = new JTextField();
	JTextField txfModals = new JTextField();
	
	JTextArea txfObservation = new JTextArea();	
	
	JFormattedTextField txfCPF = new JFormattedTextField();
	JFormattedTextField txfDateOfBirth = new JFormattedTextField();
	JFormattedTextField txfNumberPhone = new JFormattedTextField();
	JFormattedTextField txfNumberHouse = new JFormattedTextField();
	
	JButton btnAddImage = new JButton();
	JButton btnSave = new JButton();
	JButton btnConsultClient = new JButton();
	JButton btnCancel = new JButton();
	
	JComboBox<String> cbSex = new JComboBox<>(combBoxTextsSex);
	JComboBox<String> cbState = new JComboBox<>(combBoxTextsStates);
	JComboBox<String> cbModals = new JComboBox<>();
	
	private Connection conn;
	
	JPanel panel = new JPanel();
	
	public windowClient (Connection conn) throws ParseException { 

		this.conn = conn;
		
		setSize(900,600);
		setTitle("Clientes");
		setIconifiable(true);
		setMaximizable(false);
		setClosable(true);
		setResizable(false);
		setLocation(175, 20);
		
		buildWindow();
		actionsButtons();
		
		configureGUI = new windowConfigure(conn);
		clientLib = new createClientLib(this);

	}
	
	public void buildWindow() throws ParseException{
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);		
		
		lblCodClient = new JLabel("Código");
		lblCodClient.setBounds(25, 25, 100, 25);
		lblCodClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblCodClient);
		
		lblFullName = new JLabel("Nome Completo");
		lblFullName.setBounds(150, 25, 100, 25);
		lblFullName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblFullName);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(480, 25, 50, 25);
		lblCPF.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblCPF);
		
		lblRG = new JLabel("RG");
		lblRG.setBounds(320, 220, 50, 25);
		lblRG.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblRG);
	
		lblDateOfBirth = new JLabel("Data de Nascimento");
		lblDateOfBirth.setBounds(25, 75, 150, 25);
		lblDateOfBirth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblDateOfBirth);
		
		lblNumberPhone = new JLabel("Nº do Celular");
		lblNumberPhone.setBounds(170, 75, 150, 25);
		lblNumberPhone.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblNumberPhone);
		
		lblNumberHouse = new JLabel("Nº da Casa");
		lblNumberHouse.setBounds(320, 75, 200, 25);
		lblNumberHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblNumberHouse);
		
		lblAdrress = new JLabel("Rua");
		lblAdrress.setBounds(25, 120, 150, 25);
		lblAdrress.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblAdrress);
		
		lblCodHouse = new JLabel("Nº Residência");
		lblCodHouse.setBounds(400, 120, 150, 25);
		lblCodHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblCodHouse);
		
		lblZipCode = new JLabel("CEP");
		lblZipCode.setBounds(25, 165, 100, 25);
		lblZipCode.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblZipCode);
		
		lblHouseNearWhat = new JLabel("Próximo");
		lblHouseNearWhat.setBounds(150, 165, 100, 25);
		lblHouseNearWhat.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblHouseNearWhat);
		
		lblneighborhood = new JLabel("Bairro");
		lblneighborhood.setBounds(280, 165, 100, 25);
		lblneighborhood.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblneighborhood);
		
		lblCity = new JLabel("Cidade");
		lblCity.setBounds(25, 220, 100, 25);
		lblCity.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblCity);
		
		lblState = new JLabel("UF");
		lblState.setBounds(200, 220, 100, 25);
		lblState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblState);
		
		lblSex = new JLabel("Gênero");
		lblSex.setBounds(450, 75, 100, 25);
		lblSex.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblSex);
		
		lblObservation = new JLabel("Observação");
		lblObservation.setBounds(25, 275, 100, 25);
		lblObservation.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblObservation);
		
		lblImage = new JLabel();
		lblImage.setBounds(710, 25, 150, 200);
		lblImage.setIcon(new ImageIcon("C:\\WorksSpaces\\ProjectGymUNESC\\ClassGUILibrary\\src\\Rodrigo-Guirao-Diaz-300x400.jpg"));
		panel.add(lblImage);
		
		//JTextFields
		
		txfCodClient = new JTextField();
		txfCodClient.setBounds(25, 50, 100, 20);
		txfCodClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfCodClient);
		
		txfFullName = new JTextField();
		txfFullName.setBounds(150, 50, 300, 20);
		txfFullName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfFullName);
		
		txfCPF = new JFormattedTextField();
		txfCPF.setBounds(480, 50, 110, 20);
		txfCPF.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskCPF = new MaskFormatter("###.###.###-##");
		dateMaskCPF.install(txfCPF);
		panel.add(txfCPF);
		
		txfRG = new JTextField();
		txfRG.setBounds(320, 245, 100, 20);
		txfRG.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfRG);
	
		txfDateOfBirth = new JFormattedTextField();
		txfDateOfBirth.setBounds(25, 100, 80, 20);
		txfDateOfBirth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskDateOfBirth = new MaskFormatter("##/##/####");
		dateMaskDateOfBirth.install(txfDateOfBirth);
		panel.add(txfDateOfBirth);
		
		txfNumberPhone = new JFormattedTextField();
		txfNumberPhone.setBounds(170, 100, 120, 20);
		txfNumberPhone.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskNumberPhone = new MaskFormatter("(##) # ####-####");
		dateMaskNumberPhone.install(txfNumberPhone);
		panel.add(txfNumberPhone);
		
		txfNumberHouse = new JFormattedTextField();
		txfNumberHouse.setBounds(320, 100, 110, 20);
		txfNumberHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskNumberHouse = new MaskFormatter("(##) ####-####");
		dateMaskNumberHouse.install(txfNumberHouse);
		panel.add(txfNumberHouse);

		txfAdrress = new JTextField();
		txfAdrress.setBounds(25, 145, 350, 20);
		txfAdrress.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfAdrress);
		
		txfCodHouse = new JTextField();
		txfCodHouse.setBounds(400, 145, 90, 20);
		txfCodHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfCodHouse);
		
		txfZipCode = new JTextField();
		txfZipCode.setBounds(25, 190, 100, 20);
		txfZipCode.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfZipCode);
		
		txfHouseNearWhat = new JTextField();
		txfHouseNearWhat.setBounds(150, 190, 100, 20);
		txfHouseNearWhat.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfHouseNearWhat);
		
		txfneighborhood = new JTextField();
		txfneighborhood.setBounds(280, 190, 210, 20);
		txfneighborhood.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfneighborhood);
		
		txfCity = new JTextField();
		txfCity.setBounds(25, 245, 150, 20);
		txfCity.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfCity);
		
		txfObservation = new JTextArea();
		txfObservation.setBounds(25, 300, 275, 100);
		txfObservation.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		txfObservation.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel.add(txfObservation);
		
		//ComboBox
		cbSex = new JComboBox<String>(combBoxTextsSex);
		cbSex.setBounds(450, 100, 110, 20);
		cbSex.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbSex);
		
		cbState = new JComboBox<String>(combBoxTextsStates);
		cbState.setBounds(200, 245, 100, 20);
		cbState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbState);
		
		//Buttons
		
		btnAddImage = new JButton("+");
		btnAddImage.setBounds(810, 235, 50, 25);
		btnAddImage.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		btnAddImage.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\plus.png"));
		panel.add(btnAddImage);
		
		btnConsultClient = new JButton("Consultar");
		btnConsultClient.setBounds(250, 480, 90, 65);
		btnConsultClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnConsultClient.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Client.png"));
		btnConsultClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultClient.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(btnConsultClient);
		
		btnSave = new JButton("Salvar");
		btnSave.setBounds(150, 480, 90, 65);
		btnSave.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		//btnSave.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Save.png"));
		btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(25, 480, 90, 65);
		btnCancel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnCancel.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Exit.png"));
		btnCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(btnCancel);

	}
	
	public void actionsButtons() {

		btnAddImage.addActionListener(e->{
			clientLib.chooseImageForPerson(lblImage);
		});
		
		btnConsultClient.addActionListener(e->{
			
		});
		
		btnSave.addActionListener(e->{
			clientLib.validations(cbSex);

		});
		
		btnCancel.addActionListener(e->{
			dispose();
		});
	}
}