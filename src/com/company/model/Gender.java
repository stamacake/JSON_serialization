package com.company.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("male"), FEMALE("female");

    private final String stringRepresentation;

    Gender(String male) {
        stringRepresentation = male;
    }


    @JsonValue
    public String getStringRepresentation() {
        return stringRepresentation;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "stringRepresentation='" + stringRepresentation + '\'' +
                '}';
    }
}
