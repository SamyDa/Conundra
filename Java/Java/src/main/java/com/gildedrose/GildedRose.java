package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static Item[] items;
    
    public static void setItems(Item[] newItems) {
    	items = newItems;
    }
    
    public static void updateQuality() {
    	
    	Arrays.stream(items).forEach(item -> {
    						item.updateQuality();
    						item.updateSellInAndQuality();
    					}
    			);    	
    }
    
    
}