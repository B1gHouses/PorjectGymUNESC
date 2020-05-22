package PackageGraphicWindows;

import java.sql.Connection;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

public class windowPayment extends JInternalFrame{
	
	
	
	
	
	
	
	
	public windowPayment(Connection conn) {
		setSize(900,600);
		setTitle("Pagamento");
		setIconifiable(true);
		setMaximizable(false);
		setClosable(true);
		setResizable(false);
		setLocation(150, 20);

		buildWindow();
		actionsButtons();
	}
	
	public void buildWindow() {
		
	}
	
	public void actionsButtons() {
		
	}
}
