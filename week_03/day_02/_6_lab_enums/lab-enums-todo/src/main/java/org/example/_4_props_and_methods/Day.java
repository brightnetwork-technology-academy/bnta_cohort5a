package org.example._4_props_and_methods;

/*
    TODO 7

    To associate data and behaviors with each enum's constants, we can add some properties and methods
    just as you would do in any other class. This gives us more flexibility, e.g. custom messages associated with
    a particular enum.

    Take a few minutes and compare this enum (org.example._4_props_and_methods.Day) with org.example._1_intro.Day.

   Tt's time for you to enhance an enum from the previous exercise (go to TODO8 in LogLevel).

 */
public enum Day {
    SUNDAY("Sunday", true),
    MONDAY("Monday", false),
    TUESDAY("Tuesday", false),
    WEDNESDAY("Wednesday", false),
    THURSDAY("Thursday", false),
    FRIDAY("Friday", false),
    SATURDAY("Saturday", true);

    private final String displayName;
    private final boolean weekday;

    Day(String displayName, boolean weekday) {
        this.displayName = displayName;
        this.weekday = weekday;
    }

    public String getUserFriendlyName() {
        return this.displayName;
    }

    public boolean isWeekday() {
        return this.weekday;
    }
}
