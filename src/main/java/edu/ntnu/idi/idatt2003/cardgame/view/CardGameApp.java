package edu.ntnu.idi.idatt2003.cardgame.view;

import edu.ntnu.idi.idatt2003.cardgame.controller.CardGameController;
import edu.ntnu.idi.idatt2003.cardgame.model.DeckOfCards;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameApp extends Application {

    private CardGameController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Card game");

        // Create view components
        Label handDisplay = createCenterDisplay();
        TextArea flushDisplay = createNonEditableTextArea("", 111, 35);
        TextArea queenDisplay = createNonEditableTextArea("", 111, 35);
        TextArea sumDisplay = createNonEditableTextArea("", 111, 35);
        TextArea heartsDisplay = createNonEditableTextArea("", 111, 35);

        // Instantiate the controller
        DeckOfCards deck = new DeckOfCards();
        controller = new CardGameController(deck, handDisplay, flushDisplay, queenDisplay, sumDisplay, heartsDisplay);

        // Set up the layout
        BorderPane layout = new BorderPane();
        layout.setCenter(handDisplay);
        layout.setBottom(createBottomLayout(flushDisplay, queenDisplay, sumDisplay, heartsDisplay));

        Scene scene = new Scene(layout, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createCenterDisplay() {
        Label handDisplay = new Label("Your hand will appear here");
        handDisplay.setAlignment(Pos.CENTER);
        return handDisplay;
    }

    private VBox createBottomLayout(TextArea flushDisplay, TextArea queenDisplay, TextArea sumDisplay, TextArea heartsDisplay) {
        VBox bottomLayout = new VBox();
        bottomLayout.getChildren().addAll(createValueDisplay(flushDisplay, queenDisplay, sumDisplay, heartsDisplay), createButtonDisplay());
        return bottomLayout;
    }

    private HBox createButtonDisplay() {
        Button dealHandButton = new Button("Deal hand");
        Button checkHandButton = new Button("Check hand");
        dealHandButton.setPrefSize(200, 100);
        checkHandButton.setPrefSize(200, 100);

        HBox buttonDisplay = new HBox();
        buttonDisplay.setAlignment(Pos.CENTER);
        buttonDisplay.setSpacing(400);
        buttonDisplay.setPadding(new Insets(30, 30, 30, 30));
        buttonDisplay.getChildren().addAll(dealHandButton, checkHandButton);

        // Set event handlers
        dealHandButton.setOnAction(e -> controller.dealHandAction());
        checkHandButton.setOnAction(e -> controller.checkHandAction());

        return buttonDisplay;
    }

    private HBox createValueDisplay(TextArea flushDisplay, TextArea queenDisplay, TextArea sumDisplay, TextArea heartsDisplay) {
        VBox flushBox = createLabeledTextArea("Flush", flushDisplay);
        VBox queenBox = createLabeledTextArea("Queen of spades", queenDisplay);
        VBox sumBox = createLabeledTextArea("Sum of faces", sumDisplay);
        VBox heartsBox = createLabeledTextArea("Cards of hearts", heartsDisplay);

        HBox valueDisplay = new HBox();
        valueDisplay.setAlignment(Pos.CENTER);
        valueDisplay.setSpacing(250);
        valueDisplay.setPadding(new Insets(20, 20, 20, 20));
        valueDisplay.getChildren().addAll(flushBox, queenBox, sumBox, heartsBox);

        return valueDisplay;
    }

    private VBox createLabeledTextArea(String title, TextArea textArea) {
        Label label = new Label(title);

        VBox container = new VBox(5);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(textArea, label);

        return container;
    }

    private TextArea createNonEditableTextArea(String text, double width, double height) {
        TextArea textArea = new TextArea(text);
        textArea.setPrefSize(width, height);
        textArea.setEditable(false);
        return textArea;
    }
}