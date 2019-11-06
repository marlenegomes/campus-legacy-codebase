package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Normal extends Item {

    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public Normal(String name, int sellIn, int quality) {
           super(name, sellIn, quality);
        }

    @Override
    public void UpdateItem() {
        super.UpdateItem();
        logger.info("si normal ou conjured || quality -1");
        this.quality--;
        if (this.sellIn < 0) {
            logger.info("si normal ou conjured et sellin<0 || quality -1");
            this.quality--;
        }
        if (this.quality < 0) {
            logger.info("si normal ou conjured et quality<0 || quality = 0");
            this.quality = 0;
        }
    }
}
