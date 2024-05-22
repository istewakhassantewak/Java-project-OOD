package com.example;

public class Student extends User {
    private String id;
    private String name;
    private String className;
    private String section;

    public Student(String username, String password, String email) {
        super(username, password, email);
    }

  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
