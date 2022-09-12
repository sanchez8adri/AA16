package POJOs;

public class Artista {
	
	private String nombreArtista;

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public Artista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	@Override
	public String toString() {
		return "Artista [nombreArtista=" + nombreArtista + "]";
	}
	
	

}
