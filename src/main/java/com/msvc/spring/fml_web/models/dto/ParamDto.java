package com.msvc.spring.fml_web.models.dto;

/**
 * Clase DTO (Data Transfer Object) para encapsular parámetros de mensaje y código.
 * Utilizada para transferir datos entre las capas de la aplicación.
 */
public class ParamDto {
    /**
     * Mensaje asociado al DTO.
     */
    private String message;
    /**
     * Código numérico asociado al DTO.
     */
    private Integer code;

    private long id;
    /**
     * Constructor por defecto de {@code ParamDto}.
     */
    public ParamDto() {
        // Default constructor
    }

    /**
     * Constructor de {@code ParamDto} que inicializa solo el mensaje.
     * @param message El mensaje a establecer.
     */
    public ParamDto(String message) {
        this.message = message;
    }

    /**
     * Constructor de {@code ParamDto} que inicializa el mensaje y el código.
     * @param message El mensaje a establecer.
     * @param code El código a establecer.
     */
    public ParamDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     * Constructor de {@code ParamDto} que inicializa el mensaje y el código.
     * @param message El mensaje a establecer.
     * @param code El código a establecer.
     */
    public ParamDto(String message, Long id) {
        this.message = message;
        this.id = id;
    }

    /**
     * Constructor de {@code ParamDto} que inicializa el mensaje, el código y el id.
     * @param message El mensaje a establecer.
     * @param code El código a establecer.
     * @param id El id a establecer.
     */
    public ParamDto(String message, Integer code, long id) {
        this.message = message;
        this.code = code;
        this.id = id;
    }

    /**
     * Obtiene el mensaje del DTO.
     * @return El mensaje.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje del DTO.
     * @param message El mensaje a establecer.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene el código del DTO.
     * @return El código.
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Establece el código del DTO.
     * @param code El código a establecer.
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Obtiene el id del DTO.
     * @return El id.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece el id del DTO.
     * @param id El id a establecer.
     */
    public void setId(long id) {
        this.id = id;
    }
}