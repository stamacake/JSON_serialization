package com.vtbschool.serializers.jsonserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtbschool.serializers.AbstractSerializer;
import com.vtbschool.serializers.AnySerializer;
import com.vtbschool.exceptions.WriteFileException;
import com.vtbschool.model.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JSONSerializer<T> extends AbstractSerializer<T> implements AnySerializer<T> {
    private final static Logger logger = LoggerFactory.getLogger(JSONSerializer.class);

    public JSONSerializer(Class<T> type) {
        super(type);
    }

    @Override
    public void serialize(String filePath, T object) {
        serialize(new File(filePath), object);
    }

    @Override
    public void serialize(File resultFile, T object) {

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
    public void serialize(OutputStream os, T object) {
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
    public T deserialize(String filepath) {
        return deserialize(new File(filepath));

    }

    @Override
    public T deserialize(File file) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(file, getType());
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }


        logger.debug("converted from JSON");

        return obj;
    }

    @Override
    public T deserialize(InputStream is) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(is, getType());
        } catch (IOException e) {
            logger.debug(e.toString());
            e.printStackTrace();
        }

        logger.debug("converted from JSON");

        return obj;

    }
}