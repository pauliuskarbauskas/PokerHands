package com.danske;

public class HandBuilder {

	private Hand iHand;
	
	public HandBuilder() {
		super();
		iHand = new Hand();
	}
	
	public HandBuilder withRoyalFlush(Suit suit) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(i + 10, suit);
			hand[i] = card;
		}
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withStraightFlush(int highest, Suit suit) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(highest + i, suit);
			hand[i] = card;
		}
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withFullHouse(int highest, int secondarry) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 4; i++) {
			Card card = new Card();
			card.setValue(highest);
			hand[i] = card;
		}
		
		for (int i = 3; i < 5; i++) {
			Card card = new Card();
			card.setValue(secondarry);
			hand[i] = card;
		}
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withOnePair(int pair, int kicker) {
		
		Card[] hand = new Card[5];
		hand[0] = new Card(pair, Suit.CLUB);
		hand[1] = new Card(pair, Suit.CLUB);
		hand[2] = new Card(pair+1, Suit.CLUB);
		hand[3] = new Card(pair+2, Suit.CLUB);
		hand[4] = new Card(kicker, Suit.DIAMOND);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withHighCard() {
		
		Card[] hand = new Card[5];
		hand[0] = new Card(2, Suit.CLUB);
		hand[1] = new Card(3, Suit.CLUB);
		hand[2] = new Card(5, Suit.CLUB);
		hand[3] = new Card(11, Suit.CLUB);
		hand[4] = new Card(14, Suit.DIAMOND);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withTwoPair(int pair1, int pair2, int kicker) {
		
		Card[] hand = new Card[5];
		hand[0] = new Card(pair1, Suit.CLUB);
		hand[1] = new Card(pair1, Suit.CLUB);
		hand[2] = new Card(pair2, Suit.CLUB);
		hand[3] = new Card(pair2, Suit.CLUB);
		hand[4] = new Card(kicker, Suit.DIAMOND);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withThreeOfKind(int kind, int kicker, int kicker2) {
		
		int[] handValues = new int[5];
		
		handValues[0] = kind;
		handValues[1] = kind;
		handValues[2] = kind;
		handValues[3] = kicker;
		handValues[4] = kicker2;
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			card.setValue(handValues[i]);
			hand[i] = card;
		}
		
		hand[0].setSuit(Suit.DIAMOND);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withFourOfKind(int kind, int kicker) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			card.setValue(kind);
			hand[i] = card;
		}
		
		hand[4].setValue(kicker);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withStraightOf(int highest) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			card.setValue(highest + i);
			hand[i] = card;
		}
		
		hand[0].setSuit(Suit.CLUB);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withFlush(Suit suit) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			card.setSuit(suit);
			hand[i] = card;
		}
		
		hand[0].setValue(2);
		hand[1].setValue(5);
		hand[2].setValue(6);
		hand[3].setValue(7);
		hand[4].setValue(13);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public Hand build() {
		return iHand;
	}
}
