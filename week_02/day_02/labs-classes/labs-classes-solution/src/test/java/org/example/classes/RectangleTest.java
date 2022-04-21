package org.example.classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RectangleTest {
    private static Class<?> clazz;
    private static final String RECTANGLE_CLASS = "org.example.classes.Rectangle";
    private static final String RECTANGLE_CONSTRUCTOR = "public org.example.classes.Rectangle(float,float)";

    private static final String LENGTH = "private float org.example.classes.Rectangle.length";
    private static final String WIDTH = "private float org.example.classes.Rectangle.width";



    private static final String GET_LENGTH = "public float org.example.classes.Rectangle.getLength()";
    private static final String GET_WIDTH = "public float org.example.classes.Rectangle.getWidth()";
    private static final String GET_AREA = "public double org.example.classes.Rectangle.getArea()";
    private static final String GET_PERIMETER = "public double org.example.classes.Rectangle.getPerimeter()";
    private static final String GET_DIAGONAL = "public double org.example.classes.Rectangle.getDiagonal()";


    @BeforeAll
    static void checkIfCircleClassExists() {
        try {
            clazz = Class.forName(RECTANGLE_CLASS);
        } catch (ClassNotFoundException e) {
            fail(RECTANGLE_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("Rectangle class should have two fields (all private): float length, float width")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        assertEquals(2, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(LENGTH) || field.toString().equals(WIDTH)) {
                expectedFields++;
            }
        }

        assertEquals(2, expectedFields);
    }

    @Test
    @DisplayName("Account class should have only one constructor: public Rectangle(float,float)")
    void checkConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        assertEquals(RECTANGLE_CONSTRUCTOR, declaredConstructor.toString());
    }

    @Test
    @DisplayName("Account class should have 5 methods (all public): float getLength(), float getWidth(), " +
            "double getArea(), double getPerimeter(), double getDiagonal()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        assertEquals(5, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_LENGTH) || method.toString().equals(GET_WIDTH) ||
                    method.toString().equals(GET_AREA) || method.toString().equals(GET_PERIMETER)
                    || method.toString().equals(GET_DIAGONAL)) {
                expectedMethods++;
            }
        }
        assertEquals(5, expectedMethods);
    }

    @Test
    @DisplayName("getLength() method should return: length value")
    void checkGetLength() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object rectangleObject = null;
        Class rectangleClass = null;
        var constructorArgLength = 10f;
        var constructorArgWidth = 15f;

        rectangleClass = Class.forName(RECTANGLE_CLASS);
        rectangleObject = rectangleClass.getConstructor(float.class, float.class).newInstance(constructorArgLength, constructorArgWidth);


        for(Method method: rectangleClass.getDeclaredMethods()) {
            if(GET_LENGTH.equals(method.toString())) {
                Object returnedValue = method.invoke(rectangleObject);
                assertEquals(constructorArgLength, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getWidth() method should return: width value")
    void checkGetWidth() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object rectangleObject = null;
        Class rectangleClass = null;
        var constructorArgLength = 10f;
        var constructorArgWidth = 15f;

        rectangleClass = Class.forName(RECTANGLE_CLASS);
        rectangleObject = rectangleClass.getConstructor(float.class, float.class).newInstance(constructorArgLength, constructorArgWidth);


        for(Method method: rectangleClass.getDeclaredMethods()) {
            if(GET_WIDTH.equals(method.toString())) {
                Object returnedValue = method.invoke(rectangleObject);
                assertEquals(constructorArgWidth, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getArea() method should return: width * length")
    void checkGetArea() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object rectangleObject = null;
        Class rectangleClass = null;
        var constructorArgLength = 10f;
        var constructorArgWidth = 15f;
        double expectedValue = constructorArgWidth * constructorArgLength;
        rectangleClass = Class.forName(RECTANGLE_CLASS);
        rectangleObject = rectangleClass.getConstructor(float.class, float.class).newInstance(constructorArgLength, constructorArgWidth);


        for(Method method: rectangleClass.getDeclaredMethods()) {
            if(GET_AREA.equals(method.toString())) {
                Object returnedValue = method.invoke(rectangleObject);
                assertEquals(expectedValue, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getPerimeter() method should return: 2 * (length + width)")
    void checkGetPermieter() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object rectangleObject = null;
        Class rectangleClass = null;
        var constructorArgLength = 10f;
        var constructorArgWidth = 15f;
        double expectedValue = 2 * (constructorArgLength + constructorArgWidth);

        rectangleClass = Class.forName(RECTANGLE_CLASS);
        rectangleObject = rectangleClass.getConstructor(float.class, float.class).newInstance(constructorArgLength, constructorArgWidth);


        for(Method method: rectangleClass.getDeclaredMethods()) {
            if(GET_PERIMETER.equals(method.toString())) {
                Object returnedValue = method.invoke(rectangleObject);
                assertEquals(expectedValue, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getDiagonal() method should return: Math.sqrt(Math.pow(length,2)+Math.pow(width,2))")
    void checkGetDiagonal() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object rectangleObject = null;
        Class rectangleClass = null;
        var constructorArgLength = 10f;
        var constructorArgWidth = 15f;
        var expectedValue = Math.sqrt(Math.pow(constructorArgLength,2)+Math.pow(constructorArgWidth,2));

        rectangleClass = Class.forName(RECTANGLE_CLASS);
        rectangleObject = rectangleClass.getConstructor(float.class, float.class).newInstance(constructorArgLength, constructorArgWidth);


        for(Method method: rectangleClass.getDeclaredMethods()) {
            if(GET_DIAGONAL.equals(method.toString())) {
                Object returnedValue = method.invoke(rectangleObject);
                assertEquals(expectedValue, returnedValue);
                break;
            }
        }
    }
}
