package PackageGraphicWindows;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import PackageDatabase.dao.DAOdegree;
import PackageDatabase.dao.DAOmodality;
import PackageDatabase.dao.DAOuser;
import PackageDatabase.model.modelDegree;
import PackageDatabase.model.modelModality;
import PackageDatabase.model.modelUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
public class windowConfigure extends JInternalFrame{
	
	List<Object> objmoda;
	List<Object> objdegree;
	
	private DAOmodality daoModality;
	private DAOdegree daoDegree;
	
	private Connection conn;
	//private String[] combBoxtextPrinters = new String[] {"Selecione"/*mapear impressoras*/};		
	
	private JTable tblModality = new JTable();
	private JScrollPane spnModality = new JScrollPane();
	private DefaultTableModel tblModelModality = new DefaultTableModel(){public boolean isCellEditable(int row, int col) {return false;}};
	
	private JTable tblDegree = new JTable();
	private JScrollPane spnDegree = new JScrollPane();
	private DefaultTableModel tblModelDegree = new DefaultTableModel(){public boolean isCellEditable(int row, int col) {return false;}};

	private JTable tblPlan = new JTable();
	private JScrollPane spnPlan = new JScrollPane();
	private DefaultTableModel tblModelplan = new DefaultTableModel(){public boolean isCellEditable(int row, int col) {return false;}};
	
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
	
	private JButton btnPlan = new JButton();
	private JButton btnOKPlan = new JButton();
	private JButton btnLessTblPlan = new JButton();
	
	private JButton btnModality = new JButton();
	private JButton btnOKModality = new JButton();
	private JButton btnLessTblModality = new JButton();
	
	private JButton btnDegree = new JButton();
	private JButton btnOKDegree = new JButton();
	private JButton btnLessTblDegree = new JButton();
	
	private JPanel panel = new JPanel();
	
	private JComboBox<String> cbPrinter = new JComboBox<String>();
	private JComboBox<String> cbModality = new JComboBox<String>();
	
	public windowConfigure(Connection conn) {
		
		this.conn = conn;
		
		try {
			daoModality = new DAOmodality(conn);	
			daoDegree = new DAOdegree(conn);
		}catch (Exception e) {
			
		}
		
		setSize(500,400);
		setTitle("Configuração");
		setIconifiable(true);
		setMaximizable(false);
		setClosable(true);
		setResizable(false);
		setLocation(350, 100);
		
		buildWindow();
		actionsButtons();

	}
	
