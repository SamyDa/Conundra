package be.SamyDa.GildedRose;


class GildedRose {
    private Item[] items;
    
    

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void showItems() {
    	System.out.println("List of items\n-------------");
    	for(Item item : items) {
    		System.out.println("Name : " + item.name + "\tQuality : " + item.quality + "\tSellIn : " + item.sellIn);
    	}
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
       
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    // CHANGED FROM HERE
    //////////////////////////////////////////////////////////////////////////////////
    
    public void updateQualityV2() {
    	for(Item item : items) {
    		
    		//Find the item characteristics
    		ItemSpecificity itemSpec  = findItemSpecificity(item);
    		//Lower its quality(or increase it if the quality modifier is negative)
    		lowerItemQuality(item, itemSpec);
    		//Lower the sell in
    		lowerItemSellIn(item, itemSpec);
    		
    	}
    }

	private ItemSpecificity findItemSpecificity(Item item) {
		
		for(ItemSpecificity itemSpecElement : ItemSpecificity.values()) {
			if(itemSpecElement.getName().equals(item.name)){
				return itemSpecElement;
			}
		}
		return ItemSpecificity.NORMAL;
	}

	private void lowerItemQuality(Item item , ItemSpecificity itemSpec) {
		try {
			int qualitySubstractor = QualityCalculator.getQualityDifference(itemSpec, item.sellIn);
			
			if(item.quality - qualitySubstractor < itemSpec.getMinQuality()) 
				item.quality = itemSpec.getMinQuality();
			else if(item.quality - qualitySubstractor >itemSpec.getMaxQuality())
				item.quality = itemSpec.getMaxQuality();
			else
				item.quality = item.quality - qualitySubstractor;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void lowerItemSellIn(Item item, ItemSpecificity itemSpec) {
		try {
			item.sellIn = SellInCalculator.getNewSellInValue(item.sellIn, itemSpec);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}