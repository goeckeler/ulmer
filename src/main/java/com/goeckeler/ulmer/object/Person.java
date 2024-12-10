package com.goeckeler.ulmer.object;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** Simple person attributes */
public class Person {
  private StringProperty name;
  private StringProperty mail;

  public Person(String name, Gender gender, String mail, LocalDate birthday) {
    Objects.requireNonNull(name);

    setName(name);
    setMail(mail);
  }

  public void setName(String name) {
    this.nameProperty().set(name);
  }

  public String getName() {
    return this.nameProperty().get();
  }

  public StringProperty nameProperty() {
    if (name == null){
    name = new SimpleStringProperty(this, "name");
  }
    return name;
  }

  public void setMail(String mail) {
    this.mailProperty().set(mail);
  }

  public String getMail() {
    return this.mailProperty().get();
  }

  public StringProperty mailProperty() {
    if (mail == null){
    mail = new SimpleStringProperty(this, "mail");
  }
    return mail;
  }

  public int age() {
    return 0;
  }
}
