package io.virtdata.libbasics.shared.from_double.to_unset;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;
import io.virtdata.api.VALUE;

import java.util.function.DoubleFunction;

@ThreadSafeMapper
@Categories(Category.nulls)
public class UnsetIfGe implements DoubleFunction<Object> {

    private final double compareto;

    public UnsetIfGe(double compareto) {
        this.compareto = compareto;
    }

    @Override
    public Object apply(double value) {
        if (value >= this.compareto) return VALUE.unset;
        return value;
    }
}