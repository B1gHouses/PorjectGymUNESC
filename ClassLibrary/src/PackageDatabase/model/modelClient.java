package PackageDatabase.model;

public class modelClient implements interfaceModelGeneric{
	
	private int idClient;
	private String name;
	private String cpf;
	private String dateBorn;
	private String sex;
	private String rg;
	private String note;
	private String street;
	private String numberHouse;
	private String cep;
	private String near;
	private String neighborhood;
	private String city;
	private String state;
	private String modalityClient;
	private String degreClient;
	private String planClient;
	private String numberPhone;
	private String numberPhoneHouse;
	
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getNumberPhoneHouse() {
		return numberPhoneHouse;
	}
	public void setNumberPhoneHouse(String numberPhoneHouse) {
		this.numberPhoneHouse = numberPhoneHouse;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDateBorn() {
		return dateBorn;
	}
	public void setDateBorn(String dateBorn) {
		this.dateBorn = dateBorn;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumberHouse() {
		return numberHouse;
	}
	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNear() {
		return near;
	}
	public void setNear(String near) {
		this.near = near;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getModalityClient() {
		return modalityClient;
	}
	public void setModalityClient(String modalityClient) {
		this.modalityClient = modalityClient;
	}
	public String getDegreClient() {
		return degreClient;
	}
	public void setDegreClient(String degreClient) {
		this.degreClient = degreClient;
	}
	public String getPlanClient() {
		return planClient;
	}
	public void setPlanClient(String planClient) {
		this.planClient = planClient;
	}
	@Override
	public Object[] GetReuslt() {
		return new Object[] {getIdClient(), getName()};
	}
	
	
}
