package io.virtdata.longs;

import java.util.function.LongUnaryOperator;

public class HashRange implements LongUnaryOperator {

    private final long minValue;
    private final long width;
    private final Hash hash = new Hash();

    public HashRange(long minValue, long maxValue) {
        this.minValue = minValue;

        if (maxValue<minValue) {
            throw new RuntimeException("CycleRange must have min and max value in that order.");
        }
        this.width = maxValue - minValue;
    }

    @Override
    public long applyAsLong(long operand) {
        return minValue + (hash.applyAsLong(operand) % width);
    }
}