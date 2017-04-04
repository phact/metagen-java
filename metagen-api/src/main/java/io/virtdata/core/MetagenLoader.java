package io.virtdata.core;

import io.virtdata.ast.MetagenModel;
import io.virtdata.parser.MetagenLanguage;

import java.io.Reader;
import java.io.StringReader;

public class MetagenLoader {

    private MetagenLoader() {}
    public static MetagenLoader forRecipe(String recipe) {
        StringReader stringReader = new StringReader(recipe);
        return forRecipe(stringReader);
    }

    public static MetagenLoader forRecipe(Reader reader) {
        MetagenModel model = MetagenLanguage.parse(reader);

    }
}
