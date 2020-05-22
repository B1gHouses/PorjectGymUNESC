package PackageGraphicWindows;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import PackageClassLibrary.Observable;
import PackageClassLibrary.Observer;
import PackageDatabase.dao.AbstractDAO;

public class windowConsultGeneric extends JDialog implements Observable{
	
	private JTable tbl;
	private JScrollPane spn;
	private DefaultTableModel tblModel= new DefaultTableModel(){public boolean isCellEditable(int row, int col) {return false;}};
	
	private AbstractDAO dao;
	private Observer obs;
	
	public windowConsultGeneric(final AbstractDAO dao, final String[] columns, final Observer obs) {
		
		this.dao = dao;
		this.obs = obs;
		
		setSize(300, 380);
		setTitle("Tela");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		buildWindow(columns);
		actionsButtons();
	}		
	
	public void buildWindow(final String[] columns){
		for(String c : columns) {
			
		}
		
		tbl = new JTable(tblModel);
		spn = new JScrollPane(tbl);
		spn.setBounds(0, 65, 395, 167);
		getContentPane().add(spn);
		
		
		
	}
	
	public void actionsButtons() {
		
	}

	@Override
	public void AddObserver(Observer obj) {

	}

	@Override
	public void RemoveObserver(Observer obj) {

	}

	@Override
	public void NotifyAllObserver() {

	}
	
}
