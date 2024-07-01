package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LessThanTest {
    static class LessThanTestData{
        Integer lVal;
        Integer rVal;
        public LessThanTestData(Integer lVal, Integer rVal, boolean want) {
            this.lVal = lVal;
            this.rVal = rVal;
            this.want = want;
        }

        boolean want;
    }

    static Stream<LessThanTestData> data(){
        return Stream.of(new LessThanTestData(1,2,true)
        , new LessThanTestData(2,2,false)
        , new LessThanTestData(2,3,true)
        );
    }


    // An Attempt to mimic table tests
    @ParameterizedTest()
    @MethodSource("data")
    void apply(LessThanTestData tt) {
        LessThan<Integer> c = new LessThan<>();
        boolean got = c.apply(tt.lVal, tt.rVal);
        assertEquals( tt.want, got,String.format("compare %d, %d", tt.lVal, tt.rVal));
    }
}