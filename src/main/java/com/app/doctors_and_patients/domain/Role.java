package com.app.doctors_and_patients.domain;

public enum Role {

    ROLE_PATIENT("ROLE_PATIENT"), ROLE_DOCTOR("ROLE_DOCTOR");

    private String fullName;

    Role(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
