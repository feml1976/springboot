package com.msvc.spring.fml_web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.msvc.spring.fml_web.FmlWebApplication;
import com.msvc.spring.fml_web.models.dto.ParamDto;

/**
 * Controlador REST que maneja las solicitudes relacionadas con variables de ruta (Path Variables).
 * Proporciona endpoints para demostrar el uso de {@code @PathVariable} en Spring Boot.
 */
@RestController
@RequestMapping("/api/path-variable")
public class PathVariableController {

    private final FmlWebApplication fmlWebApplication;

    /**
     * Constructor de la clase {@code PathVariableController}.
     * Se inyecta {@code FmlWebApplication} a través del constructor (aunque no se utiliza en los métodos actuales,
     * se mantiene para la estructura de inyección de dependencias).
     *
     * @param fmlWebApplication Instancia de la aplicación principal.
     */
    public PathVariableController(FmlWebApplication fmlWebApplication) {
        this.fmlWebApplication = fmlWebApplication;
    }

    /**
     * Endpoint que recibe un mensaje como variable de ruta y lo retorna como una cadena.
     * Ejemplo de uso: {@code http://localhost:8090/api/path-variable/baz/hello}
     *
     * @param message El mensaje recibido como variable de ruta.
     * @return Una respuesta HTTP 200 OK con el mensaje.
     */
    @GetMapping("/baz/{message}")
    public ResponseEntity<String> baz(@PathVariable String message) {
        ParamDto paramDto = new ParamDto(message);
        return ResponseEntity.ok(paramDto.getMessage());
    }

    /**
     * Endpoint que recibe un mensaje como variable de ruta y lo retorna encapsulado en un {@link ParamDto}.
     * Ejemplo de uso: {@code http://localhost:8090/api/path-variable/bazs/hello}
     *
     * @param message El mensaje recibido como variable de ruta.
     * @return Una respuesta HTTP 200 OK con un objeto {@link ParamDto} conteniendo el mensaje.
     */
    @GetMapping("/bazs/{message}")
    public ResponseEntity<ParamDto> bazs(@PathVariable String message) {
        ParamDto paramDto = new ParamDto(message);
        return ResponseEntity.ok(paramDto);
    }

    /**
     * Endpoint que recibe un mensaje y un código como variables de ruta, y los retorna encapsulados en un {@link ParamDto}.
     * Spring Boot se encarga automáticamente de convertir el 'code' a Integer.
     * Ejemplo de uso: {@code http://localhost:8090/api/path-variable/bazsc/hello/9875}
     *
     * @param message El mensaje recibido como variable de ruta.
     * @param code El código recibido como variable de ruta, convertido automáticamente a {@code Integer}.
     * @return Una respuesta HTTP 200 OK con un objeto {@link ParamDto} conteniendo el mensaje y el código.
     */
    @GetMapping("/bazsc/{message}/{code}")
    public ResponseEntity<ParamDto> bazsc(@PathVariable String message, @PathVariable Integer code) {
        // Spring Boot automáticamente convierte 'code' a Integer.
        // Si la conversión falla, Spring lanzará una excepción MethodArgumentTypeMismatchException,
        // la cual puede ser manejada por un controlador de excepciones global si se desea.
        ParamDto paramDto = new ParamDto(message, code);
        return ResponseEntity.ok(paramDto);
    }
    // Resto de endpoints...
    /**
     * Endpoint que recibe un mensaje y un código como variables de ruta, y los retorna encapsulados en un {@link ParamDto}.
     * Ejemplo de uso: {@code http://localhost:8090/api/path-variable/bazscs/hello/9875}
     *
     * @param message El mensaje recibido como variable de ruta.
     * @param code El código recibido como variable de ruta, convertido automáticamente a {@code Integer}.
     * @return Una respuesta HTTP 200 OK con un objeto {@link ParamDto} conteniendo el mensaje y el código.
     */
    @GetMapping("/bazscs/{message}/{id}")
    public ResponseEntity<ParamDto> bazscs(@PathVariable String message, @PathVariable Long id) {
        // Spring Boot automáticamente convierte 'code' a Integer.
        // Si la conversión falla, Spring lanzará una excepción MethodArgumentTypeMismatchException,
        // la cual puede ser manejada por un controlador de excepciones global si se desea.
        ParamDto paramDto = new ParamDto(message, id);
        return ResponseEntity.ok(paramDto);
    }

}