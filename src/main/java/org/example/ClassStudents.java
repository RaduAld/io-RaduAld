package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassStudents {

    private ArrayList<Student> students = new ArrayList<>();

    public String addStudent(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {

        LocalDate min1 = LocalDate.of(1900, 1, 1);
        LocalDate currentYear = LocalDate.now();
        LocalDate min2 = LocalDate.of(currentYear.getYear() - 18, 1, 1);
        if (dateOfBirth.isBefore(min1) || dateOfBirth.isAfter(min2)) {
            throw new IllegalArgumentException("Invalid year.");
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid first or last name.");
        } else if (!(gender.toLowerCase(Locale.ROOT).equals("m") ||
                gender.toLowerCase(Locale.ROOT).equals("f") ||
                gender.toLowerCase(Locale.ROOT).equals("male") ||
                gender.toLowerCase(Locale.ROOT).equals("female"))) {
            throw new IllegalArgumentException("Invalid gender.");
        }
        try {
            Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
            students.add(student);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error during Student creation");
        }
        return "ok";
    }

    public String deleteById(String id) {
        if (!(id.matches("[0-9]+"))){
            throw new IllegalArgumentException("Invalid id!");
        }
        String name = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                name = s.getFirstName() + ' ' + s.getLastName();
                break;
            }
        }
        if (name == null) {
            throw new IllegalArgumentException("Invalid id!");
        }
        return "Successful delete of " + name;
    }

    public ArrayList<Student> retrieveByAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Invalid age!");
        }
        ArrayList<Student> studentsByAge = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

    public ArrayList<Student> listStudents(String option) {
        switch (option){
            case "birth" :
                this.students.sort(Comparator.comparing(Student::getDateOfBirth));
                break;
            case "name":
                this.students.sort(Comparator.comparing(Student::getLastName));
                break;
            default:
                throw new IllegalArgumentException("Invalid list option!");
        }
        return students;
    }
}
