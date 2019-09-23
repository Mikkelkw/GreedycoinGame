/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * Mikkel Klingenberg Wahl
 */
import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

public class GreedyCoinGame {
	LinkedList words = new LinkedList();
	int scoreHuman = 0;
	int scoreMachine = 0;
	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			words.add(inFile.nextInt());
			
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		System.out.println("+++++++++++");
		
		System.out.print("Coins:		");
		for(int i = 0; i < words.size(); i++){
			
			System.out.print("	" + words.get(i) +" ");
		}
		System.out.println("");
		System.out.print("Position:	");
		int position = 0;
		for(int i = 0; i < words.size(); i++) {
			
			System.out.print("	" + position +"");
		position++;
		}
		System.out.println("");
		System.out.println("");
		System.out.println("	Human: " + scoreHuman + "   Machine: " +scoreMachine);
		System.out.println("+++++++++++");
	}

	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Let's play the coin game!");
		System.out.println("I will go first");
		
		while(words.size() != 0) {
		
		printCoins();
		int red = 0;
		int blue = 0;
		for(int i = 0; i < words.size()-1; i = i +2) {
			red = red + (int) words.get(i);
		}
		for(int i = 1; i < words.size(); i =  i +2) {
			blue = blue + (int) words.get(i);
		}
		if(red > blue) {
			System.out.println("I choose 0");
			scoreMachine = scoreMachine +(int) words.getFirst();
			words.removeFirst();
			
		}
		if(blue > red) {
			int p =  words.size() - 1;
			System.out.println("I choose " + p);
			scoreMachine = scoreMachine + (int) words.getLast();
			words.remove(words.getLast());
		}
		printCoins();

		// get the keyboard for the silly human
		

		System.out.println("Indicate the position of the coin you choose: ");
		int humanChoice = keyboard.nextInt();
		Boolean test = false;
		int size = words.size() -1;
		if(humanChoice != 0 && humanChoice != size) {
			test = true;
		}
		
		while(test) {
			System.out.println("Please choose a valid int");
			humanChoice = keyboard.nextInt();
			if(humanChoice == 0 || humanChoice == size) {
				test = false;
			}
		}
		if(humanChoice == 0) {
			scoreHuman = scoreHuman +(int) words.getFirst();
			words.removeFirst();
			
		}
		if(humanChoice == size && size != 0) {
			int p =  words.size() - 1;

			scoreHuman = scoreHuman + (int) words.getLast();
			words.remove(words.getLast());
		}
		
		}
		if(scoreMachine > scoreHuman) {
			System.out.println("Game over!! Final score = Machine: " +scoreMachine +"  You: " +scoreHuman);
		}else {
			System.out.println("Game over!! Finalscore:  You: " +scoreHuman +  "  Machine: " +scoreMachine);
		}
		keyboard.close();
		System.exit(0);
		
	}

	public static void main(String[] args) throws IOException {
		
		GreedyCoinGame game = new GreedyCoinGame("file5.txt");
		
		game.playGame();
	}

}
