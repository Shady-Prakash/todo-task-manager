package service;

import model.User;
import model.Task;
import java.util.*;

public class TaskManager {
  private ArrayList<User> users = new ArrayList<>();
  private ArrayList<Task> tasks = new ArrayList<>();

  public ArrayList<User> getUsers() {
    return users;
  }

  // ===== AUTH =====
  public void register(User user) {
    users.add(user);
    System.out.println("✅ Registered!");
  }

  public User login(String username, String password) {
    for (User u : users) {
      if (u.getUsername().equals(username) &&
          u.getPassword().equals(password)) {
        return u;
      }
    }
    return null;
  }

  // ===== USERS =====
  // Check duplicate userID
  public boolean isDuplicateId(int id) {
    for (User u : users) {
      if (u.getId() == id) {
        return true;
      }
    }
    return false;
  }

  // Check duplicate email
  public boolean isDuplicateEmail(String email) {
    for (User u : users) {
      if (u.getEmail().equalsIgnoreCase(email)) {
        return true;
      }
    }
    return false;
  }

  // Check duplicate username
  public boolean isDuplicateUsername(String username) {
    return users.stream().anyMatch(u -> u.getUsername().equals(username));
  }

  // Create an user
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

  // Read user list
  public void viewUsers() {
    System.out.println("\n--------------------------------------------------");
    System.out.printf("%-5s %-15s %-25s\n", "UserID", "Name", "Email");
    System.out.println("--------------------------------------------------");

    for (User u : users) {
      System.out.printf("%-5d %-15s %-25s\n",
          u.getId(),
          u.getName(),
          u.getEmail());
    }

    System.out.println("--------------------------------------------------");
  }

  // Find user by userID
  public User findUserById(int id) {
    for (User u : users) {
      if (u.getId() == id)
        return u;
    }
    return null;
  }

  // list users dropdown
  public void displayUsersList() {
    System.out.println("\n--- Select User ---");
    for (int i = 0; i < users.size(); i++) {
      User u = users.get(i);
      System.out.println((i + 1) + ". " + u.getName());
    }
  }

  // find user by index
  public User getUserByIndex(int index) {
    if (index >= 0 && index < users.size())
      return users.get(index);
    return null;
  }

  // Update an user
  public boolean updateUser(int id, String fn, String ln, String email, String username, String password) {
    for (User u : users) {
      if (u.getId() == id) {
        u.setName(fn, ln);
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        System.out.println("✅ User updated!");
        return true;
      }
    }
    System.out.println("❌ User not found!");
    return false;
  }

  // Delete an user
  public boolean deleteUser(int id) {
    boolean removed = users.removeIf(u -> u.getId() == id);

    if (removed) {
      System.out.println("✅ User deleted!");
    } else {
      System.out.println("❌ User not found!");
    }
    return removed;
  }

  // ===== TASKS =====
  public boolean isDuplicateTaskId(int taskId) {
    return tasks.stream().anyMatch(t -> t.getTaskId() == taskId);
  }

  public void assignTask(Task task) {
    if (isDuplicateTaskId(task.getTaskId())) {
      System.out.println("❌ Task ID already exists!");
      return;
    }

    tasks.add(task);
    System.out.println("✅ Task assigned!");
  }

  public void updateTaskStatus(int taskId, String status, String currentUser) {
    for (Task t : tasks) {
      if (t.getTaskId() == taskId) {

        // Only assigned user can update
        t.setStatus(status);
        System.out.println("✅ Status updated!");
        return;
      }
    }
    System.out.println("❌ Task not found!");
  }

  public void viewTasksByUser(String name) {
    System.out.println("\n--- Tasks for " + name + " ---");

    System.out.printf("%-5s %-20s %-12s %-10s %-20s %-20s\n",
        "Task ID", "Description", "Status", "Priority", "Assigned By", "Assigned To");

    for (Task t : tasks) {
      if (t.getAssignedTo().equalsIgnoreCase(name)) {
        t.display();
      }
    }
  }

  public void displayBoard() {
    System.out.println("\n=========== TASK BOARD ===========");

    printByStatus("TODO");
    printByStatus("IN_PROGRESS");
    printByStatus("PENDING");
    printByStatus("COMPLETED");
  }

  private void printByStatus(String status) {
    System.out.println("\n--- " + status + " ---");

    System.out.printf("%-5s %-20s %-12s %-10s %-20s %-20s\n",
        "ID", "Description", "Status", "Priority", "Assigned By", "Assigned To");

    for (Task t : tasks) {
      if (t.getStatus().equals(status)) {
        t.display();
      }
    }
  }
}
