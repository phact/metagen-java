package io.virtdata.parserapi;

public interface DataMapper<R> {
    R get(long input);
}
