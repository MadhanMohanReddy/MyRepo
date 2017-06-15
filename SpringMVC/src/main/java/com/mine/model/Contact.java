package com.mine.model;

/**
 * Created by madhan.reddy on 6/15/2017.
 */
public class Contact {
  private String firstName;
  private String lastName;

  public Contact() {
  }

  public Contact(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public int hashCode(){
    return firstName.hashCode() + lastName.hashCode();
  }

  public boolean equals(Object object){
    if (object instanceof Contact){
      Contact second = (Contact)object;
      return (firstName.equals(second.getFirstName()) && lastName.equals(second.getLastName()));
    }
    return false;
  }

  public String toString(){
    return "[First Name = " + firstName + ", Last Name = " + lastName + "]";
  }
}
