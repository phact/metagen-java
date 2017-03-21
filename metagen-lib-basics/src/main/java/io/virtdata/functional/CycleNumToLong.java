package io.virtdata.functional;

import io.virtdata.parserapi.Desc;
import io.virtdata.parserapi.Example;

import java.util.function.LongUnaryOperator;

/**
 * This is here for completeness. It's nothing but an identity function, only
 * named in a way that it can be found.
 */
@Desc("an identify function that simply returns the input as long")
@Example("CycleNumToLong")
public class CycleNumToLong implements LongUnaryOperator {

    @Override
    public long applyAsLong(long operand) {
        return operand;
    }
}
