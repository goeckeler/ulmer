package com.goeckeler.ulmer.object;

public enum Gender {
  MALE,
  FEMALE,
  DIVERSE;

  @Override
  public String toString() {
	 return this.name().toLowerCase(); 
  }
}
