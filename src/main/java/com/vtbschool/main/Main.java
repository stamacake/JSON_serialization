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

    public static void main(String[] args) {
        // TESTS

    }

}
