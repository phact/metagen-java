package io.virtdata.api.composers;

import io.virtdata.api.FunctionType;
import io.virtdata.api.ValueType;

import java.util.function.*;

public class ComposerForFunction implements FunctionComposer<Function<?,?>> {

    private final Function<?,?> inner;

    public ComposerForFunction(Function<?, ?> inner) {
        this.inner = inner;
    }

    @Override
    public Object getFunctionObject() {
        return inner;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FunctionComposer andThen(Object outer) {
        FunctionType functionType = FunctionType.valueOf(outer);
        Object outv = ((Function<Object,Object>)this.inner).apply(1);
        ValueType itype = ValueType.valueOfAssignableClass(outv.getClass());

        switch (functionType) {

            case long_long:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((LongUnaryOperator) outer).applyAsLong(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((LongUnaryOperator) outer).applyAsLong(((Function<Object, Double>) inner).apply(o).longValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((LongUnaryOperator) outer).applyAsLong(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((LongUnaryOperator) outer).applyAsLong(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).longValue());
                        return new ComposerForFunction(f14);
                }
            case long_int:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((LongToIntFunction) outer).applyAsInt(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((LongToIntFunction) outer).applyAsInt(((Function<Object, Double>) inner).apply(o).longValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((LongToIntFunction) outer).applyAsInt(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((LongToIntFunction) outer).applyAsInt(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).longValue());
                        return new ComposerForFunction(f14);
                }
            case long_double:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((LongToDoubleFunction) outer).applyAsDouble(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((LongToDoubleFunction) outer).applyAsDouble(((Function<Object, Double>) inner).apply(o).longValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((LongToDoubleFunction) outer).applyAsDouble(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((LongToDoubleFunction) outer).applyAsDouble(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).longValue());
                        return new ComposerForFunction(f14);
                }
            case long_T:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((LongFunction<Object>) outer).apply(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((LongFunction<Object>) outer).apply(((Function<Object, Double>) inner).apply(o).longValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((LongFunction<Object>) outer).apply(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((LongFunction<Object>) outer).apply(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).longValue());
                        return new ComposerForFunction(f14);
                }
            case R_T:
                final Function<Object,Object> f5=
                        (Object o) ->
                                ((Function<Object,Object>)outer).apply(((Function<Object,Object>)inner).apply(o));
                return new ComposerForFunction(f5);
            case int_int:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((IntUnaryOperator) outer).applyAsInt(((Function<Object, Long>) inner).apply(o).intValue());
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((IntUnaryOperator) outer).applyAsInt(((Function<Object, Double>) inner).apply(o).intValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((IntUnaryOperator) outer).applyAsInt(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((IntUnaryOperator) outer).applyAsInt(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).intValue());
                        return new ComposerForFunction(f14);
                }
            case int_long:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((IntToLongFunction) outer).applyAsLong(((Function<Object, Long>) inner).apply(o).intValue());
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((IntToLongFunction) outer).applyAsLong(((Function<Object, Double>) inner).apply(o).intValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((IntToLongFunction) outer).applyAsLong(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((IntToLongFunction) outer).applyAsLong(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).intValue());
                        return new ComposerForFunction(f14);
                }
            case int_double:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((IntToDoubleFunction) outer).applyAsDouble(((Function<Object, Long>) inner).apply(o).intValue());
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((IntToDoubleFunction) outer).applyAsDouble(((Function<Object, Double>) inner).apply(o).intValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((IntToDoubleFunction) outer).applyAsDouble(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((IntToDoubleFunction) outer).applyAsDouble(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).intValue());
                        return new ComposerForFunction(f14);
                }
            case int_T:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((IntFunction<Object>) outer).apply(((Function<Object, Long>) inner).apply(o).intValue());
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((IntFunction<Object>) outer).apply(((Function<Object, Double>) inner).apply(o).intValue());
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((IntFunction<Object>) outer).apply(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((IntFunction<Object>) outer).apply(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()).intValue());
                        return new ComposerForFunction(f14);
                }
            case double_double:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((DoubleUnaryOperator) outer).applyAsDouble(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((DoubleUnaryOperator) outer).applyAsDouble(((Function<Object, Double>) inner).apply(o));
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((DoubleUnaryOperator) outer).applyAsDouble(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((DoubleUnaryOperator) outer).applyAsDouble(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()));
                        return new ComposerForFunction(f14);
                }
            case double_int:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((DoubleToIntFunction) outer).applyAsInt(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((DoubleToIntFunction) outer).applyAsInt(((Function<Object, Double>) inner).apply(o));
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((DoubleToIntFunction) outer).applyAsInt(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((DoubleToIntFunction) outer).applyAsInt(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()));
                        return new ComposerForFunction(f14);
                }
            case double_long:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((DoubleToLongFunction) outer).applyAsLong(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((DoubleToLongFunction) outer).applyAsLong(((Function<Object, Double>) inner).apply(o));
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((DoubleToLongFunction) outer).applyAsLong(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((DoubleToLongFunction) outer).applyAsLong(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()));
                        return new ComposerForFunction(f14);
                }
            case double_T:
                switch (itype) {
                    case LONG:
                        final Function<Object, Object> f11 = (Object o) ->
                                ((DoubleFunction<Object>) outer).apply(((Function<Object, Long>) inner).apply(o));
                        return new ComposerForFunction(f11);
                    case DOUBLE:
                        final Function<Object, Object> f12 = (Object o) ->
                                ((DoubleFunction<Object>) outer).apply(((Function<Object, Double>) inner).apply(o));
                        return new ComposerForFunction(f12);
                    case INT:
                        final Function<Object, Object> f13 = (Object o) ->
                                ((DoubleFunction<Object>) outer).apply(((Function<Object, Integer>) inner).apply(o));
                        return new ComposerForFunction(f13);
                    default:
                        final Function<Object, Object> f14 = (Object o) ->
                                ((DoubleFunction<Object>) outer).apply(Double.valueOf(((Function<Object, Object>) inner).apply(o).toString()));
                        return new ComposerForFunction(f14);
                }
            default:
                throw new RuntimeException(functionType + " is not recognized");

        }
    }
}
