package com.msvc.spring.fml_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.msvc.spring.fml_web.models.User;
import com.msvc.spring.fml_web.models.dto.UserDto;


@Controller
public class UserController {
    // This class will handle user-related requests
    // For example, methods for creating, updating, deleting users, etc.

    // You can use annotations like @GetMapping, @PostMapping, etc. to define request mappings
    // Example method to handle a GET request   
    // You can define request mappings here to handle HTTP requests
    // Example method to handle a request
    @GetMapping("path/details")//http://localhost:8090/path/details
    // This method will be invoked when a GET request is made to the specified path
    public String details(Model model){
        // The Model object is used to pass data to the view
        User entity = new User("Francisco Emilio", "Montoya Lopez");
        model.addAttribute("title", "User Details with Model");
        model.addAttribute("method", "detailsModel");
        model.addAttribute("description", "This is the user details page with a model.");
        model.addAttribute("name", entity.getName());
        // Add additional attributes to the model
        model.addAttribute("lastname", entity.getLastname());
        // The view name is returned as a string, which will be resolved by the view resolver
        model.addAttribute("user", entity); // Add the user object to the model
        // This allows the view to access the user details
        // and display them in the rendered view
        return "details"; // This returns the name of the view to be rendered
    }

    @GetMapping("path/detailsModel")//http://localhost:8090/path/detailsModel
    // This method will be invoked when a GET request is made to the specified path
    public String detailsModel(Model model){
        model.addAttribute("title", "User Details with Model");
        model.addAttribute("method", "detailsModel");
        model.addAttribute("description", "This is the user details page with a model.");
        model.addAttribute("name", "Francisco");
        model.addAttribute("lastname", "Montoya");
        
        return "detailsModel";
    }


    // Additional methods can be added as needed

    @GetMapping("path/detailsModelDto")//http://localhost:8090/path/detailsModelDto
    // This method will be invoked when a GET request is made to the specified path
    public String detailsModelDto(Model model){
        // The Model object is used to pass data to the view
        User entity = new User("Emilio", "Montoya", "francisco@example.com");
        //entity.setName("Aristobulo");
        //entity.setLastname("Jaramillo");
        entity.setEmail("francisco@transer.com.co");
        model.addAttribute("title", "User Details with Model Dto");
        model.addAttribute("method", "detailsModel");
        model.addAttribute("description", "This is the user details page with a model.");
        model.addAttribute("name", entity.getName());
        // Add additional attributes to the model
        model.addAttribute("lastname", entity.getLastname());
        // The view name is returned as a string, which will be resolved by the view resolver
        model.addAttribute("email", entity.getEmail());
        model.addAttribute("user", entity); // Add the user object to the model
        // This allows the view to access the user details
        // and display them in the rendered view
        return "detailsDto"; // This returns the name of the view to be rendered
    }

    
    @GetMapping("path/listUsers")//http://localhost:8090/path/listUsers    
    public String getListUsers(ModelMap model) {   
        // This method can be used to retrieve a list of users
        /*List<UserDto> entityDtos = new ArrayList<>();
        entityDtos.add(new UserDto("Esposa", "Alejandra", "jimenez", "alejandra.jimenez@example.com"));
        entityDtos.add(new UserDto("Mascota", "Rocky", "Montoya", "rocky.montoya@example.com"));
        entityDtos.add(new UserDto("Hermano", "Cristian", "Montoya", "cristian.montoya@example.com"));
        entityDtos.add(new UserDto("Hermano", "Jose", "Montoya", "jose.montoya@example.com"));
        entityDtos.add(new UserDto("Madre", "Alba", "Lopez", "alba.lopez@example.com"));
        entityDtos.add(new UserDto("Padre", "Jose", "Montoya", "jose.montoya@example.com"));
        
        // Add the list of users to the model
        
        model.addAttribute("users", entityDtos);
        */
        model.addAttribute("title", "List of Users");    
        model.addAttribute("description", "list of users to the model");
        return "listUsers"; // This returns the name of the view to be rendered
    }

