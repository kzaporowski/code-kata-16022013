package pl.zaporowski.codekata.poker;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotEqualCardsCompareTest {
	private Card lowerCard;
	private Card greaterCard;
	
	@Before
	public void setUp(){
		Suit suit = Suit.CLUB;

		lowerCard = new Card(suit, CardVal.CARD_2);
		greaterCard = new Card(suit, CardVal.CARD_A);
	}
	
	@After
	public void tearDown(){
		lowerCard = null;
		greaterCard = null;
	}
	
	@Test
	public void testEquals_otherCardIsGreater_shouldReturnFalse(){
		boolean actualResult = lowerCard.equals(greaterCard);
		
		Assert.assertFalse("result should be false if other object is greater then base", actualResult);
	}
	
	@Test
	public void testEquals_otherCardIsLower_shouldReturnFalse(){
		boolean actualResult = greaterCard.equals(lowerCard);
		
		Assert.assertFalse("result should be false if other object is lower then base", actualResult);
	}
	
	@Test
	public void testHashCode_firstNotEqualsSecond_hashShouldNotBeTheSame(){
		int actualGreaterCardHashCode = greaterCard.hashCode();
		int actualLowerCardHashCode = lowerCard.hashCode();
		
		Assert.assertNotSame(actualGreaterCardHashCode, actualLowerCardHashCode);
	}
	
	@Test
	public void testHashCode_secondNotEqualsFirst_hashShouldNotBeTheSame(){
		int actualGreaterCardHashCode = lowerCard.hashCode();
		int actualLowerCardHashCode = greaterCard.hashCode();
		
		Assert.assertNotSame(actualGreaterCardHashCode, actualLowerCardHashCode);
	}
}