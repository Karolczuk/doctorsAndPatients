package com.app.doctors_and_patients.domain;

public enum Gender {

    MALE("MEN"), FEMALE("WOMEN");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
