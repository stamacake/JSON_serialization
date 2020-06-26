package com.vtbschool.xmlserializer;

import com.vtbschool.InternSerializer;
import com.vtbschool.exceptions.ReadFileException;
import com.vtbschool.exceptions.SerializationLibException;
import com.vtbschool.exceptions.WriteFileException;
import com.vtbschool.model.Intern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLSerializer implements InternSerializer {
    private final static Logger logger = LoggerFactory.getLogger(XMLSerializer.class);


    @Override
    public void serialize(String filePath, Intern object) {
        serialize(new File(filePath), object);
    }

    @Override
    public void serialize(File resultFile, Intern object) {
        try {
            serialize(new FileOutputStream(resultFile), object);
        } catch (FileNotFoundException e) {
            logger.debug(e.toString());
            throw new ReadFileException(e.getMessage());
        }
        logger.debug("converted to XML");
    }

    @Override
    public void serialize(OutputStream out, Intern object) {
        try {


            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (OutputStream os = out) {
                jaxbMarshaller.marshal(object, os);
            }
        } catch (IOException e) {
            logger.debug(e.toString());
            throw new ReadFileException(e.getMessage());
        } catch (JAXBException e) {
            logger.debug(e.toString());
            throw new SerializationLibException(e.getMessage());
        }
        logger.debug("converted to XML");
    }

    @Override
    public Intern deserialize(String filepath) {
        return deserialize(new File(filepath));
    }

    @Override
    public Intern deserialize(File file) {
        try {
            return deserialize(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        }
    }

    @Override
    public Intern deserialize(InputStream is) {
        Intern intern;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Intern.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            try (InputStream inputStream = is) {
                intern = (Intern) unmarshaller.unmarshal(inputStream);
            }
            logger.debug("converted from XML");
        } catch (IOException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        } catch (JAXBException e) {
            logger.debug(e.toString());
            throw new SerializationLibException(e.getMessage());
        }
        return intern;
    }
}
