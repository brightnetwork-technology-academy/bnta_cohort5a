package org.examples.streamapi;

import org.examples.streamapi.model.Person;

import java.util.List;

import static org.examples.streamapi.model.Person.Gender.*;

public class TestUtil {

    public static final List<Person> PEOPLE = List.of(
           new Person("Alec","Gunn", 20, MALE),
           new Person("Suranne","Kirkpatrick", 33, NON_BINARY),
           new Person("Millicent","Halliday", 40, UNKNOWN),
           new Person("Bartlomiej","Herring", 27, MALE),
           new Person("Lisa","Boyer", 57, NON_BINARY),
           new Person("Elspeth","Humphries",16, FEMALE),
           new Person("Ruqayyah","Winters", 19, FEMALE),
           new Person("Victoria","Rich", 28, FEMALE),
           new Person("Zachary","Willis", 15, MALE),
           new Person("Max","Mcnamara", 17, MALE),
           new Person("Penelope","Kinney",29, FEMALE),
           new Person("Fatima","Cano", 35, FEMALE),
           new Person("Raiden","Sierra", 15, NON_BINARY),
           new Person("Viktor","Rollins",22, MALE),
           new Person("Aghata","Burks", 39, UNKNOWN),
           new Person("Gregg","O'Sullivan", 25, MALE),
           new Person("Andrew","Jarvis",47, MALE),
           new Person("Xavier","Thorpe", 30, MALE),
           new Person("Eve","Rossi", 26, FEMALE),
           new Person("Alivia","Parrish", 21, FEMALE)
    );
}
