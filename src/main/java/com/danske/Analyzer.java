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
		
		if(hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && hand.getHand()[0].getValue() == hand.getHand()[2].getValue()) {
			hand.setRank(Rank.THREE_OF_KIND);
			return true;
		}
		
		if(hand.getHand()[1].getValue() == hand.getHand()[2].getValue() && hand.getHand()[1].getValue() == hand.getHand()[3].getValue()) {
			hand.setRank(Rank.THREE_OF_KIND);
			return true;
		}
		
		if(hand.getHand()[2].getValue() == hand.getHand()[3].getValue() && hand.getHand()[2].getValue() == hand.getHand()[4].getValue()) {
			hand.setRank(Rank.THREE_OF_KIND);
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
			hand.setRank(Rank.TWO_PAIR);
			return true;
		}
		
		if (hand.getHand()[0].getValue() == hand.getHand()[1].getValue() && hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			hand.setRank(Rank.TWO_PAIR);
			return true;
		}
		
		if (hand.getHand()[1].getValue() == hand.getHand()[2].getValue() && hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			hand.setRank(Rank.TWO_PAIR);
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
			hand.setRank(Rank.ONE_PAIR);
			return true;
		}
		
		if (hand.getHand()[1].getValue() == hand.getHand()[2].getValue()) {
			hand.setRank(Rank.ONE_PAIR);
			return true;
		}
		
		if (hand.getHand()[2].getValue() == hand.getHand()[3].getValue()) {
			hand.setRank(Rank.ONE_PAIR);
			return true;
		}
		
		if (hand.getHand()[3].getValue() == hand.getHand()[4].getValue()) {
			hand.setRank(Rank.ONE_PAIR);
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
	
	/**
	 * gets Highest value card of the hand
	 * @param hand
	 * @return int value
	 */
	public static int getHighCard(Hand hand) {
		return hand.getHand()[4].getValue();
	}
	
	/**
	 * Checks the hands rank
	 * @param hand
	 * @return Rank
	 */
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
		
		hand.setRank(Rank.HIGH_CARD);
		
		return Rank.HIGH_CARD;
	}
	
	/**
	 * Compares Four Of Kind hands
	 * @param hand1
	 * @param hand2
	 * @return true if hand 1 won
	 */
	public static boolean compareFourOfKind(Hand hand1, Hand hand2) {
		
		int hand1Poker = 0;
		int hand1Kicker = 0;
		int hand2Poker = 0;
		int hand2Kicker = 0;
		
		if (hand1.getHand()[0].getValue() == hand1.getHand()[1].getValue()) {
			hand1Poker = hand1.getHand()[0].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else {
			hand1Poker = hand1.getHand()[4].getValue();
			hand1Kicker = hand1.getHand()[0].getValue();
		}
		
		if (hand2.getHand()[0].getValue() == hand2.getHand()[1].getValue()) {
			hand2Poker = hand2.getHand()[0].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else {
			hand2Poker = hand2.getHand()[4].getValue();
			hand2Kicker = hand2.getHand()[0].getValue();
		}
		
		if (hand1Poker > hand2Poker) {
			return true;
		} else if (hand1Poker == hand2Poker) {
			return hand1Kicker > hand2Kicker;
		}
		
		return false;
	}
	
	/**
	 * Compares both hands for a better high card
	 * @param hand1
	 * @param hand2
	 * @return true if hand 1 has better high card
	 */
	public static boolean compareHighCard(Hand hand1, Hand hand2) {
		
		for (int i = 4; i >= 0; i--) {
			
			if (hand1.getHand()[i].getValue() != hand2.getHand()[i].getValue()) {
				return hand1.getHand()[i].getValue() > hand2.getHand()[i].getValue();
			}
		}
		
		return false;
	}
	
	/**
	 * Compares hands for a better three of kind rank
	 * @param hand1
	 * @param hand2
	 * @return true if hand1 has better hand
	 */
	public static boolean compareThreeOfKind(Hand hand1, Hand hand2) {
		
		int hand1PlayingHand = 0;
		int hand1Kicker = 0;
		int hand2PlayingHand = 0;
		int hand2Kicker = 0;
		
		if (hand1.getHand()[0].getValue() == hand1.getHand()[1].getValue()) {
			hand1PlayingHand = hand1.getHand()[0].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[1].getValue() == hand1.getHand()[2].getValue()) {
			hand1PlayingHand = hand1.getHand()[1].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[2].getValue() == hand1.getHand()[3].getValue()) {
			hand1PlayingHand = hand1.getHand()[2].getValue();
			hand1Kicker = hand1.getHand()[1].getValue();
		}
		
		if (hand2.getHand()[0].getValue() == hand2.getHand()[1].getValue()) {
			hand2PlayingHand = hand2.getHand()[0].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[1].getValue() == hand2.getHand()[2].getValue()) {
			hand2PlayingHand = hand2.getHand()[1].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[2].getValue() == hand2.getHand()[3].getValue()) {
			hand2PlayingHand = hand2.getHand()[2].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		}
		
		if (hand1PlayingHand > hand2PlayingHand) {
			return true;
		} else if (hand1PlayingHand == hand2PlayingHand) {
			
			if (hand1Kicker > hand2Kicker) {
				return true;
			}
			
			for (int i = 4; i >= 0; i--) {
				if (hand1.getHand()[i].getValue() > hand2.getHand()[i].getValue()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Compares both hands for a better pair rank
	 * @param hand1
	 * @param hand2
	 * @return true if hand1 has better pair or kicker if pairs are the same rank
	 */
	public static boolean compareOnePair(Hand hand1, Hand hand2) {
		
		int hand1PlayingHand = 0;
		int hand1Kicker = 0;
		int hand2PlayingHand = 0;
		int hand2Kicker = 0;
		
		if (hand1.getHand()[0].getValue() == hand1.getHand()[1].getValue()) {
			hand1PlayingHand = hand1.getHand()[0].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[1].getValue() == hand1.getHand()[2].getValue()) {
			hand1PlayingHand = hand1.getHand()[1].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[2].getValue() == hand1.getHand()[3].getValue()) {
			hand1PlayingHand = hand1.getHand()[2].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[3].getValue() == hand1.getHand()[4].getValue()) {
			hand1PlayingHand = hand1.getHand()[4].getValue();
			hand1Kicker = hand1.getHand()[2].getValue();
		}
		
		if (hand2.getHand()[0].getValue() == hand2.getHand()[1].getValue()) {
			hand2PlayingHand = hand2.getHand()[0].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[1].getValue() == hand2.getHand()[2].getValue()) {
			hand2PlayingHand = hand2.getHand()[1].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[2].getValue() == hand2.getHand()[3].getValue()) {
			hand2PlayingHand = hand2.getHand()[2].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[3].getValue() == hand2.getHand()[4].getValue()) {
			hand2PlayingHand = hand2.getHand()[4].getValue();
			hand2Kicker = hand2.getHand()[2].getValue();
		}
		
		if (hand1PlayingHand > hand2PlayingHand) {
			return true;
		} else if (hand1PlayingHand == hand2PlayingHand) {
			return hand1Kicker > hand2Kicker;
		}
		
		return false;
	}
	
	/**
	 * Compares hands for a better two pair 
	 * @param hand1
	 * @param hand2
	 * @return true is hand 1 has better two pairs or if higher kicker if pairs are the same
	 */
	public static boolean compareTwoPair(Hand hand1, Hand hand2) {
	
		int hand1PlayingHand = 0;
		int hand1Kicker = 0;
		int hand2PlayingHand = 0;
		int hand2Kicker = 0;
		
		if (hand1.getHand()[0].getValue() == hand1.getHand()[1].getValue() && hand1.getHand()[2].getValue() == hand1.getHand()[3].getValue()) {
			hand1PlayingHand = hand1.getHand()[0].getValue() > hand1.getHand()[2].getValue() ? hand1.getHand()[0].getValue() : hand1.getHand()[2].getValue();
			hand1Kicker = hand1.getHand()[4].getValue();
		} else if (hand1.getHand()[0].getValue() == hand1.getHand()[1].getValue() && hand1.getHand()[3].getValue() == hand1.getHand()[4].getValue()) {
			hand1PlayingHand = hand1.getHand()[0].getValue() > hand1.getHand()[3].getValue() ? hand1.getHand()[0].getValue() : hand1.getHand()[3].getValue();
			hand1Kicker = hand1.getHand()[2].getValue();
		} else if (hand1.getHand()[1].getValue() == hand1.getHand()[2].getValue() && hand1.getHand()[3].getValue() == hand1.getHand()[4].getValue()) {
			hand1PlayingHand = hand1.getHand()[1].getValue() > hand1.getHand()[3].getValue() ? hand1.getHand()[1].getValue() : hand1.getHand()[3].getValue();
			hand1Kicker = hand1.getHand()[0].getValue();
		}
		
		if (hand2.getHand()[0].getValue() == hand2.getHand()[1].getValue() && hand2.getHand()[2].getValue() == hand2.getHand()[3].getValue()) {
			hand2PlayingHand = hand2.getHand()[0].getValue() > hand2.getHand()[2].getValue() ? hand2.getHand()[0].getValue() : hand2.getHand()[2].getValue();
			hand2Kicker = hand2.getHand()[4].getValue();
		} else if (hand2.getHand()[0].getValue() == hand2.getHand()[1].getValue() && hand2.getHand()[3].getValue() == hand2.getHand()[4].getValue()) {
			hand2PlayingHand = hand2.getHand()[0].getValue() > hand2.getHand()[3].getValue() ? hand2.getHand()[0].getValue() : hand2.getHand()[3].getValue();
			hand2Kicker = hand2.getHand()[2].getValue();
		} else if (hand2.getHand()[1].getValue() == hand2.getHand()[2].getValue() && hand2.getHand()[3].getValue() == hand2.getHand()[4].getValue()) {
			hand2PlayingHand = hand2.getHand()[1].getValue() > hand2.getHand()[3].getValue() ? hand2.getHand()[1].getValue() : hand2.getHand()[3].getValue();
			hand2Kicker = hand2.getHand()[0].getValue();
		}
		
		if (hand1PlayingHand > hand2PlayingHand) {
			return true;
		} else if (hand1PlayingHand == hand2PlayingHand) {
			return hand1Kicker > hand2Kicker;
		}
		
		return false;
	}
	
	/**
	 * Analyzes winner based on Rank and or kicker if ranks of the hands are the same
	 * @param hand1
	 * @param hand2
	 * @return true if hand1 has won
	 */
	public static boolean analyze(Hand hand1, Hand hand2) {
		
		if (getRank(hand1).value > getRank(hand2).value) {
			return true;
		} else if (getRank(hand1).value < getRank(hand2).value) {
			return false;
		} else if (getRank(hand1) == getRank(hand2)) {

			Rank rank = getRank(hand1);
			
			switch (rank) {
			
				case ROYAL:
					return false;
				case STRAIGHT_FLUSH:
				case STRAIGHT:
				case FLUSH:
				case HIGH_CARD:
					return compareHighCard(hand1, hand2);
				case FOUR_OF_KIND:
					return compareFourOfKind(hand1, hand2);
				case THREE_OF_KIND:
					return compareThreeOfKind(hand1, hand2);
				case TWO_PAIR:
					return compareTwoPair(hand1, hand2);
				case ONE_PAIR:
					return compareOnePair(hand1, hand2);
				default:
					break;
			}
		}
		
		return false;
		
	}

}
