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

  public String sumFaces() {
    int sum = cards.stream()
            .mapToInt(PlayingCard:: getFace)
            .sum();
    return Integer.toString(sum);

  }

  public String showHearts() {
    String hearts = cards.stream()
            .filter(card -> card.getSuit() == 'H')
            .map(PlayingCard::getAsString)
            .collect(Collectors.joining(" "));

    return hearts.isEmpty() ? "No hearts" : hearts;
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
