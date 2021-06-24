package com.gildedrose;

public class ConjuredItem extends Item {

	
	public ConjuredItem( int sellIn, int quality) {
		super("Conjured", sellIn, quality,0,50);
	}

	@Override
	public void updateQuality() {
		this.addQuality(-2);
	}

}
