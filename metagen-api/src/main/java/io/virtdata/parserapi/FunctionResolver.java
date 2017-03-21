package io.virtdata.parserapi;

import io.virtdata.core.ResolvedFunction;

public interface FunctionResolver {
    ResolvedFunction getResolvedFunction(String spec);
}
