package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreaterThanTest {
    static class GreaterhanTestData{
        Integer lVal;
        Integer rVal;
        public GreaterhanTestData(Integer lVal, Integer rVal, boolean want) {
            this.lVal = lVal;
            this.rVal = rVal;
            this.want = want;
        }

        boolean want;
    }

    static Stream<GreaterhanTestData> data(){
        return Stream.of(new GreaterhanTestData(1,2,false)
                , new GreaterhanTestData(2,2,false)
                , new GreaterhanTestData(4,3,true)
        );
    }


    // An Attempt to mimic table tests
    @ParameterizedTest()
    @MethodSource("data")
    void apply(GreaterhanTestData tt) {
        GreaterThan<Integer> c = new GreaterThan<>();
        boolean got = c.apply(tt.lVal, tt.rVal);
        assertEquals( tt.want, got,String.format("compare %d, %d", tt.lVal, tt.rVal));
    }
}
