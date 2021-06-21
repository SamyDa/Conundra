package be.SamyDa.GildedRose;

public enum ItemSpecificity {

	CONJURED("Conjured",2, 0 , 50) , SULFURAS("Sulfuras, Hand of Ragnaros", 0 , 0 , 80) , AGED("Aged Brie",-1, 0 , 50),
	BACKSTAGE("Backstage passes to a TAFKAL80ETC concert",-1 , 0 , 50),NORMAL("Other" , 1 , 0 , 50);
	
	
	
	private String name; 
	private int qualityMultiplicator;
	private int minQuality;
	private int maxQualtiy;
	
	private ItemSpecificity(String name , int qualityMultiplicator, int minQuality,  int maxQualtiy) {
		this.name = name;
		this.qualityMultiplicator = qualityMultiplicator;
		this.maxQualtiy = maxQualtiy;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQualityMultiplicator() {
		return this.qualityMultiplicator;
	}
	
	public int getMinQuality() {
		return this.minQuality;
	}
	
	public int getMaxQuality() {
		return this.maxQualtiy;
	}
}
