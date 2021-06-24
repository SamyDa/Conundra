package com.gildedrose;

public class BackstageItem extends Item {

	
	private final int FIRST_SELLIN_LIMIT = 11;
	private final int SECOND_SELLIN_LIMIT = 6;
	
	
	public BackstageItem( int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality,0,50);
	}

	@Override
	public void updateQuality() {
		
		if(this.getSellIn() < 0 ) {
			this.setQuality(0);
			return;
		}
		
		int addValue = 1;
		
		if(this.getSellIn()<FIRST_SELLIN_LIMIT ) {
			addValue ++;
		}
		
		if(this.getSellIn()<SECOND_SELLIN_LIMIT ) {
			addValue ++;
		}
		
		this.addQuality(addValue);
		
	}

	@Override
	public void updateSellInAndQuality() {
		this.setSellIn(this.getSellIn()-1);
		if(this.getSellIn()<0)
			this.setQuality(0);
		
	}

}
