package com.danske;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {

	/**
	 * Reads values from poker.txt file
	 * @return List of lines
	 */
	public static List<String> readHands() {

		List<String> data = new ArrayList<String>();
		
		try {
			
			File file = new File("poker.txt");
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error - poker.txt not found");
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * Parses String line to two hands
	 * @param line
	 * @return a List of two hands
	 */
	public static List<Card[]> parseHands(String line) {
		
		List<Card[]> hands = new ArrayList<>();
		Card[] hand1 = new Card[5];
		Card[] hand2 = new Card[5];
		
		String[] parts = line.split(" ");
		
		for(int i = 0; i < 5; i++) {
			hand1[i] = createCard(parts[i]);
		}
		
		for(int i = 0; i < 5; i++) {
			hand2[i] = createCard(parts[i+5]);
		}
		
		hands.add(hand1);
		hands.add(hand2);
		
		return hands;
	}
	
	/**
	 * Creates a Card Object from given string
	 * @param cardString
	 * @return Card Object
	 */
	private static Card createCard(String cardString) {
		
		Card card = new Card();
		card.setValue(getCardValue(cardString.substring(0, 1)));
		card.setSuit(getCardSuit(cardString.substring(1, 2)));

		return card;
	}
	
	/**
	 * Evaluates card Value
	 * @param value
	 * @return Integer Based on the value
	 */
	private static int getCardValue(String value) {
		
		try {
			return Integer.parseInt(value);
		} catch(Exception e) {}
		
		if(value.equals("T")) {
			return 10;
		}
		
		if(value.equals("J")) {
			return 11;
		}
		
		if(value.equals("Q")) {
			return 12;
		}
		
		if(value.equals("K")) {
			return 13;
		}
		
		if(value.equals("A")) {
			return 14;
		}
		
		return 0;
	}
	
	/**
	 * Evaluates Card Suit
	 * @param value
	 * @return Suit enum based on the value
	 */
	private static Suit getCardSuit(String value) {
		
		if(value.equals("C")) {
			return Suit.CLUB;
		}
		
		if(value.equals("D")) {
			return Suit.DIAMOND;
		}
		
		if(value.equals("H")) {
			return Suit.HEART;
		}
		
		return Suit.SPADE;
	}
}
