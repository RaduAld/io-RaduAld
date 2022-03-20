package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class RetrieveTest
{
    ClassStudents classStd = new ClassStudents();

    @Test
    public void TestRetrieve()
    {
        boolean thrown = false;
        try {
            Student chris = new Student("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255");
            ArrayList<Student> students = new ArrayList<>();
            students.add(chris);

            classStd.addStudent("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255");

            classStd.addStudent("Christine", "Matthew", LocalDate.of(1960,
                    Calendar.DECEMBER, 15), "f", "888885548");

            classStd.addStudent("Chris", "Matthew", LocalDate.of(1980,
                    Calendar.DECEMBER, 15), "gender", "484522479");

            assertEquals(classStd.retrieveByAge(20), students);
            classStd.retrieveByAge(18);
        } catch (IllegalArgumentException i){
            thrown = true;
        }
        assertTrue(thrown);
    }
}
