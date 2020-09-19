package com.danske;

import static org.junit.Assert.*;

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
	
	@Test
	public void testRoyalFlush() {
		
		assertTrue(Analyzer.isHandRoyalFlush(iHand));
		
		defaultHand[0].setValue(1);
		assertFalse(Analyzer.isHandRoyalFlush(iHand));
	}
	
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
	
//	@Test
//	public void testHighCard() {
//		assertEquals(14, Analyzer.getHighCard(defaultHand));
//	}

}
