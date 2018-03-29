/*
 *
 *       Copyright 2015 Jonathan Shook
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package io.virtdata.basicsmappers.from_long.to_string;

import io.virtdata.annotations.ThreadSafeMapper;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongFunction;

/**
 * Integer devide the cycle, the other side of modulo.
 */
@ThreadSafeMapper
public class DivideToLongToString implements LongFunction<String> {

    private final long divisor;
    AtomicLong seq=new AtomicLong(0);

    public DivideToLongToString(long divisor) {
        this.divisor=divisor;
    }

    @Override
    public String apply(long operand) {
        return String.valueOf((operand / divisor));
    }
}