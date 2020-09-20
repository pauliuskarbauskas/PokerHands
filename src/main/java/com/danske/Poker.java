package com.danske;

import java.util.List;

public class Poker {

	public static void main(String[] args) {

		List<String> data = Helper.readHands();
		int result = 0;
		
		for (String a: data) {
			
			List<Hand> hands = Helper.parseHands(a);
			
			if (Analyzer.analyze(hands.get(0), hands.get(1))){
				result++;
			}
		}
		
		System.out.println("Player1 has won " + result + " times.");
		
	}

}
