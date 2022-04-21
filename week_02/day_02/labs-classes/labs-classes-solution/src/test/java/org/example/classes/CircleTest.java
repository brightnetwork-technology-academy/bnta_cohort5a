package org.example.classes;


import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CircleTest {

    private static Class<?> clazz;
    private static final String CIRCLE_CLASS = "org.example.classes.Circle";
    private static final String CIRCLE_CONSTRUCTOR = "public org.example.classes.Circle(double)";
    private static final String RADIUS = "private double org.example.classes.Circle.radius";

    private static final String GET_CIRCUMFERENCE = "public double org.example.classes.Circle.getCircumference()";
    private static final String GET_RADIUS = "public double org.example.classes.Circle.getRadius()";

    @BeforeAll
    static void checkIfCircleClassExists() {
        try {
            clazz = Class.forName(CIRCLE_CLASS);
        } catch (ClassNotFoundException e) {
            fail(CIRCLE_CLASS + " does not exist");
        }
    }


    @Test
    @DisplayName("Circle class should have only one field: private double radius")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        assertEquals(1, declaredFields.length);

        Field declaredField = declaredFields[0];
        assertEquals(RADIUS, declaredField.toString());
    }

    @Test
    @DisplayName("Circle class should have only one constructor: public Circle(double)")
    void checkConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        assertEquals(CIRCLE_CONSTRUCTOR, declaredConstructor.toString());
    }

    @Test
    @DisplayName("Circle class should have 2 methods (all public): double getCircumference() and double getRadius()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        assertEquals(2, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_CIRCUMFERENCE) || method.toString().equals(GET_RADIUS)) {
                expectedMethods++;
            }
        }
        assertEquals(2, expectedMethods);
    }

    @Test
    @DisplayName("getCircumference() method should return: radius * radius * PI ")
    void checkGetCircumference() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object circleObject = null;
        Class circleClass = null;
        var expectedValue = 10d * 10d * Math.PI;
        var constructorArg = 10d;
        circleClass = Class.forName(CIRCLE_CLASS);
        circleObject = circleClass.getConstructor(double.class).newInstance(constructorArg);


        for(Method method: circleClass.getDeclaredMethods()) {
            if(GET_CIRCUMFERENCE.equals(method.toString())) {
                Object returnedValue = method.invoke(circleObject);
                assertEquals(expectedValue, (double)returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getRadius() method should return: radius value")
    void checkGetRadius() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object circleObject = null;
        Class circleClass = null;
        var constructorArg = 10d;

        circleClass = Class.forName(CIRCLE_CLASS);
        circleObject = circleClass.getConstructor(double.class).newInstance(constructorArg);


        for(Method method: circleClass.getDeclaredMethods()) {
            if(GET_RADIUS.equals(method.toString())) {
                Object returnedValue = method.invoke(circleObject);
                assertEquals(constructorArg, returnedValue);
                break;
            }
        }
    }
}
