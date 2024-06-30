package org.example;

import java.util.Comparator;
import java.util.Objects;

public class LessThan<T extends Comparable<T>> implements Operator<T>{

    @Override
    public boolean apply(T lVal, T rVal) {
        return lVal.compareTo(rVal) < 0;
    }


    @Override
    public String toString(){
        return "<";
    }
}
