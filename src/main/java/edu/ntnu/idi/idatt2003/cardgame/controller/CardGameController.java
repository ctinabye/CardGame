package edu.ntnu.idi.idatt2003.cardgame.controller;

import edu.ntnu.idi.idatt2003.cardgame.model.DeckOfCards;
import edu.ntnu.idi.idatt2003.cardgame.model.HandOfCards;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Controller class for managing the card game. It handles the actions related to dealing a hand of cards
 * and checking the hand for specific conditions such as flush, sum of faces, presence of hearts, and the queen of spades.
 */
public class CardGameController {

    private DeckOfCards deck;
    private HandOfCards hand;

    private Label handDisplay;
    private TextArea flushDisplay;
    private TextArea queenDisplay;
    private TextArea sumDisplay;
    private TextArea heartsDisplay;

    /**
     * Constructs a CardGameController with the specified deck and display components.
     *
     * @param deck the deck of cards to be used in the game
     * @param handDisplay the label to display the hand of cards
     * @param flushDisplay the text area to display if the hand has a flush
     * @param queenDisplay the text area to display if the hand has the queen of spades
     * @param sumDisplay the text area to display the sum of faces in the hand
     * @param heartsDisplay the text area to display the hearts in the hand
     */
    public CardGameController(DeckOfCards deck,
                              Label handDisplay,
                              TextArea flushDisplay,
                              TextArea queenDisplay,
                              TextArea sumDisplay,
                              TextArea heartsDisplay) {
        this.deck = deck;
        this.handDisplay = handDisplay;
        this.flushDisplay = flushDisplay;
        this.queenDisplay = queenDisplay;
        this.sumDisplay = sumDisplay;
        this.heartsDisplay = heartsDisplay;
    }

    /**
     * Deals a hand of cards from the deck and updates the hand display.
     */
    public void dealHandAction() {
        hand = new HandOfCards(deck.dealHand(5));
        handDisplay.setText(hand.toString());
    }

    /**
     * Checks the hand for specific conditions (sum of faces, presence of hearts, flush, and queen of spades)
     * and updates the respective display components.
     */
    public void checkHandAction() {
        String sum = hand.sumFaces();
        sumDisplay.setText(sum);

        String heartCards = hand.showHearts();
        heartsDisplay.setText(heartCards);

        boolean flush = hand.hasFlush();
        flushDisplay.setText(flush ? "Yes" : "No");

        boolean queenOfSpades = hand.queenOfSpadesInHand();
        queenDisplay.setText(queenOfSpades ? "Yes" : "No");
    }
}