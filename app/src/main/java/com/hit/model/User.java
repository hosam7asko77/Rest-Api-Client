package com.hit.model;

public class User {
    private Integer id;
    private  String name;
    private String course;
    private String email;
    private String password;
    private Integer age;

    public User(Integer id, String name, String course, String email, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }
}
