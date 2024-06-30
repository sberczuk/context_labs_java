package org.example;

public class BooleanAttribute implements ProductAttribute<Boolean>{
    String name;
    Boolean value;


    public BooleanAttribute(String name, Boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public AttributeType GetType() {
        return AttributeType.BOOLEAN;
    }

    @Override
    public Boolean GetValue() {
        return this.value;
    }

    @Override
    public String GetName() {
        return this.name;
    }
}
