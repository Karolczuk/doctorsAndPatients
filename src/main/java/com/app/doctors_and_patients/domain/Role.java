package com.app.doctors_and_patients.domain;

public enum Role {

    PATIENT("ROLE_PATIENT"), DOCTOR("ROLE_DOCTOR");

    private String fullName;

    Role(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
