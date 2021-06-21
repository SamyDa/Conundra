package be.SamyDa.GildedRose;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class App {

	private static Scanner scanner = new Scanner(System.in);
    private static LocalDateTime currentDate = LocalDateTime.now();
    private static List<Item> itemsV1 = new ArrayList<Item>();
    private static List<Item> itemsV2 = new ArrayList<Item>();
    
	public static void main(String[] args) {
		
		 int choice = 0;
	        System.out.println("App from Samy Daouri  -  Version 0.1   - " +  currentDate);
	        System.out.println();
	        displayMenu();
	        
	      
	        
	        do{         
	            System.out.println("\nWhich option do you want to execute (99 to display the menu again)?");      
	            try {
		            choice = scanner.nextInt();
		            
	            }catch(InputMismatchException e) {
	            	choice = 99;
	            	System.out.println("Only integers are allowed, please try again");
	            	scanner.next();
	            }
	            processChoice(choice);
	            System.out.println();
	        }while(choice !=0 );
		
		
		
		
	}
	
	private static void displayMenu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("----                     Menu                            ----");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Available options :");
        System.out.println("\t 0. Close the application");
        System.out.println("\t 1. Add item");
        System.out.println("\t 2. Update Quality & show items");
        System.out.println("\t 3. Show the items ");
        System.out.println("\n------------------------------------------------------------");
    }
	
	private static void processChoice(int choice) {
        
        switch(choice) {
        case 1 :
        	addItemMenu();
            break;
        case 2 :
        	System.out.println("Initial state : ");
        	System.out.println("(V1)");
    		(new GildedRose((Item[]) itemsV1.toArray(new Item[itemsV1.size()]))).showItems();
    		System.out.println("(V2)");
    		(new GildedRose((Item[]) itemsV2.toArray(new Item[itemsV2.size()]))).showItems();
        	if(itemsV1.size()> 0 && itemsV2.size()>0) {
        		for(int i= 0; i<15; i++) {
	        		GildedRose gildedRoseV1 = new GildedRose((Item[]) itemsV1.toArray(new Item[itemsV1.size()]));
	        		GildedRose gildedRoseV2 = new GildedRose((Item[]) itemsV2.toArray(new Item[itemsV2.size()]));
	        		gildedRoseV1.updateQuality();
	        		gildedRoseV2.updateQualityV2();
	        		System.out.println("(V1)");
	        		gildedRoseV1.showItems();
	        		System.out.println("(V2)");
	        		gildedRoseV2.showItems();
        		}
        	}
        	else
        		System.out.println("No items");
            break;
        case 3 :
        	if(itemsV1.size()> 0 && itemsV2.size()>0) {
        		System.out.println("(V1)");
        		(new GildedRose((Item[]) itemsV1.toArray(new Item[itemsV1.size()]))).showItems();
        		System.out.println("(V2)");
        		(new GildedRose((Item[]) itemsV2.toArray(new Item[itemsV2.size()]))).showItems();
        	}
        	else
        		System.out.println("No items");
            break;
        case 99:
        	displayMenu();
            break;
        default :
            if(choice !=0 )
                System.out.println("This option is not allowed");
            break;
    }
}

	private static void addItemMenu() {
		List<ItemSpecificity> itemSpecificities  = new ArrayList<ItemSpecificity>();
		int[] count = {0}; 
		String name = "";
		ItemSpecificity seletedItemSpec = null;
		for(ItemSpecificity itemSpecificity : ItemSpecificity.values()) {
			itemSpecificities.add(itemSpecificity);
		}
		System.out.println("Please select the item you want to add : ");
		itemSpecificities.forEach(itemSpec -> {count[0]++; System.out.println("\t"+count[0] + "." + itemSpec.getName());} );
		
		int choice = askIntToUser("Which item do you want to add ( choice between 1 and "+itemSpecificities.size()+" )?", 1, itemSpecificities.size());
		seletedItemSpec = itemSpecificities.get(choice-1);
		if(ItemSpecificity.NORMAL.equals(seletedItemSpec)) {
			  System.out.println("Please, enter the name of the Item :\n ");
			  name = scanner.next();
		}
		else
			name = seletedItemSpec.getName();
		
		int quality = askIntToUser("Please, enter the quality of "+seletedItemSpec.getName()+" ( choice between "+seletedItemSpec.getMinQuality() +" and "+seletedItemSpec.getMaxQuality()+" )?", seletedItemSpec.getMinQuality(), seletedItemSpec.getMaxQuality());
		int sellIn = askIntToUser("Please enter the sellIn (between 1 and 365) : ", 1, 365);
		itemsV1.add(new Item(name ,  sellIn ,quality ));
		itemsV2.add(new Item(name ,  sellIn ,quality ));
		
	}
	
	private static int askIntToUser(String question , int min , int max) {
		int choice = 0 ;
		do{         
            System.out.println("\n" + question);      
            try {
            	choice = scanner.nextInt();
	            if(choice < min|| choice > max) {
	            	System.out.println("The choice is invalid");
	            	choice =0;
	            }
	            
            }catch(InputMismatchException e) {
            	System.out.println("Only integers are allowed, please try again");
            	scanner.next();
            }
            System.out.println();
        }while(choice ==0 );
		
		return choice;
		
	}

}
