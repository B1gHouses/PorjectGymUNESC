package PackageGraphicWindows;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import PackageClassLibrary.Observable;
import PackageClassLibrary.Observer;
import PackageDatabase.dao.AbstractDAO;
import PackageDatabase.model.interfaceModelGeneric;

@SuppressWarnings("serial")
public class windowConsultGeneric extends JDialog implements Observable{
	
	private JTable tbl;
	private JScrollPane spn;

	private DefaultTableModel tblModel= new DefaultTableModel(){public boolean isCellEditable(int row, int col) {return false;}};
	
	private JLabel lblSerch = new JLabel();
	
	private JTextField txfSerch = new JTextField();
	
	private JButton btnOk = new JButton();
	private JButton btnCancel = new JButton();
	
	private AbstractDAO dao;

	private List<Observer> listObs = new ArrayList<Observer>();
	private List<Object> listObj;
	
	
	public windowConsultGeneric(final AbstractDAO dao, final String[] columns, final Observer obs) {

		setBounds(100, 100, 400, 250);
		setModal(true);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		this.dao = dao;
		AddObserver(obs);
		
		buildWindow(columns);
		actionsButtons();
	}		
	
	public void buildWindow(final String[] columns){
		for(String c : columns) {
			tblModel.addColumn(c);
		}
		
		tbl = new JTable(tblModel);
		spn = new JScrollPane(tbl);
		spn.setBounds(10, 65, 380, 150);
		getContentPane().add(spn);
		
		lblSerch = new JLabel("Pesquisar");
		lblSerch.setBounds(10, 10, 150, 20);
		lblSerch.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(lblSerch);
		
		txfSerch = new JTextField();
		txfSerch.setBounds(85, 10, 150, 20);
		txfSerch.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(txfSerch);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(240, 10, 50, 20);
		btnOk.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnOk);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(290, 10, 90, 20);
		btnCancel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
		getContentPane().add(btnCancel);
		
		loadData();
		
	}
	
	public void actionsButtons() {
		btnCancel.addActionListener(e->{
			dispose();
		});
		
		btnOk.addActionListener(e->{
			
			NotifyAllObserver();
			
			dispose();
		});
		
	}

	private void loadData() {
		
		while(tblModel.getRowCount()>0) {
			tblModel.removeRow(0);
		}
		
		try {
			listObj = dao.SelectWithOutParameter();
			
			for (Object obj : listObj) {
				tblModel.addRow(((interfaceModelGeneric)obj).GetReuslt());
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
		}
	}
	
	
	@Override
	public void AddObserver(Observer obj) {
		listObs.add(obj);
	}

	@Override
	public void RemoveObserver(Observer obj) {
		listObs.remove(obj);
	}

	@Override
	public void NotifyAllObserver() {
		for (int i=0; i < listObs.size(); i++ ) {
			Observer obs = listObs.get(i);
			obs.Update(listObj.get(tbl.getSelectedRow()));
		}
	}
	
}
