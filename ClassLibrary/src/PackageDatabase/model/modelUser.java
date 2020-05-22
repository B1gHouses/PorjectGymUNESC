package PackageDatabase.model;

public class modelUser {
	private int idCode;
	private String user;
	private String password;
	private int profile;
	
	public modelUser(){
		
	}
	
	
	public modelUser(final String user, final String password) {
		this.user = user;
		this.password = password;
	}

	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}



}
