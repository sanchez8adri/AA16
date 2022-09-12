package spring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import POJOs.*;

public class Main implements CalcularRecaudacion{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigSpring.class)){
			
			Usuario usuario = new Usuario("sanchezadri", new Persona("Adrian", "Sanchez", "789456123M"));
			CalcularRecaudacion interfaz = new Main();
			
			Servicio servicio = ctx.getBean(Servicio.class);

			File archivo = servicio.generaArchivo();
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("----The Best of Spotify----\n");
			bw.write("Usuario: " +usuario.getNombreUsuario() + " Nombre: " +usuario.getPersona().getNombre()+" "+usuario.getPersona().getApellido() + " DNI: " +usuario.getPersona().getDni()+"\n");
			
			File artistas2020 = new File("Artistas 2020.txt");
			if(servicio.cargaArchivo(artistas2020)==1) {
				List<Artista> listaArtistas2020 = recibirArtistas(artistas2020);
				
				bw.write("\nTop 10 artistas 2020:\n");
				
				for(Artista artista: listaArtistas2020) {
					bw.write(artista.toString()+"\n");
				}
				
			}else {
				bw.write("\nTop 10 artistas 2020:\n");
				bw.write("No se pudo almacenar la información de los artistas 2020\n");
			}
			
			File artistas2021 = new File("Artistas 2021.txt");
			if(servicio.cargaArchivo(artistas2021)==1) {
				List<Artista> listaArtistas2021 = recibirArtistas(artistas2021);
				
				bw.write("\nTop 10 artistas 2021:\n");
				
				for(Artista artista: listaArtistas2021) {
					bw.write(artista.toString()+"\n");
				}
			}else {
				bw.write("\nTop 10 artistas 2021:\n");
				bw.write("No se pudo almacenar la información de los artistas 2021\n");
			}

			File canciones2020 = new File("Canciones 2020.txt");
			if(servicio.cargaArchivo(canciones2020)==1) {
				List<Cancion> listaCanciones2020 = interfaz.calcularRecaudacion(canciones2020);
				
				bw.write("\nTop 10 Canciones 2020:\n");
				
				for(Cancion cancion: listaCanciones2020) {
					bw.write(cancion.toString()+"\n");
				}
			}else {
				bw.write("\nTop 10 Canciones 2020:\n");
				bw.write("No se pudo almacenar la información de las canciones 2020\n");
			}

			File canciones2021 = new File("Canciones 2021.txt");
			if(servicio.cargaArchivo(canciones2021)==1) {
				List<Cancion> listaCanciones2021 = interfaz.calcularRecaudacion(canciones2021);
				
				bw.write("\nTop 10 Canciones 2021:\n");
				
				for(Cancion cancion: listaCanciones2021) {
					bw.write(cancion.toString()+"\n");
				}
			}else {
				bw.write("\nTop 10 Canciones 2021:\n");
				bw.write("No se pudo almacenar la información de las canciones 2021\n");
			}
			
			bw.close();
			fw.close();
			
			System.out.println("Información almacenada");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public List<Cancion> calcularRecaudacion(File canciones) throws IOException {
		
		Scanner sn = new Scanner(canciones);
		List<String> listaCanciones = new ArrayList<>();
		
		List<Cancion> listaCancionesRecaudacion = new ArrayList<>();
		
		while(sn.hasNext()) {
			listaCanciones.add(sn.nextLine());
		}
		
		for(int i=0; i<listaCanciones.size(); i++) {
			String cadena = listaCanciones.get(i);
			String[] parts = cadena.split("-"); 
			
			listaCancionesRecaudacion.add(new Cancion(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[2])*2));
		}
		
		return listaCancionesRecaudacion;
		
	}
	
	public static List<Artista> recibirArtistas(File artistas) throws IOException{
		
		Scanner sn = new Scanner(artistas);
		List<Artista> listaArtistas = new ArrayList<>();
		
		while(sn.hasNext()) {
			listaArtistas.add(new Artista(sn.nextLine()));
		}
		
		return listaArtistas;
		
	}

}
