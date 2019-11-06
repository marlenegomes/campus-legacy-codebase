package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Item {
    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void UpdateItem() {
        logger.info("Mise à jour sellIn");
        this.sellIn--;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}