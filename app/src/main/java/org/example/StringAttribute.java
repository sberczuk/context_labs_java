package org.example;

public class StringAttribute implements ProductAttribute<String> {
    String value;
    String name;

    @Override
    public AttributeType GetType() {
        return AttributeType.STRING;
    }

    @Override
   public  String GetValue() {
        return value;
    }

    @Override
    public String GetName() {
        return name;
    }

    public StringAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }


}
