package com.goeckeler.ulmer.object;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** Simple person attributes */
public class Person {
  private StringProperty name;
  private StringProperty mail;
  private ObjectProperty<Gender> gender;
  private ObjectProperty<LocalDate> birthday;

  public Person(String name, Gender gender, String mail, LocalDate birthday) {
    Objects.requireNonNull(name);

    setName(name);
    setMail(mail);
    setGender(gender);
    setBirthday(birthday);
  }

  public void setName(String name) {
    this.nameProperty().set(name);
  }

  public String getName() {
    return this.nameProperty().get();
  }

  @SuppressWarnings("exports")
  public StringProperty nameProperty() {
    if (name == null) {
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

  @SuppressWarnings("exports")
  public StringProperty mailProperty() {
    if (mail == null) {
      mail = new SimpleStringProperty(this, "mail");
    }
    return mail;
  }

  public void setGender(Gender gender) {
    this.genderProperty().set(gender);
  }

  public Gender getGender() {
    return this.genderProperty().get();
  }

  public ObjectProperty<Gender> genderProperty() {
    if (gender == null) {
      gender = new SimpleObjectProperty<Gender>(this, "gender");
    }
    return gender;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthdayProperty().set(birthday);
  }

  public LocalDate getBirthday() {
    return this.birthdayProperty().get();
  }

  public ObjectProperty<LocalDate> birthdayProperty() {
    if (birthday == null) {
      birthday = new SimpleObjectProperty<LocalDate>(this, "birthday");
    }
    return birthday;
  }

  public int age() {
    return 0;
  }
}
