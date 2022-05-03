package org.examples.streamapi._4;

import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {
/*
    We used Predicates with the Stream's filter method.


    In Java, each method must belong to a Type - there are no methods on their own.
    Every lambda we pass is an implementation of a functional interface - (a functional interface is an interface with one method only).

    We can assign a lambda to a reference which sometimes may be helpful write more reusable code.

 */

    @Test
    void filterUsingAPredicate() {
        // Use lambda expression and assign it to a variable
        Predicate<Person> ageMoreThan30 = (person) -> {
            return person.getAge() > 30;
        };

        Predicate<Person> ageLessThan20 = (person) -> {
            return person.getAge() < 20;
        };

        List<Person> peopleOlderThan30AndYoungerThen20 = PEOPLE
                .stream()
                // Time to use the predicates ?
                .filter(ageLessThan20.or(ageLessThan20))
                .toList();

        assertEquals(5, peopleOlderThan30AndYoungerThen20.size());
    }

        /*
            Time for some practice:
             - create the same test but this time use IntelliJ to help you get rid of unnecessary code in the lambdas
             (e.g. return keyword)
             - use FilterTest exercises again, but this time with the help of predefined predicates

             - extras: define some predicates in Person class (public static) and use them in the test
         */
}