package com.vtbschool.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum()
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
