package spring;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectoLog {
	
	@Before("execution(* generaArchivo())")
	public void log() {
		System.out.println("Se está generando el archivo...");
	}
	
	@Before("execution(* cargaArchivo(*))")
	public void log2() {
		System.out.println("Validando si es correcto el archivo recibido...");
	}
	
	@After("execution(* generaArchivo())")
	public void log3() {
		System.out.println("Archivo generado con éxito\n");
	}

}
