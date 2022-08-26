package demo;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Trial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sampleInput = "Hello World How Are You";
		
		//Sample Output
		// H : Hello How
		// W : World 
		// A : Are
		// Y : You
		
		
		display(formatTheInput(sampleInput));
	}

	private static String formatTheInput(String sampleInput) {
		// TODO Auto-generated method stub
		
		String[] inputArray = sampleInput.split(" ");
		HashMap<Character, List<String>> map = new HashMap<Character, List<String>>();
		for(String i:inputArray) {
			
			char firstLetter = i.charAt(0);
			
			if(map.get(firstLetter) == null) {
				map.put(firstLetter, new ArrayList<String>());
			}
			
			map.get(firstLetter).add(i);
		}
		
		
		StringBuilder mapAsString = new StringBuilder("");
		for(Character key : map.keySet()) {
			mapAsString.append(key + " : " + String.join(", ", map.get(key)) + "\n");
		}
		// Code to format the String
		
		return mapAsString.toString();
	}

	private static void display(String outputString) {
		// TODO Auto-generated method stub
		System.out.println(outputString);
		
	}

}
