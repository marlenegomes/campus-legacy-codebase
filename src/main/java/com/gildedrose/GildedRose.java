package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("si non sulfuras || sellIn -1");
                item.sellIn--;
            }

            switch (item.name) {
                case "Aged Brie":
                    if (item.quality < 50) {
                        logger.info("si Aged Brie || quality +1");
                        item.quality++;
                        if (item.sellIn < 0 && item.quality < 50) {
                            logger.info("si Aged Brie et sellIn <0 et quality<50 || quality +1");
                            item.quality++;
                        }
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        logger.info("si Backstage et quality<50 || quality +1");
                        item.quality++;
                        if (item.sellIn < 11) {
                            logger.info("si Backstage et sellIn <11 || quality +1");
                            item.quality++;
                        }
                        if (item.sellIn < 6) {
                            logger.info("si Backstage et sellIn <6 || quality +1");
                            item.quality++;
                        }
                    }
                    if (item.quality > 50) {
                        logger.info("si Backstage quality>50 || quality = 50");
                        item.quality = 50;
                    }
                    if (item.sellIn <= 0) {
                        logger.info("si Backstage et sellIn <=0 || quality = 0");
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Red red wine":
                    if (item.sellIn >= 300) {
                        logger.info("si RedWine et sellIn >300 || quality +1");
                        item.quality++;
                    }
                    if (item.sellIn < 0) {
                        logger.info("si RedWine et sellIn <=0 || quality -1");
                        item.quality--;
                    }
                    break;
                default:
                    if (item.name.startsWith("Conjured")) {
                        logger.info("si Conjured || quality -1");
                        item.quality--;
                        if (item.sellIn < 0) {
                            logger.info("si Conjured et sellIn <0 || quality -1");
                            item.quality--;
                        }
                    }
                    logger.info("si normal ou conjured || quality -1");
                    item.quality--;
                    if (item.sellIn < 0) {
                        logger.info("si normal ou conjured et sellin<0 || quality -1");
                        item.quality--;
                    }
                    if (item.quality < 0) {
                        logger.info("si normal ou conjured et quality<0 || quality = 0");
                        item.quality = 0;
                    }
            }
            logger.debug("FIN : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);
        }
    }
}