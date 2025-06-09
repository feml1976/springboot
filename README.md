# fml-web

Este proyecto es una aplicación Spring Boot de demostración que ilustra el uso de Path Variables en controladores REST.

## Tecnologías Utilizadas

* **Spring Boot**: Framework principal para el desarrollo de la aplicación.
* **Java 21**: Versión del JDK utilizada.
* **Maven**: Herramienta de gestión de proyectos y dependencias.
* **Spring Boot Starter Web**: Para construir aplicaciones web, incluyendo RESTful.
* **Spring Boot Starter Thymeleaf**: Para la construcción de interfaces de usuario (aunque no se usa explícitamente en los controladores REST, está presente en el `pom.xml`).
* **Spring Boot DevTools**: Para proporcionar reinicios rápidos de la aplicación, recarga en vivo y otras mejoras de desarrollo.

## Estructura del Proyecto

El proyecto sigue una estructura típica de aplicaciones Spring Boot:

* `src/main/java/com/msvc/spring/fml_web/`: Contiene el código fuente de la aplicación.
    * `FmlWebApplication.java`: Clase principal que arranca la aplicación Spring Boot.
    * `controllers/PathVariableController.java`: Controlador REST que maneja los endpoints relacionados con Path Variables.
    * `models/dto/ParamDto.java`: Clase DTO (Data Transfer Object) utilizada para encapsular datos.
* `src/main/resources/`: Contiene recursos de la aplicación.
    * `application.properties`: Archivo de configuración de la aplicación (nombre de la aplicación, puerto del servidor).
* `pom.xml`: Archivo de configuración de Maven, donde se declaran las dependencias y la configuración de construcción.

## Configuración

* **Puerto del Servidor**: La aplicación está configurada para ejecutarse en el puerto `8090`. Esto se define en `src/main/resources/application.properties` con la propiedad `server.port=8090`.
* **Nombre de la Aplicación**: El nombre de la aplicación es `fml-web`, configurado en `spring.application.name=fml-web` en `application.properties`.

## Endpoints

El controlador `PathVariableController` expone los siguientes endpoints bajo la ruta base `/api/path-variable`:

* **GET /api/path-variable/baz/{message}**
    * **Descripción**: Recibe un mensaje como variable de ruta y lo devuelve como una cadena de texto.
    * **Ejemplo**: `http://localhost:8090/api/path-variable/baz/hello`
    * **Respuesta de Ejemplo**: `hello`

* **GET /api/path-variable/bazs/{message}**
    * **Descripción**: Recibe un mensaje como variable de ruta y lo devuelve encapsulado en un objeto `ParamDto`.
    * **Ejemplo**: `http://localhost:8090/api/path-variable/bazs/world`
    * **Respuesta de Ejemplo**:
        ```json
        {
            "message": "world",
            "code": null
        }
        ```

* **GET /api/path-variable/bazsc/{message}/{code}**
    * **Descripción**: Recibe un mensaje y un código (entero) como variables de ruta, y los devuelve encapsulados en un objeto `ParamDto`. Spring Boot maneja automáticamente la conversión del código a `Integer`.
    * **Ejemplo**: `http://localhost:8090/api/path-variable/bazsc/test/12345`
    * **Respuesta de Ejemplo**:
        ```json
        {
            "message": "test",
            "code": 12345
        }
        ```

## Cómo Ejecutar la Aplicación

1.  **Clonar el repositorio** (si aplica) o asegúrate de tener el código fuente.
2.  **Navegar al directorio raíz del proyecto** (`fml-web`).
3.  **Compilar y ejecutar la aplicación** usando Maven:
    ```bash
    mvn spring-boot:run
    ```
    Alternativamente, puedes construir un JAR ejecutable y luego ejecutarlo:
    ```bash
    mvn clean install
    java -jar target/fml-web-0.0.1-SNAPSHOT.jar
    ```

Una vez que la aplicación esté en funcionamiento, podrás acceder a los endpoints a través de tu navegador o una herramienta como Postman/cURL.