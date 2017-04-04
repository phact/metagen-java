package io.virtdata.ast;

public interface ModelTraverser {

    void model(MetagenModel model);

    void flow(MetagenFlow flow);

    void expression(Expression e);

    <U> U assignment(String s);
}
