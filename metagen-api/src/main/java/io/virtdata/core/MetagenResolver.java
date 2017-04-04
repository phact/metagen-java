package io.virtdata.core;

import io.virtdata.ast.MetagenModel;

public class MetagenResolver {
    private final MetagenModel model;

    public MetagenResolver(MetagenModel model) {
        this.model = model;
    }

    public VirtDataSet resolve() {
        VirtDataSet vds = new VirtDataSet();

        model.getFlows().forEach(
                f -> f.getExpressions()
        );

    }

}
