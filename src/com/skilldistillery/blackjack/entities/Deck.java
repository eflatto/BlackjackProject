package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> deck = new ArrayList<>(52);

	
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
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
	
	public int cardsLeftInDeck() {
		return 0;
		
	}
	
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public int size() {
		return deck.size();
		
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	
}
