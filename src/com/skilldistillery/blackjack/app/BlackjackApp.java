package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackDealerHand;
import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class BlackjackApp {

	private Scanner sc = new Scanner(System.in);
	private Deck deckOfCards = new Deck();
	private BlackjackHand blackJackHand = new BlackjackHand();
	private BlackjackDealerHand dealer = new BlackjackDealerHand();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApp blackJack = new BlackjackApp();
		blackJack.launch();

	}

	public void launch() {
		startMenu();
	}

	public void playAgain() {
		String choice;
		dealer.clear();
		blackJackHand.clear();
		do {
			System.out.println("Play again? Y/N");
			System.out.println("the are "+deckOfCards.size()+" cards left");
			choice = sc.next();
			if (choice.equalsIgnoreCase("Y")) {
				newHand();
			}
			else {
				System.out.println("Goodbye..");
				System.exit(0);
			}
		} while (choice.equalsIgnoreCase("Y"));
	}

	public void startMenu() {

		System.out.println("Hello welcome to Blackjack! ");
		System.out.println("Dealer is shuffling deck...");
		System.out.println();
		deckOfCards.shuffle();
		delayGame(4000);
		newHand();
	}

	public void hitOrStay() {
		System.out.println("Would you like to stay or hit?  ");
		System.out.print("Enter 0 to stay or 1 to hit: ");
		int choice = sc.nextInt();
		System.out.println();
		if (blackJackHand.getHandValue() > 21) {
			System.out.println("You busted !");
		}
		if (choice == 1 && blackJackHand.getHandValue() < 21) {
			dealPlayerCard();
			showPlayerHand();
			if (blackJackHand.getHandValue() < 21)
				hitOrStay();
		} else if (choice == 0) {
			dealerPlays();
		}
	}

	public void dealPlayerCard() {
		Card card = deckOfCards.dealCard();
		blackJackHand.addCard(card);
		System.out.println("Dealer deals you " + card);

	}

	public void dealDealerHiddenCard() {
		Card card = deckOfCards.dealCard();
		dealer.addCard(card);

	}

	public void dealDealerCard() {
		Card card = deckOfCards.dealCard();
		dealer.addCard(card);
		System.out.println("Dealer pulls " + card + "\n");

	}

	public void newHand() {
		boolean bust = false;
		

		System.out.println("Dealer will now begin dealing cards...\n");
		delayGame(2000);
		dealPlayerCard();
		System.out.println();

		delayGame(2000);
		System.out.println("Dealer Face down card\n");
		dealDealerHiddenCard();

		delayGame(2000);
		dealPlayerCard();
		System.out.println("");

		delayGame(2000);
		dealDealerCard();
		dealer.getShownCardValue();
		delayGame(2000);
		showPlayerHand();
		delayGame(2000);
		if (blackJackHand.getHandValue() == 21) {
			System.out.println("nice job! you got a 21 !");

			System.exit(0);
		}
		while (blackJackHand.getHandValue() < 21) {
			hitOrStay();
			if (blackJackHand.getHandValue() > 21)
				System.out.println("You busted!");
			showDealerHand();
			playAgain();
		}
		if (blackJackHand.getHandValue() == 21)
			System.out.println("You got a 21 you win!");
			playAgain();
	}

	public void dealerPlays() {
		boolean dealerBusts = false;
		System.out.println("Dealer turns hidden card...\n");
		dealer.getHiddenCardValue();
		delayGame(3000);
		showDealerHand();
		while (dealer.getHandValue() < 17) {
			dealDealerCard();
			showDealerHand();
			delayGame(3000);
			if (dealer.getHandValue() > 21 ) {
				System.out.println("Dealer busts !");
				System.out.println("You win");
				dealerBusts=true;
				playAgain();
				if (dealer.getHandValue() == 21) {
					System.out.println("Dealer has 21 !");
					showDealerHand();
					playAgain();
				}

			}
		}
		if (dealer.getHandValue() > blackJackHand.getHandValue() && dealerBusts == false ) {
			System.out.println("You lose !");
			showPlayerHand();
			playAgain();
		}
		if (dealer.getHandValue() < blackJackHand.getHandValue() || dealerBusts == true ) {
			System.out.println("You win !");
			showPlayerHand();
			playAgain();
		}
		if (dealer.getHandValue() == blackJackHand.getHandValue()) {
			System.out.println("You push !");
			showPlayerHand();
			playAgain();
		}


	}

	public void delayGame(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showPlayerHand() {
		System.out.println("Your hand: " + blackJackHand + "\n");
	}

	public void showDealerHand() {
		System.out.println("Dealer has " + dealer + "\n");
	}

}
