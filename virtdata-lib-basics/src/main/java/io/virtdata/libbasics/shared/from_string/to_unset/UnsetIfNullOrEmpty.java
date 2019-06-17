package io.virtdata.libbasics.shared.from_string.to_unset;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;
import io.virtdata.api.VALUE;

import java.util.function.Function;

@Categories(Category.nulls)
@ThreadSafeMapper
public class UnsetIfNullOrEmpty implements Function<String,Object> {
    
    @Override
    public Object apply(String s) {
        if (s==null || s.isEmpty()) {
            return VALUE.unset;
        }
        return s;
    }
}
