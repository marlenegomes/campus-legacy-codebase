package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void decreaseQualityByOne() {
        Item[] items = new Item[] {
                new Item("normal", 20, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(29);
    }

    @Test
    void decreaseSellInByOne() {
        Item[] items = new Item[] {
                new Item("normal", 20, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(19);
    }

    @Test
    void decreaseQualityByTwo() {
        Item[] items = new Item[] {
                new Item("conjured", 20, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(28);
    }

    @Test
    void IncreaseQualityByOne() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 20, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(31);
    }

    @Test
    void keepQuality() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 20, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void keepSellIn() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 20, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(20);
    }

    @Test
    void increaseQualityByTwo() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(32);
    }

    @Test
    void increaseQualityByThree() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(33);
    }
}
