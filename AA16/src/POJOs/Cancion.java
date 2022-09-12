package POJOs;

public class Cancion {

	private String titulo;
	private String artistas;
	private long reproducciones;
	private long recaudacion;
	
	public long getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(long recaudacion) {
		this.recaudacion = recaudacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtistas() {
		return artistas;
	}
	public void setArtistas(String artistas) {
		this.artistas = artistas;
	}
	public long getReproducciones() {
		return reproducciones;
	}
	public void setReproducciones(long reproducciones) {
		this.reproducciones = reproducciones;
	}
	
	public Cancion(String titulo, String artistas, long reproducciones, long recaudacion) {
		this.titulo = titulo;
		this.artistas = artistas;
		this.reproducciones = reproducciones;
		this.recaudacion = recaudacion;
	}
	
	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artistas=" + artistas + ", reproducciones=" + reproducciones
				+ ", recaudacion=" + recaudacion + "$]";
	}
	
	
	
	
}
