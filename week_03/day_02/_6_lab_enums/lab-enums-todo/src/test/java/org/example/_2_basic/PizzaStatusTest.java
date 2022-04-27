package org.example._2_basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStatusTest {
    private static Class<?> clazz;
    private static final String PIZZA_STATUS_CLASS = "org.example._2_basic.PizzaStatus";
    private static final String ORDERED = "public static final org.example._2_basic.PizzaStatus " +
            "org.example._2_basic.PizzaStatus.ORDERED";
    private static final String READY = "public static final org.example._2_basic.PizzaStatus " +
            "org.example._2_basic.PizzaStatus.READY";
    private static final String DELIVERED = "public static final org.example._2_basic.PizzaStatus " +
            "org.example._2_basic.PizzaStatus.DELIVERED";


    @BeforeAll
    static void checkIfPizzaStatusExist() {
        try {
            clazz = Class.forName(PIZZA_STATUS_CLASS);
        } catch (ClassNotFoundException e) {
            fail(PIZZA_STATUS_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("PizzaStatus should be an enum")
    void checkIfEnum() {
        assertTrue(clazz.isEnum());
    }

    @Test
    @DisplayName("PizzaStatus should have 3 declared constants: ORDERED, READY and DELIVERED")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        // expected = 4 = 3 declared fields (ORDERED, READY and DELIVERED) + an extra field: $VALUES
        assertEquals(4, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(ORDERED) || field.toString().equals(READY) || field.toString().equals(DELIVERED)) {
                expectedFields++;
            }
        }

        assertEquals(3, expectedFields);
    }
}