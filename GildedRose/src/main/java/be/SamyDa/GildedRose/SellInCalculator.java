package be.SamyDa.GildedRose;

public class SellInCalculator {
	
	public static int getNewSellInValue(int sellIn , ItemSpecificity itemSpecificity) throws IllegalArgumentException {
		if(itemSpecificity == null) {
			throw new IllegalArgumentException("item specificity cannot be null");
		}
		
		if(ItemSpecificity.SULFURAS.equals(itemSpecificity)) {
			return sellIn;
		}
		else {
			return sellIn-1;
		}
	}

}
