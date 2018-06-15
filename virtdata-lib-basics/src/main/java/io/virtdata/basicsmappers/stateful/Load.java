package io.virtdata.basicsmappers.stateful;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;
import io.virtdata.threadstate.ThreadLocalState;

import java.util.HashMap;
import java.util.function.Function;

@ThreadSafeMapper
@Categories({Category.state})
public class Load implements Function<Object,Object> {

    private final String name;

    public Load(String name) {
        this.name = name;
    }

    @Override
    public Object apply(Object o) {

        HashMap<String, Object> map = ThreadLocalState.tl_ObjectMap.get();
        return map.get(name);
    }

}
