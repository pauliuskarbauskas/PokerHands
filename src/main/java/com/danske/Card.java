package com.danske;

public class Card {
	
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

}
