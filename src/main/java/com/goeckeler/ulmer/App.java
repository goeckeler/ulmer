package com.goeckeler.ulmer;

import java.time.LocalDate;
import java.time.Month;

import com.goeckeler.ulmer.object.Gender;
import com.goeckeler.ulmer.object.Person;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** JavaFX App */
public class App extends Application {

  @Override
  public void start(Stage stage) {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    var pane = new BorderPane();
    pane.setPrefSize(640, 480);

    var label = new Label("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    pane.setBottom(new StackPane(label));

    TableView<Person> tableView = new TableView<>();
    tableView.setPlaceholder(new Label("No rows to display."));

    TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(
        person -> new ReadOnlyObjectWrapper<String>(person.getValue().name()));

    TableColumn<Person, String> mailColumn = new TableColumn<>("Mail");
    mailColumn.setCellValueFactory(
        person -> new ReadOnlyObjectWrapper<String>(person.getValue().mail()));

    tableView.getColumns().add(nameColumn);
    tableView.getColumns().add(mailColumn);

    tableView
        .getItems()
        .add(
            new Person(
                "John Doe", Gender.MALE, "john.doe@mail.com", LocalDate.of(1973, Month.MAY, 12)));
    tableView
        .getItems()
        .add(
            new Person(
                "Jane Deer",
                Gender.FEMALE,
                "jane.deer@mail.com",
                LocalDate.of(2003, Month.OCTOBER, 2)));
    VBox vbox = new VBox(tableView);
    pane.setCenter(vbox);

    var scene = new Scene(pane);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
