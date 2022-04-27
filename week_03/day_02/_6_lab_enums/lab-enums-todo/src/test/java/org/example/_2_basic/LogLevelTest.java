package org.example._2_basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("_2_basic.LogLevelTest")
class LogLevelTest {
    private static Class<?> clazz;
    private static final String LOG_LEVEL_CLASS = "org.example._2_basic.LogLevel";
    private static final String DEBUG = "public static final org.example._2_basic.LogLevel " +
            "org.example._2_basic.LogLevel.DEBUG";
    private static final String INFO = "public static final org.example._2_basic.LogLevel " +
            "org.example._2_basic.LogLevel.INFO";
    private static final String WARNING = "public static final org.example._2_basic.LogLevel " +
            "org.example._2_basic.LogLevel.WARNING";


    @BeforeAll
    static void checkIfLogLevelExist() {
        try {
            clazz = Class.forName(LOG_LEVEL_CLASS);
        } catch (ClassNotFoundException e) {
            fail(LOG_LEVEL_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("LogLevel should be an enum")
    void checkIfEnum() {
        assertTrue(clazz.isEnum());
    }

    @Test
    @DisplayName("LogLevel should have 3 declared constants: DEBUG, INFO and WARNING")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        // expected = 4 = 3 declared fields (DEBUG, INFO and WARNING) + an extra field: $VALUES
        assertEquals(4, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(DEBUG) || field.toString().equals(INFO) || field.toString().equals(WARNING)) {
                expectedFields++;
            }
        }

        assertEquals(3, expectedFields);
    }
}