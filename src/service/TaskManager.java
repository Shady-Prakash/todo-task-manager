package service;

import java.util.*;
import model.User;
import model.Task;

public class TaskManager {
  private ArrayList<User> users = new ArrayList<>();
  private ArrayList<Task> tasks = new ArrayList<>();

  // Check by ID: Duplicate Check Methods
  public boolean isDuplicateId(int id) {
    for (User u : users) {
      if (u.getId() == id) {
        return true;
      }
    }
    return false;
  }

  // Check By Email: Duplicate Check Methods
  public boolean isDuplicateEmail(String email) {
    for (User u : users) {
      if (u.getEmail().equalsIgnoreCase(email)) {
        return true;
      }
    }
    return false;
  }

  // Create
  public void addUser(User user) {
    if (isDuplicateId(user.getId())) {
      System.out.println("❌ Duplicate ID! User already exists.");
      return;
    }

    if (isDuplicateEmail(user.getEmail())) {
      System.out.println("❌ Duplicate Email! User already exists.");
      return;
    }

    users.add(user);
    System.out.println("✅ User added successfully!");
  }

  // Read
  public void viewUsers() {
    System.out.println("\n--------------------------------------------------");
    System.out.printf("%-5s %-15s %-25s\n", "ID", "Name", "Email");
    System.out.println("--------------------------------------------------");

    for (User u : users) {
      System.out.printf("%-5d %-15s %-25s\n",
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

  // Update
  public void updateUser(int id, String firstName, String lastName, String email) {
    User u = findUserById(id);
    if (u != null) {
      u.setName(firstName, lastName);
      u.setEmail(email);
    } else {
      System.out.println("User not found");
    }
  }

  // Delete
  public void deleteUser(int id) {
    users.removeIf(u -> u.getId() == id);
  }

  // Task Management
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
