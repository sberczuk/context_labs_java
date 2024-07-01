package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreaterThanTest {
    record GreaterThanTestData(Integer lVal,
                               Integer rVal,
                               boolean want){}

    static Stream<GreaterThanTestData> data() {
        return Stream.of(new GreaterThanTestData(1, 2, false)
                , new GreaterThanTestData(2, 2, false)
                , new GreaterThanTestData(4, 3, true)
        );
    }


    // An Attempt to mimic table tests
    @ParameterizedTest()
    @MethodSource("data")
    void apply(GreaterThanTestData tt) {
        GreaterThan<Integer> c = new GreaterThan<>();
        boolean got = c.apply(tt.lVal, tt.rVal);
        assertEquals(tt.want, got, String.format("compare %d, %d", tt.lVal, tt.rVal));
    }
}
