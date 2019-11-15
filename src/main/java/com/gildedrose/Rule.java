package com.gildedrose;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rule {

    public static Rule ruleFor(Range<Integer> range, Action action) {
        return new Rule(range, action);
    }

    private final Range<Integer> range;
    private final Action action;


    interface Action {
        int execute(int quality);
    }

    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public Rule(Range<Integer> range, Action action) {
        this.range = range;
        this.action = action;
    }

    public void apply(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
        item.quality = action.execute(item.quality);
        if (item.quality > 50 && !item.name.equals("Red red wine") && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = 50;
        } else if (item.quality < 0) {
            item.quality = 0;
        }
    }

    public Range<Integer> getRange() {
        return range;
    }
}
