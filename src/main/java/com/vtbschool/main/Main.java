package com.vtbschool.main;

import com.vtbschool.serializers.AnySerializer;
import com.vtbschool.SerializationFactory;
import com.vtbschool.Serializers;
import com.vtbschool.model.Group;

public class Main {

    public static void main(String[] args) {
        SerializationFactory factory = new SerializationFactory();
        AnySerializer serializer = factory.getSerializer(Serializers.JSON);

        Group group = new Group();
        group.setId(112);


        serializer.serialize("group.json", group);

        Group gr = serializer.deserialize("group.json");
    }

}
