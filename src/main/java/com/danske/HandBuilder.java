package com.danske;

public class HandBuilder {

	private Hand iHand;
	
	public HandBuilder() {
		super();
		iHand = new Hand();
	}
	
	public HandBuilder withRoyalFlush(Suit suit) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 4; i++) {
			Card card = new Card(i + 11, suit);
			hand[i] = card;
		}
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withOnePair(int pair, int kicker) {
		
		Card[] hand = new Card[5];
		hand[0].setValue(pair);
		hand[1].setValue(pair);
		hand[4].setValue(kicker);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withTwoPair(int pair1, int pair2, int kicker) {
		
		Card[] hand = new Card[5];
		hand[0].setValue(pair1);
		hand[1].setValue(pair1);
		hand[2].setValue(pair2);
		hand[3].setValue(pair2);
		hand[4].setValue(kicker);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withThreeOfKind(int kind, int kicker, int kicker2) {
		
		Card[] hand = new Card[5];
		hand[0].setValue(kind);
		hand[1].setValue(kind);
		hand[2].setValue(kind);
		hand[3].setValue(kicker2);
		hand[4].setValue(kicker);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withFourOfKind(int kind, int kicker) {
		
		Card[] hand = new Card[5];
		hand[0].setValue(kind);
		hand[1].setValue(kind);
		hand[2].setValue(kind);
		hand[3].setValue(kind);
		hand[4].setValue(kicker);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withStraightOf(int highest) {
		
		Card[] hand = new Card[5];
		
		for (int i = 0; i < 4; i++) {
			hand[i].setValue(highest - 1);
		}
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public HandBuilder withFlush(Suit suit) {
		
		Card[] hand = new Card[5];
		hand[0].setSuit(suit);
		hand[0].setSuit(suit);
		hand[0].setSuit(suit);
		hand[0].setSuit(suit);
		
		iHand.setHand(hand);
		
		return this;
	}
	
	public Hand build() {
		return iHand;
	}
}
