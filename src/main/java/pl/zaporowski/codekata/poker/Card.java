package pl.zaporowski.codekata.poker;

public class Card {
	
	private Suit suit;
	private CardVal value;
	@SuppressWarnings("unused")
	private Card(){
		
	}
	
	public Card(Suit suit, CardVal val){
		this.suit = suit;
		this.value = val;
	}

	public Suit getSuit() {
		return suit;
		
	}

	public CardVal getValue() {
		return value;
	}

	public int compareOtherCardValue(Card other) {
		if(this.getValue().getVal() == other.getValue().getVal()){
			return 0;
		}
		
		if(this.getValue().getVal() > other.getValue().getVal()){
			return 1;
		}
		
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	
}
