package be.SamyDa.GildedRose;

public class QualityCalculator {
	
	
	public static int getQualityDifference(ItemSpecificity itemSpecificity, int sellIn) throws IllegalArgumentException {
		
		if(itemSpecificity == null) {
			throw new IllegalArgumentException("item specificity cannot be null");
		}
		
		if(itemSpecificity.equals(ItemSpecificity.BACKSTAGE)) {
			if(sellIn<0 ) return itemSpecificity.getMaxQuality();
			
			if(sellIn < 6 ) return 3*itemSpecificity.getQualityMultiplicator();
			
			if (sellIn < 11 ) return 2*itemSpecificity.getQualityMultiplicator();
			
			return itemSpecificity.getQualityMultiplicator();
			
			
		}
		
		int sellInMultiplicator = 1;
		if(sellIn <= 0 ) sellInMultiplicator = 2;
		
		return sellInMultiplicator*itemSpecificity.getQualityMultiplicator();
		
	}
	
}
