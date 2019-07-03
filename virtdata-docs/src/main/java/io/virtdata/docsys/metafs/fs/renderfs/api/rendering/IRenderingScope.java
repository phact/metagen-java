package io.virtdata.docsys.metafs.fs.renderfs.api.rendering;

import io.virtdata.docsys.metafs.fs.renderfs.api.rendered.RenderedContent;
import io.virtdata.docsys.metafs.fs.renderfs.model.ViewModel;

public interface IRenderingScope extends Versioned {

    long getVersion();

    TemplateView getTemplate();

    ViewModel getViewModel();

    RenderedContent getRendered();
}
