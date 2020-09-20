package com.danske;

public class Analyzer {
	
	/**
	 * Determine if hand is straight
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStright(Hand hand) {
		
		for (int i = 0; i < 4; i++) {
			if (hand.getHand()[i].getValue() != hand.getHand()[i+1].getValue() - 1) {
				return false;
			}
		}
				
		hand.setRank(Rank.STRAIGHT);
		return true;
	}
	
	/**
	 * Determine if hand is Flush
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandFlush(Hand hand) {
		
		for (int i = 0; i < 4; i++) {
			if (hand.getHand()[i].getSuit() != hand.getHand()[i+1].getSuit()) {
				return false;
			}
		}
		
		hand.setRank(Rank.FLUSH);
		return true;
	}

	/**
	 * Determine if hand is straight flush
	 * @param hand
	 * @return boolean
	 */
	public static boolean isHandStraightFlush(Hand hand) {
		
		if (isHandFlush(hand) && isHandStright(hand)) {
			hand.setRank(Rank.STRAIGHT_FLUSH);
			return true;
			
		} else {
			hand.setRank(Rank.X);
		}
		
		return false;
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
			
			hand.setRank(Rank.FOUR_OF_KIND);
			return true;
		}
		
		if (lastCard == hand.getHand()[1].getValue() &&
			lastCard == hand.getHand()[2].getValue() &&
			lastCard == hand.getHand()[3].getValue()) {
			
			hand.setRank(Rank.FOUR_OF_KIND);
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
			
			hand.setRank(Rank.FULL_HOUSE);
			return true;
		}
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && 
			hand.getHand()[0].getValue() == hand.getHand()[2].getValue() &&
			hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
				
			hand.setRank(Rank.FULL_HOUSE);
			return true;
		}
		
		return false;
	}
	
	public static int getHighCard(Hand hand) {
		return hand.getHand()[4].getValue();
	}
	
	public static Rank getRank(Hand hand) {
		
		if (isHandStraightFlush(hand) && hand.getHand()[4].getValue() == 14) {
			return Rank.ROYAL;
		}
		
		if (isHandStraightFlush(hand)) {
			return Rank.STRAIGHT_FLUSH;
		}
		
		if (isFourOfKind(hand)) {
			return Rank.FOUR_OF_KIND;
		}
		
		if (isFullHouse(hand)) {
			return Rank.FULL_HOUSE;
		}
		
		if (isHandFlush(hand)) {
			return Rank.FLUSH;
		}
		
		if (isHandStright(hand)) {
			return Rank.STRAIGHT;
		}
		
		if (isThreeOfKind(hand)) {
			return Rank.THREE_OF_KIND;
		}
		
		if (isTwoPair(hand)) {
			return Rank.TWO_PAIR;
		}
		
		if (isOnePair(hand)) {
			return Rank.ONE_PAIR;
		}
		
		return Rank.X;
	}
	
	public static boolean analyze(Hand hand1, Hand hand2) {
		
		if (getRank(hand1).value > getRank(hand2).value) {
			return true;
		}
		
		if (getRank(hand1) == getRank(hand2)) {

			Rank rank = getRank(hand1);
			
			switch (rank) {
			
				case ROYAL:
					return false;
				
				case STRAIGHT_FLUSH:
					System.out.println("Hands are straight flushes but not royal");
					break;
					
				case FOUR_OF_KIND:
					break;
				
				case FLUSH:
					break;
					
				case STRAIGHT:
					break;
					
				case THREE_OF_KIND:
					break;
					
				case TWO_PAIR:
					break;
					
				case ONE_PAIR:
					break;
					
				default:
					break;
			}
		}
		
		return false;
		
	}

}
