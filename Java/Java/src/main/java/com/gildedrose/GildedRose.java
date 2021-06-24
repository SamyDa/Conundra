package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    
    private static final String[] NOT_DECREASABLE_QUALITY_ITEMS = {AGED_BRIE, BACKSTAGE, SULFURAS};
    
    public static void setItems(Item[] newItems) {
    	items = newItems;
    }
    
    public static void updateQuality() {
    	for(Item item : items) {
            if (!decreaseQuality(item)) {
            	
            	increaseQuality(item, false);
            }
            
            decreaseSellIn(item);
            
            if (item.sellIn < 0) {
            
	            switch(item.name) {
		            case AGED_BRIE : increaseQuality(item, false);
		            				 break;
		            case BACKSTAGE : item.quality = 0;
		            				 break;
		            default : decreaseQuality(item);
	            }
            }
            
        }
    }
    
    private static void decreaseSellIn(Item item) {
    	 if (!item.name.equals(SULFURAS)) {
             item.sellIn = item.sellIn - 1;
         }
	}

	private static boolean decreaseQuality(Item item) {
		
		
    	if (!Arrays.asList(NOT_DECREASABLE_QUALITY_ITEMS).contains(item.name) && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    	
    	return !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE);
    }
    
    private static void increaseQuality(Item item, boolean isRecursiveCall) {
    	
    	
    	if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    	
    	if (item.name.equals(BACKSTAGE ) && isRecursiveCall == false) {
            if (item.sellIn < 11) {
            	increaseQuality(item, true);
            }
            if (item.sellIn < 6) {
            	increaseQuality(item, true);
            }
        }
    }
    
}