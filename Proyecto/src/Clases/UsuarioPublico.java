package Clases;

public class UsuarioPublico extends Usuario {

		private String idLiga;
		private int dineroDisponible;
	
		
	public String getIdLiga() {
			return idLiga;
		}

		public void setIdLiga(String idLiga) {
			this.idLiga = idLiga;
		}

		public int getDineroDisponible() {
			return dineroDisponible;
		}

		public void setDineroDisponible(int dineroDisponible) {
			this.dineroDisponible = dineroDisponible;
		}

	public UsuarioPublico(String usuario, String contraseina, String idLiga, int dineroDisponible) {
		super(usuario, contraseina);
		this.idLiga=idLiga;
		this.dineroDisponible=dineroDisponible;
	}

}
