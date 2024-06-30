package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualsTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @ParameterizedTest()
    @MethodSource("org.example.ComparatorTestData#stringEqualData")
    void apply(ComparatorTestData tt) {

        EqualsOperator equalsOperator = new EqualsOperator();
        assertEquals(tt.expectedResult, equalsOperator.apply(tt.lValue, tt.rValue));
    }
}