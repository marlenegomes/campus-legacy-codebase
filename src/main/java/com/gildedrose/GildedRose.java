package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GildedRose {

    static Logger logger = LoggerFactory.getLogger(GildedRose.class);

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            logger.info("current items: " + items[i].name + "| quality: " + items[i].quality + " | sellIn: " + items[i].sellIn);
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                logger.info("item n'est pas Brie ni Backstage");
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        logger.info("Item quality baisse de 1");
                        items[i].quality = items[i].quality - 1;
                    }
                    if (items[i].name.contains("Conjured") && items[i].quality>0) {
                        logger.info("si conjured : Item quality baisse de 1 en plus");
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                logger.info("item = brie ou backstage");
                if (items[i].quality < 50) {
                    logger.info("item quality augmente de 1");
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.contains("Conjured") && items[i].quality<50) {
                        logger.info("si conjured : Item quality augmente de 1 en plus");
                        items[i].quality = items[i].quality + 1;
                    }

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                logger.info("si backstage et <11 : item quality augmente de 1" );
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                logger.info("si backstage et <6 : item quality augmente de 1 " + items[i].quality );
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("sellIn baisse de 1 " + items[i].sellIn);
                 items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                logger.info("item quality baisse de 1 :" + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                            }
                            if (items[i].name.contains("Conjured") && items[i].quality>0) {
                                logger.info("si conjured : Item quality baisse de 1 en plus: " + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                        logger.info("Backstage quality = 0");
                    }
                } else {
                    if (items[i].quality < 50) {
                        logger.info("item quality augmente de 1: " + items[i].quality );
                        items[i].quality = items[i].quality + 1;
                    }
                    if (items[i].name.contains("Conjured") && items[i].quality<50) {
                        logger.info("si conjured : Item quality augmente de 1 en plus: " + items[i].quality);
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            logger.info("item name: " + items[i].name  + "| item quality: " + items[i].quality + "| item sellIn : " + items[i].sellIn);
        }
    }

    public Item[] getItems() {
        return items;
    }
}