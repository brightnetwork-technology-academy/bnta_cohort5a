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

public class AccountTest {
    private static Class<?> clazz;
    private static final String ACCOUNT_CLASS = "org.example.classes.Account";
    private static final String ACCOUNT_CONSTRUCTOR = "public org.example.classes.Account(java.lang.String,java.lang.String,int)";

    private static final String ID = "private java.lang.String org.example.classes.Account.id";
    private static final String NAME = "private java.lang.String org.example.classes.Account.name";
    private static final String BALANCE = "private int org.example.classes.Account.balance";

    private static final String GET_ID = "public java.lang.String org.example.classes.Account.getId()";
    private static final String GET_NAME = "public java.lang.String org.example.classes.Account.getName()";
    private static final String GET_BALANCE = "public int org.example.classes.Account.getBalance()";

    @BeforeAll
    static void checkIfCircleClassExists() {
        try {
            clazz = Class.forName(ACCOUNT_CLASS);
        } catch (ClassNotFoundException e) {
            fail(ACCOUNT_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("Account class should have three fields (all private): String id, String name, int balance")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        assertEquals(3, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(ID) || field.toString().equals(NAME) || field.toString().equals(BALANCE)) {
                expectedFields++;
            }
        }

        assertEquals(3, expectedFields);
    }

    @Test
    @DisplayName("Account class should have only one constructor: public Account(String,String,int)")
    void checkConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        assertEquals(ACCOUNT_CONSTRUCTOR, declaredConstructor.toString());
    }

    @Test
    @DisplayName("Account class should have 3 methods (all public): String getId(), String getName, int getBalance()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        assertEquals(3, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_ID) || method.toString().equals(GET_NAME) || method.toString().equals(GET_BALANCE)) {
                expectedMethods++;
            }
        }
        assertEquals(3, expectedMethods);
    }

    @Test
    @DisplayName("getId() method should return: id value")
    void checkGetId() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object accountObject = null;
        Class accountClass = null;
        var constructorArgId = "X";
        var constructorArgName = "Y";
        var constructorArgBalance = 100;

        accountClass = Class.forName(ACCOUNT_CLASS);
        accountObject = accountClass.getConstructor(String.class, String.class, int.class).newInstance(constructorArgId, constructorArgName, constructorArgBalance);


        for(Method method: accountClass.getDeclaredMethods()) {
            if(GET_ID.equals(method.toString())) {
                Object returnedValue = method.invoke(accountObject);
                assertEquals(constructorArgId, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getName() method should return: name value")
    void checkGetName() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object accountObject = null;
        Class accountClass = null;
        var constructorArgId = "X";
        var constructorArgName = "Y";
        var constructorArgBalance = 100;

        accountClass = Class.forName(ACCOUNT_CLASS);
        accountObject = accountClass.getConstructor(String.class, String.class, int.class).newInstance(constructorArgId, constructorArgName, constructorArgBalance);


        for(Method method: accountClass.getDeclaredMethods()) {
            if(GET_NAME.equals(method.toString())) {
                Object returnedValue = method.invoke(accountObject);
                assertEquals(constructorArgName, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getBalance() method should return: balance value")
    void checkGetBalance() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object accountObject = null;
        Class accountClass = null;
        var constructorArgId = "X";
        var constructorArgName = "Y";
        var constructorArgBalance = 100;

        accountClass = Class.forName(ACCOUNT_CLASS);
        accountObject = accountClass.getConstructor(String.class, String.class, int.class).newInstance(constructorArgId, constructorArgName, constructorArgBalance);


        for(Method method: accountClass.getDeclaredMethods()) {
            if(GET_BALANCE.equals(method.toString())) {
                Object returnedValue = method.invoke(accountObject);
                assertEquals(constructorArgBalance, returnedValue);
                break;
            }
        }
    }
}
