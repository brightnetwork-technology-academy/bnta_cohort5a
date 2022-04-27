package org.example._1_intro;
/*
    TODO 1 README

    Enum types are special classes that have a set of fixed values e.g. days of the week.
    Long story short, you can think of enums as a good way to model drop-down fields in a web form.

    To create an enum, use the enum keyword instead of class.
 */
public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

  /*
        TODO 3 README

        In the world without enums the above code would look like this:

        public class Day {
            public static final int SUNDAY = 0;
            public static final int MONDAY = 1;
            public static final int TUESDAY = 2;

            ...

        }
     */

/*
    TODO 4 It's time to create some enums!

    Create some enums in package org.example._2_basic:

    LogLevel (DEBUG, INFO, WARNING) - this one is already created

    Month (JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER)

    PizzaStatus (ORDERED,READY,DELIVERED)

    Implement the enums and run some tests in org.java.example_2_basic package
 */