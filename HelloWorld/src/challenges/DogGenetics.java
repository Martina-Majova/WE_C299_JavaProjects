package challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
	
	public void findGenetics() {
		System.out.println("Please enter name of your dog");
		Scanner scanner = new Scanner(System.in);
		String dogName = scanner.nextLine();
		
		List<String> dogRaces = new ArrayList<>();
		Collections.addAll(dogRaces, "Husky", "German Shepherd", "Golden Retriever", "Chihuahua", "Labrador", "Greyhound", "Bulldog", "Boxer", "Dachshund", "Border Terrier", "Shiba Inu");
		Collections.shuffle(dogRaces);
		int total = 100;
		System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.\n \n"
							+ dogName + " is:\n");
		
		for(int i=0; i<5; i++) {
			Random r = new Random();
			int percentage;
			if(i<4) {
				percentage = r.nextInt(total-(5-i))+1;
				total -= percentage;
			} else {
				percentage = total;
			}
			System.out.println(percentage + "% of " + dogRaces.get(i));
		}
		System.out.println("Wow, that's QUITE the dog!");
		
	}

}
