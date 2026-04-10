package model;

public class User extends Person {
  private String email;

  public User(int id, String firstName, String lastName, String email) {
    super(id, firstName, lastName);
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return firstName + " " + lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public void displayInfo() {
    System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email);
  }
}