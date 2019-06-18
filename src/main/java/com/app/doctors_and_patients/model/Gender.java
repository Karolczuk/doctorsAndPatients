package com.app.doctors_and_patients.model;

public enum Gender {

    MALE("MĘŻCZYZNA"), FEMALE("KOBIETA");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
