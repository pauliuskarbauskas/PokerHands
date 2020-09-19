package com.danske;

public class Card implements Comparable<Card> {
	
	// Instance Variables
	private int value;
	private Suit suit;
	
	// Constructors
	public Card() {
	}

	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	// Methods
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
	
	@Override
	public int compareTo(Card other) {

		if (this.value < other.value) {
			return -1;
		} else if (this.value > other.value) {
			return 1;
		}
		
		return 0;
	}

}
