package com.gildedrose;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGildedRose {

	private Item [] items;
	
	@Before
	public void before() {
		items = new Item[] {
			new ConjuredItem(5, 25),
			new Sulfuras( 50, 61),
			new AgedBrieItem( 2, 40),
			new BackstageItem( 12, 25),
			new NormalItem("Nice_Item	", 10, 20)
		};
		GildedRose.setItems(items);
	}
	
	@Test
	public void testUpdateQualityAfterOneDay() {
		Item[] resultItems = new Item[] {
				new ConjuredItem( 4, 23),
				new Sulfuras( 50, 61),
				new AgedBrieItem( 1, 41),
				new BackstageItem( 11, 26	),
				new NormalItem("Nice_Item	", 9, 19)
		};
		testOverDays(1, items, resultItems);
	}
	
	@Test
	public void testUpdateQualityAfterFiveDays() {
		Item[] resultItems = new Item[] {
				new ConjuredItem( 0, 15),
				new Sulfuras( 50, 61),
				new AgedBrieItem( -3, 48),
				new BackstageItem( 7, 33),
				new NormalItem("Nice_Item	", 5, 15)
		};
		testOverDays(5, items, resultItems);
	}
	@Test
	public void testUpdateQualityAfterTenDays() {
		Item[] resultItems = new Item[] {
				new ConjuredItem( -5, 0),
				new Sulfuras( 50, 61),
				new AgedBrieItem( -8, 50),
				new BackstageItem( 2, 46),
				new NormalItem("Nice_Item	", 0, 10)
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
		return item.equals(comparedItem);
	}
}
