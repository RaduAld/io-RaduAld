package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ClassStudents classStd = new ClassStudents();
        Logger logger = Logger.getLogger("Student.java");

        ArrayList<String> responses = new ArrayList<>();
        classStd.addStudent("Lana", "DelRey",
                LocalDate.of(2001, Calendar.DECEMBER, 15),
                "FEMALE", "456623255");
        classStd.addStudent("Michael", "Santos",
                LocalDate.of(1950, Calendar.FEBRUARY, 9),
                "Male", "5844558");
        classStd.addStudent("Suzie", "Fletcher",
                LocalDate.of(1986, Calendar.APRIL, 28),
                "female", "9999999999999");
        classStd.addStudent("John", "Lennon",
                LocalDate.of(1932, Calendar.MARCH, 21),
                "MAlE", "7896254");
        classStd.addStudent("Marie", "Curie",
                LocalDate.of(1968, Calendar.AUGUST, 3),
                "female", "874599487");

        String delete = classStd.deleteById("9999999999999");
        System.out.println(delete);

        ArrayList<Student> studentsByAge = classStd.retrieveByAge(20);
        if (studentsByAge.isEmpty()){
            logger.log(Level.WARNING, "No one has that age");
        } else {
            for (Student student : studentsByAge){
                System.out.println(student);
            }
        }

        System.out.println();
        for (Student student : classStd.listStudents("name")){
            System.out.println(student);
        }
    }


}
