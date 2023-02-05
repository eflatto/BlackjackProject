package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	// initializing all the objects needed to play the game
	private Scanner sc = new Scanner(System.in);
	private Deck deckOfCards = new Deck();
	private Player player = new Player();
	private BlackjackDealer dealer = new BlackjackDealer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackApp blackJack = new BlackjackApp();
		// launch blackjack app
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

	// choose to play again or exit the game
	public void playAgain() {
		String choice;
		// Clear the dealer's and player's hands every new round
		dealer.getHand().clear();
		player.getHand().clear();
		do {
			// Print the number of cards left in the deck
			System.out.println("there are " + deckOfCards.size() + " cards left");
			System.out.println("Press Y to play again");
			System.out.print("Or hit any other key to exit: ");
			System.out.println("\n==============================================================================");

			// If the deck is empty, tell the player to start over and exit the game
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

	// allow the player to choose to hit or stay
	public void hitOrStay() {
		System.out.println("Would you like to stay or hit?  ");
		System.out.print("Enter 0 to stay or 1 to hit: ");
		int choice = sc.nextInt();
		System.out.println();
		// If the player's hand value is over 21, print "You busted!"
		if (player.getHand().getHandValue() > 21) {
			System.out.println("You busted !");
		}
		// If the player chose to hit and their hand value is under 21,
		// deal them another card and show their hand
		if (choice == 1 && player.getHand().getHandValue() < 21) {
			player.recieveCard(deckOfCards);
			player.showHand();
			// If the player's hand value is still under 21,
			// allow them to hit or stay again
			if (player.getHand().getHandValue() < 21)
				hitOrStay();

			// If the player chose to stay, have the
			// dealer play their hand
		} else if (choice == 0) {
			dealerPlays();
		}
	}
	//begins a new hand of BlackJack
	public void newHand() {
		boolean bust = false;

		System.out.println("Dealer will now begin dealing cards...\n");
		// pause the game for 2 seconds
		delayGame(2000);
		// deal a card to the player
		player.recieveCard(deckOfCards);
		System.out.println();

		delayGame(2000);
		System.out.println("Dealer Face down card\n");
		dealer.dealDealerHiddenCard(deckOfCards);

		delayGame(2000);
		player.recieveCard(deckOfCards);
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
	//pause the game for a few seconds method
	public void delayGame(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}