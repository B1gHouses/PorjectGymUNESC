package PackageGraphicWindows;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import PackageClassLibrary.createClientLib;

@SuppressWarnings("serial")
public class windowClient extends JDialog{
	
	Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
	//int sumCPF = 0;
	
	private createClientLib clientLib;
	private windowConfigure configureGUI;
	
	
	/*String[] combBoxTextsSex = new String[] {"Selecione", "Feminino", "Masculino"}; 
	String[] combBoxTextsStates = new String[] 
			{"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
					"GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
					"PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	String[] combBoxTextsModals = new String[] {"Selecione", "Capoeira", "Muay Thai", "Jiu Jitsu"};


	/*String[] combBoxTextsJiuJitsuDegree15 = new String[] {"Selecione", "Branca", "Cinza e branca", "Cinza", "Cinza e preta", "Amarela e branca", 
			"Amarela", "Amarela e preta", "Laranja e branca", "Laranja", "Laranja e preta", "Verde e branca", "Verde", "Verde e preta"};
	
	String[] combBoxTextsJiuJitsuDegree = new String[] {"Selecione", "Branca", "Azul", "Roxa", "Marrom", "Preta", "Vermelha e preta", "Vermelha e branca", "Vermelha"};

	String[] combBoxTextsCapoeiraDegree15 = new String[] {"Selecione", "Crua", "Crua-cinza", "Crua-amarela", "Crua-laranja", "Crua-verde", "Crua-vermelho", "Crua-azul", 
			"Cinza-laranja", "Cinza-verde", "Cinza-vermelho", "Cinza-azul", "Amarelo-verde", "Amarelo-vermelho", "Amarelo-azul", "Laranja-vermelho", "Laranja-azul", "Verde-azul"};

	
	String[] combBoxTextsCapoeiraDegree = new String[] {"Selecione", };
	

	String[] combBoxTextsMuayThaiDegree = new String[] {"Selecione", "Branco", "Branco com ponta vermelha", "Vermelho ponta azul clara", "Azul claro", 
			"Azul claro ponta azul escura", "Azul escuro", "Azul escuro ponta preta", 
			"Preto(professor)", "Preto e branco com a ponta preta", "Preto e branco com a ponta vermelha"};*/
	//usuario escolhe o valor e armazena banco
	/*String[] combBoxTextsJiuJitsuValue = new String[] {"Selecione", puxa banco};
	String[] combBoxTextsCapoeiraValue = new String[] {"Selecione", puxa banco};
	String[] combBoxTextsMuayThaiValue = new String[] {"Selecione", puxa banco};*/
	
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
	
	JCheckBox chbModalsCapoeira = new JCheckBox();
	JCheckBox chbModalsMuayThai = new JCheckBox();
	JCheckBox chbModalsJiuJitsu = new JCheckBox();
	
	JComboBox<String> cbSex = new JComboBox<>(combBoxTextsSex);
	JComboBox<String> cbState = new JComboBox<>(combBoxTextsStates);
	JComboBox<String> cbModals = new JComboBox<>(combBoxTextsModals);
	
	JComboBox<String> cbCapoeira = new JComboBox<>(combBoxTextsCapoeiraDegree);
	JComboBox<String> cbMuayThai = new JComboBox<>(combBoxTextsMuayThaiDegree);
	JComboBox<String> cbJiuJitsu = new JComboBox<>(combBoxTextsJiuJitsuDegree);
	
	JComboBox<String> cbValuesCapoeira = new JComboBox<>(combBoxTextsCapoeiraValue);
	JComboBox<String> cbValuesMuayThai = new JComboBox<>(combBoxTextsMuayThaiValue);
	JComboBox<String> cbValuesJiuJitsu = new JComboBox<>(combBoxTextsJiuJitsuValue);
	
	JComboBox<String> cbDegreeCapoeira = new JComboBox<>(combBoxTextsCapoeiraDegree);
	JComboBox<String> cbDegreeMuayThai = new JComboBox<>(combBoxTextsMuayThaiDegree);
	JComboBox<String> cbDegreeJiuJitsu = new JComboBox<>(combBoxTextsJiuJitsuDegree);	
	

	public windowClient () throws ParseException { 
		setSize(900,600);
		setTitle("Clientes");
		setModal(true);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		buildWindow();
		actionsButtons();
		
		
		configureGUI = new windowConfigure();
		clientLib = new createClientLib(this);
	}
	
