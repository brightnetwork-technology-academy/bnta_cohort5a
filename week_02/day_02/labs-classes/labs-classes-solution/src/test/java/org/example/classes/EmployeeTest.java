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

public class EmployeeTest {
    private static Class<?> clazz;
    private static final String EMPLOYEE_CLASS = "org.example.classes.Employee";
    private static final String EMPLOYEE_CONSTRUCTOR = "public org.example.classes.Employee(int,java.lang.String,java.lang.String,int)";
    private static final String ID = "private int org.example.classes.Employee.id";
    private static final String FIRST_NAME = "private java.lang.String org.example.classes.Employee.firstName";
    private static final String LAST_NAME = "private java.lang.String org.example.classes.Employee.lastName";
    private static final String SALARY = "private int org.example.classes.Employee.salary";

    private static final String GET_ID = "public int org.example.classes.Employee.getId()";
    private static final String GET_FIRST_NAME = "public java.lang.String org.example.classes.Employee.getFirstName()";
    private static final String GET_LAST_NAME = "public java.lang.String org.example.classes.Employee.getLastName()";
    private static final String GET_NAME = "public java.lang.String org.example.classes.Employee.getName()";
    private static final String GET_SALARY = "public int org.example.classes.Employee.getSalary()";
    private static final String GET_ANNUAL_SALARY = "public int org.example.classes.Employee.getAnnualSalary()";

    @BeforeAll
    static void checkIfCircleClassExists() {
        try {
            clazz = Class.forName(EMPLOYEE_CLASS);
        } catch (ClassNotFoundException e) {
            fail(EMPLOYEE_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("Employee class should have four fields (all private): int id, String firstName," +
            " String lastName, int salary")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        assertEquals(4, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(ID) || field.toString().equals(FIRST_NAME) || field.toString().equals(LAST_NAME) || field.toString().equals(SALARY)) {
                expectedFields++;
            }
        }

        assertEquals(4, expectedFields);
    }

    @Test
    @DisplayName("Employee class should have only one constructor: public Employee(int,java.lang.String,java.lang.String,int)")
    void checkConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        assertEquals(EMPLOYEE_CONSTRUCTOR, declaredConstructor.toString());
    }

    @Test
    @DisplayName("Employee class should have 5 methods (all public): int getId(), String getFirstName(), String getLastName()," +
            " String getName(), int getAnnualSalary()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        assertEquals(6, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_FIRST_NAME) || method.toString().equals(GET_LAST_NAME)
                    || method.toString().equals(GET_NAME) || method.toString().equals(GET_SALARY)
                    || method.toString().equals(GET_ANNUAL_SALARY)  || method.toString().equals(GET_ID)) {
                expectedMethods++;
            }
        }
        assertEquals(6, expectedMethods);
    }


    @Test
    @DisplayName("getId() method should return: id value")
    void checkGetId() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "Y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_ID.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(constructorArgId, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getFirstName() method should return: firstName value")
    void checkGetFirstName() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "Y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_FIRST_NAME.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(constructorArgFirstName, returnedValue);
                break;
            }
        }
    }


    @Test
    @DisplayName("getLastName() method should return: lastName value")
    void checkGetLastName() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_LAST_NAME.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(constructorArgLastName, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getName() method should return: firstName + \" \" + lastName")
    void checkGetName() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_NAME.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(constructorArgFirstName+ " "+constructorArgLastName, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getSalary() method should return: salary value")
    void checkGetSalary() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_SALARY.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(constructorArgSalary, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getAnnualSalary() method should return: salary value * 12")
    void checkGetAnnualSalary() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object employeeObject = null;
        Class employeeClass = null;
        var constructorArgId = 100;
        var constructorArgFirstName = "X";
        var constructorArgLastName = "y";
        var constructorArgSalary = 10000;


        employeeClass = Class.forName(EMPLOYEE_CLASS);
        employeeObject = employeeClass.getConstructor(int.class, String.class, String.class, int.class)
                .newInstance(constructorArgId, constructorArgFirstName, constructorArgLastName, constructorArgSalary);


        for(Method method: employeeClass.getDeclaredMethods()) {
            if(GET_ANNUAL_SALARY.equals(method.toString())) {
                Object returnedValue = method.invoke(employeeObject);
                assertEquals(12 * constructorArgSalary, returnedValue);
                break;
            }
        }
    }
}
