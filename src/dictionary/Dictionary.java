package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {

	
public static char[] getRandomWord() {
		Random rand = new Random();
				
		FileReader file = null;
		try {
			file = new FileReader("\\dictionary.txt");
		} catch (FileNotFoundException e1) {
			System.err.println("dictionary.txt not found!");
		}
		
		ArrayList<String> words  = new ArrayList<>();
		BufferedReader reader = new BufferedReader(file);
		    String word;
		    try {
				while ((word = reader.readLine()) != null) {
				    
					if (word.length() > 2) {
					words.add(word.toUpperCase());
					}
				}
			} catch (IOException e) {
				System.err.println("dictionary.txt read error!");
			}
		
		return words.get(rand.nextInt(words.size())).toCharArray();
	}
}