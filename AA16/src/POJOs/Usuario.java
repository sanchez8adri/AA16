package POJOs;

public class Usuario {
	
	private String nombreUsuario;
	private Persona persona;
	
	public Usuario(String nombreUsuario, Persona persona) {
		this.nombreUsuario = nombreUsuario;
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", persona=" + persona + "]";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
