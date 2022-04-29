package org.example._4_props_and_methods;

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
