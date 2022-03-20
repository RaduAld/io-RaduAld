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
public class ListTest
{
    ClassStudents classStd = new ClassStudents();

    @Test
    public void TestDeleteLogGender()
    {
        boolean thrown = false;
        try {
            classStd.addStudent("Christine", "Bangi", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "f", "888885548");

            classStd.addStudent("Chris", "Charles", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "gender", "484522479");

            classStd.addStudent("Chris", "Ander", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255");

            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student("Chris", "Ander", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255"));
            students.add(new Student("Christine", "Bangi", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "f", "888885548"));
            students.add(new Student("Chris", "Ander", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255"));
            assertEquals(classStd.listStudents("name"), students);
            classStd.listStudents("asdddd");
        } catch (IllegalArgumentException i){
            thrown = true;
        }
        assertTrue(thrown);
    }
}
