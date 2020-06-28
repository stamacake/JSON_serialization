package com.vtbschool;

import com.vtbschool.exceptions.NoSuchSerializerException;
import com.vtbschool.serializers.AnySerializer;
import com.vtbschool.serializers.jsonserializer.JSONSerializer;
import com.vtbschool.serializers.xmlserializer.XMLSerializer;

public class SerializationFactory<T> {

    Class<T> type;
    public SerializationFactory(Class<T> type) {
        this.type = type;
    }

    public AnySerializer getSerializer(Serializers serializer) {
        switch (serializer) {
            case XML:
                return new XMLSerializer(type);
            case JSON:
                return new JSONSerializer(type);
        }
        throw new NoSuchSerializerException();
    }

    public AnySerializer<T> getXMLSerializer() {
        return new XMLSerializer(type);
    }

    public AnySerializer<T> getJSONSerializer() {
        return new JSONSerializer(type);
    }
}
