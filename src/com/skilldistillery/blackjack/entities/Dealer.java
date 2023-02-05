package com.skilldistillery.blackjack.entities;

public class Dealer {

	private BlackjackDealerHand hand = new BlackjackDealerHand();
	public Dealer() {
		
	}
	
	public void dealDealerCard(Deck deck) {
		Card card = deck.dealCard();
		hand.addCard(card);
		System.out.println("Dealer pulls " + card + "\n");

	}
	public void showDealerHand() {
		System.out.println("Dealer has " + hand + "\n");
	}

	public void getHiddenCard() {
		hand.getHiddenCardValue();
	}
	public int getTotalCardVal() {
		return hand.getHandValue();
	}
	public void getShownCardVal() {
		hand.getShownCardValue();
	}
	public void dealDealerHiddenCard(Deck deck) {
		Card card = deck.dealCard();
		hand.addCard(card);

	}

	public BlackjackDealerHand getHand() {
		return hand;
	}

	public void setHand(BlackjackDealerHand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return  hand + "";
	}
	

	
}