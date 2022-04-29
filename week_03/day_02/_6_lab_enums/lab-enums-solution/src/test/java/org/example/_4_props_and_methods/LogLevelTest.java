package org.example._4_props_and_methods;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("_4_props_and_methods.LogLevelTest")
class LogLevelTest {

    private static Class<?> clazz;
    private static final String LOG_LEVEL_CLASS = "org.example._4_props_and_methods.LogLevel";
    private static final String DEBUG = "public static final org.example._4_props_and_methods.LogLevel " +
            "org.example._4_props_and_methods.LogLevel.DEBUG";
    private static final String INFO = "public static final org.example._4_props_and_methods.LogLevel " +
            "org.example._4_props_and_methods.LogLevel.INFO";
    private static final String WARNING = "public static final org.example._4_props_and_methods.LogLevel " +
            "org.example._4_props_and_methods.LogLevel.WARNING";
    private static final String DISPLAY_NAME = "private final java.lang.String " +
            "org.example._4_props_and_methods.LogLevel.getDisplayName";
    private static final String SEND_TO_ADMIN = "private final boolean " +
            "org.example._4_props_and_methods.LogLevel.sendSMSToAdmin";


    private static final String GET_DISPLAY_NAME = "public java.lang.String org.example._4_props_and_methods.LogLevel.getGetDisplayName()";
    private static final String IS_SEND_SMS_TO_ADMIN = "public boolean " +
            "org.example._4_props_and_methods.LogLevel.isSendSMSToAdmin()";


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
    @DisplayName("LogLevel should have 3 declared constants: DEBUG, INFO and WARNING and 2 fields: displayName and sendToAdmin ")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        // expected = 4 = 3 declared fields (DEBUG, INFO and WARNING) + an extra field: $VALUES
        assertEquals(6, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(DEBUG) || field.toString().equals(INFO) || field.toString().equals(WARNING)
                    || field.toString().equals(DISPLAY_NAME) || field.toString().equals(SEND_TO_ADMIN)) {
                expectedFields++;
            }
        }

        assertEquals(5, expectedFields);
    }

    @Test
    @DisplayName("LogLevel enum should have 2 methods (all public): String getDisplayName(), booelan isSendSMSToAdmin()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // expected = 2 = 5 :) 2 declared methods + valueOf, values(), $values() - debug to see
        assertEquals(5, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_DISPLAY_NAME) || method.toString().equals(IS_SEND_SMS_TO_ADMIN)) {
                expectedMethods++;
            }
        }
        assertEquals(2, expectedMethods);
    }

    @Test
    @DisplayName("getDisplayName() method should return a display name of an particular enum")
    void checkGetDisplayName() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Class<?> cls = Class.forName(LOG_LEVEL_CLASS);

        for (Method declaredMethod : cls.getDeclaredMethods()) {
            if(declaredMethod.getName().equals("getGetDisplayName")) {
                assertAll(
                        () -> assertEquals("It's INFO!", declaredMethod.invoke(LogLevel.valueOf("INFO"))),
                        () -> assertEquals("It's DEBUG!", declaredMethod.invoke(LogLevel.valueOf("DEBUG"))),
                        () -> assertEquals("It's WARNING!", declaredMethod.invoke(LogLevel.valueOf("WARNING")))
                );
            }
        }
    }

    @Test
    @DisplayName("getIsSendSMSToAdmin() method should return true for WARNING and false for INFO and DEBUG")
    void checkIsSendSMSToAdmin() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Class<?> cls = Class.forName(LOG_LEVEL_CLASS);

        for (Method declaredMethod : cls.getDeclaredMethods()) {
            if(declaredMethod.getName().equals("isSendSMSToAdmin")) {
                assertAll(
                        () -> assertEquals(false, declaredMethod.invoke(LogLevel.valueOf("INFO"))),
                        () -> assertEquals(false, declaredMethod.invoke(LogLevel.valueOf("DEBUG"))),
                        () -> assertEquals(true, declaredMethod.invoke(LogLevel.valueOf("WARNING")))
                );
            }
        }
    }

}