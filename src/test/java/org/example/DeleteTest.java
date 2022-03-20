package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Unit test for simple App.
 */
public class DeleteTest
{
    ClassStudents classStd = new ClassStudents();

    @Test
    public void TestDelete()
    {
        boolean thrown = false;
        try {
            classStd.addStudent("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "Male", "456623255");

            classStd.addStudent("Christine", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "f", "888885548");

            classStd.addStudent("Chris", "Matthew", LocalDate.of(2002,
                    Calendar.DECEMBER, 15), "gender", "484522479");

            assertEquals(classStd.deleteById("888885548"), "Successful delete of Christine Matthew");
        } catch (IllegalArgumentException i){
            thrown = true;
        }
        assertTrue(thrown);
    }
}
