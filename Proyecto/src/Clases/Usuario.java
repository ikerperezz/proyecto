package Clases;

public class Usuario {
	private String usuario;
	private String contraseina;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseina() {
		return contraseina;
	}

	public void setContraseina(String contraseina) {
		this.contraseina = contraseina;
	}

	public Usuario(String usuario, String contraseina) {
		super();
		this.usuario = usuario;
		this.contraseina = contraseina;
	}
}
	
	
