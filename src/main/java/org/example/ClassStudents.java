package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassStudents {

    private ArrayList<Student> students = new ArrayList<>();

    public String addStudent(String firstName, String lastName, Date dateOfBirth, String gender, long id) {

        Date min = new Date(1900, Calendar.JANUARY, 1);
        int currentYear = new Date().getYear() + 1900;
        Date min1 = new Date(currentYear - 18, Calendar.JANUARY, 1);
        if (dateOfBirth.before(min) || dateOfBirth.after(min1)) {
            return "Invalid year.";
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            return "Invalid first or last name.";
        } else if (!(gender.toLowerCase(Locale.ROOT).equals("m") ||
                gender.toLowerCase(Locale.ROOT).equals("f") ||
                gender.toLowerCase(Locale.ROOT).equals("male") ||
                gender.toLowerCase(Locale.ROOT).equals("female"))) {
            return "Invalid gender.";
        }
        try{
            Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
            students.add(student);
        } catch (Exception e) {
            Logger logger = Logger.getLogger("ClassStudents.java");
            logger.log(Level.SEVERE, "Error during Student creation", e);
        }
        return "ok";
    }

    public String deleteById(int id){
        for (Student s : students){
            if (s.getId() == id){
                students.remove(s);
                break;
            }
        }
        return "ok";
    }
}
