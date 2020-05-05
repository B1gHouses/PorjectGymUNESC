package PackageMain;
import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import PackageGraphicWindows.windowLogin;



public class MainProject {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new windowLogin().setVisible(true);
	
	}
}
