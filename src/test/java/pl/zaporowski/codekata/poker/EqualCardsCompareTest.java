package pl.zaporowski.codekata.poker;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EqualCardsCompareTest {
	
	private Card first;
	private Card second;
	
	@Before
	public void setUp(){
		Suit suit = Suit.CLUB;
		CardVal cardVal = CardVal.CARD_2;
		first = new Card(suit, cardVal);
		second = new Card(suit, cardVal);
	}
	
	@After
	public void tearDown(){
		first = null;
		second = null;
	}
	
	@Test
	public void testEquals_firstEqualsSecond_shouldReturnTrue(){
		boolean actualResult = first.equals(second);
		
		Assert.assertTrue("result should be true if first object is equal with second", actualResult);
	}
	
	@Test
	public void testEquals_secondEqualsFirst_shouldReturnTrue(){
		boolean actualResult = second.equals(first);
		
		Assert.assertTrue("result should be true if second object is equal with first", actualResult);
	}
	
	@Test
	public void testHashCode_firstEqualsSecond_hashShouldBeTheSame(){
		int expectedResult = first.hashCode();
		int actualResult = second.hashCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testHashCode_secondEqualsFirst_hashShouldBeTheSame(){
		int expectedResult = second.hashCode();
		int actualResult = first.hashCode();
		
		Assert.assertEquals(expectedResult, actualResult);
	}
}
