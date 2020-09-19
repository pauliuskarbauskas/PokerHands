package com.danske;

import java.util.Arrays;

public class Hand {
	
	// Instance variables
	private Card[] hand;

	// Constructors
	public Hand() {
		hand = new Card[5];
	}
	
	// Methods
	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + Arrays.toString(hand) + "]";
	}
	
}
