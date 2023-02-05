package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player {
	private String name;
	private Hand hand = new BlackjackHand();
	private Deck deckOfCards;

	// Default no arg constructor 
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String name) {
		this.name = name;
		this.hand = new BlackjackHand();
	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void setName(String name) {
		this.name = name;
	}
	// Method to display the player's hand to the console
	public void showHand() {
		System.out.println("Your hand: " + getHand() + "\n");
	}
	// Method to recieve a card from the deck
	public void recieveCard(Deck deck) {
		Card card = deck.dealCard();
		hand.addCard(card);
		System.out.println("Dealer deals you " + card + " " + card.getRank().getValue());
	}

	@Override
	public String toString() {
		return "" + name ;
	}
	
}
