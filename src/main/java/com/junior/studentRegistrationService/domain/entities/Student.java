package com.junior.studentRegistrationService.domain.entities;

import com.junior.studentRegistrationService.domain.enums.Course;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public class Student {

    private Long id;
    private String name;
    private Email email;
    private String address;
    private Course course;

    public Student(String name, Email email, String address, Course course) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.course = course;
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