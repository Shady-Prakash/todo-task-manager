package util;

import java.io.*;
import java.util.*;
import model.User;

public class FileHandler {

  public static void saveUsers(String filename, ArrayList<User> users) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
      for (User u : users) {
        pw.println(u.getId() + "," + u.getName());
      }
    } catch (IOException e) {
      System.out.println("Error writing file: " + e.getMessage());
    }
  }

  public static ArrayList<User> loadUsers(String filename) {
    ArrayList<User> users = new ArrayList<>();

    try (Scanner sc = new Scanner(new File(filename))) {
      while (sc.hasNextLine()) {
        String[] data = sc.nextLine().split(",");
        users.add(new User(
            Integer.parseInt(data[0]),
            data[1],
            data[2],
            data[3]));
      }
    } catch (Exception e) {
      System.out.println("Error reading file: " + e.getMessage());
    }

    return users;
  }
}
