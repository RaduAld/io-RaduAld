package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void TestAddLogYear()
    {
        String response = classStd.addStudent("Chris", "Matthew", new Date(2005,
                        Calendar.DECEMBER, 15), "male", 456623255);
        assertEquals( response,  "Invalid year.");
    }

    @Test
    public void TestAddLogName()
    {
        String response1 = classStd.addStudent("", "Matthew", new Date(2002,
                Calendar.DECEMBER, 15), "male", 456623255);
        assertEquals( response1,  "Invalid first or last name.");
        String response2 = classStd.addStudent("Chris", "", new Date(2002,
                Calendar.DECEMBER, 15), "male", 456623255);
        assertEquals( response2,  "Invalid first or last name.");
    }

    @Test
    public void TestAddLogGender()
    {
        String response1 = classStd.addStudent("Chris", "Matthew", new Date(2002,
                Calendar.DECEMBER, 15), "Male", 456623255);
        assertEquals( response1,  "ok");


        String response2 = classStd.addStudent("Christine", "Matthew", new Date(2002,
                Calendar.DECEMBER, 15), "f", 456623255);
        assertEquals( response2,  "ok");

        String response3 = classStd.addStudent("Chris", "Matthew", new Date(2002,
                Calendar.DECEMBER, 15), "gender", 456623255);
        assertEquals( response3,  "Invalid gender.");
    }
}
