package PackageDatabase.model;

import java.util.ArrayList;

public class modelModality {
	private int idModality;
	private String modality;
	
	public modelModality() {
		
	}
	
	public modelModality(final int idModality, final String modality) {
		this.idModality = idModality;
		this.modality = modality;
	}
	
	public int getIdModality() {
		return idModality;
	}
	public void setIdModality(int idModality) {
		this.idModality = idModality;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String vector) {
		this.modality = vector;
	}
	
}
