package edu.ntnu.idi.idatt2003.cardgame.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of cards.
 *
 * @version 1.0
 */
public class DeckOfCards {
  private static final char[] suit = {'S', 'H', 'D', 'C'};
  private List<PlayingCard> cards;

  /**
   * Constructs 52 cards with one of each combination of suit and face value.
   */
  public DeckOfCards() {
    this.cards = new ArrayList<PlayingCard>();

    for (char suit : suit) {
      for (int face = 1; face <= 13; face++) {
        cards.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Accessor method for cards.
   *
   * @return the list of cards
   */
  public List<PlayingCard> getCards() {
    return cards;
  }

  public List<> dealHand(int n) {
    if (cards.isEmpty() || n < 1 && n > 52) {
      throw new IllegalArgumentException("cards must be between 1 and 52");
    }

  }



}
