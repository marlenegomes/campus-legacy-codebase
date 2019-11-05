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
            logger.info("Début | item: " + items[i].name + ", sellIn : " + items[i].sellIn + ", quality :  " + items[i].quality);
            int quality = items[i].quality;
            int sellIn = items[i].sellIn;
            if(!items[i].name.equals("Sulfuras, Hand of Ragnaros")){
                logger.info("dans tous les cas sauf sulfuras: sellIn - 1");
                sellIn--;
            }

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("si sulfuras : sellIn inchangé");
            } else if (items[i].name.equals("Aged Brie")) {
                if (quality < 50) {
                    if (sellIn < 0) {
                        logger.info("Aged brie, quality < 50, sellIn < 0 || quality + 2");
                        quality = quality + 2;
                    } else {
                        logger.info("Aged brie, quality < 50, sellIn > 0 || quality + 1");
                        quality = quality + 1;
                    }
                }
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                logger.info("Backstage passes, quality + 1");
                if (sellIn <= 0) {
                    logger.info("Backstage passes, sellIN <=0 || quality=0");
                    quality = 0;
                } else {
                    if (sellIn < 11) {
                        logger.info("Backstage passes, sellIN <11 || quality + 1");
                        quality = quality + 2;
                    }
                    if (sellIn < 6) {
                        logger.info("Backstage passes, sellIN <6 || quality + 2");
                        quality = quality + 1;
                    }
                    if (sellIn  > 10) {
                        logger.info("Backstage passes, sellIN <6 || quality + 2");
                        quality = quality + 1;
                    }
                }
            } else if (items[i].name.startsWith("Conjured")) {
                if (quality > 0) {
                    logger.info("Conjured, quality >0 || quality -2 ");
                    quality = quality - 2;
                    quality = checkNegativeQuality(quality);
                }
                if (sellIn < 0) {
                    if (quality > 0) {
                        logger.info("Conjured, sellIn < 0 && quality >0 || quality -2 ");
                        quality = quality - 2;
                        quality = checkNegativeQuality(quality);
                    }
                }
            } else {
                if (quality > 0) {
                    logger.info("normal, quality > 0 || quality -1 ");
                    quality = quality - 1;
                    quality = checkNegativeQuality(quality);
                }
                if (sellIn < 0) {
                    logger.info("normal, sellIn < 0 || quality -1 ");
                    quality = quality - 1;
                    quality = checkNegativeQuality(quality);
                }
            }
            items[i].sellIn = sellIn;
            items[i].quality = quality;
            logger.info("FIN | item: " + items[i].name + ", sellIn : " + items[i].sellIn + ", quality :  " + items[i].quality);
        }

    }

    private int checkNegativeQuality(int quality) {
        if(quality < 0 ){
            quality = 0;
        }
        return quality;
    }

    public Item[] getItems() {
        return items;
    }
}