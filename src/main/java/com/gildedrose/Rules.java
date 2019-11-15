package com.gildedrose;

import com.google.common.collect.*;

import java.util.Arrays;
import java.util.List;

public class Rules {

    public static Rules of(Rule... rules) {
        return new Rules(Arrays.asList(rules));
    }

    private final List<Rule> ruleList;

    public Rules(List<Rule> ruleList) {
        checkRuleListCoverIntDomain(ruleList);
        this.ruleList = ruleList;
    }

    private void checkRuleListCoverIntDomain(List<Rule> ruleList) {
        TreeRangeSet<Integer> union = TreeRangeSet.create();
        for (Rule rule : ruleList) {
            union.add(rule.getRange());
        }
        TreeRangeSet<Integer> all = TreeRangeSet.create();
        all.add(Range.all());
        if (!union.enclosesAll(all)) {
            throw new IllegalArgumentException();
        }
    }

    public void apply(Item item) {
        for (Rule rule : this.ruleList) {
            if (rule.getRange().contains(item.sellIn)) {
                rule.apply(item);
            }
        }
    }
}
