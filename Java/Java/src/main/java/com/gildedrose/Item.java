package com.gildedrose;

public abstract class Item {

    private String name;

    private int sellIn;

    private int quality;
    
    private final int minQuality;
    
    private final int maxQuality;
    
    
    public Item(String name, int sellIn, int quality, int minQuality, int maxQuality) {
		super();
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
		this.minQuality = minQuality;
		this.maxQuality = maxQuality;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSellIn() {
		return sellIn;
	}



	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}



	public int getQuality() {
		return quality;
	}



	public void setQuality(int quality) {
		this.quality = quality;
	}

	
	public void addQuality(int addValue) {
		
		if(quality + addValue > maxQuality) {
			quality = maxQuality;
			return;
		}
		if(quality + addValue < minQuality) {
			quality = minQuality;
			return;
		}
		
		quality = quality + addValue;
	}
	
	public abstract void updateQuality() ;
	public  void updateSellInAndQuality() {
		this.setSellIn(this.getSellIn()-1);
		if(this.getSellIn()<0)
			updateQuality();
	}


	@Override
    public boolean equals(Object obj) {
    	
		if(obj instanceof Item)
			return this.name.equals(((Item) obj).getName()) && this.quality == ((Item) obj).getQuality() && this.sellIn == ((Item) obj).sellIn;
    		
    	return false;		
    			
    }
    

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
   
   
}
