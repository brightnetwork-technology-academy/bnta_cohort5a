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

public class InvoiceTest {
    private static Class<?> clazz;
    private static final String INVOICE_CLASS = "org.example.classes.Invoice";
    private static final String INVOICE_CONSTRUCTOR = "public org.example.classes.Invoice(java.lang.String,java.lang.String,int,double)";

    private static final String ID = "private java.lang.String org.example.classes.Invoice.id";
    private static final String DESC = "private java.lang.String org.example.classes.Invoice.desc";
    private static final String QTY = "private int org.example.classes.Invoice.qty";
    private static final String UNIT_PRICE = "private double org.example.classes.Invoice.unitPrice";


    private static final String GET_ID = "public java.lang.String org.example.classes.Invoice.getId()";
    private static final String GET_DESC = "public java.lang.String org.example.classes.Invoice.getDesc()";
    private static final String GET_QTY = "public int org.example.classes.Invoice.getQty()";
    private static final String GET_UNIT_PRICE = "public double org.example.classes.Invoice.getUnitPrice()";
    private static final String GET_TOTAL = "public double org.example.classes.Invoice.getTotal()";



    @BeforeAll
    static void checkIfCircleClassExists() {
        try {
            clazz = Class.forName(INVOICE_CLASS);
        } catch (ClassNotFoundException e) {
            fail(INVOICE_CLASS + " does not exist");
        }
    }

    @Test
    @DisplayName("Invoice class should have three fields (all private): String id, String desc," +
            " int qty, double unitPrice")
    void checkFields() {

        Field[] declaredFields = clazz.getDeclaredFields();
        assertEquals(4, declaredFields.length);

        var expectedFields = 0;
        for (Field field : declaredFields) {
            if (field.toString().equals(ID) || field.toString().equals(DESC)
                    || field.toString().equals(QTY) || field.toString().equals(UNIT_PRICE)) {
                expectedFields++;
            }
        }

        assertEquals(4, expectedFields);
    }

    @Test
    @DisplayName("Invoice class should have only one constructor: public Invoice(String,String,int,double)")
    void checkConstructors() {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        assertEquals(INVOICE_CONSTRUCTOR, declaredConstructor.toString());
    }

    @Test
    @DisplayName("Invoice class should have 5 methods (all public): String getId(), String getDesc(), int getQty()," +
            " double getUnitPrice(), double getTotal()")
    void checkMethods() {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        assertEquals(5, declaredMethods.length);
        var expectedMethods = 0;

        for (Method method : declaredMethods) {
            if (method.toString().equals(GET_ID) || method.toString().equals(GET_DESC) || method.toString().equals(GET_TOTAL)
                    || method.toString().equals(GET_QTY) || method.toString().equals(GET_UNIT_PRICE)) {
                expectedMethods++;
            }
        }
        assertEquals(5, expectedMethods);
    }

    @Test
    @DisplayName("getId() method should return: id value")
    void checkGetId() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object invoiceObject = null;
        Class invoiceClass = null;
        var constructorArgId = "X";
        var constructorArgDesc = "Y";
        var constructorArgQty = 100;
        var constructorArgUnitPrice = 100d;

        invoiceClass = Class.forName(INVOICE_CLASS);
        invoiceObject = invoiceClass.getConstructor(String.class, String.class, int.class, double.class)
                .newInstance(constructorArgId, constructorArgDesc, constructorArgQty, constructorArgUnitPrice);


        for(Method method: invoiceClass.getDeclaredMethods()) {
            if(GET_ID.equals(method.toString())) {
                Object returnedValue = method.invoke(invoiceObject);
                assertEquals(constructorArgId, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getDesc() method should return: desc value")
    void checkGetDesc() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object invoiceObject = null;
        Class invoiceClass = null;
        var constructorArgId = "X";
        var constructorArgDesc = "Y";
        var constructorArgQty = 100;
        var constructorArgUnitPrice = 100d;

        invoiceClass = Class.forName(INVOICE_CLASS);
        invoiceObject = invoiceClass.getConstructor(String.class, String.class, int.class, double.class)
                .newInstance(constructorArgId, constructorArgDesc, constructorArgQty, constructorArgUnitPrice);


        for(Method method: invoiceClass.getDeclaredMethods()) {
            if(GET_DESC.equals(method.toString())) {
                Object returnedValue = method.invoke(invoiceObject);
                assertEquals(constructorArgDesc, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getQty() method should return: qty value")
    void checkGetQty() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object invoiceObject = null;
        Class invoiceClass = null;
        var constructorArgId = "X";
        var constructorArgDesc = "Y";
        var constructorArgQty = 100;
        var constructorArgUnitPrice = 100d;

        invoiceClass = Class.forName(INVOICE_CLASS);
        invoiceObject = invoiceClass.getConstructor(String.class, String.class, int.class, double.class)
                .newInstance(constructorArgId, constructorArgDesc, constructorArgQty, constructorArgUnitPrice);


        for(Method method: invoiceClass.getDeclaredMethods()) {
            if(GET_QTY.equals(method.toString())) {
                Object returnedValue = method.invoke(invoiceObject);
                assertEquals(constructorArgQty, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getUnitPrice() method should return: unitPrice value")
    void checkGetUnitPrice() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object invoiceObject = null;
        Class invoiceClass = null;
        var constructorArgId = "X";
        var constructorArgDesc = "Y";
        var constructorArgQty = 100;
        var constructorArgUnitPrice = 100d;

        invoiceClass = Class.forName(INVOICE_CLASS);
        invoiceObject = invoiceClass.getConstructor(String.class, String.class, int.class, double.class)
                .newInstance(constructorArgId, constructorArgDesc, constructorArgQty, constructorArgUnitPrice);


        for(Method method: invoiceClass.getDeclaredMethods()) {
            if(GET_UNIT_PRICE.equals(method.toString())) {
                Object returnedValue = method.invoke(invoiceObject);
                assertEquals(constructorArgUnitPrice, returnedValue);
                break;
            }
        }
    }

    @Test
    @DisplayName("getTotal() method should return:  unitPrice * qty")
    void checkGetTotal() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object invoiceObject = null;
        Class invoiceClass = null;
        var constructorArgId = "X";
        var constructorArgDesc = "Y";
        var constructorArgQty = 100;
        var constructorArgUnitPrice = 100d;

        invoiceClass = Class.forName(INVOICE_CLASS);
        invoiceObject = invoiceClass.getConstructor(String.class, String.class, int.class, double.class)
                .newInstance(constructorArgId, constructorArgDesc, constructorArgQty, constructorArgUnitPrice);


        for(Method method: invoiceClass.getDeclaredMethods()) {
            if(GET_TOTAL.equals(method.toString())) {
                Object returnedValue = method.invoke(invoiceObject);
                assertEquals(constructorArgUnitPrice * constructorArgQty, returnedValue);
                break;
            }
        }
    }


}
