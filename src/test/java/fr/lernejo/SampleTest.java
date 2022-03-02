package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void op() {
        int result = sample.op(Sample.Operation.ADD, 1, 2);
        Assertions.assertThat(result).as("1 + 2").isEqualTo(3);
        result = sample.op(Sample.Operation.MULT, 2, 2);
        Assertions.assertThat(result).as("2 x 2").isEqualTo(4);
    }

    @Test
    void fact() {
        int result = sample.fact(4);
        Assertions.assertThat(result).as("fact de 4").isEqualTo(24);
    }

    @Test
    void failFact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            sample.fact(-1));
        Assertions.assertThat(exception.getMessage()).isEqualTo("N should be positive");

    }
}
