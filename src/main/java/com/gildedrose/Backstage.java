package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Backstage extends Item{
    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void UpdateItem() {
        super.UpdateItem();
        if (this.quality < 50) {
            logger.info("si Backstage et quality<50 || quality +1");
            this.quality++;
            if (this.sellIn < 11) {
                logger.info("si Backstage et sellIn <11 || quality +1");
                this.quality++;
            }
            if (this.sellIn < 6) {
                logger.info("si Backstage et sellIn <6 || quality +1");
                this.quality++;
            }
        }
        if (this.quality > 50) {
            logger.info("si Backstage quality>50 || quality = 50");
            this.quality = 50;
        }
        if (this.sellIn <= 0) {
            logger.info("si Backstage et sellIn <=0 || quality = 0");
            this.quality = 0;
        }
    }
}
