package PackageDatabase.model;

public class Usuario {
	private int idCodigo;
	private String usuario;
	private String senha;
	
	public Usuario(final String usuario, final String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

}
