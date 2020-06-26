package com.vtbschool;

import com.vtbschool.model.Intern;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public interface InternSerializer {
    void serialize(String filePath, Intern object);

    void serialize(File resultFile, Intern object);

    void serialize(OutputStream os, Intern object);

    Intern deserialize(String filepath);

    Intern deserialize(File file);

    Intern deserialize(InputStream is);


}
