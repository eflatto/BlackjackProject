package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Class that represents the Deck
public class Deck {
	//List of Card Objects 
	private List<Card> deck = new ArrayList<>(52);

	// Constructor to create a deck of 52 cards, with each suit having
	//a rank of Ace, 2 to 10, Jack, Queen, and King
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		// Iterate through each suit and each rank to 
		//create a Card object and add it to the deck
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(rank,suit);
				deck.add(card);
			}
		}
	}

	public Deck(ArrayList<Card> deck) {
		super();
		this.deck = deck;
	}	
	
	
	// Removes and returns the top card in the deck
	public Card dealCard() {
		return deck.remove(0);
	}
	
	// Shuffles the deck using the Collections.shuffle method
	public void shuffle() {
		Collections.shuffle(deck);
	}
	// Returns the number of cards remaining in the deck
	public int size() {
		return deck.size();
		
	}
	// Getter for the deck list
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	
}
