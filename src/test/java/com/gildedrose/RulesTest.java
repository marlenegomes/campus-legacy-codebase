package com.gildedrose;

import com.google.common.collect.BoundType;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    @Test
    void shouldThrowWhenRangeIsNotTotal() {
        Assertions.assertThatThrownBy(
                () ->
                        new Rules(
                                Arrays.asList(
                                        new Rule(Range.closed(0, 10), quality -> quality)
                                )
                        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldBuildWhenRangeIsTotal() {
        Assertions.assertThatCode(
                () ->
                        new Rules(
                                Arrays.asList(
                                        new Rule(Range.atLeast(0), quality -> quality),
                                        new Rule(Range.lessThan(0), quality -> quality)
                                )
                        )).doesNotThrowAnyException();
    }
}