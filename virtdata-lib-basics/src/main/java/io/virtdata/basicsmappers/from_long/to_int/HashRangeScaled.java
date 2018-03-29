package io.virtdata.basicsmappers.from_long.to_int;

import io.virtdata.annotations.ThreadSafeMapper;
import io.virtdata.basicsmappers.from_long.to_long.Hash;

import java.util.function.LongToIntFunction;

/**
 * Uses the input value as well to establish the upper bound of the
 * value produced from the hash.
 */
@ThreadSafeMapper
public class HashRangeScaled implements LongToIntFunction {

    private final Hash hash = new Hash();

    @Override
    public int applyAsInt(long operand) {
        if (operand==0) { return 0; }
        long l = hash.applyAsLong(operand);
        return (int) ((l % operand) % Integer.MAX_VALUE);
    }
}
