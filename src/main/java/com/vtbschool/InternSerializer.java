package com.vtbschool;

import com.vtbschool.model.Group;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public interface InternSerializer {
    void serialize(String filePath, Group object);

    void serialize(File resultFile, Group object);

    void serialize(OutputStream os, Group object);

    Group deserialize(String filepath);

    Group deserialize(File file);

    Group deserialize(InputStream is);


}
