package demo;
import java.util.HashMap;
import java.util.Scanner;


public class Refrigerator {
	
	public static final int MAX_CAPACITY = 100;
	
	private HashMap<String, Integer> contents;
	private int currentCapacity;
	private int temperature;
	
	
	
	
	public Refrigerator() {
		
		this.contents = new HashMap<>();
		this.currentCapacity = 0;
		this.temperature = 5;
	}
	
	public void addItems() {
		Scanner scanner = new Scanner(System.in);
		
		String food;
		
		while(currentCapacity<MAX_CAPACITY) {
		System.out.println("Enter name of food item. If you would like to stop adding items, write stop");
		
		food = scanner.nextLine();
			if(food.equals("stop")) {
				break;
			}
			if(contents.containsKey(food)) {
				contents.put(food, contents.get(food)+1);
			} else {
				contents.put(food, 1);
			}
	
			currentCapacity += 1;		
			if(currentCapacity == MAX_CAPACITY) {
				System.out.println("The fridge is now full");
			}
		}
		scanner.close();
	}
	
	public void removeItems() {
		Scanner scanner = new Scanner(System.in);
		String food;
		do {
			System.out.println("Enter name of the item to take out, write stop to close the fridge");
			food = scanner.nextLine();
			if(contents.containsKey(food) && contents.get(food)>0) {
				contents.put(food, contents.get(food)-1);
				currentCapacity --;
			} else {
				System.out.println(food + " not in the fridge");
			}
		} while (!food.equals("stop"));
		scanner.close();
		
	}


	public void printTemperature() {
		System.out.println("The temperature is " + temperature + " degrees");
	}
	
	
	public void setTemperature() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter desired temperature");		
		int temp = scanner.nextInt();
		
		if(temp > 10) {
			System.out.println("Temperature setting is too high, please set a lower temperature.");
			temp = scanner.nextInt();
		} else if(temp<0) {
			System.out.println("Temperature setting is too low, please set a higher temperature.");
			temp = scanner.nextInt();
		} else {
			System.out.println("Temperature was successfully set to " + temp + " degrees.");
			this.temperature = temp;
		}
		scanner.close();
	}
	
	public void printContents() {
		
		StringBuilder mapAsString = new StringBuilder("");
		for(String key : contents.keySet()) {
			mapAsString.append(key + ", quantity: " + contents.get(key) + "\n");
		}
		// Code to format the String
		System.out.println(mapAsString.toString());
		System.out.println("The fridge is currently at " + currentCapacity + "% capacity.");
		System.out.println("Current temperature: " + temperature + "degrees.");
		
	}
	
	
	public void printCurrentCapacity() {
		System.out.println("The refrigerator is at " + currentCapacity + "% capacity.");
	}
	
	
	
	
	
	
	
	
	

}
