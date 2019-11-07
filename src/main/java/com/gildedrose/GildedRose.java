package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.ArrayList;

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
        for (int i = 0; i < items.length; i++) {

            Item item = items[i];
            logger.debug("DEBUT : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);

            applyUpdate(item, RulesFactory(item));

            logger.debug("FIN : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);
        }
    }

    private Rules RulesFactory(Item item) {
        Rules ruleList;
        switch (item.name) {
            case "Aged Brie":
                ruleList = new Rules(Arrays.asList(
                        RuleSet.increaseQualityByOneBrie,
                        RuleSet.increaseQualityByTwoBrie
                ));
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                ruleList = new Rules(Arrays.asList(
                        RuleSet.increaseQualityByOneBackstage,
                        RuleSet.increaseQualityByTwoBackstage,
                        RuleSet.increaseQualityByThreeBackstage,
                        RuleSet.setQualityToZeroBackstage
                ));
                break;
            case "Sulfuras, Hand of Ragnaros":
                ruleList = new Rules(Arrays.asList(
                        RuleSet.ruleSulfuras
                ));
                break;
            case "Red red wine":
                ruleList = new Rules(Arrays.asList(
                        RuleSet.increaseQualityByOneWine,
                        RuleSet.decreaseQualityByOneWine,
                        RuleSet.maintainQualityWine
                ));
                break;
            default:
                if (item.name.startsWith("Conjured")) {
                    ruleList = new Rules(Arrays.asList(
                            RuleSet.DecreaseQualityByTwoConjured,
                            RuleSet.DecreaseQualityByFourConjured
                    ));
                } else {
                    ruleList = new Rules(Arrays.asList(
                            RuleSet.DecreaseQualityByOne,
                            RuleSet.DecreaseQualityByTwo
                    ));
                }
        }
        return ruleList;
    }

    private void applyUpdate(Item item, Rules rules) {
        rules.apply(item);
    }


}