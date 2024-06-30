package org.example;


public interface ProductAttribute<T extends Comparable<T>> {
    AttributeType GetType();

    T GetValue();

    String GetName();

    default String asString() {
        return String.format("%s: %s\n", GetName(), GetValue());
    }


}


