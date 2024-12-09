package com.goeckeler.ulmer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var pane = new BorderPane();
        pane.setPrefSize(640, 480);
        
        var label = new Label("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        pane.setBottom(new StackPane(label));
        
        var scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
        /*
         * Start of table representation
         * 
        TableView<Person> tableView = new TableView();

        TableColumn<Person, String> column1 = 
        new TableColumn<>("First Name");
        
        column1.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));


        TableColumn<Person, String> column2 = 
        new TableColumn<>("Last Name");
        
        column2.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(new Person("John", "Doe"));
        tableView.getItems().add(new Person("Jane", "Deer"));

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);

        stage.show();
        */
      


    }

    public static void main(String[] args) {
        launch();
    }

}