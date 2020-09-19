package com.danske;

import java.util.Arrays;

public class Hand {
	
	// Instance variables
	private Card[] hand;
	private int rank;
	
	// Constructors
	public Hand() {
		hand = new Card[5];
		rank = 0;
	}
	
	// Methods
	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + Arrays.toString(hand) + ", rank=" + rank + "]";
	}
		
}
