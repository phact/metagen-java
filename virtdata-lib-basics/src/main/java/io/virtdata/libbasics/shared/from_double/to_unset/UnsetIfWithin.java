package io.virtdata.libbasics.shared.from_double.to_unset;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;
import io.virtdata.api.VALUE;

import java.util.function.DoubleFunction;

/**
 * Yields UNSET.value if the input value is within the specified
 * range, inclusive. Otherwise, passes the original value along.
 */
@ThreadSafeMapper
@Categories(Category.nulls)
public class UnsetIfWithin implements DoubleFunction<Object> {


    private final double min;
    private final double max;

    public UnsetIfWithin(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Object apply(double value) {
        if (value>=min && value <=max) { return VALUE.unset; }
        return value;
    }
}