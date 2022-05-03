package org.example.streamapi.model;

import java.util.Objects;

public class Friend {
    private String name;
    private String availableDay;
    private String activity;

    public String getName() {
        return name;
    }

    public String getAvailableDay() {
        return availableDay;
    }

    public String getActivity() {
        return activity;
    }

    public Friend(String name, String availableDay, String activity) {
        this.name = name;
        this.availableDay = availableDay;
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(name, friend.name) && Objects.equals(availableDay, friend.availableDay) && Objects.equals(activity, friend.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, availableDay, activity);
    }
}