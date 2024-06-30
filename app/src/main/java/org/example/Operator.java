package org.example;

public interface Operator<T extends Comparable<T>>{
    abstract boolean apply( T lVal, T rVal);
}

