package com.vtbschool.serializers;

public abstract class AbstractSerializer<T> implements AnySerializer<T> {
    private Class<T> type;

    public AbstractSerializer(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }
}
