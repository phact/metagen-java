package io.virtdata;

import io.virtdata.api.DataMapper;
import io.virtdata.core.VirtData;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class IntegratedRealerTests {

    public void testLastNames() {
        DataMapper mapper = VirtData.getOptionalMapper("LastNames()").orElse(null);
        assertThat(mapper).isNotNull();
        assertThat(mapper.get(0L)).isEqualTo("Vanderploeg");
    }

    public void testFirstNames() {
        DataMapper mapper = VirtData.getOptionalMapper("FirstNames()").orElse(null);
        assertThat(mapper).isNotNull();
        assertThat(mapper.get(0L)).isEqualTo("Leigh");
    }

    public void testFemaleNames() {
        DataMapper mapper = VirtData.getOptionalMapper("FemaleFirstNames()").orElse(null);
        assertThat(mapper).isNotNull();
        assertThat(mapper.get(0L)).isEqualTo("Jewell");
    }

    public void testMaleNames() {
        DataMapper mapper = VirtData.getOptionalMapper("MaleFirstNames()").orElse(null);
        assertThat(mapper).isNotNull();
        assertThat(mapper.get(0L)).isEqualTo("Brad");
    }

    public void testFullNames() {
        DataMapper mapper = VirtData.getOptionalMapper("FullNames()").orElse(null);
        assertThat(mapper).isNotNull();
        assertThat(mapper.get(0L)).isEqualTo("Leigh Vanderploeg");
    }



}
