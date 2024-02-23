package com.junior.studentRegistrationService.domain;

import io.micrometer.common.util.StringUtils;

public class Student {

    private Long id;
    private String name;
    private Email email;
    private String address;
    private Course course;

    public Student(String name, Email email, String address, Course course) {

        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name can't be blank!");

        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address can't be blank!");

        if (email == null)
            throw new IllegalArgumentException("Invalid e-mail address!");

        if (course == null)
            throw new IllegalArgumentException("You must fill course!");


        this.name = name;
        this.email =email;
        this.address =address;
        this.course =course;
}

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Course getCourse() {
        return course;
    }

}