	private void buildWindow(){
		
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

		btnDegree = new JButton("Graduação");
		btnDegree.setBounds(10, 90, 100, 25);
		panel.add(btnDegree);		
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 130, 100, 25);
		panel.add(btnModality);
		
	}
	
	private void buildWindowGeneral(){
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
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(125, 330, 100, 25);
		panel.add(btnCancel);
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);

		btnDegree = new JButton("Graduação");
		btnDegree.setBounds(10, 90, 100, 25);
		panel.add(btnDegree);		
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 130, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	private void buildWindowPlan(){

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		
		if (tblModelplan.getColumnCount() == 0) {
			tblModelplan.addColumn("Modalidade");
			tblModelplan.addColumn("Valor");
			tblModelplan.addColumn("Dias");
		}
		
		tblPlan = new JTable(tblModelplan);
		spnPlan = new JScrollPane(tblPlan);
		spnPlan.setBounds(125, 120, 350, 100);
		panel.add(spnPlan);
		tblPlan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		txfValue.setBounds(250, 45, 200, 20);
		txfValue.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfValue);
		
		txfDays = new JTextField();
		txfDays.setBounds(250, 70, 200, 20);
		txfDays.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfDays);
		
		//ComboBox
		
		cbModality = new JComboBox<String>(loadDataAllModalitys());
		cbModality.setBounds(250, 20, 200, 20);
		cbModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbModality);
		
		
		//Buttons

		btnOKPlan = new JButton("OK");
		btnOKPlan.setBounds(400, 95, 50, 20);
		panel.add(btnOKPlan);
		
		btnLessTblPlan = new JButton("-");
		btnLessTblPlan.setBounds(125, 95, 50, 20);
		panel.add(btnLessTblPlan);
		
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(125, 330, 100, 25);
		panel.add(btnCancel);
		
		/*btnSavePlan = new JButton("Salvar");
		btnSavePlan.setBounds(375, 330, 100, 25);
		panel.add(btnSavePlan);*/
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);

		btnDegree = new JButton("Graduação");
		btnDegree.setBounds(10, 90, 100, 25);
		panel.add(btnDegree);		
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 130, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	private void buildWindowDegree() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		if (tblModelDegree.getColumnCount() == 0) {
			tblModelDegree.addColumn("Modalidade");
			tblModelDegree.addColumn("Gradução");
		}
		
		tblDegree = new JTable(tblModelDegree);
		spnDegree = new JScrollPane(tblDegree);
		spnDegree.setBounds(125, 75, 350, 100);
		panel.add(spnDegree);
		tblDegree.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblModality = new JLabel("Modalidade");
		lblModality.setBounds(125, 20, 100, 20);
		lblModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblModality);
		
		lblDegree = new JLabel("Graduação");
		lblDegree.setBounds(125, 45, 100, 20);
		lblDegree.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblDegree);
		
		txfDegree = new JTextField();
		txfDegree.setBounds(200, 45, 200, 20);
		txfDegree.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfDegree);
		
		cbModality = new JComboBox<String>();
		cbModality.setBounds(200, 20, 200, 20);
		cbModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(cbModality);
		
		btnLessTblDegree = new JButton("-");
		btnLessTblDegree.setBounds(425, 180, 50, 25);
		panel.add(btnLessTblDegree);
		
		/*btnSaveDegree = new JButton("Salvar");
		btnSaveDegree.setBounds(375, 330, 100, 25);
		panel.add(btnSaveDegree);*/
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(125, 330, 100, 25);
		panel.add(btnCancel);
		
		btnOKDegree = new JButton("OK");
		btnOKDegree.setBounds(420, 45, 50, 20);
		panel.add(btnOKDegree);
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);

		btnDegree = new JButton("Graduação");
		btnDegree.setBounds(10, 90, 100, 25);
		panel.add(btnDegree);		
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 130, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	private void buildWindowModality(){
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);	
		
		if (tblModelModality.getColumnCount() == 0) {
			tblModelModality.addColumn("Modalidade");
		}
		
		tblModality = new JTable(tblModelModality);
		spnModality = new JScrollPane(tblModality);
		spnModality.setBounds(125, 45, 350, 100);
		panel.add(spnModality);
		tblModality.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblModelModality.addRow(loadDataAllModalitys());
		
		lblModality = new JLabel("Modalidade");
		lblModality.setBounds(125, 20, 100, 20);
		lblModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(lblModality);
		
		txfModality = new JTextField();
		txfModality.setBounds(200, 20, 200, 20);
		txfModality.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		panel.add(txfModality);
		
		btnLessTblModality = new JButton("-");
		btnLessTblModality.setBounds(425, 150, 50, 25);
		panel.add(btnLessTblModality);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(125, 330, 100, 25);
		panel.add(btnCancel);
		
		/*btnSaveModality = new JButton("Salvar");
		btnSaveModality.setBounds(375, 330, 100, 25);
		panel.add(btnSaveModality);*/
		
		btnOKModality = new JButton("OK");
		btnOKModality.setBounds(420, 20, 50, 20);
		panel.add(btnOKModality);
		
		btnGeneral = new JButton("Geral");
		btnGeneral.setBounds(10, 10, 100, 25);
		panel.add(btnGeneral);
		
		btnPlan = new JButton("Mensalidade");
		btnPlan.setBounds(10, 50, 100, 25);
		panel.add(btnPlan);

		btnDegree = new JButton("Graduação");
		btnDegree.setBounds(10, 90, 100, 25);
		panel.add(btnDegree);		
		
		btnModality = new JButton("Modalidade");
		btnModality.setBounds(10, 130, 100, 25);
		panel.add(btnModality);
		
		actionsButtons();
	}
	
	public void actionsButtons(){
		btnGeneral.addActionListener(e->{
			//if(tblModality.getRowCount() != 0 || tblDegree.getRowCount() != 0) {
				//if(JOptionPane.showConfirmDialog(null, "Você NÃO Salvou as alterações, \n Deseja Continuar?", "Você Não Salvou", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			clearTable();
				//}else {return;}
	//		}
			buildWindowGeneral();
		});
		
		btnPlan.addActionListener(e->{
			clearTable();
			buildWindowPlan();
		});
		
		btnModality.addActionListener(e->{
			clearTable();
			buildWindowModality();
		});
		
		btnDegree.addActionListener(e->{
			clearTable();
			buildWindowDegree();
		});
		
	/*	btnSaveModality.addActionListener(e->{
			ArrayList<String> numdata = new ArrayList<String>();
			for (int count = 0; count < tblModelModality.getRowCount(); count++){
				  numdata.add(tblModelModality.getValueAt(count, 0).toString());
				}
			
			ArrayList<String> data = numdata;
			
			try {
				modelModality modality = new modelModality();
				 //modality.setModality(numdata);

				 
				 DAOmodality dao = new DAOmodality(conn);
				 dao.Insert(modality);
				 
				 JOptionPane.showMessageDialog(null, "Usuário Inserido");
				 
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Inserir o usuário: " + e1.getMessage());
				}
		});*/
		
		btnOKPlan.addActionListener(e->{
			
			if(txfValue.getText().equals("") || txfDays.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Posição Invalido");
				return;
			}

			String combBoxTextModality = (String)cbModality.getSelectedItem();
			
			String[] vector = new String[] {combBoxTextModality, txfValue.getText(), txfDays.getText()};
			
			tblModelplan.addRow(vector);
			
			txfValue.setText("");		
			txfDays.setText("");	
		});
		
		btnOKDegree.addActionListener(e->{
			if(txfDegree.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Posição Invalido");
				return;
			}
			String combBoxTextModality = (String)cbModality.getSelectedItem();
			
			tblModelDegree.addRow(new String[] {combBoxTextModality, txfDegree.getText()});
			
			txfDegree.setText("");
		});
		
		btnOKModality.addActionListener(e->{
			if(txfModality.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Posição Invalido");
				return;
			}

			tblModelModality.addRow(new String[] {txfModality.getText()});
			
			try {
				
				modelModality modality = new modelModality();
				 modality.setModality(txfModality.getText());
				
				DAOmodality dao = new DAOmodality(conn);
				dao.Insert(modality);
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage(), "Erro abrir Insert Modality", JOptionPane.ERROR_MESSAGE);
			}
			
			txfModality.setText("");
		});
		
		btnLessTblDegree.addActionListener(e->{
			if (tblDegree.getSelectedRow() >= 0){
				tblModelDegree.removeRow(tblDegree.getSelectedRow());
				tblDegree.setModel(tblModelDegree);
		    }else{
		        JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
		    }
		});
		
		btnLessTblModality.addActionListener(e->{
			if (tblModality.getSelectedRow() >= 0){
				tblModelModality.removeRow(tblModality.getSelectedRow());
				tblModality.setModel(tblModelModality);
		    }else{
		        JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
		    }
		});
		
		btnCancel.addActionListener(e->{
			dispose();
		});
	}
	
	private void clearTable() {
		while(tblModelModality.getRowCount()>0) {
			tblModelModality.removeRow(0);
		}
		
		while(tblModelDegree.getRowCount()>0) {
			tblModelDegree.removeRow(0);
		}
		
		while(tblModelplan.getRowCount()>0) {
			tblModelplan.removeRow(0);
		}
		
	}
	
	private String[] loadDataAllModalitys() {
		try {
			String[] str = new String[] {};
			objmoda = daoModality.SelectWithOutParameter();	
			objdegree = daoDegree.SelectWithOutParameter();	
			
			for(Object ob : objmoda) {
				for(Object obj : objdegree) {
				modelModality modality = (modelModality) ob;
				modelDegree degree = (modelDegree) obj;
				
				tblModelDegree.addRow(new String[] {modality.getModality(), degree.getDegree()});
				tblModelModality.addRow(new String[] {modality.getModality()});
				//cbModality = new JComboBox<String>(loadDataAllModalitys());
				}
			}
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro Carregar dados na table: " + e1.getMessage());
		}
		return null;
	}
	
}
