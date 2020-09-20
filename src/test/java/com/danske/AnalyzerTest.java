package com.danske;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest {
	
	private Card[] defaultHand;
	private Hand iHand;
	
	@Before
	public void setUp() throws Exception {
		
		// Set defaultHand to a royal flush for each test at the beginning
		defaultHand = new Card[5];
		defaultHand[0] = new Card(10, Suit.SPADE);
		defaultHand[1] = new Card(11, Suit.SPADE);
		defaultHand[2] = new Card(12, Suit.SPADE);
		defaultHand[3] = new Card(13, Suit.SPADE);
		defaultHand[4] = new Card(14, Suit.SPADE);
		
		iHand = new Hand();
		iHand.setHand(defaultHand);
	}

	@After
	public void tearDown() throws Exception {
		defaultHand = null;
	}

	@Test
	public void testStraight() {
		
		assertTrue(Analyzer.isHandStright(iHand));
		
		defaultHand[0].setValue(1);
		assertFalse(Analyzer.isHandStright(iHand));
	}
	
	@Test
	public void testFlush() {
		
		assertTrue(Analyzer.isHandFlush(iHand));
		
		defaultHand[0].setSuit(Suit.DIAMOND);
		assertFalse(Analyzer.isHandFlush(iHand));
	}
	
//	@Test
//	public void testRoyalFlush() {
//		
//		assertTrue(Analyzer.isHandRoyalFlush(iHand));
//		
//		defaultHand[0].setValue(1);
//		assertFalse(Analyzer.isHandRoyalFlush(iHand));
//	}
	
	@Test
	public void testStraightFlush() {
		
		defaultHand[0].setValue(2);
		defaultHand[1].setValue(3);
		defaultHand[2].setValue(4);
		defaultHand[3].setValue(5);
		defaultHand[4].setValue(6);
		assertTrue(Analyzer.isHandStraightFlush(iHand));
		
		defaultHand[4].setValue(14);
		assertFalse(Analyzer.isHandStraightFlush(iHand));
	}
	
	@Test
	public void testFourOfKind() {
		
		assertFalse(Analyzer.isFourOfKind(iHand));
		
		// reset hand values to have poker of 10
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(10);
		defaultHand[3].setValue(10);
		assertTrue(Analyzer.isFourOfKind(iHand));
		
		// test (9, 10, 10, 10, 10)
		defaultHand[0].setValue(9);
		defaultHand[4].setValue(10);
		assertTrue(Analyzer.isFourOfKind(iHand));
		
	}
	
	@Test
	public void testThreeOfKind() {
		
		assertFalse(Analyzer.isThreeOfKind(iHand));
		
		// reset to three of kind (10, 10, 10, K, A)
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(10);
		assertTrue(Analyzer.isThreeOfKind(iHand));
		
		// test (9, 10, 10, 10, A)
		defaultHand[0].setValue(9);
		defaultHand[3].setValue(10);
		assertTrue(Analyzer.isThreeOfKind(iHand));
		
		// test (9, 10, A, A, A)
		defaultHand[0].setValue(9);
		defaultHand[2].setValue(14);
		defaultHand[3].setValue(14);
		assertTrue(Analyzer.isThreeOfKind(iHand));

	}
	
	@Test
	public void testTwoPair() {
		
		assertFalse(Analyzer.isTwoPair(iHand));
		
		// test (10, 10, 11, 11, A)
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(11);
		defaultHand[3].setValue(11);
		
		assertTrue(Analyzer.isTwoPair(iHand));
		
		// test (10, 10, 11, A, A)
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(11);
		defaultHand[3].setValue(14);
		
		assertTrue(Analyzer.isTwoPair(iHand));
		
		// test (10, 11, 11, A, A)
		defaultHand[1].setValue(11);
		defaultHand[2].setValue(11);
		defaultHand[3].setValue(14);
		
		assertTrue(Analyzer.isTwoPair(iHand));
	}
	
	@Test
	public void testOnePair() {
		
		assertFalse(Analyzer.isOnePair(iHand));
		
		// test (10, 10, 12, 13, A)
		defaultHand[1].setValue(10);
		assertTrue(Analyzer.isOnePair(iHand));
		
		// test (10, 12, 12, 13, 14)
		defaultHand[1].setValue(12);
		assertTrue(Analyzer.isOnePair(iHand));
		
		// test (10, 12, 13, 13, 14)
		defaultHand[2].setValue(13);
		assertTrue(Analyzer.isOnePair(iHand));
		
		// test (10, 12, 13, 14, 14)
		defaultHand[3].setValue(14);
		assertTrue(Analyzer.isOnePair(iHand));
		
	}	
	
	@Test
	public void testFullHouse() {
		
		// test (10, 10, A, A, A)
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(14);
		defaultHand[3].setValue(14);
		assertTrue(Analyzer.isFullHouse(iHand));
		
		// test (10, 10, 10, A, A)
		defaultHand[2].setValue(10);
		defaultHand[3].setValue(14);
		assertTrue(Analyzer.isFullHouse(iHand));
		
	}
	
	@Test
	public void testHandRank() {

		HandBuilder handBuilder = new HandBuilder();

		assertEquals(Rank.ROYAL, Analyzer.getRank(handBuilder.withRoyalFlush(Suit.DIAMOND).build()));
		assertEquals(Rank.STRAIGHT_FLUSH, Analyzer.getRank(handBuilder.withStraightFlush(5, Suit.DIAMOND).build()));
		assertEquals(Rank.FOUR_OF_KIND, Analyzer.getRank(handBuilder.withFourOfKind(5, 2).build()));
		assertEquals(Rank.FULL_HOUSE, Analyzer.getRank(handBuilder.withFullHouse(5, 2).build()));
		assertEquals(Rank.FLUSH, Analyzer.getRank(handBuilder.withFlush(Suit.DIAMOND).build()));
		assertEquals(Rank.STRAIGHT, Analyzer.getRank(handBuilder.withStraightOf(7).build()));
		assertEquals(Rank.THREE_OF_KIND, Analyzer.getRank(handBuilder.withThreeOfKind(3, 4, 5).build()));
		assertEquals(Rank.TWO_PAIR, Analyzer.getRank(handBuilder.withTwoPair(3, 4, 5).build()));
		assertEquals(Rank.ONE_PAIR, Analyzer.getRank(handBuilder.withOnePair(3, 4).build()));
		assertEquals(Rank.HIGH_CARD, Analyzer.getRank(handBuilder.withHighCard().build()));
		
	}
	
	@Test
	public void testCompareFourOfKind() {
		
		List<Hand> parsedHands = Helper.parseHands("2C 2D 2H 2S 5S 3C 3C 3D 3H AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("2C AD AH AS AS 3C AC AD AH AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("3C 3D 3H 3S 5S 2C 2C 2D 2H AS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("3C AD AH AS AS 2C AC AD AH AS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
	}
	
	@Test
	public void testCompareHighCard() {
		
		List<Hand> parsedHands = Helper.parseHands("2C 3D 5H 7S KS 2C 3C 5D 7H AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("2C 3D 5H 7S AS 2C 3C 5D 7H AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("2C 3D 5H 7S AS 2C 3C 5D 7H KS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
	}
	
	@Test
	public void testCompareThreeOfKind() {
		
		List<Hand> parsedHands = Helper.parseHands("2C 2D 2H 7S KS 3C 3C 3D 7H AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("2C 3D 3H 3S KS 2C 3C 3D 3H AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("2C 3D KH KS KS 2C 3C AD AH AS");
		assertFalse(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("3C 3D 3H KS AS 2C 2C 2D KH AS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("3C 3D 3H KS AS 3C 3C 3D TH KS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
		parsedHands = Helper.parseHands("3C 3D 3H KS AS 3C 3C 3D TH AS");
		assertTrue(Analyzer.analyze(parsedHands.get(0), parsedHands.get(1)));
		
	}
	
	@Test
	public void testHighCard() {
		assertEquals(14, Analyzer.getHighCard(iHand));
	}
	
	
	
}
