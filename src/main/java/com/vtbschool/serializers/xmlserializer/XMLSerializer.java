package com.vtbschool.serializers.xmlserializer;

import com.vtbschool.serializers.AbstractSerializer;
import com.vtbschool.serializers.AnySerializer;
import com.vtbschool.exceptions.ReadFileException;
import com.vtbschool.exceptions.SerializationLibException;
import com.vtbschool.exceptions.WriteFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XMLSerializer<T> extends AbstractSerializer<T> implements AnySerializer<T> {
    private final static Logger logger = LoggerFactory.getLogger(XMLSerializer.class);

    public XMLSerializer(Class<T> type) {
        super(type);
    }


    @Override
    public void serialize(String filePath, T object) {
        serialize(new File(filePath), object);
    }

    @Override
    public void serialize(File resultFile, T object) {
        try {
            serialize(new FileOutputStream(resultFile), object);
        } catch (FileNotFoundException e) {
            logger.debug(e.toString());
            throw new ReadFileException(e.getMessage());
        }
        logger.debug("converted to XML");
    }

    @Override
    public void serialize(OutputStream out, T object) {
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
    public T deserialize(String filepath) {
        return deserialize(new File(filepath));
    }

    @Override
    public T deserialize(File file) {
        try {
            return deserialize(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        }
    }

    @Override
    public T deserialize(InputStream is) {
        T obj;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(getType());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            try (InputStream inputStream = is) {
                obj = (T) unmarshaller.unmarshal(inputStream);
            }
            logger.debug("converted from XML");
        } catch (IOException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        } catch (JAXBException e) {
            logger.debug(e.toString());
            throw new SerializationLibException(e.getMessage());
        }
        return obj;
    }
}
