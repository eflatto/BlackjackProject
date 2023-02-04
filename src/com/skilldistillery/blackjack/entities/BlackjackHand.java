package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		int total = 0;
		for (Card card : cards) {
			total=total+card.getRank().getValue();
		}
		return total;
	}

	
}
