package com.msvc.spring.fml_web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.spring.fml_web.models.User;
import com.msvc.spring.fml_web.models.dto.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@RestController// The @RestController annotation is a convenience annotation that combines @Controller and @ResponseBody
// It indicates that the class is a controller where every method returns a domain object instead of a view
//@RequestMapping("/api") // This annotation maps HTTP requests to handler methods of MVC and REST controllers
public class UserRestController {
    // This class will handle user-related requests
    // For example, methods for creating, updating, deleting users, etc.

    // You can use annotations like @GetMapping, @PostMapping, etc. to define request mappings
    // Example method to handle a GET request   
    // You can define request mappings here to handle HTTP requests
    // Example method to handle a request
    @GetMapping("api/detailsRest")//http://localhost:8090/api/detailsRest
    // This method will be invoked when a GET request is made to the specified path
    public Map<String, Object> details(){
        User entity = new User("Francisco Emilio", "Montoya Lopez");
        Map<String, Object> model = new HashMap<>();
        model.put("title", "User Details with Model");
        model.put("method", "detailsRest");
        model.put("description", "This is the user details page with a model.");
        model.put("name", entity.getName());
        model.put("lastname", entity.getLastname());        
        model.put("user", entity); 

        return model;
    }

        @GetMapping("api/detailsRestModel")//http://localhost:8090/api/detailsRestModel
    // This method will be invoked when a GET request is made to the specified path
    public Map<String, Object> detailsModel(){
        // The Model object is used to pass data to the
        Map<String, Object> model = new HashMap<>();
        model.put("title", "User Details with Model");
        model.put("method", "detailsRestModel");
        model.put("description", "This is the user details page with a model.");
        model.put("name", "Francisco");
        model.put("lastname", "Montoya");
        
        return model;
    }

    @GetMapping(path="api/detailsRequestModels")//http://localhost:8090/api/detailsRequestModel
    public Map<String, Object> detailsRequestModels(){
        // The Model object is used to pass data to the
        Map<String, Object> model = new HashMap<>();
        
        model.put("title", "User Details with Model");
        model.put("method", "detailsRequestModels");
        model.put("description", "This is the user details page with a model.");
        model.put("name", "Francisco");
        model.put("lastname", "Montoya");
        
        return model;
    }


    // Additional methods can be added as needed

    @GetMapping("api/detailsRestMap")//http://localhost:8090/api/detailsRest
    // This method will be invoked when a GET request is made to the specified path
    public UserDto detailsMap(){
        UserDto model = new UserDto();
        model.setTitle("User Details with Model");
        User entity = new User("Francisco Emilio", "Montoya Lopez");
        model.setUser(entity);
        return model;
    }

    @GetMapping("api/getUsers")//http://localhost:8090/api/getUsers
    // This method will be invoked when a GET request is made to the specified path
    public List<UserDto> getUsers() {
        // This method can be used to retrieve a list of users
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("Esposa", new User("Alejandra", "jimenez")));
        users.add(new UserDto("Mascota", new User("Rocky", "Montoya")));
        users.add(new UserDto("Hermano", new User("Cristian", "Montoya")));
        users.add(new UserDto("Hermano", new User("Jose", "Montoya")));
        users.add(new UserDto("Madre", new User("Alba", "Lopez")));
        users.add(new UserDto("Padre", new User("Jose", "Montoya")));
        return users;
    }

}
