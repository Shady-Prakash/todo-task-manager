package util;

import java.io.*;
import java.util.*;
import model.User;

public class FileHandler {

  public static void saveUsers(String filename, ArrayList<User> users) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
      for (User u : users) {
        pw.println(u.toFileString());
      }
    } catch (IOException e) {
      System.out.println("Error saving users!" + e.getMessage());
    }
  }

  public static ArrayList<User> loadUsers(String filename) {
    ArrayList<User> users = new ArrayList<>();

    try (Scanner sc = new Scanner(new File(filename))) {
      while (sc.hasNextLine()) {
        String[] data = sc.nextLine().split(",");
        if (data.length == 6) {
          int id = Integer.parseInt(data[0]);
          String email = data[3];

          boolean exists = false;

          for (User u : users) {
            if (u.getId() == id || u.getEmail().equalsIgnoreCase(email)) {
              exists = true;
              break;
            }
          }

          if (!exists) {
            users.add(new User(id, data[1], data[2], email, data[4], data[5]));
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading file: " + e.getMessage());
    }

    return users;
  }
}
