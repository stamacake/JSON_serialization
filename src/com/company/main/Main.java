package com.company.main;

import com.company.model.Gender;
import com.company.model.Intern;
import com.company.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static public String toJSON(Intern convertJava) throws IOException {
        StringWriter writer = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("intern.json"), convertJava);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(convertJava);
    }

    static public Intern fromJSON(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Intern user = mapper.readValue(new File(jsonFilePath), Intern.class);
        return user;
    }

    public static void main(String[] args) throws IOException {
        Intern intern1 = new Intern();
        intern1.setFirstName("John");
        intern1.setLastName("Statham");
        intern1.setAge(20);
        intern1.setCompamy("VTB");
        intern1.setGender(Gender.MALE);
        intern1.setSkills(new String[]{"java", "sql", "handsome"});

        Task task1 = new Task();
        task1.setDescription("first task");
        task1.setId(1);
        task1.setName("TASK NAME 1");

        Task task2 = new Task();
        task2.setDescription("second task");
        task2.setId(2);
        task2.setName("TASK NAME 2");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        intern1.setTasks(tasks);


        String jsonRepresentation = toJSON(intern1);
        System.out.println("Serialized:");
        System.out.println(jsonRepresentation);

        System.out.println("Now we deserialize");

        Intern intern2 = fromJSON("intern.json");

        System.out.println(intern2);
        System.out.println("Let's change something in deserialized object.");
        intern2.setFirstName("Boris");
        System.out.println(intern2);
        System.out.println("Name has been nicely changed.");
    }

}
