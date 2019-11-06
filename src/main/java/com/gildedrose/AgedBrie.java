package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgedBrie extends Item {
    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void UpdateItem() {
        super.UpdateItem();
        if (this.quality < 50) {
            logger.info("si Aged Brie || quality +1");
            this.quality++;
            if (this.sellIn < 0 && this.quality < 50) {
                logger.info("si Aged Brie et sellIn <0 et quality<50 || quality +1");
                this.quality++;
            }
        }
    }
}
