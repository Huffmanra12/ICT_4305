package ict4305.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MyDateTest {

    @Test
    void testDefaultConstructor() {
        MyDate d = new MyDate();
        assertEquals(1, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(1970, d.getYear());
    }
    @Test
    void testDayMonthYearConstructor() {
        MyDate d = new MyDate(25, 1, 2026);
        assertEquals(25, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(2026, d.getYear());
    }
    @Test
    void testCopyConstructor() {
        MyDate d = new MyDate(25, 1, 2026);
        MyDate c = new MyDate(d);

        assertEquals(25, c.getDay());
        assertEquals(1, c.getMonth());
        assertEquals(2026, c.getYear());
    }
    @Test
    void testIsLeapYear() {
        MyDate d = new MyDate(29, 2, 2028);

        assertEquals(29, d.getDay());
        assertEquals(2, d.getMonth());
        assertEquals(2028, d.getYear());
    }
    @Test
    void testIsNotLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> new MyDate(29, 2, 2026));
    }
    @Test
    void testGetLastDayOfMonthLeap() {

        assertEquals(29, MyDate.getLastDayOfMonth(2, 2028));
    }
    @Test
    void testGetLastDayOfMonth30() {

        assertEquals(31, MyDate.getLastDayOfMonth(5, 2026));
    }
    @Test
    void testGetLastDayOfMonth31() {

        assertEquals(30, MyDate.getLastDayOfMonth(4, 2026));
    }
    @Test
    void testGetLastDayOfMonthInvalid() {

        assertThrows(IllegalArgumentException.class, () -> MyDate.getLastDayOfMonth(13, 2026));
    }
    @Test
    void testInvalidDay() {

        assertThrows(IllegalArgumentException.class, () -> MyDate.validateDate(32, 1, 2026));

    }
    @Test
    void testInvalidMonth() {

        assertThrows(IllegalArgumentException.class, () -> MyDate.validateDate(31, 13, 2026));
    }
    @Test
    void testInvalidYear() {

        assertThrows(IllegalArgumentException.class, () -> MyDate.validateDate(31, 1, -1));

    }
    @Test
    void testCopyConstructNull() {

        assertThrows(IllegalArgumentException.class, () -> new MyDate(null));
    }
}
