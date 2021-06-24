package com.gildedrose;

public class NormalItem extends Item {

	

	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality,0,50);
	}

	@Override
	public void updateQuality() {
		this.addQuality(-1);
		
	}


}
