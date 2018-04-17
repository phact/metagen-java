package io.virtdata.basicsmappers.from_long.to_long;

import io.virtdata.annotations.*;

import java.util.function.LongUnaryOperator;

@Description("Return an interpolated number along a")
@Input(Range.NonNegativeLongs)
@Output(Range.Longs)
@Example("Interpolate(0.0,100.0) // return a linear value, 0L -> 0.0D, Long.MAX_VALUE -> 100.0D")
@ThreadSafeMapper
public class Interpolate implements LongUnaryOperator {

    private final int resolution;
    private final double[] lut;

    public Interpolate(double... value) {
        this(value.length, value);
    }

    public Interpolate(long... value) {
        double[] doubles = new double[value.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i]=(double)value[i];
        }
        this.resolution=doubles.length;
        this.lut = doubles;
    }

    public Interpolate(int resolution, double[] lut) {
        this.resolution = resolution;
        this.lut = lut;
    }

    @Override
    public long applyAsLong(long input) {
        long value = input;
        double unit = (double) value / (double) Long.MAX_VALUE;
        double samplePoint = unit * resolution;
        int leftidx = (int) samplePoint;
        double leftPartial = samplePoint - leftidx;

        double leftComponent=(lut[leftidx] * (1.0-leftPartial));
        double rightComponent = (lut[leftidx+1] * leftPartial);

        double sample = leftComponent + rightComponent;
        return (long) sample;
    }
}
