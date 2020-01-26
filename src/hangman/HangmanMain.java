package hangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class HangmanMain {
	static Scanner in = new Scanner(System.in);
	static ArrayList<Character> guesses;
	static char[] word;
	static Random rand = new Random();
	static int numGuesses;
	static char newGame;
	
	public static void main(String[] args) {
	
		
		while(newGame != 'N') {
			playGame();
		}
		
		}
	

		

	private static void playGame() {
		newGame = '&';
		word = dictionary.Dictionary.getRandomWord();
		guesses = new ArrayList<>();
		guesses.add(' ');
		numGuesses = 0;
		System.out.println("\n\n\n\n\n\t   HANGMAN\n\n\n\n\n\n\n\n\n\n\n\n");
		
		
		Draw.drawHangman(numGuesses);
		System.out.println("\n\n\n");
		Draw.printWord(Draw.drawWord(word, guesses));
		Draw.printGuesses(guesses, numGuesses);
				
		while(numGuesses < 9 && !guessedWord(Draw.drawWord(word, guesses))) {
			char guess = '*';
				
				System.out.println("\n\n\tGuess a Character:  \n\n");
				System.out.print("\t");
				guess = in.next().toUpperCase().charAt(0);
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
				
				if (isValidGuess(guess,guesses)) {
					guesses.add(guess);
					Collections.sort(guesses);
					if (!isInWord(guess)) {
						numGuesses ++;
					}
				}
				else { 
					if(isInGuesses(guess)){
					System.out.println("\n\n\tALREADY GUESSED!");
					}
					else {
						System.out.println("\n\n\tINVALID ENTRY");
					}
				}
		
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
					Draw.drawHangman(numGuesses);
					Draw.printWord(Draw.drawWord(word, guesses));
					Draw.printGuesses(guesses, numGuesses);
					
				}
		
		
		if(guessedWord(Draw.drawWord(word, guesses))){
			System.out.println("\n\n\n\n\n\n\tWELL DONE!\n");
		}
		else {
			System.out.println("\n\n\n\n\n\n\tGAME OVER!\n");
		}
		System.out.println("\n\tThe word was....\n");
		System.out.print("\t");
		for (char c : word) {
			System.out.print(c);
		}
		while(newGame != 'Y' && newGame != 'N') {
			System.out.println("\n\n\n\n\n\n\tWould you like to play again?\n\n");
			System.out.print("\t");
			newGame =  in.next().toUpperCase().charAt(0);		
		}
	}
	
	private static boolean isInWord(char guess) {
		boolean result = false;
		
		for (char c : word) {
			if (c == guess) {
				result = true;
			}
		}
		
		return result;
	}


	private static boolean isInGuesses(char guess) {
		boolean result = false;
		
		for (char c : guesses) {
			if (c == guess) {
				result = true;
			}
		}
		
		return result;
	}



//	static char[] getRandomWord() {
//		
//		ArrayList<String> words  = new ArrayList<>();
//		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\dictionary.txt"))) {
//		    String word;
//		    while ((word = reader.readLine()) != null) {
//		        
//		    	if (word.length() > 2) {
//		    	words.add(word.toUpperCase());
//		    	}
//		    }
//		} catch (IOException e) {
//		    // handle exception
//		}
//		
//		return words.get(rand.nextInt(words.size())).toCharArray();
//	}

	static boolean isValidGuess(char guess, ArrayList<Character> guesses) {
		
		boolean resultaz = (guess >= 'A' && guess <= 'Z');
		boolean guessed = true;
		
		for (char c : guesses) {
			if (c == guess) {
				guessed =  false;
			}
		
		}
		return (resultaz && guessed);
		
	}

	static boolean guessedWord(char[] display) {
		boolean result = true;
		for (char c : display) {
			if (c == '-')
				result = false;
		}
		return result;
	}
}

/*
 		//set word
 		word = "Boo".toUpperCase().toCharArray();
 		
		//test Draw hangman
		for(int i = 0; i <=7; i++) {
			System.out.println(Draw.drawHangman(i));
 		}
 */

/*
		//Test draw word
		guesses.add('A');
		guesses.add('O');
		guesses.add('I');
		guesses.add('S');
		char[] word = {'A','U','S','T','R','A','L','I','A'};

		Draw.drawWord(word, guesses);
*/

/*
        //test is valid
		guesses.add('O');
		System.out.println(isValidGuess('s',guesses) + " 's' should be false");
		System.out.println(isValidGuess('A',guesses) + " 'A' should be true");
		System.out.println(isValidGuess('Z',guesses) + " 'Z' should be true");
		System.out.println(isValidGuess('O',guesses) + " 'O' should be false");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
/*
		//guessed word#
		String a = "-AEIOU";
		char[] arry = a.toCharArray();
		System.out.println(guessedWord(arry));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/