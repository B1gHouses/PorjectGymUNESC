package PackageDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.stream.events.EndElement;

public class connectionFactory {

	public static Connection getConnection(final String adress, final int port, 
			final String database, final String username, final String password) throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://"
				+ adress
				+ ":"
				+ port
				+"/"
				+database, username, password
				);
	}
	
}
