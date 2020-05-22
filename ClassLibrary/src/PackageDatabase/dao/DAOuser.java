package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PackageDatabase.model.modelUser;

public class DAOuser extends AbstractDAO{

	private String queryAllUsers = "SELECT * FROM "
								+ "ACADEMY_PRIMAL.LOGINS";
	
	private String queryOnlyUser = "SELECT * FROM "
								+ "ACADEMY_PRIMAL.LOGINS "
								+ "WHERE "
								+ "AC_USERNAME = ? AND "
								+ "AC_PASSWORD = ? /*AND "
								+ "C_PROFILE = ?*/";
	
	private String insertUser = "INSERT INTO "
								+ "ACADEMY_PRIMAL.LOGINS"
								+ "(AC_USERNAME, AC_PASSWORD, AC_PROFILE)"
								+ "VALUES"
								+ "(?, ?, ?)";
	
	private String deleteUser = "DELETE FROM "
								+ "ACADEMY_PRIMAL.LOGINS "
								+ "WHERE AC_IDLOGINS = ?";
	
	private String queryLike = "SELECT * FROM "
								+ "ACADEMY_PRIMAL.LOGINS "
								+ "WHERE "
								+ "AC_USERNAME LIKE ?";
	
	private PreparedStatement PSqueryAllUsers;
	private PreparedStatement PSqueryOnlyUser;
	private PreparedStatement PSinsertUser;
	private PreparedStatement PSdeleteUser;
	private PreparedStatement PSqueryLike;
	
	public DAOuser(final Connection conn) throws SQLException{
		PSqueryAllUsers = conn.prepareStatement(queryAllUsers);
		PSqueryOnlyUser = conn.prepareStatement(queryOnlyUser);
		PSinsertUser = conn.prepareStatement(insertUser);
		PSdeleteUser = conn.prepareStatement(deleteUser);
		PSqueryLike = conn.prepareStatement(queryLike);
	}
	
	
	public modelUser SelectLogin(final String _user, final String _password) throws SQLException {
		
		modelUser user = null;
		
		Set(PSqueryOnlyUser, 1, _user);
		Set(PSqueryOnlyUser, 2, _password);
		
		ResultSet result = PSqueryOnlyUser.executeQuery();
		if(result.first()) {
				user = new modelUser();
				user.setIdCode(result.getInt("AC_IDLOGINS"));
				user.setUser(result.getString("AC_USERNAME"));
				user.setPassword(result.getString("AC_PASSWORD"));
				user.setProfile(result.getInt("AC_PROFILE"));
		}
		result.close();
		
		return user;
		
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		ArrayList<Object> arlUsers = new ArrayList<Object>();
		ResultSet result = null;
		if(as_parameter != null && as_parameter instanceof String) {
			String parameter = (String) as_parameter;
			if(!parameter.isEmpty()) {
				Set(PSqueryLike, 1, "%"+as_parameter+"%");
				result = PSqueryLike.executeQuery();	
			}
			else {
				result = PSqueryAllUsers.executeQuery();	
			}
		}else {
			result = PSqueryAllUsers.executeQuery();
		}
		
		while(result.next()) {
			modelUser user = new modelUser();
			user.setIdCode(result.getInt("AC_IDLOGINS"));
			user.setUser(result.getString("AC_USERNAME"));
			user.setPassword(result.getString("AC_PASSWORD"));
			user.setProfile(result.getInt("AC_PROFILE"));
			arlUsers.add(user);
		}
		result.close();
		
		return arlUsers;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {

		modelUser user = (modelUser) ao_object;
		Set(PSinsertUser, 1, user.getUser());
		Set(PSinsertUser, 2, user.getPassword());
		Set(PSinsertUser, 3, user.getProfile());
		
		PSinsertUser.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {
		modelUser user = (modelUser) ao_object;
		Set(PSdeleteUser, 1, user.getIdCode());
		
		PSdeleteUser.execute();
	}

}
