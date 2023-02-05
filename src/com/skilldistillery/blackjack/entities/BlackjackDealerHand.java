package com.skilldistillery.blackjack.entities;

public class BlackjackDealerHand extends Hand {

	
	public BlackjackDealerHand() {
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
	
	public void getHiddenCardValue() {
		System.out.println("Dealer turns a "+cards.get(0));
	}
	public void getShownCardValue() {
		System.out.println("Dealer has a face up "+cards.get(1) + " "+ cards.get(1).getRank().getValue());
	}

}
