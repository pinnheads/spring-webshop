package com.da.da_25_26.users;

import java.util.ArrayList;
import java.util.List;

public class User {

  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;

  private static final List<User> userList = new ArrayList<>();

  static {
    userList.add(new User(1L, "John", "Doe", "john.doe@email.com", "Fulda"));
    userList.add(new User(2L, "Martin", "Luther", "martin.luther@email.com", "Frankfurt"));
    userList.add(new User(3L, "Peter", "Parker", "peter.parker@email.com", "Stuttgart"));
    userList.add(new User(4L, "Robert", "Wool", "robert.wool@email.com", "Munich"));
    userList.add(new User(5L, "Jenny", "Doe", "jenny.doe@email.com", "Fulda"));
  }

  public User(long id, String firstName, String lastName, String email, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public static List<User> getUsers() {
    return userList;
  }

  public static User createUser(String firstName, String lastName, String email, String address) {
    Long newUserId = userList.getLast().id++;
    userList.addLast(new User(newUserId, firstName, lastName, email, address));
    return userList.getLast();
  }

}
