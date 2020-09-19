package com.danske;

public class Analyzer {
	
	/**
	 * Determine if hand is straight
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStright(Hand hand) {
		
		boolean result = true;
		
		for (int i = 0; i < 4; i++) {
			if (hand.getHand()[i].getValue() != hand.getHand()[i+1].getValue() - 1) {
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
	public static boolean isHandFlush(Hand hand) {
		
		boolean result = true;
		
		for (int i = 0; i < 4; i++) {
			if (hand.getHand()[i].getSuit() != hand.getHand()[i+1].getSuit()) {
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
	public static boolean isHandRoyalFlush(Hand hand) {
		
		boolean result = false;
		
		if (isHandFlush(hand) && isHandStright(hand) && hand.getHand()[4].getValue() == 14) {
			result = true;
			hand.setRank(10);
		}
		
		return result;
	}
	
	/**
	 * Determine if hand is straight flush
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStraightFlush(Hand hand) {
		
		boolean result = false;
		
		if (isHandFlush(hand) && isHandStright(hand) && hand.getHand()[4].getValue() != 14) {
			result = true;
			hand.setRank(9);
		}
		
		return result;
	}
	
	/**
	 * Determines if hand is
	 * @param hand
	 * @return
	 */
	public static boolean isFourOfKind(Hand hand) {
		
		int firstCard = hand.getHand()[0].getValue();
		int lastCard = hand.getHand()[4].getValue();
		
		if (firstCard == hand.getHand()[1].getValue() &&
			firstCard == hand.getHand()[2].getValue() &&
			firstCard == hand.getHand()[3].getValue()) {
			return true;
		}
		
		if (lastCard == hand.getHand()[2].getValue() &&
			lastCard == hand.getHand()[3].getValue() &&
			lastCard == hand.getHand()[3].getValue()) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Determines if hand is Three of Kind
	 * @param hand
	 * @return boolean
	 */
	public static boolean isThreeOfKind(Hand hand) {
		
		int firstCard = hand.getHand()[0].getValue();
		int secondCard = hand.getHand()[1].getValue();
		int thirdCard = hand.getHand()[4].getValue();
		
		if(firstCard == hand.getHand()[1].getValue() && firstCard == hand.getHand()[2].getValue()) {
			return true;
		}
		
		if(secondCard == hand.getHand()[2].getValue() && secondCard == hand.getHand()[3].getValue()) {
			return true;
		}
		
		if(thirdCard == hand.getHand()[3].getValue() && thirdCard == hand.getHand()[4].getValue()) {
			return true;
		}

		return false;
	}
	
	/**
	 * Determines if hand is Two pair
	 * @param hand
	 * @return boolean
	 */
	public static boolean isTwoPair(Hand hand) {
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && hand.getHand()[2].getValue() == hand.getHand()[3].getValue()) {
			return true;
		}
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			return true;
		}
		
		if (hand.getHand()[1].getValue() == hand.getHand()[2].getValue() && hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Determines if hand has One Pair
	 * @param hand
	 * @return boolean
	 */
	public static boolean isOnePair(Hand hand) {
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue()) {
			return true;
		}
		
		if (hand.getHand()[1].getValue() == hand.getHand()[2].getValue()) {
			return true;
		}
		
		if (hand.getHand()[2].getValue() == hand.getHand()[3].getValue()) {
			return true;
		}
		
		if (hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			return true;
		}
		
		return false;
	}

	/**
	 * Determine if hand is full house
	 * @param hand
	 * @return boolean
	 */
	public static boolean isFullHouse(Hand hand) {
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && 
			hand.getHand()[2].getValue() == hand.getHand()[3].getValue() &&
			hand.getHand()[2].getValue() == hand.getHand()[4].getValue()) {
			
			return true;
		}
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && 
			hand.getHand()[0].getValue() == hand.getHand()[2].getValue() &&
			hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
				
			return true;
		}
		
		return false;
	}
	
	public static boolean analyze(Hand hand1, Hand hand2) {
		return hand1.getRank() > hand2.getRank();
		
	}
	
//	public static int getHighCard(Card[] hand) {
//		return hand[4].getValue();
//	}
}
