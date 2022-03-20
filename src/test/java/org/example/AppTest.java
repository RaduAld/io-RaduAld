package org.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    ClassStudents classStd = new ClassStudents();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestAddYear()
    {
        boolean thrown = false;
        try{
            classStd.addStudent("Chris", "Matthew", LocalDate.of(2005,
                    Calendar.DECEMBER, 15), "male", "456623255");
        } catch (IllegalArgumentException i){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void TestAddName()
    {
        boolean thrown1 = false;
        boolean thrown2 = false;
        try {
            classStd.addStudent("", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "male", "456623255");
        } catch (IllegalArgumentException i){
            thrown1 = true;
        }
        assertTrue(thrown1);

        try {
            classStd.addStudent("Chris", "", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "male", "456623255");
        } catch (IllegalArgumentException i){
            thrown2 = true;
        }
        assertTrue(thrown2);
    }

    @Test
    public void TestAddGender()
    {
        boolean thrown1 = false;
        boolean thrown2 = false;
        boolean thrown3 = false;
        try {
            String response1 = classStd.addStudent("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255");
        } catch (IllegalArgumentException i){
            thrown1 = true;
        }
        assertFalse(thrown1);

        try {
            String response2 = classStd.addStudent("Christine", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "f", "456623255");
        } catch (IllegalArgumentException i){
            thrown2 = true;
        }
        assertFalse(thrown2);

        try {
            String response3 = classStd.addStudent("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "gender", "456623255");
        } catch (IllegalArgumentException i){
            thrown3 = true;
        }
        assertTrue(thrown3);
    }
}