    @GetMapping("path/listUsersOld")//http://localhost:8090/path/listUsers    
    public String getListUsersOld(ModelMap model) {   
        // This method can be used to retrieve a list of users
        List<UserDto> entityDtos = new ArrayList<>();
        entityDtos.add(new UserDto("Esposa", new User("Alejandra", "jimenez", "alejandra.jimenez@example.com")));
        entityDtos.add(new UserDto("Mascota", new User("Rocky", "Montoya", "rocky.montoya@example.com")));
        entityDtos.add(new UserDto("Hermano", new User("Cristian", "Montoya", "cristian.montoya@example.com")));
        entityDtos.add(new UserDto("Hermano", new User("Jose", "Montoya", "jose.montoya@example.com")));
        entityDtos.add(new UserDto("Madre", new User("Alba", "Lopez", "alba.lopez@example.com")));
        entityDtos.add(new UserDto("Padre", new User("Jose", "Montoya", "jose.montoya@example.com")));
        
        // Add the list of users to the model
        
        model.addAttribute("users", entityDtos);
        model.addAttribute("title", "List of Users");    
        model.addAttribute("description", "list of users to the model");
        return "listUsers"; // This returns the name of the view to be rendered
    }

    @ModelAttribute("users")
    public List<UserDto> usersModelsList() {
        return Arrays.asList(
            new UserDto("Esposa", "Alejandra", "jimenez", "alejandra.jimenez@example.com"),
            new UserDto("Mascota", "Rocky", "Montoya", "rocky.montoya@example.com"),
            new UserDto("Hermano", "Cristian", "Montoya", "cristian.montoya@example.com"),
            new UserDto("Hermano", "Jose", "Montoya", "jose.montoya@example.com"),
            new UserDto("Madre", "Alba", "Lopez", "alba.lopez@example.com"),
            new UserDto("Padre", "Jose", "Montoya", "jose.montoya@example.com")
        );
        /*List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("Esposa", "Alejandra", "jimenez", "alejandra.jimenez@example.com"));
        users.add(new UserDto("Mascota", "Rocky", "Montoya", "rocky.montoya@example.com"));
        users.add(new UserDto("Hermano", "Cristian", "Montoya", "cristian.montoya@example.com"));
        users.add(new UserDto("Hermano", "Jose", "Montoya", "jose.montoya@example.com"));
        users.add(new UserDto("Madre", "Alba", "Lopez", "alba.lopez@example.com"));
        users.add(new UserDto("Padre", "Jose", "Montoya", "jose.montoya@example.com"));
        return users;*/
    }

    @GetMapping("/listUsers")//http://localhost:8090/path/listUsers    
    public String listUsers(ModelMap model) {   
        // This method can be used to retrieve a list of users
        /*List<UserDto> entityDtos = new ArrayList<>();
        entityDtos.add(new UserDto("Esposa", "Alejandra", "jimenez", "alejandra.jimenez@example.com"));
        entityDtos.add(new UserDto("Mascota", "Rocky", "Montoya", "rocky.montoya@example.com"));
        entityDtos.add(new UserDto("Hermano", "Cristian", "Montoya", "cristian.montoya@example.com"));
        entityDtos.add(new UserDto("Hermano", "Jose", "Montoya", "jose.montoya@example.com"));
        entityDtos.add(new UserDto("Madre", "Alba", "Lopez", "alba.lopez@example.com"));
        entityDtos.add(new UserDto("Padre", "Jose", "Montoya", "jose.montoya@example.com"));
        
        // Add the list of users to the model
        
        model.addAttribute("users", entityDtos);
        */
        model.addAttribute("title", "List of Users");    
        model.addAttribute("description", "list of users to the model");
        return "listUsers"; // This returns the name of the view to be rendered
    }
}
