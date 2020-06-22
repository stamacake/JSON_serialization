package com.vtbschool.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtbschool.model.Gender;
import com.vtbschool.model.Intern;
import com.vtbschool.model.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {



    static public String toJSON(Intern convertJava) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("intern.json"), convertJava);

        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("converted to JSON");

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(convertJava);
    }

    static public Intern fromJSON(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Intern user = mapper.readValue(new File(jsonFilePath), Intern.class);

        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("converted from JSON");

        return user;
    }

    static public String toXML(Intern convertJava) throws JAXBException, IOException {

        JAXBContext jaxbContext = JAXBContext.newInstance(convertJava.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (OutputStream os = new FileOutputStream("intern.xml")) {
            jaxbMarshaller.marshal(convertJava, os);
        }
        StringWriter res = new StringWriter();
        jaxbMarshaller.marshal(convertJava, res);

        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("converted to XML");

        return res.toString();
    }

    public static Intern fromXML(String xmlFilePath) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Intern.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Intern intern;
        try (InputStream inputStream = new FileInputStream("intern.xml")) {
            intern = (Intern) unmarshaller.unmarshal(inputStream);
        }

        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("converted from XML");

        return intern;

    }

    public static void main(String[] args) throws IOException, JAXBException {
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
        String xmlRepresentation = toXML(intern1);
        System.out.println("Serialized:");
        System.out.println(jsonRepresentation);
        System.out.println(xmlRepresentation);

        System.out.println("Now we deserialize");

        Intern jsonIntern = fromJSON("intern.json");
        Intern xmlIntern = fromXML("intern.xml");
        System.out.println(jsonIntern);
        System.out.println("Let's change something in deserialized object.");
        jsonIntern.setFirstName("Boris");
        System.out.println(jsonIntern);
        System.out.println("Name has been nicely changed.");
    }

}
