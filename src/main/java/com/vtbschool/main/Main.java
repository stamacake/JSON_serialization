package com.vtbschool.main;

import com.vtbschool.InternSerializer;
import com.vtbschool.SerializationFactory;
import com.vtbschool.Serializers;
import com.vtbschool.model.Intern;

public class Main {

    public static void main(String[] args) {
        SerializationFactory factory = new SerializationFactory();
        InternSerializer serializer = factory.getSerializer(Serializers.JSON);

        Intern intern = new Intern();
        intern.setFirstName("dsdss");

        serializer.serialize("intern1.json", intern);

        Intern intern2 = serializer.deserialize("intern1.json");
    }

}
