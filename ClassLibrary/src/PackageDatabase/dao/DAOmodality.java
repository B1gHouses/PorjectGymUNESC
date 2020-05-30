package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import PackageDatabase.model.modelModality;
import PackageDatabase.model.modelUser;

public class DAOmodality extends AbstractDAO{
	
	
	private String selectAllModalitys = "SELECT * FROM ACADEMY_PRIMAL.MODALITY";
	
	private String insertModality = "INSERT INTO ACADEMY_PRIMAL.MODALITY" 
									+ "(MODALITY)" 
									+ "VALUES (?)";
	
	private PreparedStatement PSinsertModality;
	private PreparedStatement PSselectModality;
	
	public DAOmodality(final Connection conn) throws SQLException{
		PSinsertModality = conn.prepareStatement(insertModality);
		PSselectModality = conn.prepareStatement(selectAllModalitys);
	}
	
	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlModality = new ArrayList<Object>();
		
		ResultSet result = PSselectModality.executeQuery();
		
		while(result.next()){
			modelModality modality = new modelModality();
			modality.setModality(result.getString("modality"));
			arlModality.add(modality);
	
		}
		result.close();
		
		return arlModality;
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {

		return null;
	}
	
	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelModality modality = (modelModality) ao_object;
		Set(PSinsertModality, 1, modality.getModality());
		
		PSinsertModality.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {

	}

	@Override
	public void Delete(Object ao_object) throws SQLException {

	}

}
