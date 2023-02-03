package com.skilldistillery.blackjack.testing;

import com.skilldistillery.blackjack.entities.Rank;
import com.skilldistillery.blackjack.entities.Suit;

public class CardTest {
  public static void main(String[] args) {
    Rank[] ranks = Rank.values();
    for(int i=0; i<ranks.length; i++) {
      System.out.print(ranks[i] + " " + ranks[i].getValue()+", ");
      
    }
    System.out.println();
    
    for(Suit s : Suit.values()){
      System.out.println(s);
    }
  }
}