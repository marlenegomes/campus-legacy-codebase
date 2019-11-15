package com.gildedrose;

import com.google.common.collect.Range;

public class RuleSet {

    static final Rule increaseQualityByOneBrie = new Rule(Range.atLeast(0), quality -> quality + 1);
    static final Rule increaseQualityByTwoBrie = new Rule(Range.lessThan(0), quality -> quality + 2);

    static final Rule increaseQualityByTwoBackstage = new Rule(Range.closedOpen(6, 11), quality -> quality + 2);
    static final Rule increaseQualityByThreeBackstage = new Rule(Range.closedOpen(0, 6), quality -> quality + 3);
    static final Rule setQualityToZeroBackstage = new Rule(Range.lessThan(0), quality -> 0);

    static final Rule DecreaseQualityByOne = new Rule(Range.atLeast(0), quality -> quality - 1);
    static final Rule DecreaseQualityByTwo = new Rule(Range.lessThan(0), quality -> quality - 2);

    static final Rule DecreaseQualityByTwoConjured = new Rule(Range.atLeast(0), quality -> quality - 2);
    static final Rule DecreaseQualityByFourConjured = new Rule(Range.lessThan(0), quality -> quality - 4);

    static final Rule ruleSulfuras = new Rule(Range.all(), quality -> quality);

}
