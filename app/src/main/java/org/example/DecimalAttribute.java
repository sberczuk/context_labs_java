package org.example;

import java.math.BigDecimal;

public class DecimalAttribute implements ProductAttribute<BigDecimal> {
    String name;
    BigDecimal value;

    @Override
    public AttributeType GetType() {
        return null;
    }

    @Override
    public BigDecimal GetValue() {
        return value;
    }

    @Override
    public String GetName() {
        return this.name;
    }

    public DecimalAttribute(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }
}
