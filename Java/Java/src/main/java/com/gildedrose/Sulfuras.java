package com.gildedrose;

public class Sulfuras extends Item {

	
	public Sulfuras( int sellIn, int quality) {
		super("Sulfuras, Hand of Ragnaros", sellIn, quality , 0 , 80);
	}

	@Override
	public void updateQuality() {
		//Do nothing , quality stays the same
	}

	@Override
	public void updateSellInAndQuality() {
		//Do nothing , sellIn stays the same

	}

}
