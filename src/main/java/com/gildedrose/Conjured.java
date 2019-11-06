package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conjured extends Normal {

    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void UpdateItem() {
        super.UpdateItem();
        if (name.startsWith("Conjured")) {
            logger.info("si Conjured || quality -1");
            this.quality -= 2;
            if (this.sellIn < 0) {
                logger.info("si Conjured et sellIn <0 || quality -1");
                this.quality -= 2;
            }
        }
    }
}
