package com.msvc.spring.fml_web.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.spring.fml_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/request-params")
public class RequestParamsController {
    @GetMapping("/bar")//http://localhost:8090/api/request-params/bar?param1=value1&param2=value2
    public ResponseEntity<Map<String, String>> getRequestParams(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(params);
    }
    @GetMapping("/foo")//http://localhost:8090/api/request-params/foo?param=mesanje
    public ParamDto foo(@RequestParam(value = "param", required = false, defaultValue = "mesanje por default") String message) {
        // Here you can use the 'param' value as needed
        ParamDto paramDto = new ParamDto(message);
        return paramDto;
    }
}
