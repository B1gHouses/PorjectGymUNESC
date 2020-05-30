package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PackageDatabase.model.modelDegree;
import PackageDatabase.model.modelModality;

public class DAOdegree extends AbstractDAO{

	
	
	private String selectAllDegree = "SELECT * FROM ACADEMY_PRIMAL.DEGREE";
	
	private PreparedStatement PSselectDegree;
	
	public DAOdegree(final Connection conn) throws SQLException{
		PSselectDegree = conn.prepareStatement(selectAllDegree);
	}
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlModality = new ArrayList<Object>();
		
		ResultSet result = PSselectDegree.executeQuery();
		
		while(result.next()){
			modelDegree degree = new modelDegree();
			degree.setDegree(result.getString("degree"));
			arlModality.add(degree);
	
		}
		result.close();
		
		return arlModality;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
