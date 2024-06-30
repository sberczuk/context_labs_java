package org.example;

public class EqualsOperator<T extends Comparable<T>> implements Operator<T> {
    @Override
    public boolean apply(T lVal, T rVal) {
       // System.out.printf("comparing %s, %s\n", lVal, rVal);
        return lVal.compareTo(rVal) == 0;
    }

    @Override
    public String toString(){
        return "==";
    }

}
