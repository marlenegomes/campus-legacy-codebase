package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void decreaseQualityByOne() {
        Item[] items = new Item[] {
                new Item("normal", 10, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void decreaseQualityByTwoIfSellinIsNegative() {
        Item[] items = new Item[] {
                new Item("normal", -111, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void itemQualityShouldIncreaseIfAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void AgedBrieShouldIncreaseByTwoIfSellInNegative() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -500000, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void qualityShouldBeTheSameIfSulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void sellInShouldBeTheSameIfSulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(10);
    }

    @Test
    void itemQualityShouldIncreaseByOneIfSellInMoreThanEleven() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void ItemQualityShouldIncreaseByTwoIfBackstageSellinLessThanEleven() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void ItemQualityShouldIncreaseByThreeIfBackstageSellinLessThanSix() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(13);
    }

    @Test
    void DecreaseQualityByTwoIfConjured() {
        Item[] items = new Item[] {
                new Item("Conjured", 24, 33),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(31);
    }

    @Test
    void DecreaseQualityByFourIfConjuredAndSellInNegative() {
        Item[] items = new Item[] {
                new Item("Conjured", -24, 33),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(29);
    }

    @Test
    void qualityShouldNotBeOverFifty() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void qualityShouldNotBeOverFiftyIfBackstage() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void qualityShouldBeZeroIfBackstageSellinIsZero() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void qualityShouldIncreaseByOneIfRedWine() {
        Item[] items = new Item[] {
                new Item("Red red wine", 500, 60),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(61);
    }

    @Test
    void redWineQualityShouldNotIncreaseByOneIfSellInIsLessThanThreeHundred() {
        Item[] items = new Item[] {
                new Item("Red red wine", 200, 60),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(60);
    }

    @Test
    void redWineQualityShouldDecreaseByOneIfSellInIsLessThanZero() {
        Item[] items = new Item[] {
                new Item("Red red wine",  -14, 555),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(554);
    }

    @Test
    void ItemQualityShouldNotBeLessThanZero() {
        Item[] items = new Item[] {
                new Item("Un item tout à fait normal",  20, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void ItemWhichStartWithConjuredIsConjured() {
        Item[] items = new Item[] {
                new Item("Conjured tomato pasta",  10, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }



}
