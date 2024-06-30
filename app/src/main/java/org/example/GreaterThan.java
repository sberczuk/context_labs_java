package org.example;

public class GreaterThan<T extends Comparable<T>> implements Operator<T>{

    @Override
    public boolean apply(T lVal, T rVal) {
        return lVal.compareTo(rVal) > 0;
    }


    @Override
    public String toString(){
        return ">";
    }
}
