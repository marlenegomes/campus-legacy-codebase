package com.gildedrose;

import com.google.common.collect.*;

import java.util.List;

public class Rules {

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
        for (int i=0; i < this.ruleList.size(); i++) {
            if (this.ruleList.get(i).getRange().contains(item.sellIn)  ) {
                this.ruleList.get(i).apply(item);
            }
            }
        }
    }
