package spring;

import java.io.File;
import java.io.IOException;
import java.util.List;

import POJOs.Cancion;

public interface CalcularRecaudacion {
	
	List<Cancion> calcularRecaudacion(File canciones) throws IOException;

}
