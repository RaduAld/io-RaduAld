package org.example;

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

        ArrayList<String> responses = new ArrayList<>();
        responses.add(classStd.addStudent("Lana", "DelRey",
                new Date(2001, Calendar.DECEMBER, 15),
                "FEMALE", 456623255));
        responses.add(classStd.addStudent("Michael", "Santos",
                new Date(1950, Calendar.FEBRUARY, 9),
                "Male", 5844558));
        responses.add(classStd.addStudent("Suzie", "Fletcher",
                new Date(1986, Calendar.APRIL, 28),
                "female", 999999999));
        for (String response : responses){
            if (!response.equals("ok")){
                Logger logger = Logger.getLogger("Student.java");
                logger.log(Level.WARNING, response);
            } else {
                System.out.println("Successful!");
            }
        }
    }


}
