package pl.zaporowski.codekata.poker;

import junit.framework.Assert;

import org.junit.Test;

public class CardValueCompareTest {

	private static final int EQUAL_OBJECTS_RESULT = 0;

	@Test
	public void testCompareOtherCardValue_someCards_shouldReturnZero(){
		Suit suit = Suit.CLUB;
		CardVal val = CardVal.CARD_2;
		Card card_First = new Card(suit, val);
		Card card_Second = new Card(suit, val);
		int expectedEqualObjectsResult = EQUAL_OBJECTS_RESULT;
		
		int actualEqualObjectsResult = card_First.compareOtherCardValue(card_Second);
		
		Assert.assertEquals(expectedEqualObjectsResult, actualEqualObjectsResult);
	}
	
	@Test
	public void testCompareOtherCardValue_firstCardIsGreater_shouldReturnGreaterThenZero(){
		//given
		Suit suit = Suit.CLUB;
		Card card_First = new Card(suit, CardVal.CARD_A);
		Card card_Second = new Card(suit, CardVal.CARD_9);
		//when
		int actualFirstObjectsIsGreaterResult = card_First.compareOtherCardValue(card_Second);
		//then
		Assert.assertTrue("Should be greater then zero", actualFirstObjectsIsGreaterResult > 0);
	}
	
	@Test
	public void testCompareOtherCardValue_secondCardIsGreater_shouldReturnLessThenZero(){
		//given
		Suit suit = Suit.CLUB;
		Card card_First = new Card(suit, CardVal.CARD_3);
		Card card_Second = new Card(suit, CardVal.CARD_J);
		//when
		int actualSecondObjectsIsGreaterResult = card_First.compareOtherCardValue(card_Second);
		//then
		Assert.assertTrue("Should be less then zero", actualSecondObjectsIsGreaterResult < 0);
	}
	
	@Test
	public void testCompareOtherCardValue_secondCardIsNull_shouldThrowNPE(){
		//given
		Suit suit = Suit.CLUB;
		Card card_First = new Card(suit, CardVal.CARD_3);
		Card card_Second = null;
		//when
		try {
			card_First.compareOtherCardValue(card_Second);
			Assert.fail("NPE expected here");
		}catch(NullPointerException e) {
			
		}
		
	}
}
