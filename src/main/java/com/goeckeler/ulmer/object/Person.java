package com.goeckeler.ulmer.object;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/** Simple person attributes */
public class Person {
  private String name;
  private String mail;
  private Gender gender;
  private LocalDate birthday;

  public Person(String name, Gender gender, String mail, LocalDate birthday) {
    Objects.requireNonNull(name);

    this.name = name;
    this.gender = gender;
    this.mail = mail;
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public long age() {
    return birthday.until(LocalDate.now(), ChronoUnit.YEARS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person) obj;
    return Objects.equals(birthday, other.birthday)
        && gender == other.gender
        && Objects.equals(mail, other.mail)
        && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return name == null ? "N.N." : name;
  }
}
