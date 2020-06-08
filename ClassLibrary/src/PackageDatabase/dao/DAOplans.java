package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PackageDatabase.model.modelPlans;

public class DAOplans extends AbstractDAO{

	private String queryAllValues = "SELECT * FROM "
								+ "ACADEMY_PRIMAL.PLAN_ACADEMY";
	
	private String insertPlan = "INSERT INTO ACADEMY_PRIMAL.PLAN_ACADEMY (plan, modality) VALUES (?, ?)";
	
	private String deletePlan = "DELETE FROM ACADEMY_PRIMAL.PLAN_ACADEMY WHERE PLAN = ? AND MODALITY = ?";
	
	private PreparedStatement PSqueryAllValues;
	private PreparedStatement PSinsertPlan;
	private PreparedStatement PSdeletePlan;
	
	public DAOplans(final Connection conn) throws SQLException {
		PSqueryAllValues = conn.prepareStatement(queryAllValues);
		PSinsertPlan = conn.prepareStatement(insertPlan);
		PSdeletePlan = conn.prepareStatement(deletePlan);
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlValues = new ArrayList<Object>();
		
		ResultSet result = PSqueryAllValues.executeQuery();
		
		while(result.next()){
			modelPlans values = new modelPlans();
			values.setPlans(result.getString("PLAN"));
			values.setModality(result.getString("MODALITY"));
			arlValues.add(values);
	
		}
		result.close();
		
		return arlValues;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelPlans plans = (modelPlans) ao_object;
		Set(PSinsertPlan, 1, plans.getPlans());
		Set(PSinsertPlan, 2, plans.getModality());
		
		PSinsertPlan.execute();
	}
	
	@Override
	public void Update(Object ao_object) throws SQLException {
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		modelPlans plans = (modelPlans) ao_object;
		Set(PSdeletePlan, 1, plans.getPlans());
		Set(PSdeletePlan, 2, plans.getModality());
		
		PSdeletePlan.execute();
	}

}
