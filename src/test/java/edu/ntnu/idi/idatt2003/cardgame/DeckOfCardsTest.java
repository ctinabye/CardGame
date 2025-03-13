package edu.ntnu.idi.idatt2003.cardgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.idi.idatt2003.cardgame.Model.DeckOfCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
  }
}
