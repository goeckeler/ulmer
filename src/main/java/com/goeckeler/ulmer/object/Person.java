package com.goeckeler.ulmer.object;

import java.time.LocalDate;
import java.util.Objects;

/** Simple person attributes */
public record Person(String name, Gender gender, String mail, LocalDate birthday) {
  public Person {
    Objects.requireNonNull(name);
  }

  public int age() {
    return 0;
  }
}
