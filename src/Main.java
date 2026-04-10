import java.util.*;

import service.TaskManager;
import util.FileHandler;
import model.User;
import model.Task;

public class Main {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      TaskManager manager = new TaskManager();

      // Load data
      manager.getUsers().addAll(FileHandler.loadUsers("data/users.txt"));

      while (true) {
        System.out.println("\n====================================");
        System.out.println("      TODO TASK MANAGER SYSTEM      ");
        System.out.println("====================================");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Add Task");
        System.out.println("6. Evaluate Tasks");
        System.out.println("7. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        try {
          switch (choice) {
            case 1:
              System.out.print("Enter ID: ");
              int id = sc.nextInt();
              sc.nextLine();

              System.out.print("Enter First Name: ");
              String fname = sc.nextLine();

              System.out.print("Enter Last Name: ");
              String lname = sc.nextLine();

              System.out.print("Enter Email: ");
              String email = sc.nextLine();

              manager.addUser(new User(id, fname, lname, email));
              break;

            case 2:
              manager.viewUsers();
              break;

            case 3:
              System.out.print("Enter ID: ");
              int uid = sc.nextInt();
              sc.nextLine();

              System.out.print("Enter New First Name: ");
              String firstname = sc.nextLine();

              System.out.print("Enter New Last Name: ");
              String lastname = sc.nextLine();

              System.out.print("Enter New Email: ");
              String mail = sc.nextLine();

              manager.updateUser(uid, firstname, lastname, mail);
              break;

            case 4:
              System.out.print("Enter ID: ");
              manager.deleteUser(sc.nextInt());
              break;

            case 5:
              System.out.print("Task ID: ");
              int tid = sc.nextInt();
              sc.nextLine();

              System.out.print("Description: ");
              String desc = sc.nextLine();

              manager.addTask(new Task(tid, desc));
              break;

            case 6:
              manager.evaluateTasks();
              break;

            case 7:
              FileHandler.saveUsers("users.txt", manager.getUsers());
              System.out.println("Saved. Exiting...");
              return;
          }
        } catch (Exception e) {
          System.out.println("Invalid input!");
          sc.nextLine(); // clear buffer
        }
      }
    }
  }
}