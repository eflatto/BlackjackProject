package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	private Scanner sc = new Scanner(System.in);
	private Deck deckOfCards = new Deck();
	private Player player = new Player();
	private BlackjackDealer dealer = new BlackjackDealer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApp blackJack = new BlackjackApp();
		blackJack.launch();
	}

	public void launch() {
		startMenu();
	}

	public void startMenu() {

		System.out.println("Hello welcome to Blackjack! ");
		System.out.println("Dealer is shuffling deck...");
		System.out.println();
		deckOfCards.shuffle();
		delayGame(4000);
		newHand();
	}

	public void playAgain() {
		String choice;
		dealer.getHand().clear();
		player.getHand().clear();
		do {
			System.out.println("Press Y to play again");
			System.out.println("Or hit any other key to exit");
			System.out.println("there are " + deckOfCards.size() + " cards left");
			if (deckOfCards.size() == 0) {
				System.out.println("Sorry please start over ran out of cards");
				System.exit(0);
			}
			choice = sc.next();
			if (choice.equalsIgnoreCase("Y")) {
				newHand();
			} else {
				System.out.println("Goodbye..");
				System.exit(0);
			}
		} while (choice.equalsIgnoreCase("Y"));
	}

	public void hitOrStay() {
		System.out.println("Would you like to stay or hit?  ");
		System.out.print("Enter 0 to stay or 1 to hit: ");
		int choice = sc.nextInt();
		System.out.println();
		if (player.getHand().getHandValue() > 21) {
			System.out.println("You busted !");
		}
		if (choice == 1 && player.getHand().getHandValue() < 21) {
			player.dealPlayerCard(deckOfCards);
			player.showHand();
			if (player.getHand().getHandValue() < 21)
				hitOrStay();
		} else if (choice == 0) {
			dealerPlays();
		}
	}

	public void newHand() {
		boolean bust = false;

		System.out.println("Dealer will now begin dealing cards...\n");
		delayGame(2000);
		player.dealPlayerCard(deckOfCards);
		System.out.println();

		delayGame(2000);
		System.out.println("Dealer Face down card\n");
		dealer.dealDealerHiddenCard(deckOfCards);

		delayGame(2000);
		player.dealPlayerCard(deckOfCards);
		System.out.println("");

		delayGame(2000);
		dealer.dealDealerCard(deckOfCards);
		dealer.getShownCardVal();
		delayGame(2000);
		player.showHand();
		delayGame(2000);
		if (player.getHand().getHandValue() == 21) {
			System.out.println("nice job! you got a BlackJack !");
			playAgain();
		}
		while (player.getHand().getHandValue() < 21) {
			hitOrStay();
			if (player.getHand().getHandValue() > 21)
				System.out.println("You busted!");
			dealer.showDealerHand();
			playAgain();
		}
		if (player.getHand().getHandValue() == 21)
			System.out.println("You got a 21 you win!");
		playAgain();
	}

	public void dealerPlays() {
		boolean dealerBusts = false;
		System.out.println("Dealer turns hidden card...\n");
		delayGame(3000);
		dealer.getHiddenCard();
		dealer.showDealerHand();
		while (dealer.getTotalCardVal() < 17) {
			dealer.dealDealerCard(deckOfCards);
			delayGame(3000);
			dealer.showDealerHand();
			delayGame(3000);
			if (dealer.getTotalCardVal() > 21) {
				System.out.println("Dealer busts !");
				System.out.println("You win");
				dealerBusts = true;
				playAgain();
				if (dealer.getTotalCardVal() == 21) {
					System.out.println("Dealer has 21 !");
					dealer.showDealerHand();
					playAgain();
				}

			}
		}
		if (dealer.getTotalCardVal() > player.getHand().getHandValue() && dealerBusts == false) {
			System.out.println("You lose !");
			player.showHand();
			playAgain();
		}
		if (dealer.getTotalCardVal() < player.getHand().getHandValue() || dealerBusts == true) {
			System.out.println("You win !");
			player.showHand();
			playAgain();
		}
		if (dealer.getTotalCardVal() == player.getHand().getHandValue()) {
			System.out.println("You push !");
			player.showHand();
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
}