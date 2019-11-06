package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sulfuras extends Item {
    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void UpdateItem() {
        logger.info("c'est un sulfuras");
    }
}
