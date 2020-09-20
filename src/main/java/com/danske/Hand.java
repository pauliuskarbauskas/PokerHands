package com.danske;

import java.util.Arrays;

public class Hand {
	
	// Instance variables
	private Card[] hand;
	private Rank rank;
	
	// Constructors
	public Hand() {
		hand = new Card[5];
	}
	
	public Hand(Card[] hand) {
		this.hand = hand;
	}
	
	// Methods
	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + Arrays.toString(hand) + ", rank=" + rank + "]";
	}
		
}
