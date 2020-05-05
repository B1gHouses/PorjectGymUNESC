package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PackageDatabase.model.Usuario;

public class UsuarioDAO extends AbstractDAO{

	private String query = "SELECT * FROM UNESC.LOGINS";
	private PreparedStatement pst_query;
	
	public UsuarioDAO(final Connection conn) throws SQLException{
		pst_query = conn.prepareStatement(query);
	}
	
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		ArrayList<Object> arlUsuarios = new ArrayList<Object>();
		ResultSet result = pst_query.executeQuery();
		
		while(result.next()) {
			arlUsuarios.add(new Usuario(result.getString("USERNAME"), result.getString("PASSWORD")));
		}
		result.close();
		
		return arlUsuarios;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {

		
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		
	}

}
