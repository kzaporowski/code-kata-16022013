package pl.zaporowski.codekata.poker;

public enum CardVal {
	CARD_2(2),CARD_3(3),CARD_4(4),CARD_5(5),CARD_6(6),CARD_7(7)
	,CARD_8(8),CARD_9(9),CARD_T(10),CARD_J(11),CARD_Q(12),CARD_K(13),CARD_A(14);
	
	private int val;

	CardVal(int val){
		this.val = val;
	}
	
	public int getVal(){
		return val;
	}
}
