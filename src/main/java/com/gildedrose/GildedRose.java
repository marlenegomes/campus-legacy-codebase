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

            Item typedItem = null;

            switch (item.name) {
                case "Aged Brie":
                    typedItem = new AgedBrie(item.name, item.sellIn, item.quality);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    typedItem = new Backstage(item.name, item.sellIn, item.quality);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    typedItem = new Sulfuras(item.name, item.sellIn, item.quality);
                    break;
                case "Red red wine":
                    typedItem = new RedWine(item.name, item.sellIn, item.quality);
                    break;
                default:
                    if(item.name.startsWith("Conjured")){
                        typedItem = new Conjured(item.name, item.sellIn, item.quality);
                    }else {
                        typedItem = new Normal(item.name, item.sellIn, item.quality);
                    }
            }

            typedItem.UpdateItem();
            applyUpdate(item, typedItem);

            logger.debug("FIN : nom item: {}, sellIn: {}, quality: {}", item.name, item.sellIn, item.quality);
        }
    }

    private void applyUpdate(Item item, Item childitem) {
        item.quality = childitem.quality;
        item.sellIn = childitem.sellIn;
    }
}