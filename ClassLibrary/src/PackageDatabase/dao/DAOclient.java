package PackageDatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PackageDatabase.model.modelClient;

public class DAOclient extends AbstractDAO{

	private String selectAllClients = "SELECT * FROM ACADEMY_PRIMAL.CLIENTS";
	
	private String insertClients = "INSERT INTO ACADEMY_PRIMAL.CLIENTS (AC_NAME, AC_CPF, AC_DATE_BORN, AC_SEX, AC_RG, AC_NOTE, AC_RUA, AC_N_CASA, AC_CEP, AC_NEAR, AC_BAIRRO, AC_CIDADE, AC_UF, MODALITY, DEGREE, PLAN, NUMERO_CELULAR, NUMERO_TELEFONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private PreparedStatement PSselectAllClients;
	private PreparedStatement PSinsertClients;
	
	public DAOclient(final Connection conn) throws SQLException {
		PSselectAllClients = conn.prepareStatement(selectAllClients);
		PSinsertClients = conn.prepareStatement(insertClients);
	}
	
	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {
		return null;
	}

	@Override
	public List<Object> SelectWithOutParameter() throws SQLException {
		ArrayList<Object> arlClients = new ArrayList<Object>();
		
		ResultSet result = PSselectAllClients.executeQuery();
		
		while(result.next()){
			
			modelClient client = new modelClient();
			
			client.setIdClient(result.getInt("ac_idClients"));
			client.setName(result.getString("ac_name"));
			client.setCpf(result.getString("ac_cpf"));
			client.setDateBorn(result.getString("ac_date_Born"));
			client.setSex(result.getString("ac_sex"));
			client.setRg(result.getString("ac_rg"));
			client.setNote(result.getString("ac_note"));
			client.setStreet(result.getString("ac_rua"));
			client.setNumberHouse(result.getString("ac_n_casa"));
			client.setCep(result.getString("ac_cep"));
			client.setNear(result.getString("ac_near"));
			client.setNeighborhood(result.getString("ac_bairro"));
			client.setCity(result.getString("ac_cidade"));
			client.setState(result.getString("ac_uf"));
			client.setModalityClient(result.getString("modality"));
			client.setDegreClient(result.getString("Degree"));
			client.setPlanClient(result.getString("plan"));
			client.setNumberPhone(result.getString("NUMERO_CELULAR"));
			client.setNumberPhoneHouse(result.getString("NUMERO_TELEFONE"));
			
			arlClients.add(client);
	
		}
		result.close();
		
		return arlClients;
	}

	@Override
	public void Insert(Object ao_object) throws SQLException {
		modelClient client = (modelClient) ao_object;
		
		Set(PSinsertClients, 1, client.getName());
		Set(PSinsertClients, 2, client.getCpf());
		Set(PSinsertClients, 3, client.getDateBorn());
		Set(PSinsertClients, 4, client.getSex());
		Set(PSinsertClients, 5, client.getRg());
		Set(PSinsertClients, 6, client.getNote());
		Set(PSinsertClients, 7, client.getStreet());
		Set(PSinsertClients, 8, client.getNumberHouse());
		Set(PSinsertClients, 9, client.getCep());
		Set(PSinsertClients, 10, client.getNear());
		Set(PSinsertClients, 11, client.getNeighborhood());
		Set(PSinsertClients, 12, client.getCity());
		Set(PSinsertClients, 13, client.getState());
		Set(PSinsertClients, 14, client.getModalityClient());
		Set(PSinsertClients, 15, client.getDegreClient());
		Set(PSinsertClients, 16, client.getPlanClient());
		Set(PSinsertClients, 17, client.getNumberPhone());
		Set(PSinsertClients, 18, client.getNumberPhoneHouse());
		
		PSinsertClients.execute();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {
		
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {

	}

}
