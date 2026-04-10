package service;

import java.util.*;
import model.User;
import model.Task;

public class TaskManager {
  private ArrayList<User> users = new ArrayList<>();
  private ArrayList<Task> tasks = new ArrayList<>();

  // CREATE
  public void addUser(User user) {
    users.add(user);
  }

  // READ
  public void viewUsers() {
    System.out.println("\n--------------------------------------------------");
    System.out.printf("%-5s %-15s %-15s %-25s\n", "ID", "First Name", "Last Name", "Email");
    System.out.println("--------------------------------------------------");

    for (User u : users) {
      System.out.printf("%-5d %-15s %-15s %-25s\n",
          u.getId(),
          u.getName(),
          u.getEmail());
    }

    System.out.println("--------------------------------------------------");
  }

  public User findUserById(int id) {
    for (User u : users) {
      if (u.getId() == id)
        return u;
    }
    return null;
  }

  // UPDATE
  public void updateUser(int id, String firstName, String lastName, String email) {
    User u = findUserById(id);
    if (u != null) {
      u.setName(firstName, lastName);
      u.setEmail(email);
    } else {
      System.out.println("User not found");
    }
  }

  // DELETE
  public void deleteUser(int id) {
    users.removeIf(u -> u.getId() == id);
  }

  // TASK MANAGEMENT
  public void addTask(Task task) {
    tasks.add(task);
  }

  public void evaluateTasks() {
    for (Task t : tasks) {
      if (t != null) {
        System.out.println("Evaluating Task...");
        t.display();
      }
    }
  }

  public ArrayList<User> getUsers() {
    return users;
  }
}
