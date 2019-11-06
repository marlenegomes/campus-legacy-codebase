package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedWine extends Item {
    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public RedWine(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void UpdateItem() {
        super.UpdateItem();
        if (this.sellIn >= 300) {
            logger.info("si RedWine et sellIn >300 || quality +1");
            this.quality++;
        }
        if (this.sellIn < 0) {
            logger.info("si RedWine et sellIn <=0 || quality -1");
            this.quality--;
        }
    }
}
