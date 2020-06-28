package com.vtbschool.main;

import com.vtbschool.SerializationFactory;
import com.vtbschool.fromxsd.rubenaidar.Root;

public class Main {

    public static void main(String[] args) {
        SerializationFactory<Root> sf = new SerializationFactory<>(Root.class);

        Root root = sf.getXMLSerializer().deserialize("C:\\Users\\User\\Documents\\Projects\\JSON_serialization\\src\\main\\resources\\team.xml");
        System.out.println(root);

    }

}
