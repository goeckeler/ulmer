package com.goeckeler.ulmer;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.goeckeler.ulmer.object.Gender;
import com.goeckeler.ulmer.object.Person;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** JavaFX App */
public class App extends Application {

  @Override
  public void start(final Stage stage) {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    var pane = new BorderPane();
    pane.setPrefSize(640, 480);

    var label = new Label("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    pane.setBottom(new StackPane(label));

    TableView<Person> tableView = new TableView<>(createDefaultPersons());
    tableView.setPlaceholder(new Label("No rows to display."));

    Person demo = new Person("No one", null, "no.one@null.de", null);
    column(tableView, "Name", demo.nameProperty().getName());
    column(tableView, "Gender", demo.genderProperty().getName());
    // column(tableView, "Birthday", "birthday");
    column(tableView, "Mail", demo.mailProperty().getName());

    VBox vbox = new VBox(tableView);
    pane.setCenter(vbox);

    var scene = new Scene(pane);
    stage.setScene(scene);
    stage.show();
  }

  private <T> void column(TableView<Person> view, String label, String property) {
    TableColumn<Person, T> column = new TableColumn<>(label);
    column.setCellValueFactory(new PropertyValueFactory<>(property));
    view.getColumns().add(column);
  }

  private ObservableList<Person> createDefaultPersons() {
    List<Person> persons =
        List.of(
            new Person(
                "John Doe", Gender.MALE, "john.doe@mail.com", LocalDate.of(1973, Month.MAY, 12)),
            new Person(
                "Jane Deer",
                Gender.FEMALE,
                "jane.deer@mail.com",
                LocalDate.of(2003, Month.OCTOBER, 2)));
    return FXCollections.observableArrayList(persons);
  }

  public static void main(String[] args) {
    launch();
  }
}
