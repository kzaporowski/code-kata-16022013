package pl.zaporowski.codekata.poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {
	
	private GameEngine gameEngine;
	
	@Before
	public void setUp(){
		gameEngine = new GameEngine();
	}
	
	@After
	public void tearDown(){
		gameEngine = null;
	}
	
	@Test
	public void testInit_void_shouldCreateCardset(){
		int expectedSize = 52;
		
		//when
		int actualSize = gameEngine.getDeckSize();
		
		//then
		Assert.assertEquals(expectedSize, actualSize);	
	}
	
	@Test
	public void testInit_void_shouldCreateUniqueCardset(){
		int expectedSize = 52;

		//when
		Collection<Card> actualDeck = gameEngine.getDeck();
		int actualSize = new HashSet<Card>(actualDeck).size();
		//then
		Assert.assertEquals(expectedSize, actualSize);	
	}
	
	@Test
	public void testDrawCards_withFiveCards_shouldReturnFiveCards(){
		int expectedSize = 5;
		
		List<Card> actualCardSet = gameEngine.drawCards(expectedSize);
		int actualSize = actualCardSet.size();
		
		Assert.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void testDrawCards_withFiveCards_shouldDecreaseDeckSizeByFive(){
		int cardToDrawCount = 5;
		int expectedSize = gameEngine.getDeckSize() - cardToDrawCount;
		
		gameEngine.drawCards(cardToDrawCount);
		int actualSize = gameEngine.getDeckSize();
		
		Assert.assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testDrawCard_withFiveCards_deckShouldNotContainCardsDrawn(){
		//given
		int cardToDrawCount = 5;
		Collection<Card> completeDeck = new ArrayList<Card>(gameEngine.getDeck());
		
		//when
		List<Card> expectedCardsSet = gameEngine.drawCards(cardToDrawCount);	
		Collection<Card> deckAfterDraw = gameEngine.getDeck();		
		completeDeck.removeAll(deckAfterDraw);
		
		//then
		Assert.assertEquals(expectedCardsSet, completeDeck);
	}
}