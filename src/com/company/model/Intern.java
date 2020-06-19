package com.company.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Arrays;
import java.util.List;

@JsonAutoDetect
public class Intern {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String compamy;
    private String[] skills;

    private List<Task> tasks;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getCompamy() {
        return compamy;
    }

    public void setCompamy(String compamy) {
        this.compamy = compamy;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public String toString() {
        return "Intern{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", compamy='" + compamy + '\'' +
                ", skills=" + Arrays.toString(skills) +
                ", tasks=" + tasks +
                '}';
    }
}

