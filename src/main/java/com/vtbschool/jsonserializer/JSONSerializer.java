package com.vtbschool.jsonserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtbschool.InternSerializer;
import com.vtbschool.exceptions.WriteFileException;
import com.vtbschool.model.Intern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JSONSerializer implements InternSerializer {
    private final static Logger logger = LoggerFactory.getLogger(JSONSerializer.class);

    @Override
    public void serialize(String filePath, Intern object) {
        serialize(new File(filePath), object);
    }

    @Override
    public void serialize(File resultFile, Intern object) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(resultFile, object);
            logger.debug("converted to JSON");
        } catch (IOException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        }
    }

    @Override
    public void serialize(OutputStream os, Intern object) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(os, object);
            logger.debug("Converted to JSON");
        } catch (IOException e) {
            logger.debug(e.toString());
            throw new WriteFileException(e.getMessage());
        }
    }

    @Override
    public Intern deserialize(String filepath) {
       return deserialize(new File(filepath));

    }

    @Override
    public Intern deserialize(File file) {
        ObjectMapper mapper = new ObjectMapper();
        Intern user = null;
        try {
            user = mapper.readValue(file, Intern.class);
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }


        logger.debug("converted from JSON");

        return user;
    }

    @Override
    public Intern deserialize(InputStream is) {
        ObjectMapper mapper = new ObjectMapper();
        Intern user = null;
        try {
            user = mapper.readValue(is, Intern.class);
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }


        logger.debug("converted from JSON");

        return user;

    }
}