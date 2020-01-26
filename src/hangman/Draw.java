package hangman;

import java.util.ArrayList;

public abstract class Draw {

	
	static final String hm0 = "\n"
			+ "                    \n"
			    + "       \n"
			    + "       \n"
			    + "       \n"
			    + "       \n"
			    + "       \n"
			    + "       \n"
			    + "       \n"
			    + "\t____/  \\____\n"
			    + "\t============\n\n";
	
	static final String hm1 = "\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t____/||\\____\n"
			    + "\t============\n\n";
	
	static final String hm2 = "\n"
							+ "\t     ||============#\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t     ||\n"
			   			    + "\t____/||\\____\n"
			   			    + "\t============\n\n";

	static final String hm3 = "\n"
				+ "\t     ||============#\n"
			    + "\t     ||            |\n"
			    + "\t     ||            |\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t     ||\n"
			    + "\t____/||\\____\n"
			    + "\t============\n\n";
	
	static final String hm4 = "\n"
			+ "\t     ||============#\n"
			+ "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	static final String hm5 = "\n"
			+ "\t     ||============#\n"
			+ "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	static final String hm6 = "\n"
			+ "\t     ||============#\n"
			+ "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||        ----|\n"
		    + "\t     ||            |\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	static final String hm7 = "\n"
			+ "\t     ||============#\n"
			+ "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||        ----|----\n"
		    + "\t     ||            |\n"
		    + "\t     ||\n"
		    + "\t     ||\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	static final String hm8 = "\n"
			+ "\t     ||============#\n"
			+ "\t     ||            |\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||        ----|----\n"
		    + "\t     ||            |\n"
		    + "\t     ||           /\n"
		    + "\t     ||         _/\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	static final String hm9 = "\n"
			+ "\t     ||============#\n"
		    + "\t     ||            |\n"
		    + "\t     ||           {\"}\n"
		    + "\t     ||        ----|----\n"
		    + "\t     ||            |\n"
		    + "\t     ||           / \\\n"
		    + "\t     ||         _/   \\_\n"
		    + "\t____/||\\____\n"
		    + "\t============\n\n";
	
	public static void drawHangman(int state) {
		
		String result = ""; 
		
		switch (state) {
		case 0:
			result = hm0;
			break;
		case 1:
			result = hm1;
			break;
		case 2:
			result = hm2;
			break;
		case 3:
			result = hm3;
			break;
		case 4:
			result = hm4;
			break;
		case 5:
			result = hm5;
			break;
		case 6:
			result = hm6;
			break;
		case 7:
			result = hm7;
			break;
		case 8:
			result = hm8;
			break;
		case 9:
			result = hm9;
			break;
		
		}
		
		System.out.println(result);
	}
	
	public static char[] drawWord(char[] word, ArrayList<Character> guesses) {
			char[] display = new char[word.length];
		for (int wc = 0; wc < word.length; wc++) {
			for( int gc = 0; gc < guesses.size(); gc ++) {
				if(word[wc] == guesses.get(gc)) {
					display[wc] = word[wc];
					break;
				}
				else {
					display[wc] = '-';
				}
				
			}
		}
		
			return display;
	}

	public static void printWord(char[] display) {
		System.out.print("\t");
		for (char c : display){
			
			System.out.print(c + "  ");
		}
	}

	public static void printGuesses(ArrayList<Character> guesses, int numGuesses) {
		if(guesses.size() > 1) {
			System.out.println("\n\n\tGuessed so far....\n");
			System.out.print("\t");
			for (char character : guesses) {
				System.out.print(character + "  ");
			}
		}
	}
}




/*

     ||============#     
     ||            |     
     ||            |     
     ||            Õ     
     ||         ---|---  
     ||            |     
     ||           / \    
     ||         _/   \_  
____/||\____             
============   GAME OVER!

*/