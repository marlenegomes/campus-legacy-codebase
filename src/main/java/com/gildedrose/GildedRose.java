package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.gildedrose.Rule.ruleFor;
import static com.google.common.collect.Range.*;

public class GildedRose {
    Item[] items;

    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {

            logger.debug("DEBUT : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);

            applyUpdate(item, RulesFactory(item));

            logger.debug("FIN : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);
        }
    }

    private Rules RulesFactory(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return Rules.of(
                        RuleSet.increaseQualityByOneBrie,
                        RuleSet.increaseQualityByTwoBrie
                );
            case "Backstage passes to a TAFKAL80ETC concert":
                return Rules.of(
                        new Rule(atLeast(11), upgrade()),
                        RuleSet.increaseQualityByTwoBackstage,
                        RuleSet.increaseQualityByThreeBackstage,
                        RuleSet.setQualityToZeroBackstage
                );
            case "Sulfuras, Hand of Ragnaros":
                return Rules.of(
                        RuleSet.ruleSulfuras
                );
            case "Red red wine":
                return Rules.of(
                        ruleFor(atLeast(300), incrementQuality()),
                        ruleFor(lessThan(0), decrementQuality()),
                        ruleFor(closedOpen(0, 300), stableQuality())
                );
            default:
                if (item.name.startsWith("Conjured")) {
                    return Rules.of(
                            RuleSet.DecreaseQualityByTwoConjured,
                            RuleSet.DecreaseQualityByFourConjured
                    );
                } else {
                    return Rules.of(
                            RuleSet.DecreaseQualityByOne,
                            RuleSet.DecreaseQualityByTwo
                    );
                }
        }
    }

    private Rule.Action upgrade() {
        return quality -> quality + 1;
    }

    private Rule.Action stableQuality() {
        return quality -> quality;
    }

    private Rule.Action decrementQuality() {
        return quality -> quality - 1;
    }

    private Rule.Action incrementQuality() {
        return quality -> quality + 1;
    }

    private void applyUpdate(Item item, Rules rules) {
        rules.apply(item);
    }


}