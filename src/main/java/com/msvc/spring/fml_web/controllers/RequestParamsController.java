package com.msvc.spring.fml_web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.spring.fml_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/request-params")
public class RequestParamsController {
    @GetMapping("/bar")//http://localhost:8090/api/request-params/bar?param1=value1&param2=value2
    public ResponseEntity<Map<String, String>> getRequestParams(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(params);
    }
    @GetMapping("/foo")//http://localhost:8090/api/request-params/foo?param=mensaje
    public ParamDto foo(@RequestParam(value = "param", required = false, defaultValue = "mensaje por default", name = "param") String message) {
        // Here you can use the 'param' value as needed
        ParamDto paramDto = new ParamDto(message);
        return paramDto;
    }

    @GetMapping("/fooTwo")//http://localhost:8090/api/request-params/fooTwo?text=mensaje&code=1234
    public ResponseEntity<ParamDto> fooTwo(@RequestParam(value = "text", required = false, defaultValue = "mensaje por default", name = "text") String text,
                                            @RequestParam(value = "code", required = false, defaultValue = "-321", name = "code") Integer code) {
        // Here you can use the 'param' value as needed
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return ResponseEntity.ok(paramDto);
    }

    @GetMapping("/fooThree")//http://localhost:8090/api/request-params/fooThree?text=mensaje&code=1234
    public ResponseEntity<ParamDto> fooThree(HttpServletRequest request){
        // Here you can use the 'param' value as needed
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(request.getParameter("text"));
        var code = 0;
        if (request.getParameter("code") != null && !request.getParameter("code").isEmpty()) {
            try {  
                    code = Integer.parseInt(request.getParameter("code"));  
                } 
            catch (NumberFormatException e) {  
                    code = -1;  
                }  
        } else {  
            code = -1; // También asignar -1 si el parámetro es null o vacío  
        }  
        paramDto.setCode(code);
        return ResponseEntity.ok(paramDto);
    }
}
