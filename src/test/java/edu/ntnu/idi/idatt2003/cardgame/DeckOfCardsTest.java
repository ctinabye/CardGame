package edu.ntnu.idi.idatt2003.cardgame;

import edu.ntnu.idi.idatt2003.cardgame.Model.DeckOfCards;
import edu.ntnu.idi.idatt2003.cardgame.Model.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
  @Nested
  @DisplayName("Positive tests")
  class PositiveTests {
    @Test
    @DisplayName("Should add 52 playing cards to the deck of cards")
    void deckOfCards_ShouldAddPlayingCardsToDeck () {
      DeckOfCards cards = new DeckOfCards();

      assertEquals(52, cards.getCards().size());
    }

    @Test
    @DisplayName("Should remove 5 cards form the deck of cards")
    void dealHand_ShouldReturnRemaininfSizeOfDeck() {

      DeckOfCards cards = new DeckOfCards();
      cards.dealHand(5);

      assertEquals(47, cards.getCards().size());

    }

    @Test
    @DisplayName("Should return the list of cards on hand")
    void dealHand_ShouldReturnHand () {
      DeckOfCards cards = new DeckOfCards();
      List<PlayingCard> hand = cards.dealHand(5);

      assertEquals(5, hand.size());
    }

    @Test
    @DisplayName("Should return a card in the list with a suit and face")
    void dealHand_ShoudReturnSuitAndFace() {
      DeckOfCards cards = new DeckOfCards();
      List<PlayingCard> hand = cards.dealHand(1);

      assertEquals(1, hand.size());
      PlayingCard card = hand.get(0);
      assertNotNull(card.getSuit());
      assertTrue(card.getFace() >= 1 && card.getFace() <= 13);
    }
   @Test
   @DisplayName("Hand should not contain duplicates")
   void dealHand_NoDuplicates() {
     DeckOfCards cards = new DeckOfCards();
     List<PlayingCard> hand = cards.dealHand(5);

     Set<PlayingCard> handSet = new HashSet<>(hand);
     assertEquals(hand.size(), handSet.size(), "Hand contains duplicate cards");
   }
  }

  @Nested
  @DisplayName("Negative tests")
  class NegativeTests{

    @Test
    @DisplayName("Should throw IllegalArgumentException when deck of cards is empty")
    void dealHand_ThrowException_WhenListEmpty() {
      DeckOfCards cards = new DeckOfCards();
      List<PlayingCard> hand = cards.dealHand(52);


      assertThrows(IllegalArgumentException.class, () -> cards.dealHand(2));
    }
    @Test
    @DisplayName("Should throw IllegalArgumentException when dealing non existent amount of cards")
    void dealHand_ThrowException_WhenDealingNonExistentCards() {
      DeckOfCards cards = new DeckOfCards();

      assertThrows(IllegalArgumentException.class, () -> cards.dealHand(0));
      assertThrows(IllegalArgumentException.class, () -> cards.dealHand(53));
    }
  }

}
