package com.danske;

public class Analyzer {
	
	/**
	 * Determine if hand is straight
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStright(Card[] hand) {
		
		boolean result = true;
		
		for (int i = 0; i < 4; i++) {
			if (hand[i].getValue() != hand[i+1].getValue() - 1) {
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Determine if hand is Flush
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandFlush(Card[] hand) {
		
		boolean result = true;
		
		for (int i = 0; i < 4; i++) {
			if (hand[i].getSuit() != hand[i+1].getSuit()) {
				result = false;
			}
		}
		
		return result;
	}

	/**
	 * Determine if hand is royal
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandRoyalFlush(Card[] hand) {
		return isHandFlush(hand) && isHandStright(hand) && hand[4].getValue() == 14;
	}
	
	/**
	 * Determine if hand is straight flush
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStraightFlush(Card[] hand) {
		return isHandFlush(hand) && isHandStright(hand);
	}
	
	/**
	 * Determines if hand is
	 * @param hand
	 * @return
	 */
	public static boolean isFourOfKind(Card[] hand) {
		
		boolean result = true;
		
		for (int i = 0; i < 3; i++) {
			if (hand[i].getValue() != hand[i+1].getValue()) {
				result = false;
			}
		}
		
		return result;
	}

}
