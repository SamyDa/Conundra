package com.gildedrose;

public class AgedBrieItem extends Item {

	
	public AgedBrieItem( int sellIn, int quality) {
		super("Aged Brie", sellIn, quality,0,50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		
		this.addQuality(1);
		
	}



}
