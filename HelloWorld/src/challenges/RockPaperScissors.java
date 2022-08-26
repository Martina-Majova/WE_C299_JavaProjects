package challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
	public void play() {
		Scanner scanner = new Scanner(System.in);
		int rounds = input(scanner);
		if(validInput(rounds)) {
			output(game(rounds, scanner));
			nextGame(scanner);
		}
		scanner.close();
		}
	
	public int input(Scanner scanner) {
		System.out.println("How many rounds would you like to play? Please choose 1 - 10");
		int rounds = scanner.nextInt();
		return rounds;
		
	}
	
	public boolean validInput(int rounds) {
		if(rounds<1 || rounds>10) {
			System.out.println("Invalid number of rounds selected");
			return false;
		} else {
			return true;
		}
	}
	
	private Map<String, Integer> game(int rounds, Scanner scanner) {
		Map<String, Integer> score = new HashMap<>();
		score.put("tie", 0);
		score.put("userWin", 0);
		score.put("computerWin", 0);
		for(int i=0; i<rounds; i++) {
			System.out.println("Please enter your choice (1 = Rock, 2 = Paper, 3 = Scissors)");
			int playerChoice = scanner.nextInt();
			int computerChoice = (int) Math.floor(Math.random()*(3-1+1)+1);
			
			switch(playerChoice) {
				case 1:
					switch(computerChoice) {
						case 1:
							System.out.println("Tie");
							score.put("tie", score.get("tie") + 1);
							break;
						case 2:
							System.out.println("You loose");
							score.put("computerWin", score.get("computerWin") + 1);
							break;	
						case 3:
							System.out.println("You win");
							score.put("userWin", score.get("userWin") + 1);
							break;	
					}
					break;
				case 2:
					switch(computerChoice) {
						case 2:
							System.out.println("Tie");
							score.put("tie", score.get("tie") + 1);
							break;
						case 3:
							System.out.println("You loose");
							score.put("computerWin", score.get("computerWin") + 1);
							break;	
						case 1:
							System.out.println("You win");
							score.put("userWin", score.get("userWin") + 1);
							break;	
					}
					break;
				case 3:
					switch(computerChoice) {
						case 3:
						System.out.println("Tie");
						score.put("tie", score.get("tie") + 1);
						break;
						case 1:
							System.out.println("You loose");
							score.put("computerWin", score.get("computerWin") + 1);
							break;	
						case 2:
							System.out.println("You win");
							score.put("userWin", score.get("userWin") + 1);
							break;	
					}
					break;
				default:
					System.out.println("Invalid choice");
			}
		}
			return score;
		
	}

	
	private void output(Map<String, Integer> score) {
		System.out.println("The overall score is: \n Tie: " + score.get("tie") + "\n User wins: " + score.get("userWin")  + "\n Computer wins: " + score.get("computerWin"));
		if((score.get("tie")>score.get("userWin") && score.get("tie")>score.get("computerWin")) || score.get("userWin") == score.get("computerWin")) {
			System.out.println("The overall result is a tie!");
		} else if(score.get("userWin")>score.get("computerWin")) {
			System.out.println("The user wins the whole game!");
		} else {
			System.out.println("The computer wins the whole game!");
		}
	}
	
	private void nextGame(Scanner scanner) {
		System.out.println("Would you like to play another game? \n Yes/No");
		scanner.nextLine();
		String choice = scanner.nextLine();
		if(choice.equals("Yes")) {
			play();
		}
	}

}
