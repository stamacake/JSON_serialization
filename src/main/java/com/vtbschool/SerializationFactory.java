package com.vtbschool;

import com.vtbschool.exceptions.NoSuchSerializerException;
import com.vtbschool.jsonserializer.JSONSerializer;
import com.vtbschool.xmlserializer.XMLSerializer;

public class SerializationFactory {

    public SerializationFactory() {
    }

    public InternSerializer getSerilizer(Serializers serializer) {
        switch (serializer) {
            case XML:
                return new XMLSerializer();
            case JSON:
                return new JSONSerializer();
        }
        throw new NoSuchSerializerException();
    }

    public InternSerializer getXMLSerializer() {
        return new XMLSerializer();
    }

    public InternSerializer getJSONSerializer() {
        return new JSONSerializer();
    }
}
