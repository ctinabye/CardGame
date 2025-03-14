package edu.ntnu.idi.idatt2003.cardgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards.
 */
public class HandOfCards {
  private List<PlayingCard> cards;

  /**
   * Constructs an empty hand of cards.
   */
  public HandOfCards() {
    this.cards = new ArrayList<>();
  }

  /**
   * Accessor method for hand of cards.
   *
   * @return the hand of cards as a list
   */
  public List<PlayingCard> getHandOfCards() {
    return new ArrayList<>(cards);
  }


  /**
   * Returns true if the card is successfully removed, otherwise false.
   *
   * @param card the card to be removed
   *
   * @return true or false
   */
  public boolean removeCard(PlayingCard card) {
    return cards.remove(card);
  }

  /**
   * Returns true if the card is successfully added, otherwise false.
   *
   * @param card the card to be added
   *
   * @return true or false
   */
  public boolean addCard(PlayingCard card) {
    return cards.add(card);
  }

  /**
   * Removes all the cards on hand.
   */
  public void clearHand() {
    cards.clear();
  }






}
