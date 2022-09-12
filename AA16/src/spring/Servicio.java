package spring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class Servicio {
	
	public File generaArchivo() throws IOException {
		
		File archivo = new File("Lista_Spotify.txt");
		FileWriter fw = new FileWriter(archivo);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Actualmente este archivo no contiene información\n");
		bw.close();
		fw.close();
		
		return archivo;
		
	}
	
	public int cargaArchivo(File archivo) {
		
		if(archivo.exists()) {
			if(archivo.getName().contains(".txt")) {
				System.out.println("Formato de archivo correcto, el archivo " +archivo.getName()+ " está listo para ser usado\n");
				return 1;
			}else {
				System.out.println("Formato de archivo incorrecto");
				return 0;
			}
		}else
			System.out.println("El archivo no existe");
			return 0;
	}

}
