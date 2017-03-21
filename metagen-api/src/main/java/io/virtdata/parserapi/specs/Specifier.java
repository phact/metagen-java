package io.virtdata.parserapi.specs;

import io.virtdata.parserapi.ValueType;

import java.util.Optional;

public interface Specifier {
    public Optional<ValueType> getResultType();
    public String getCanonicalSpec();
}
