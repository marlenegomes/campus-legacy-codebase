package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    private Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            Item item = items[i];
            logger.debug("DEBUT : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);

            switch (item.name) {
                case "Aged Brie":
                    AgedBrie agedbrie = new AgedBrie(item.name, item.sellIn, item.quality);
                    agedbrie.UpdateItem();
                    applyUpdate(item, agedbrie);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    Backstage backstage = new Backstage(item.name, item.sellIn, item.quality);
                    backstage.UpdateItem();
                    applyUpdate(item, backstage);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    Sulfuras sulfuras = new Sulfuras(item.name, item.sellIn, item.quality);
                    sulfuras.UpdateItem();
                    break;
                case "Red red wine":
                    RedWine redwine = new RedWine(item.name, item.sellIn, item.quality);
                    redwine.UpdateItem();
                    applyUpdate(item, redwine);
                    break;
                default:
                    if(item.name.startsWith("Conjured")){
                        Conjured conjured = new Conjured(item.name, item.sellIn, item.quality);
                        conjured.UpdateItem();
                        applyUpdate(item, conjured);
                    }else {
                        Normal normal = new Normal(item.name, item.sellIn, item.quality);
                        normal.UpdateItem();
                        applyUpdate(item, normal);
                    }
            }
            logger.debug("FIN : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);
        }
    }

    private void applyUpdate(Item item, Item agedbrie) {
        item.quality = agedbrie.quality;
        item.sellIn = agedbrie.sellIn;
    }
}