	@SuppressWarnings("deprecation")
	public void buildWindow() throws ParseException{
		
		lblCodClient = new JLabel("Código");
		lblCodClient.setBounds(25, 25, 100, 25);
		lblCodClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblCodClient);
		
		lblFullName = new JLabel("Nome Completo");
		lblFullName.setBounds(150, 25, 100, 25);
		lblFullName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblFullName);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(480, 25, 50, 25);
		lblCPF.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblCPF);
		
		lblRG = new JLabel("RG");
		lblRG.setBounds(630, 25, 50, 25);
		lblRG.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblRG);
	
		lblDateOfBirth = new JLabel("Data de Nascimento");
		lblDateOfBirth.setBounds(25, 75, 150, 25);
		lblDateOfBirth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblDateOfBirth);
		
		lblNumberPhone = new JLabel("Nº do Celular");
		lblNumberPhone.setBounds(200, 75, 150, 25);
		lblNumberPhone.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblNumberPhone);
		
		lblNumberHouse = new JLabel("Nº da Casa");
		lblNumberHouse.setBounds(380, 75, 200, 25);
		lblNumberHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblNumberHouse);
		
		lblAdrress = new JLabel("Rua");
		lblAdrress.setBounds(25, 120, 150, 25);
		lblAdrress.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblAdrress);
		
		lblCodHouse = new JLabel("Nº Residência");
		lblCodHouse.setBounds(400, 120, 150, 25);
		lblCodHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblCodHouse);
		
		lblZipCode = new JLabel("CEP");
		lblZipCode.setBounds(25, 165, 100, 25);
		lblZipCode.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblZipCode);
		
		lblHouseNearWhat = new JLabel("Próximo");
		lblHouseNearWhat.setBounds(150, 165, 100, 25);
		lblHouseNearWhat.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblHouseNearWhat);
		
		lblneighborhood = new JLabel("Bairro");
		lblneighborhood.setBounds(280, 165, 100, 25);
		lblneighborhood.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblneighborhood);
		
		lblCity = new JLabel("Cidade");
		lblCity.setBounds(25, 220, 100, 25);
		lblCity.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblCity);
		
		lblState = new JLabel("UF");
		lblState.setBounds(200, 220, 100, 25);
		lblState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblState);
		
		lblSex = new JLabel("Gênero");
		lblSex.setBounds(550, 75, 100, 25);
		lblSex.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblSex);
		
		lblObservation = new JLabel("Observação");
		lblObservation.setBounds(25, 275, 100, 25);
		lblObservation.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblObservation);
		
		lblModals = new JLabel("Modalidade");
		lblModals.setBounds(550, 120, 100, 25);
		lblModals.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblModals);
		
		lblDegree = new JLabel("Grau");
		lblDegree.setBounds(405, 220, 100, 25);
		lblDegree.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblDegree);

		lblValue = new JLabel("Valores");
		lblValue.setBounds(405, 320, 100, 25);
		lblValue.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValue);
		
		lblValueJiuJitsu = new JLabel("Jiu-Jitsu");
		lblValueJiuJitsu.setBounds(330, 345, 100, 25);
		lblValueJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueJiuJitsu);
		
		lblValueCapoeira = new JLabel("Capoeira");
		lblValueCapoeira.setBounds(330, 370, 100, 25);
		lblValueCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueCapoeira);
		
		lblValueMuayThai = new JLabel("Muay Thai");
		lblValueMuayThai.setBounds(330, 395, 100, 25);
		lblValueMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblValueMuayThai);
		
		lblDegreeJiuJitsu = new JLabel("Jiu-Jitsu");
		lblDegreeJiuJitsu.setBounds(330, 245, 100, 25);
		lblDegreeJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblDegreeJiuJitsu);
		
		lblDegreeCapoeira = new JLabel("Capoeira");
		lblDegreeCapoeira.setBounds(330, 270, 100, 25);
		lblDegreeCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblDegreeCapoeira);
		
		lblDegreeMuayThai = new JLabel("Muay Thai");
		lblDegreeMuayThai.setBounds(330, 295, 100, 25);
		lblDegreeMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblDegreeMuayThai);
		
		lblImage = new JLabel();
		lblImage.setBounds(710, 100, 150, 200);
		getContentPane().add(lblImage);
		
		//JTextFields
		
		txfCodClient = new JTextField();
		txfCodClient.setBounds(25, 50, 100, 20);
		txfCodClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfCodClient);
		
		txfFullName = new JTextField();
		txfFullName.setBounds(150, 50, 300, 20);
		txfFullName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfFullName);
		
		txfCPF = new JFormattedTextField();
		txfCPF.setBounds(480, 50, 110, 20);
		txfCPF.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskCPF = new MaskFormatter("###.###.###-##");
		dateMaskCPF.install(txfCPF);
		getContentPane().add(txfCPF);
		
		txfRG = new JTextField();
		txfRG.setBounds(630, 50, 100, 20);
		txfRG.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfRG);
	
		txfDateOfBirth = new JFormattedTextField();
		txfDateOfBirth.setBounds(25, 100, 80, 20);
		txfDateOfBirth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskDateOfBirth = new MaskFormatter("##/##/####");
		dateMaskDateOfBirth.install(txfDateOfBirth);
		getContentPane().add(txfDateOfBirth);
		
		txfNumberPhone = new JFormattedTextField();
		txfNumberPhone.setBounds(200, 100, 120, 20);
		txfNumberPhone.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskNumberPhone = new MaskFormatter("(##) # ####-####");
		dateMaskNumberPhone.install(txfNumberPhone);
		getContentPane().add(txfNumberPhone);
		
		txfNumberHouse = new JFormattedTextField();
		txfNumberHouse.setBounds(380, 100, 110, 20);
		txfNumberHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		MaskFormatter dateMaskNumberHouse = new MaskFormatter("(##) ####-####");
		dateMaskNumberHouse.install(txfNumberHouse);
		getContentPane().add(txfNumberHouse);

		txfAdrress = new JTextField();
		txfAdrress.setBounds(25, 145, 350, 20);
		txfAdrress.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfAdrress);
		
		txfCodHouse = new JTextField();
		txfCodHouse.setBounds(400, 145, 90, 20);
		txfCodHouse.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfCodHouse);
		
		txfZipCode = new JTextField();
		txfZipCode.setBounds(25, 190, 100, 20);
		txfZipCode.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfZipCode);
		
		txfHouseNearWhat = new JTextField();
		txfHouseNearWhat.setBounds(150, 190, 100, 20);
		txfHouseNearWhat.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfHouseNearWhat);
		
		txfneighborhood = new JTextField();
		txfneighborhood.setBounds(280, 190, 210, 20);
		txfneighborhood.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfneighborhood);
		
		txfCity = new JTextField();
		txfCity.setBounds(25, 245, 150, 20);
		txfCity.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfCity);
		
		txfObservation = new JTextArea();
		txfObservation.setBounds(25, 300, 275, 100);
		txfObservation.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		txfObservation.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		getContentPane().add(txfObservation);
		
		//ComboBox
		cbSex = new JComboBox<String>(combBoxTextsSex);
		cbSex.setBounds(550, 100, 110, 20);
		cbSex.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbSex);
		
		cbState = new JComboBox<String>(combBoxTextsStates);
		cbState.setBounds(200, 245, 100, 20);
		cbState.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbState);
		
		cbValuesCapoeira= new JComboBox<String>(combBoxTextsCapoeiraValue);
		cbValuesCapoeira.setBounds(405, 370, 300, 20);
		cbValuesCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbValuesCapoeira);
		
		cbValuesJiuJitsu = new JComboBox<String>(combBoxTextsJiuJitsuValue);
		cbValuesJiuJitsu.setBounds(405, 345, 300, 20);
		cbValuesJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbValuesJiuJitsu);
		
		cbValuesMuayThai = new JComboBox<String>(combBoxTextsMuayThaiValue);
		cbValuesMuayThai.setBounds(405, 395, 300, 20);
		cbValuesMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbValuesMuayThai);
		
		cbDegreeCapoeira= new JComboBox<String>(combBoxTextsCapoeiraDegree);
		cbDegreeCapoeira.setBounds(405, 270, 300, 20);
		cbDegreeCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbDegreeCapoeira);
		
		cbDegreeJiuJitsu = new JComboBox<String>(combBoxTextsJiuJitsuDegree);
		cbDegreeJiuJitsu.setBounds(405, 245, 300, 20);
		cbDegreeJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbDegreeJiuJitsu);
		
		cbDegreeMuayThai = new JComboBox<String>(combBoxTextsMuayThaiDegree);
		cbDegreeMuayThai.setBounds(405, 295, 300, 20);
		cbDegreeMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(cbDegreeMuayThai);

		//CheckBox
		
		chbModalsCapoeira = new JCheckBox("Capoeira");
		chbModalsCapoeira.setBounds(550, 170, 100, 20);
		chbModalsCapoeira.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(chbModalsCapoeira);
		
		chbModalsJiuJitsu = new JCheckBox("Jiu Jitsu");
		chbModalsJiuJitsu.setBounds(550, 145, 100, 20);
		chbModalsJiuJitsu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(chbModalsJiuJitsu);
		
		chbModalsMuayThai = new JCheckBox("Muay Thai");
		chbModalsMuayThai.setBounds(550, 195, 100, 20);
		chbModalsMuayThai.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(chbModalsMuayThai);
		
		if (!chbModalsCapoeira.isSelected()) {
			cbValuesCapoeira.disable();
			cbDegreeCapoeira.disable();
		}
		if (!chbModalsJiuJitsu.isSelected()) {
			cbValuesJiuJitsu.disable();
			cbDegreeJiuJitsu.disable();
		}
		if (!chbModalsMuayThai.isSelected()) {
			cbValuesMuayThai.disable();
			cbDegreeMuayThai.disable();
		}
		
		//Buttons
		
		btnAddImage = new JButton();
		btnAddImage.setBounds(826, 300, 35, 25);
		btnAddImage.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		btnAddImage.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\plus.png"));
		getContentPane().add(btnAddImage);
		
		btnConsultClient = new JButton("Consultar");
		btnConsultClient.setBounds(250, 480, 90, 65);
		btnConsultClient.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnConsultClient.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Client.png"));
		btnConsultClient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultClient.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnConsultClient);
		
		btnSave = new JButton("Salvar");
		btnSave.setBounds(150, 480, 90, 65);
		btnSave.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		//btnSave.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Save.png"));
		btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(25, 480, 90, 65);
		btnCancel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 10));
		btnCancel.setIcon(new ImageIcon("C:\\Users\\victo\\Desktop\\ProjectGymUNESC\\2 - Images\\src\\48x48\\Exit.png"));
		btnCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnCancel );
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionsButtons() {
		 
		chbModalsCapoeira.addActionListener(e->{
			if(chbModalsCapoeira.isSelected()) {
				cbValuesCapoeira.enable(true);
				cbDegreeCapoeira.enable(true);
				repaint();
			}else {
				cbDegreeCapoeira.disable();
				cbValuesCapoeira.disable();
				repaint();
			}
		});

		chbModalsJiuJitsu.addActionListener(e->{
			if(chbModalsJiuJitsu.isSelected()) {
				cbValuesJiuJitsu.enable(true);
				cbDegreeJiuJitsu.enable(true);
				repaint();
			}else {
				cbValuesJiuJitsu.disable();
				cbDegreeJiuJitsu.disable();
				repaint();
			}
		});
		
		chbModalsMuayThai.addActionListener(e->{
			if(chbModalsMuayThai.isSelected()) {
				cbValuesMuayThai.enable(true);
				cbDegreeMuayThai.enable(true);
				repaint();
			}else {
				cbValuesMuayThai.disable();
				cbDegreeMuayThai.disable();
				repaint();
			}
		});
		
		/*
		  *  preciso que quando o usuario aperte a tecla tab ou enter
		  *  ele va no banco e procura se o cpf ja exite.
		  */
		 
		txfCPF.addActionListener(e->{
			//String CPFText;
		//	CPFText = txfCPF.getText();
			
			//passar o cpf para o banco e fazer a procura dele
			//caso nao exista nao da mensagem, caso exista abrir os dados do usuario, dizendo que ja existe
		});
		
		btnAddImage.addActionListener(e->{
			clientLib.chooseImageForPerson(lblImage);
		});
		
		btnConsultClient.addActionListener(e->{
			//form
		});
		
		btnSave.addActionListener(e->{
			clientLib.validations(cbSex);
			/*try {
				//try banco
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}*/
		});
		
		btnCancel.addActionListener(e->{
			dispose();
		});
	}
}