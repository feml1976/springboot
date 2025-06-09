package com.msvc.spring.fml_web.models.dto;

import com.msvc.spring.fml_web.models.User;

public class UserDto {
    private String title;
    private User user;
    private String name;
    private String lastname;
    private String fullName;
    private String email;

    public UserDto() {
        // Default constructor
    }
    public UserDto(String title, User user) {
        this.title = title;
        this.user = user;
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.fullName = user.getName() + " " + user.getLastname();
        this.email = user.getEmail();
    }

    public UserDto(String title, String name, String lastname, String email) {
        this.title = title;
        this.name = name;
        this.lastname = lastname;
        this.fullName = name + " " + lastname;
        this.email = email;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "title='" + title + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
