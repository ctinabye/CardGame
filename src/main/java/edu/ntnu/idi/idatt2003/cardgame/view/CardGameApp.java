package edu.ntnu.idi.idatt2003.cardgame.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class CardGameApp extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Card game");

        BorderPane layout = new BorderPane();
        layout.setCenter(createCenterDisplay());
        layout.setBottom(createBottomLayout());

        Scene scene = new Scene(layout, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createCenterDisplay() {
        Label handDisplay = new Label("Your hand will appear here");
        handDisplay.setAlignment(Pos.CENTER);
        return handDisplay;
    }


    private VBox createBottomLayout() {
        VBox bottomLayout = new VBox();
        bottomLayout.getChildren().addAll(createValueDisplay(), createButtonDisplay());
        return bottomLayout;
    }

    private HBox createButtonDisplay() {
        Button dealHandButton = new Button("Deal hand");
        Button checkHandButton = new Button("Check hand");
        dealHandButton.setPrefSize(200, 100);
        checkHandButton.setPrefSize(200, 100);

       // event handlers
        dealHandButton.setOnAction(this);
        checkHandButton.setOnAction(this);

        HBox buttonDisplay = new HBox();
        buttonDisplay.setAlignment(Pos.CENTER);
        buttonDisplay.setSpacing(400);
        buttonDisplay.setPadding(new Insets(30, 30, 30, 30));
        buttonDisplay.getChildren().addAll(dealHandButton, checkHandButton);

        return buttonDisplay;
    }

    private HBox createValueDisplay() {
        VBox flushBox = createLabeledTextArea("Flush", "", 111, 35);
        VBox queenBox = createLabeledTextArea("Queen of spades", "", 111, 35);
        VBox sumBox = createLabeledTextArea("Sum of faces", "", 111, 35);
        VBox heartsBox = createLabeledTextArea("Cards of hearts", "", 111, 35);

        HBox valueDisplay = new HBox();
        valueDisplay.setAlignment(Pos.CENTER);
        valueDisplay.setSpacing(250);
        valueDisplay.setPadding(new Insets(20, 20, 20, 20));
        valueDisplay.getChildren().addAll(flushBox, queenBox, sumBox, heartsBox);

        return valueDisplay;
    }

    private VBox createLabeledTextArea(String title, String initialText, double width, double height) {
        TextArea textArea = new TextArea(initialText);
        textArea.setPrefSize(width, height);
        textArea.setEditable(false);
        Label label = new Label(title);

        VBox container = new VBox(5); // 5 piksler mellomrom
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

    @Override
    public void handle(ActionEvent actionEvent) {
        // Her kan du håndtere knappetrykkene, f.eks. oppdatere visningen med nye kort
    }
}
