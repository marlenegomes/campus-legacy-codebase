package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GildedRose {

    static Logger logger = LoggerFactory.getLogger(GildedRose.class);

    Item[] items;

    public GildedRose(Item[] items) {
        for (int i = 0; i < items.length; i++) {
        logger.info("items: " + items[i]);
        }
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            if (items[i].name.contains("Conjured")) {
                                items[i].quality = items[i].quality - 2;
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                            } else {
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                            }
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    logger.info("item quality: " + items[i].quality);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                                logger.info("item quality: " + items[i].quality);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                                logger.info("item quality: " + items[i].quality);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("name item: " + items[i].name );
                items[i].sellIn = items[i].sellIn - 1;
                logger.info("item sellIn: " + items[i].sellIn);
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                                logger.info("item quality: " + items[i].quality);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                        logger.info("item quality: " + items[i].quality);

                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        logger.info("item quality: " + items[i].quality);
                    }
                }
            }
        }
    }

    public Item[] getItems() {
        return items;
    }
}