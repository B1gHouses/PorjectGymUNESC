package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PackageDatabase.model.modelDegree;

public class DAOdegree extends AbstractDAO{

	private String selectAllDegree = "SELECT MODALITY, DEGREE FROM ACADEMY_PRIMAL.DEGREE";
	private String insertDegreeAndModality = "INSERT INTO ACADEMY_PRIMAL.DEGREE (DEGREE, MODALITY) VALUES(?, ?)";
	private String deleteDegreeAndModality = "DELETE FROM ACADEMY_PRIMAL.DEGREE WHERE DEGREE = ? AND MODALITY = ?";
	
	private PreparedStatement PSselectDegree;
	private PreparedStatement PSinsertDegreeAndModality;
	private PreparedStatement PSdeleteDegreeAndModality;
	
	public DAOdegree(final Connection conn) throws SQLException{
		PSselectDegree = conn.prepareStatement(selectAllDegree);
		PSinsertDegreeAndModality = conn.prepareStatement(insertDegreeAndModality);
		PSdeleteDegreeAndModality = conn.prepareStatement(deleteDegreeAndModality);
	}
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlModality = new ArrayList<Object>();
		
		ResultSet result = PSselectDegree.executeQuery();
		
		while(result.next()){
			modelDegree degree = new modelDegree();
			degree.setDegree(result.getString("DEGREE"));
			degree.setModality(result.getString("MODALITY"));
			arlModality.add(degree);
	
		}
		result.close();
		
		return arlModality;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelDegree degree = (modelDegree) ao_object;
		Set(PSinsertDegreeAndModality, 1, degree.getDegree());
		Set(PSinsertDegreeAndModality, 2, degree.getModality());
		
		PSinsertDegreeAndModality.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		modelDegree degree = (modelDegree) ao_object;
		Set(PSdeleteDegreeAndModality, 1, degree.getDegree());
		Set(PSdeleteDegreeAndModality, 2, degree.getModality());
		
		PSdeleteDegreeAndModality.execute();
	}

}
