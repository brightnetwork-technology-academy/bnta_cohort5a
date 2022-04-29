package org.example._2_basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {
    private static Class<?> clazz;
    private static final String MONTH_CLASS = "org.example._2_basic.Month";
    private static final String JANUARY = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.JANUARY";
    private static final String FEBRUARY = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.FEBRUARY";
    private static final String MARCH = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.MARCH";
    private static final String APRIL = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.APRIL";
    private static final String MAY = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.MAY";
    private static final String JUNE = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.JUNE";
    private static final String JULY = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.JULY";
    private static final String AUGUST = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.AUGUST";
    private static final String SEPTEMBER = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.SEPTEMBER";
    private static final String OCTOBER = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.OCTOBER";
    private static final String NOVEMBER = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.NOVEMBER";
    private static final String DECEMBER = "public static final org.example._2_basic.Month " +
            "org.example._2_basic.Month.DECEMBER";

    @BeforeAll
    static void checkIfMonthExist() {
        try {
            clazz = Class.forName(MONTH_CLASS);
        } catch (ClassNotFoundException e) {
            fail(MONTH_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("Month should be an enum")
    void checkIfEnum() {
        assertTrue(clazz.isEnum());
    }

    @Test
    @DisplayName("Month should have 12 declared constants: JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        // expected = 13 = 12 declared fields + an extra field: $VALUES
        assertEquals(13, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(JANUARY) || field.toString().equals(FEBRUARY) || field.toString().equals(MARCH)
             || field.toString().equals(APRIL) || field.toString().equals(MAY) || field.toString().equals(JUNE)
             || field.toString().equals(JULY) || field.toString().equals(AUGUST) || field.toString().equals(SEPTEMBER)
             || field.toString().equals(OCTOBER) || field.toString().equals(NOVEMBER) || field.toString().equals(DECEMBER)) {
                expectedFields++;
            }
        }
        assertEquals(12, expectedFields);
    }
}