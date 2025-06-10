package com.msvc.spring.fml_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/properties-variables")
public class PropertiesVariablesController {
    private final String applicationName;
    private final String version;

    @Value("${parameters.username:defaultUsername}")
    private String username;

    @Value("${parameters.message:defaultMessage}")
    private String message;

    @Value("${parameters.password:defaultPassword}")
    private String password;

    @Value("${parameters.listOfValues:defaultList}")
    private String[] listOfValues;
    
    @Value("${parameters.code:0}")
    private Integer code;

    @Value("${seed.parameters.listOfValuesOficinas:defaultList}")
    private List<String> listOfValuesOficinas;


    @Value("#{${seed.parameters.valuesMap}}")
    private Map<String, Object> valuesMap;

    public PropertiesVariablesController(@Value("${parameters.name}") String applicationName,
                                         @Value("${parameters.version}") String version) {
        this.applicationName = applicationName;
        this.version = version;
    }

    @GetMapping("/getvalues")//http://localhost:8090/api/properties-variables/getvalues
    public Map<String, Object> getValues(@RequestParam(required = false, defaultValue = "default") String param) {
        // Puedes usar el valor de 'param' según sea necesario
        return values(param);
    }

    private Map<String, Object> values(String param) {
        Map<String, Object> response = new HashMap<>();
        response.put("applicationName", applicationName);
        response.put("version", version);
        response.put("username", username);
        response.put("message", message);
        response.put("password", password);
        response.put("listOfValues", listOfValues);
        response.put("code", code);
        response.put("listOfValuesOficinas", listOfValuesOficinas);
        response.put("valuesMap", valuesMap);
        response.put("param", param);
        return response;
    }

    @GetMapping("/getconfiguration")//http://localhost:8090/api/properties-variables/getconfiguration
    public Map<String, Object> getConfiguration(@Value("${configuration.username:defaultUsername}") String username,
                                                @Value("${configuration.message:defaultMessage}") String message,
                                                @Value("${configuration.password:defaultPassword}") String password,
                                                @Value("${configuration.listOfValues:defaultList}") String[] listOfValues,
                                                @Value("${seed.parameters.listOfValuesOficinas:defaultList}") List<String> listOfValuesOficinas,
                                                @Value("#{${seed.parameters.valuesMap}}") Map<String, Object> valuesMap,
                                                @Value("${configuration.code:0}") Integer code, String param) {
        return valuesConfiguration(
                username, message, password, listOfValues, code, listOfValuesOficinas, valuesMap,"defaultParam");
    }

    private Map<String, Object> valuesConfiguration(String username,
                                                    String message,
                                                    String password,
                                                    String[] listOfValues,
                                                    Integer code,
                                                    List<String> listOfValuesOficinas,
                                                    Map<String, Object> valuesMap,
                                                    String param) {
        Map<String, Object> response = new HashMap<>();
        response.put("applicationName", applicationName);
        response.put("version", version);
        response.put("username", username);
        response.put("message", message);
        response.put("password", password);
        response.put("listOfValues", listOfValues);
        response.put("code", code);
        response.put("listOfValuesOficinas", listOfValuesOficinas);
        response.put("valuesMap", valuesMap);
        response.put("param", param);
        return response;
    }
}
