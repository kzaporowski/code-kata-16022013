package pl.zaporowski.codekata.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

	private List<Card> list;
	
	public GameEngine(){
		list = new ArrayList<Card>();
		
		for(Suit suit : Suit.values()){
			for(CardVal cardVal : CardVal.values()){
				list.add(new Card(suit, cardVal));
			}
		}
	}
	
	public List<Card> getDeck() {
		return Collections.unmodifiableList(list);
	}

	public List<Card> drawCards(int expectedSize) {
		 List<Card> drawnCards = new ArrayList<Card>();
		
		for(int i = 0; i < expectedSize; i++){
			drawnCards.add(list.remove(i));
		}
		return drawnCards;
	}
	
	public int getDeckSize(){
		return list.size();
	}
}