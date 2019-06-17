package io.virtdata.libbasics.shared.from_long.to_long;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpolateTest {

    @Test
    public void testDeciles() {
        long topvalue = 1_000_000_000L;

        Interpolate f = new Interpolate(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, topvalue);
        long min = f.applyAsLong(0L);
        assertThat(min).isEqualTo(0L);

        long expected = (long)(((double)topvalue) * .8);
        System.out.println("expected long at 80% of maximum value:" + expected);

        long highvalue = (long) (Long.MAX_VALUE * 0.98d);
        long high = f.applyAsLong(highvalue);
        assertThat(high).isEqualTo(expected);

        long highervalue = (long) (Long.MAX_VALUE * 0.9999d);
        long higher = f.applyAsLong(highervalue);
        assertThat(higher).isEqualTo(999000000L);

        long max = f.applyAsLong(Long.MAX_VALUE);
        assertThat(max).isEqualTo(1000000000L);

    }
}