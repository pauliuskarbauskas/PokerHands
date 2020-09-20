package com.danske;

import java.util.List;

public class Poker {

	public static void main(String[] args) {

//		List<String> data = Helper.readHands();
//
//		for (String a: data) {
//			List<Card[]> hands = Helper.parseHands(a);
//		}
		
		
		Card[] hand1 = new Card[5];
		hand1[0] = new Card(5, Suit.DIAMOND);
		hand1[1] = new Card(7, Suit.DIAMOND);
		hand1[2] = new Card(11, Suit.DIAMOND);
		hand1[3] = new Card(13, Suit.DIAMOND);
		hand1[4] = new Card(14, Suit.DIAMOND);
		
		Card[] hand2 = new Card[5];
		hand2[0] = new Card(4, Suit.DIAMOND);
		hand2[1] = new Card(7, Suit.DIAMOND);
		hand2[2] = new Card(11, Suit.DIAMOND);
		hand2[3] = new Card(13, Suit.DIAMOND);
		hand2[4] = new Card(14, Suit.DIAMOND);
		
//		hand2[0] = new Card(9, Suit.DIAMOND);
//		hand2[1] = new Card(9, Suit.HEART);
//		hand2[2] = new Card(9, Suit.SPADE);
//		hand2[3] = new Card(9, Suit.CLUB);
//		hand2[4] = new Card(13, Suit.DIAMOND);
		
		Hand p1hand = new Hand();
		p1hand.setHand(hand1);
		
		Hand p2hand = new Hand();
		p2hand.setHand(hand2);
		
		boolean who = Analyzer.analyze(p1hand, p2hand);
		
		System.out.println(who);
		
	}

}
