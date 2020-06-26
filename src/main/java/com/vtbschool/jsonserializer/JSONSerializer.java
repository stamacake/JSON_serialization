package com.vtbschool.jsonserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtbschool.InternSerializer;
import com.vtbschool.exceptions.WriteFileException;
import com.vtbschool.model.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JSONSerializer implements InternSerializer {
    private final static Logger logger = LoggerFactory.getLogger(JSONSerializer.class);

    @Override
    public void serialize(String filePath, Group object) {
        serialize(new File(filePath), object);
    }

    @Override
    public void serialize(File resultFile, Group object) {

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
    public void serialize(OutputStream os, Group object) {
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
    public Group deserialize(String filepath) {
        return deserialize(new File(filepath));

    }

    @Override
    public Group deserialize(File file) {
        ObjectMapper mapper = new ObjectMapper();
        Group gruop = null;
        try {
            gruop = mapper.readValue(file, Group.class);
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }


        logger.debug("converted from JSON");

        return gruop;
    }

    @Override
    public Group deserialize(InputStream is) {
        ObjectMapper mapper = new ObjectMapper();
        Group group = null;
        try {
            group = mapper.readValue(is, Group.class);
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }

        logger.debug("converted from JSON");

        return group;

    }
}