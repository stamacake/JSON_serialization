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
    final static Logger logger = LoggerFactory.getLogger(Main.class);


    static public String toJSON(Intern convertJava) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("intern.json"), convertJava);


        logger.debug("converted to JSON");

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(convertJava);
    }

    static public Intern fromJSON(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Intern user = mapper.readValue(new File(jsonFilePath), Intern.class);


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

        logger.debug("converted from XML");

        return intern;

    }

    public static void main(String[] args) throws IOException, JAXBException {
        // TESTS

    }

}
