package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
class Intern
{
    public String firstName;
    public String lastName;
    public int age;
    public boolean ismale;
    public String compamy;
    public String[] skills;

    public List<Task> tasks;

    Intern(){}
}



public class Main {

    static public void toJSON(Object convertJava) throws IOException {
        StringWriter writer = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("intern.json"), convertJava);
    }

    static public Intern fromJSON(String convertJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
       // Object user = mapper.readValue(new File("intern.json"), Intern.class);
        Intern user = mapper.readValue(new File(convertJson), Intern.class);
        return user;
    }

    public static void main(String[] args) throws IOException {
        Intern intern1 = new Intern();
        intern1.firstName = "John";
        intern1.lastName = "Statham";
        intern1.age = 20;
        intern1.compamy = "VTB";
        intern1.ismale = true;
        intern1.skills = new String[]{"java","sql","handsome"};

        Task task1 = new Task();
        task1.description = "first task";
        task1.id = 1;
        task1.name = "TASK NAME 1";

        Task task2 = new Task();
        task2.description = "second task";
        task2.id = 2;
        task2.name = "TASK NAME 2";
        List<Task> tsk = new ArrayList<>();
        tsk.add(task1);
        tsk.add(task2);
        intern1.tasks = tsk;


        toJSON(intern1);

        Intern intern2 = fromJSON("intern.json");

        System.out.println(intern2.lastName+" "+ intern2.skills[2]+" "+intern2.tasks.get(0).name);
    }


}
