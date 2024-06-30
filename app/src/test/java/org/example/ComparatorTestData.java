package org.example;

import java.util.stream.Stream;

public class ComparatorTestData {
    public String testName;
    public String lValue;
    public String rValue;
    public boolean expectedResult;

    public ComparatorTestData(String testName, String lValue, String rValue, boolean expectedResult) {
        this.testName = testName;
        this.lValue = lValue;
        this.rValue = rValue;
        this.expectedResult = expectedResult;
    }


    static Stream<ComparatorTestData> stringEqualData() {
        return Stream.of(
                new ComparatorTestData("pass", "RED", "RED", true),
                new ComparatorTestData("fail", "RED", "GREEN", false)
        );
    }
}
