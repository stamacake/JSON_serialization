package com.vtbschool.serializers;

import com.vtbschool.model.Group;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public interface AnySerializer<T> {
    void serialize(String filePath, T object);

    void serialize(File resultFile, T object);

    void serialize(OutputStream os, T object);

    T deserialize(String filepath);

    T deserialize(File file);

    T deserialize(InputStream is);


}
