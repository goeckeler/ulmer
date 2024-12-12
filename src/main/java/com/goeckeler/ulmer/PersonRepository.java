package com.goeckeler.ulmer;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.goeckeler.ulmer.object.Gender;
import com.goeckeler.ulmer.object.Person;

public class PersonRepository {
  private static PersonRepository instance;
  private List<Person> persons = new ArrayList<>();

  public static PersonRepository personRepository() {
    if (instance == null) {
      instance = new PersonRepository();
    }
    return instance;
  }

  private PersonRepository() {
    persons.addAll(defaultPersons());
  }

  private List<Person> defaultPersons() {
    return List.of(
        new Person("John Doe", Gender.MALE, "john.doe@mail.com", LocalDate.of(1973, Month.MAY, 12)),
        new Person(
            "Jane Deer", Gender.FEMALE, "jane.deer@mail.com", LocalDate.of(2003, Month.OCTOBER, 2)),
        new Person(
            "Dieter Thümmler",
            Gender.MALE,
            "dieter.thümmler@gmail.com",
            LocalDate.of(1938, Month.OCTOBER, 16)),
        new Person(
            "Renate Mentz",
            Gender.FEMALE,
            "echtgrell@metamorphosa.com",
            LocalDate.of(1942, Month.MARCH, 3)),
        new Person("Christina Emmer", Gender.DIVERSE, null, null));
  }

  public List<Person> findAll() {
    return persons;
  }
}
