package org.example;

public class Condition<T extends Comparable<T>> {
    private final String attribName;
    private final Operator<T> op;
    private final T value;

    public Condition(String attribName, Operator<T> op, T value) {
        this.attribName = attribName;
        this.op = op;
        this.value = value;
    }

    public boolean apply(Product p) {
        ProductAttribute attribute = p.getAttribute(attribName);
        if (attribute == null) {
            // if the rule doesn't apply, treat it was passed
            return true;
        }

        // need to add a type assertion here
        return this.op.apply((T) attribute.GetValue(), value);
    }

    @Override
    public String toString(){
        return String.format("%s %s %s", attribName, op, value);
    }
}
