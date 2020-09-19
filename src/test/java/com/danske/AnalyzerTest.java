package com.danske;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest {
	
	private Card[] defaultHand;

	@Before
	public void setUp() throws Exception {
		
		// Set defaultHand to a royal flush for each test at the beginning
		defaultHand = new Card[5];
		defaultHand[0] = new Card(10, Suit.SPADE);
		defaultHand[1] = new Card(11, Suit.SPADE);
		defaultHand[2] = new Card(12, Suit.SPADE);
		defaultHand[3] = new Card(13, Suit.SPADE);
		defaultHand[4] = new Card(14, Suit.SPADE);
	}

	@After
	public void tearDown() throws Exception {
		defaultHand = null;
	}

	@Test
	public void testStraight() {
		
		assertTrue(Analyzer.isHandStright(defaultHand));
		
		defaultHand[0].setValue(1);
		assertFalse(Analyzer.isHandStright(defaultHand));
	}
	
	@Test
	public void testFlush() {
		
		assertTrue(Analyzer.isHandFlush(defaultHand));
		
		defaultHand[0].setSuit(Suit.DIAMOND);
		assertFalse(Analyzer.isHandFlush(defaultHand));
	}
	
	@Test
	public void testRoyalFlush() {
		
		assertTrue(Analyzer.isHandRoyalFlush(defaultHand));
		
		defaultHand[0].setValue(1);
		assertFalse(Analyzer.isHandRoyalFlush(defaultHand));
	}
	
	@Test
	public void testStraightFlush() {
		
		assertTrue(Analyzer.isHandStraightFlush(defaultHand));
		
		defaultHand[0].setValue(1);
		assertFalse(Analyzer.isHandStraightFlush(defaultHand));
	}
	
	@Test
	public void testFourOfKind() {
		
		assertFalse(Analyzer.isFourOfKind(defaultHand));
		
		// reset hand values to have poker of 10
		defaultHand[1].setValue(10);
		defaultHand[2].setValue(10);
		defaultHand[3].setValue(10);
		
		assertTrue(Analyzer.isFourOfKind(defaultHand));
		
		// test (9, 10, 10, 10, 10)
		defaultHand[0].setValue(9);
		defaultHand[4].setValue(10);
		
		assertTrue(Analyzer.isFourOfKind(defaultHand));
		
	}
	
//	@Test
//	public void testThreeOfKind() {
//		
//		// reset to three of kind (10, 10, 10, K, A)
//		defaultHand[1].setValue(10);
//		defaultHand[2].setValue(10);
//		
//		assertTrue(Analyzer.isThreeOfKind(defaultHand));
//
//	}

}
