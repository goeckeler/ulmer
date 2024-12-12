package com.goeckeler.ulmer;

import static com.goeckeler.ulmer.PersonRepository.personRepository;

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
  public void start(@SuppressWarnings("exports") final Stage stage) {
    var javaVersion = SystemInfo.javaVersion();
    var javafxVersion = SystemInfo.javafxVersion();

    var pane = new BorderPane();
    pane.setPrefSize(640, 480);

    var label = new Label("JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    pane.setBottom(new StackPane(label));

    TableView<Person> tableView = new TableView<>(createDefaultPersons());
    tableView.setPlaceholder(new Label("No rows to display."));

    column(tableView, "Name", "name");
    column(tableView, "Gender", "gender");
    column(tableView, "Birthday", "birthday");
    column(tableView, "Mail", "mail");

    VBox vbox = new VBox(tableView);
    pane.setCenter(vbox);

    var scene = new Scene(pane);
    stage.setScene(scene);
    stage.setTitle("Address Book");
    stage.show();
  }

  private <T> void column(TableView<Person> view, String label, String property) {
    TableColumn<Person, T> column = new TableColumn<>(label);
    column.setCellValueFactory(new PropertyValueFactory<>(property));
    view.getColumns().add(column);
  }

  private ObservableList<Person> createDefaultPersons() {
    return FXCollections.observableArrayList(personRepository().findAll());
  }

  public static void main(String[] args) {
    launch();
  }
}
