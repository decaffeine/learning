package decaffeine.learning.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ContainsNullTest {
    @Test
    public void containsNull() {
        List<String> testList = Arrays.asList("A", "B", "C", null);
        assertThat(testList.contains(null)).isEqualTo(true);
    }

    @Test
    public void notContainsNull() {
        List<String> testList = Arrays.asList("A", "B", "C");
        assertThat(testList.contains(null)).isEqualTo(false);
    }

    @Test
    public void immutableList() {
        List<String> testList = List.of("A", "B", "C");
        assertThatThrownBy(() -> testList.contains(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void immutableListDoesNotAllowNull() {
        assertThatThrownBy(() -> List.of("A", "B", "C", null))
                .isInstanceOf(NullPointerException.class);
    }

}
