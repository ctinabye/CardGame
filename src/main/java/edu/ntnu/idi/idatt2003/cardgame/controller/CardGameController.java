package edu.ntnu.idi.idatt2003.cardgame.controller;

import edu.ntnu.idi.idatt2003.cardgame.model.DeckOfCards;
import edu.ntnu.idi.idatt2003.cardgame.model.HandOfCards;
import edu.ntnu.idi.idatt2003.cardgame.model.PlayingCard;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CardGameController {


    private DeckOfCards deck;
    private HandOfCards hand;


    private Label handDisplay;
    private TextArea flushDisplay;
    private TextArea queenDisplay;
    private TextArea sumDisplay;
    private TextArea heartsDisplay;


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


    public void dealHandAction() {
        hand = new HandOfCards(deck.dealHand(5));
        handDisplay.setText(hand.toString());
    }


    public void checkHandAction() {

    }



}
