package com.gildedrose;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGildedRose {

	private Item [] items;
	
	@Before
	public void before() {
		items = new Item[] {
			new Item("Conjured", 5, 25),
			new Item("Sulfuras, Hand of Ragnaros", 50, 61),
			new Item("Aged Brie", 2, 40),
			new Item("Backstage passes to a TAFKAL80ETC concert", 12, 25),
			new Item("Nice_Item	", 10, 20)
		};
		GildedRose.setItems(items);
	}
	
	@Test
	public void testUpdateQualityAfterOneDay() {
		Item[] resultItems = new Item[] {
				new Item("Conjured", 4, 23),
				new Item("Sulfuras, Hand of Ragnaros", 50, 61),
				new Item("Aged Brie", 1, 41),
				new Item("Backstage passes to a TAFKAL80ETC concert", 11, 26	),
				new Item("Nice_Item	", 9, 19)
		};
		testOverDays(1, items, resultItems);
	}
	
	@Test
	public void testUpdateQualityAfterFiveDays() {
		Item[] resultItems = new Item[] {
				new Item("Conjured", 0, 15),
				new Item("Sulfuras, Hand of Ragnaros", 50, 61),
				new Item("Aged Brie", -3, 48),
				new Item("Backstage passes to a TAFKAL80ETC concert", 7, 33),
				new Item("Nice_Item	", 5, 15)
		};
		testOverDays(5, items, resultItems);
	}
	@Test
	public void testUpdateQualityAfterTenDays() {
		Item[] resultItems = new Item[] {
				new Item("Conjured", -5, 0),
				new Item("Sulfuras, Hand of Ragnaros", 50, 61),
				new Item("Aged Brie", -8, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 2, 46),
				new Item("Nice_Item	", 0, 10)
		};
		testOverDays(10, items, resultItems);
	}
	
	private void testOverDays(int days , Item[] items, Item[] resultItems) {
		for(int i = 0; i< days; i++)
			GildedRose.updateQuality();
		
		Assert.assertTrue(items.length == resultItems.length);
		
		for(int i = 0; i< items.length ; i++)
			Assert.assertTrue("Item " + items[i].toString() + " Not equal to "+ resultItems[i].toString() ,itemsAreEqual(items[i],resultItems[i]));
		
	}
	
	private boolean itemsAreEqual(Item item, Item comparedItem) {
		return item.name.equals(comparedItem.name) && item.quality == comparedItem.quality && item.sellIn == comparedItem.sellIn;
	}
}
