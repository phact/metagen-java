package io.virtdata.strings;

import io.virtdata.parserapi.FDoc;
import io.virtdata.parserapi.Input;
import io.virtdata.parserapi.Output;

import java.util.function.Function;

@Input(String.class)
@Output(String.class)
@FDoc("adds a String suffix to the input")
public class Suffix implements Function<String,String> {
    private String suffix;

    public Suffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String apply(String s) {
        return s + suffix;
    }
}
