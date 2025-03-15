package edu.ntnu.idi.idatt2003.cardgame;

import edu.ntnu.idi.idatt2003.cardgame.model.HandOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import edu.ntnu.idi.idatt2003.cardgame.model.PlayingCard;
import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    private HandOfCards hand;
    private PlayingCard card1;
    private PlayingCard card2;
    private PlayingCard card3;
    private PlayingCard card4;
    private PlayingCard card5;
    private PlayingCard card6;

    @BeforeEach
    void setUp() {
        List<PlayingCard> hand1 = new ArrayList<>();
        hand = new HandOfCards(hand1);

        card1 = new PlayingCard('H', 2); // Hearts
        card2 = new PlayingCard('H', 3);
        card3 = new PlayingCard('H', 4);
        card4 = new PlayingCard('H', 5);
        card5 = new PlayingCard('H', 6);
        card6 = new PlayingCard('S', 7); // Spades
    }

    @Test
    void testAddCard() {
        assertTrue(hand.addCard(card1));
        assertEquals(1, hand.getHandOfCards().size());
    }

    @Test
    void testRemoveCard() {
        hand.addCard(card1);
        assertTrue(hand.removeCard(card1));
        assertEquals(0, hand.getHandOfCards().size());
    }

    @Test
    void testClearHand() {
        hand.addCard(card1);
        hand.addCard(card2);
        hand.clearHand();

        assertEquals(0, hand.getHandOfCards().size());
    }

    @Test
    void testHasFlush() {
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);

        assertTrue(hand.hasFlush());
    }

    @Test
    void testHasNoFlush() {
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card6);

        assertFalse(hand.hasFlush());
    }

    @Test
    void testToString() {
        hand.addCard(card1);
        hand.addCard(card2);

        assertEquals("H2 H3", hand.toString());
    }
}