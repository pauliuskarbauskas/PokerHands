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
		
		int firstCard = hand[0].getValue();
		int lastCard = hand[4].getValue();
		
		if (firstCard == hand[1].getValue() && firstCard == hand[2].getValue() && firstCard == hand[3].getValue()) {
			return true;
		}
		
		if (lastCard == hand[2].getValue() && lastCard == hand[3].getValue() && lastCard == hand[3].getValue()) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Determines if hand is Three of Kind
	 * @param hand
	 * @return boolean
	 */
	public static boolean isThreeOfKind(Card[] hand) {
		
		int firstCard = hand[0].getValue();
		int secondCard = hand[1].getValue();
		int thirdCard = hand[4].getValue();
		
		if(firstCard == hand[1].getValue() && firstCard == hand[2].getValue()) {
			return true;
		}
		
		if(secondCard == hand[2].getValue() && secondCard == hand[3].getValue()) {
			return true;
		}
		
		if(thirdCard == hand[3].getValue() && thirdCard == hand[4].getValue()) {
			return true;
		}

		return false;
	}
	
	/**
	 * Determines if hand is Two pair
	 * @param hand
	 * @return boolean
	 */
	public static boolean isTwoPair(Card[] hand) {
		
		if (hand[0].getValue() == hand[1].getValue() && hand[2].getValue() == hand[3].getValue()) {
			return true;
		}
		
		if (hand[0].getValue() == hand[1].getValue() && hand[3].getValue() == hand[4].getValue()) {
			return true;
		}
		
		if (hand[1].getValue() == hand[2].getValue() && hand[3].getValue() == hand[4].getValue()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Determines if hand has One Pair
	 * @param hand
	 * @return boolean
	 */
	public static boolean isOnePair(Card[] hand) {
		
		if (hand[0].getValue() == hand[1].getValue()) {
			return true;
		}
		
		if (hand[1].getValue() == hand[2].getValue()) {
			return true;
		}
		
		if (hand[2].getValue() == hand[3].getValue()) {
			return true;
		}
		
		if (hand[3].getValue() == hand[4].getValue()) {
			return true;
		}
		
		return false;
	}

}
