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
  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
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

    /**
     * Checks if the hand of cards has flush (5 cards of equal suit) on hand.
     *
     * @return true or false
     */
  public boolean hasFlush() {
      return cards.stream()
              .collect(Collectors.groupingBy(PlayingCard::getSuit))
              .values()
              .stream()
              .anyMatch(group ->  group.size() >= 5);

  }

  /**
   * Sums the faces in hand.
   *
   * @return the sum of faces as a string
   */
  public String sumFaces() {
    int sum = cards.stream()
            .mapToInt(PlayingCard:: getFace)
            .sum();
    return Integer.toString(sum);

  }

  /**
   * Shows the hearts on hand as a string.
   *
   * @return the hearts on hand, and returns "No hearts" if there are none
   */
  public String showHearts() {
    String hearts = cards.stream()
            .filter(card -> card.getSuit() == 'H')
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining(" "));

    return hearts.isEmpty() ? "No hearts" : hearts;
  }

  /**
   * Checks if there is a queen of spades on hand.
   *
   * @return true or false
   */
  public boolean queenOfSpadesInHand() {
    return cards.stream()
            .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }



  /**
   * Returns the hand of cards into a string showing the suit and face of each card on hand.
   *
   * @return hand of cards
   */
  @Override
  public String toString() {
      return cards.stream()
              .map(PlayingCard::getAsString)
              .collect(Collectors.joining(" "));
  }







}
