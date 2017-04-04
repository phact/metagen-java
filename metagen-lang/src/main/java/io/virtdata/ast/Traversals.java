package io.virtdata.ast;

import java.util.Optional;

public class Traversals {

    private final MetagenModel model;

    public Traversals(MetagenModel model) {
        this.model = model;
    }

    public void traverse(ModelTraverser traverser) {
        traverser.model(model);
        for (MetagenFlow flow : model.getFlows()) {
            traverser.flow(flow);
            for (Expression e : flow.getExpressions()) {
                traverser.expression(e);
                Optional.ofNullable(e.getAssignment())
                        .map(Assignment::getVariableName)
                        .ifPresent(traverser::assignment);

                Optional.ofNullable(e.getCall().getInputType())
                        .map(FunctionCall::getInputType)
                        .ifPresent();
                if (e.getAssignment()!=null) {
                    traverser.assignment(e.getAssignment().getVariableName());
                }
            }
        }

    }

}
