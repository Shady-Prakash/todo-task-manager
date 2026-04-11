package model;

public class User extends Person {
  private String email;
  private String username;
  private String password;

  public User(int id, String firstName, String lastName, String email, String username, String password) {
    super(id, firstName, lastName);
    this.email = email;
    this.username = username;
    this.password = password;
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

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void displayInfo() {
    System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email);
  }

  // For file saving
  public String toFileString() {
    return id + "," + firstName + "," + lastName + "," + email + "," + username + "," + password;
  }
}