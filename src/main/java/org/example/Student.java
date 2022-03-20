package org.example;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private long id;

    public long getId() {
        return id;
    }

    Student(String firstName, String lastName, Date dateOfBirth, String gender, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public void deleteStudent() {
    }

    public void retrieveByAge() {
    }

    public void listStudents() {
    }
}
