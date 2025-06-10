package com.msvc.spring.fml_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot.
 * Esta clase utiliza la anotación {@code @SpringBootApplication} para
 * habilitar la configuración automática de Spring Boot, el escaneo de componentes
 * y la configuración de beans.
 */
@SpringBootApplication
/*@PropertySources({
	@PropertySource("classpath:parameters.properties"),
	@PropertySource("classpath:configuration.properties")
})*/

public class FmlWebApplication {

	/**
	 * Método principal que sirve como punto de entrada de la aplicación.
	 * Utiliza {@link SpringApplication#run(Class, String...)} para arrancar
	 * la aplicación Spring.
	 *
	 * @param args Argumentos de línea de comandos pasados a la aplicación.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FmlWebApplication.class, args);
	}

}