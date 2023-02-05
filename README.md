# Blackjack Project

# Description
Blackjack is a popular card game played between a dealer and player(s). The objective of the game is to have a hand value of 21 or closest to 21 without busting.

The game starts with a welcome message and shuffling the deck of cards. The user is then dealt two cards and the dealer is dealt one card face up and one face down. The player can either choose to hit or stay. The game continues until the player busts or decides to stay. The dealer will then reveal their hand and the winner will be determined based on who is closest to 21 without busting.

 The game also has the option to play again. If the deck runs out of cards, the game will end and the user will have to start over.
 
# Classes Description
1. Rank.java is an enumeration that represents the rank of each card in a deck of cards, including 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace. Each rank is assigned a specific value, which is used to determine the value of a hand of cards in the game of Blackjack.

2. Suit.java is another enumeration that represents the four suits in a deck of cards, including Hearts, Spades, Clubs, and Diamonds.

3. Card.java represents a single playing card with a suit and a rank. 

4. Deck.java represents a deck of cards in a game of Blackjack. The class has a list of Card objects that can be shuffled and dealt. The class has a constructor that creates a deck of 52 cards.

5. Player.java represents a player in the game of Blackjack. It has fields for the player's name, hand, and the deck of cards being used. It also has methods for displaying the player's hand to the console, and receiving a card from the deck. The hand field is an object of the class "BlackjackHand" which is an extension of the Hand parent class. The "recieveCard" method takes a "Deck" object as an argument, deals a card from the deck, and adds it to the player's hand.

6. BlackjackDealer.java is a subclass of Dealer and represents a dealer in a blackjack card game. It has a BlackjackDealerHand variable named hand which represents the dealer's hand of cards. 

7. Hand.java is an abstract class that represents a hand of playing cards in a game. It contains a list of cards and has a method to add a card to the hand, a method to clear the cards in the hand, and an abstract method getHandValue to return the value of the hand.  



# Technologies Used
 Java and Eclipse 
# Lessons Learned

My understanding of Object Oriented Programming is a lot better after doing this project. I learned that I should of done more planning before starting on this as I put a lot of different methods in classes that probably shouldn't need to be there. I also learned about inheritance, polymorphism, and abstraction through creating classes for different objects in the game, such as the deck, cards, player and dealer. Additionally, I realized the importance of clear and concise code and how it can help in debugging and making changes in the future. Overall, this project helped me see the practical applications of OOP and how it can be used to create complex applications with maintainable and reusable code.





