package com.danske;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;	

public class HelperTest {
	
    /** The exception rule. */
    @Rule
    public ExpectedException iThrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadHandsMethodReadsDataFromFile() {
		
		List<String> data = Helper.readHands("poker.txt");

		assertNotNull(data);	
		assertEquals(1000, data.size());
		assertEquals("8C TS KC 9H 4S 7D 2S 5D 3S AC", data.get(0));
		assertEquals("AS KD 3D JD 8H 7C 8C 5C QD 6C", data.get(data.size()-1));
		
	}
	
	@Test
	public void testParseHandsParsesCardValuesAndSuits() {
		
		List<Hand> parsedHands = Helper.parseHands("1C 2D 3H 4S 5S 7D 2S 5D 3S AC");
		
		assertEquals(1, parsedHands.get(0).getHand()[0].getValue());
		assertEquals(Suit.CLUB, parsedHands.get(0).getHand()[0].getSuit());
		
		assertEquals(2, parsedHands.get(0).getHand()[1].getValue());
		assertEquals(Suit.DIAMOND, parsedHands.get(0).getHand()[1].getSuit());
		
		assertEquals(3, parsedHands.get(0).getHand()[2].getValue());
		assertEquals(Suit.HEART, parsedHands.get(0).getHand()[2].getSuit());
		
		assertEquals(4, parsedHands.get(0).getHand()[3].getValue());
		assertEquals(Suit.SPADE, parsedHands.get(0).getHand()[3].getSuit());
		
		assertEquals(5, parsedHands.get(0).getHand()[4].getValue());
	}
	
	@Test
	public void testParseHandsSortsHandsByValue() {
		
		List<Hand> parsedHands = Helper.parseHands("1C 2D 4H 3S 5S 7D 6S 9D 8S AC");
		
		assertEquals(1, parsedHands.get(0).getHand()[0].getValue());
		assertEquals(2, parsedHands.get(0).getHand()[1].getValue());
		assertEquals(3, parsedHands.get(0).getHand()[2].getValue());
		assertEquals(4, parsedHands.get(0).getHand()[3].getValue());
		assertEquals(5, parsedHands.get(0).getHand()[4].getValue());
		assertEquals(6, parsedHands.get(1).getHand()[0].getValue());
		assertEquals(7, parsedHands.get(1).getHand()[1].getValue());
		assertEquals(8, parsedHands.get(1).getHand()[2].getValue());
		assertEquals(9, parsedHands.get(1).getHand()[3].getValue());
		assertEquals(14, parsedHands.get(1).getHand()[4].getValue());
	}
	
	@Test
	public void testParseHandsParsesCardValuesFromTenToAce() {
		
		List<Hand> parsedHands = Helper.parseHands("1C 2D 3H 4S 5S TC JC QD KH AS");
		
		assertEquals(10, parsedHands.get(1).getHand()[0].getValue());
		assertEquals(11, parsedHands.get(1).getHand()[1].getValue());
		assertEquals(12, parsedHands.get(1).getHand()[2].getValue());
		assertEquals(13, parsedHands.get(1).getHand()[3].getValue());
		assertEquals(14, parsedHands.get(1).getHand()[4].getValue());
		
	}
	
	@Test
	public void testParseHandsParsesInvalidCardValues() {
		
		List<Hand> parsedHands = Helper.parseHands("## 2D 3H 4S 5S JC QD KH AS AC");
		
		assertEquals(0, parsedHands.get(0).getHand()[0].getValue());
		
	}

}
