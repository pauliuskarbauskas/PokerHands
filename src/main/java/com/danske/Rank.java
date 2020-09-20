package com.danske;

public enum Rank {
	
	ROYAL(10),
	STRAIGHT_FLUSH(9),
	FOUR_OF_KIND(8),
	FULL_HOUSE(7),
	FLUSH(6),
	STRAIGHT(5),
	THREE_OF_KIND(4),
	TWO_PAIR(3),
	ONE_PAIR(2),
	HIGH_CARD(1),
	X(0);
	
	public final int value;
	
	private Rank(int value) {
		this.value = value;
	}
}
