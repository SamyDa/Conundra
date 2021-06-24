package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    
    private static final String[] NOT_DECREASABLE_QUALITY_ITEMS = {AGED_BRIE, BACKSTAGE, SULFURAS};
    
    public static void setItems(Item[] newItems) {
    	items = newItems;
    }
    
    public static void updateQuality() {
    	for(Item item : items) {
    		
            if (!decreaseQuality(item, false)) {
            	
            	increaseQuality(item, false);
            }
            
            decreaseSellIn(item);
            
            if(item.sellIn >=0) continue;
            
            switch(item.name) {
	            case AGED_BRIE : increaseQuality(item, false);
	            				 break;
	            case BACKSTAGE : item.quality = 0;
	            				 break;
	            default : decreaseQuality(item, false);
            }
            
        }
    }
    
    private static void decreaseSellIn(Item item) {
    	 if (!item.name.equals(SULFURAS)) {
             item.sellIn = item.sellIn - 1;
         }
	}
    
    /**
     * The decreaseQuality method is used to calculate new decreased quality of the item. 
     * The call can be recursive(can be called several time depending on the item name)
     * 
     * @param item : item to update 
     * @param isRecursiveCall : flag indicating if it is a recursive call
     * @return true if the decrease is allowed or false otherwise
     */
	private static boolean decreaseQuality(Item item, boolean isRecursiveCall) {
		
		
    	if (!Arrays.asList(NOT_DECREASABLE_QUALITY_ITEMS).contains(item.name) && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    	
    	if(item.name.equals(CONJURED) && isRecursiveCall== false)
    		decreaseQuality(item,true);
    	
    	return !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE);
    }
    
	/**
	 * The increaseQuality is used to calculate new increased quality of the item. 
     * The call can be recursive(can be called several time depending on the item name)
	 * @param item : item to update 
	 * @param isRecursiveCall : flag indicating if it is a recursive call
	 */
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