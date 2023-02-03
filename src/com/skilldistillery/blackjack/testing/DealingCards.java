package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DealingCards dealer = new DealingCards();
		dealer.deal();
	}

	public void deal() {
		Deck theDeck = new Deck();
		System.out.println(theDeck.getDeck().size());
		System.out.println("How many cards do you want? ");
		Scanner scan = new Scanner(System.in);
		
		int numCards = scan.nextInt();
		scan.nextLine();
		
		theDeck.shuffle();
		for(int numCardsDealtSoFar = 0;numCardsDealtSoFar<numCards;numCardsDealtSoFar++) {
			Card aCard = theDeck.dealCard();
			
			System.out.println(theDeck.size()+ "cards left, just dealt: "+aCard);
		}
	}
}
